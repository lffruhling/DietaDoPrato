package com.aula.iff.prato;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leonardo on 05/06/2017.
 */

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "prato.db";
    private static final int DATABASE_VERSION = 1;
//    private SQLiteDatabase db;

    public DataHelper(Context ctx) {
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
//        this.db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( "CREATE TABLE refeicao " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "descricao TEXT, imagem BLOB)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Patter DAO

    public long inserir(String descricao, byte [] imagem){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("descricao", descricao);
        cv.put("imagem", imagem);
        return db.insert("refeicao", null, cv);
    }

    public List<Refeicao> buscarTodos(){
        List<Refeicao> lista = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("SELECT descricao, imagem FROM refeicao ORDER BY id DESC", null);

        if (cur.moveToFirst()){
            while (!cur.isAfterLast()){
                lista.add(new Refeicao(cur.getString(0), cur.getBlob(1)));
                cur.moveToNext();
            }
        }

        return lista;
    }
}
