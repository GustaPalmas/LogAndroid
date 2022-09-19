package com.br.edu.ifsc.palmas.logveiculo.ui.motorista;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.br.edu.ifsc.palmas.logveiculo.R;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadMotoristaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadMotoristaFragment extends Fragment implements View.OnClickListener,
        Response.ErrorListener, Response.Listener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText etNome;
    private EditText etEmail;
    private EditText etSenha;
    private EditText etCnh;
    private EditText etCpf;
    private EditText etData;
    private CheckBox cbAceite;
    private Spinner Categoria;
    private Button btSalvar;
    //volley
    private RequestQueue requestQueue;
    private JsonObjectRequest jsonObjectReq;
    //passar a view como atributo da classe e não do método
    View root;



    public CadMotoristaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CadMotoristaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CadMotoristaFragment newInstance(String param1, String param2) {
        CadMotoristaFragment fragment = new CadMotoristaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.root = inflater.inflate(R.layout.fragment_cad_motorista, container, false);

        // Inflate the layout for this fragment
        this.etNome = (EditText) root.findViewById(R.id.etName);
        this.etEmail =(EditText) root.findViewById(R.id.editTextTextEmailAddress);
        this.etSenha =(EditText) root.findViewById(R.id.editTextNumberPassword);
        this.etCnh =(EditText) root.findViewById(R.id.editTextNumber);
        this.etCpf =(EditText) root.findViewById(R.id.editTextTextPersonName2);
        this.etData =(EditText) root.findViewById(R.id.editTextDate2);
        this.cbAceite =(CheckBox) root.findViewById(R.id.checkBox);
        this.Categoria =(Spinner) root.findViewById(R.id.spinner);
        this.btSalvar =(Button) root.findViewById(R.id.button);
        //definindo o listener do botão
        this.btSalvar.setOnClickListener(this);
        //instanciando a fila de requests - caso o objeto seja o root
        this.requestQueue = Volley.newRequestQueue(root.getContext());
    //inicializando a fila de requests do SO
        this.requestQueue.start();
        //return root;
        return this.root;




    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //verificando se é o botão salvar
            case R.id.button:
                //instanciando objeto de negócio
                Motorista u = new Motorista();
                //populando objeto com dados da tela
                u.setNome(this.etNome.getText().toString());
                u.setEmail(this.etEmail.getText().toString());
                u.setSenha(this.etSenha.getText().toString());
                u.setCnh(this.etCnh.getText().toString());
                u.setCpf(this.etCpf.getText().toString());
                u.setData(this.etData.getText().toString());
                u.setAceito(this.cbAceite.isChecked());
                u.setCategoria((byte) this.Categoria.getSelectedItemPosition());

            //mensagem de sucesso
            Context context = view.getContext();
            CharSequence text = "Salvo com Sucesso!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
                //enviar objeto para o REST Server
                jsonObjectReq = new JsonObjectRequest(
                        Request.Method.POST,
                        "http://10.0.2.2:8080/motoristarest/rest/motorista",
                        u.toJsonObject(), this, this);
                requestQueue.add(jsonObjectReq);

            break;
        }

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Snackbar mensagem = Snackbar.make(root,
                "Ops! Houve um problema ao realizar o cadastro: " +
                        error.toString(),Snackbar.LENGTH_LONG);
        mensagem.show();


    }

    @Override
    public void onResponse(Object response) {
        String resposta = response.toString();
        try {
            if(resposta.equals("500")) {
                Snackbar mensagem = Snackbar.make(root,
                        "Erro! = " + resposta,
                        Snackbar.LENGTH_LONG);
                mensagem.show();
            }
            else {
                //sucesso
                //limpar campos da tela
                this.etNome.setText("");
                this.etEmail.setText("");
                this.etSenha.setText("");
                this.etCnh.setText("");
                this.Categoria.setSelection(0);
                this.etCpf.setText("");
                this.etData.setText("");
                this.cbAceite.setText("");

//mensagem de sucesso
                Snackbar mensagem = Snackbar.make(root,
                        "Sucesso! = " + resposta,
                        Snackbar.LENGTH_LONG);
                mensagem.show();
            }
        } catch (Exception e) { e.printStackTrace(); }

    }

}