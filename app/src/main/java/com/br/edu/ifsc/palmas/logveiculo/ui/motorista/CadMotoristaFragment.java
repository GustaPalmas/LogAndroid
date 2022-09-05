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

import com.br.edu.ifsc.palmas.logveiculo.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadMotoristaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadMotoristaFragment extends Fragment implements View.OnClickListener{

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
        View root = inflater.inflate(R.layout.fragment_cad_motorista, container, false);

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
        return root;



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
                u.setCategoria((byte)this.Categoria.getSelectedItemPosition());
        //mensagem de sucesso
                Context context = view.getContext();
                CharSequence text = "Salvo com Sucesso!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText (context, text, duration);
                toast.show();
                break;
        }
    }




}