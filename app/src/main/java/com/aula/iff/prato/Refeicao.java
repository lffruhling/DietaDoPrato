package com.aula.iff.prato;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by Leonardo on 05/06/2017.
 */

public class Refeicao {
    private String descricao;
    private byte [] imagem;

    public Refeicao(String descricao, byte[] imagem) {
        this.descricao = descricao;
        this.imagem = imagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public Bitmap getImagem() {
        return BitmapFactory.decodeByteArray(imagem, 0, imagem.length);
    }
}
