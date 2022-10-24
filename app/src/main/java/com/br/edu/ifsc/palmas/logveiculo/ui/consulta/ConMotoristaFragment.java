package com.br.edu.ifsc.palmas.logveiculo.ui.consulta;

import android.content.Context;
import android.os.Bundle;

import androidx.constraintlayout.widget.Placeholder;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.br.edu.ifsc.palmas.logveiculo.R;
import com.br.edu.ifsc.palmas.logveiculo.ui.motorista.Motorista;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
public class ConMotoristaFragment extends Fragment implements
        Response.ErrorListener, Response.Listener{

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    //atributo com lista de motorista
    private ArrayList< Motorista > motorista;
    //volley
    private RequestQueue requestQueue;
    private JsonArrayRequest jsonArrayReq;
    //passar a view como atributo da classe e não do método
    private View view;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ConMotoristaFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ConMotoristaFragment newInstance(int columnCount) {
        ConMotoristaFragment fragment = new ConMotoristaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_con_motorista_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new ConMotoristaRecyclerViewAdapter(???));
        }
        return view;
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(Object response) {

    }
}