package com.aula.iff.prato;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Leonardo on 05/06/2017.
 */

public class RefeicaoHolder extends RecyclerView.ViewHolder {
    public TextView descricao;
    public ImageView imagem;

    public RefeicaoHolder(View itemView) {
        super(itemView);

        descricao = (TextView) itemView.findViewById(R.id.txt_descricao);
        imagem = (ImageView) itemView.findViewById(R.id.img_foto);
    }
}
