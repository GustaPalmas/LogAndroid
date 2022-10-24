package com.br.edu.ifsc.palmas.logveiculo.ui.consulta;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.br.edu.ifsc.palmas.logveiculo.databinding.FragmentConMotoristaBinding;
import com.br.edu.ifsc.palmas.logveiculo.ui.motorista.Motorista;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link com.br.edu.ifsc.palmas.logveiculo.ui.motorista.Motorista}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ConMotoristaRecyclerViewAdapter extends RecyclerView.Adapter<ConMotoristaRecyclerViewAdapter.ViewHolder> {

    private final List<Motorista> mValues;

    public ConMotoristaRecyclerViewAdapter(List<Motorista> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentConMotoristaBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(String.valueOf(mValues.get(position).getId()));
        holder.mContentView.setText(mValues.get(position).getNome());
        holder.mContentView.setText(mValues.get(position).getEmail());
        holder.mIdView.setText(String.valueOf(mValues.get(position).getCpf()));
        holder.mIdView.setText(String.valueOf(mValues.get(position).getCategoria()));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public Motorista mItem;

        public ViewHolder(FragmentConMotoristaBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}