package com.aula.iff.prato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class GaleriaActivity extends AppCompatActivity{
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RefeicaoAdapter mAdapter;
    private List<Refeicao> refeicaoLista = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);
        DataHelper dh = new DataHelper(this);
        refeicaoLista = dh.buscarTodos();
        setaRecyclerView();
    }

    private void setaRecyclerView(){
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RefeicaoAdapter(this, refeicaoLista);
        mRecyclerView.setAdapter(mAdapter);
    }

}
