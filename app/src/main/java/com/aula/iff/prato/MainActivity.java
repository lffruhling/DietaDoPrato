package com.aula.iff.prato;

import android.content.Intent;
import android.graphics.Bitmap;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    ImageView imgView;
//    private DataHelper dh;
    private TextView descricao;
    private byte [] foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCamera    = (Button) findViewById(R.id.btFotografar);
        Button btnConfirmar = (Button) findViewById(R.id.btConfirmar);
//        Button btnGaleria   = (Button) findViewById(R.id.btGaleria);

        imgView = (ImageView) findViewById(R.id.imagem);
        descricao = (EditText) findViewById(R.id.descricao);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataHelper dh = new DataHelper(getBaseContext());
                dh.inserir(descricao.getText().toString(), foto);
                descricao.setText("");
                imgView.setImageResource(0);
            }
        });

//        btnGaleria.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, GaleriaActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        imgView.setImageBitmap(bitmap);;

        //converte bitmap em array de byte []
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
        foto = bos.toByteArray();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.itVisualizar){
            Intent intent = new Intent(MainActivity.this, GaleriaActivity.class);
            startActivity(intent);
            return true;
        }

        return false;
    }
}
