package com.aula.iff.prato;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Leonardo on 05/06/2017.
 */

public class RefeicaoAdapter extends RecyclerView.Adapter<RefeicaoHolder> {
    private Context ctx;
    private final List<Refeicao> dados;

    public RefeicaoAdapter(Context ctx, List<Refeicao> dados) {
        this.ctx = ctx;
        this.dados = dados;
    }


    @Override
    public RefeicaoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return new RefeicaoHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.main_line_view, parent, false));
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_line_view, parent, false);
        return new RefeicaoHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RefeicaoHolder holder, int position) {
        holder.descricao.setText(dados.get(position).getDescricao());
        holder.imagem.setImageBitmap(dados.get(position).getImagem());
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }
}
