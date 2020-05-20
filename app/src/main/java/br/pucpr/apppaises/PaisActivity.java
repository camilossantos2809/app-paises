package br.pucpr.apppaises;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class PaisActivity extends AppCompatActivity {
    private String selecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pais);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }


        Intent intent = getIntent();
        this.selecionado = intent.getStringExtra(MainActivity.PAIS_SELECIONADO);

        ImageView imageView = findViewById(R.id.flag);
        Picasso.get().load(MainActivity.LIST_PAISES_DATA.get(selecionado).getUrl()).into(imageView);

        final Button btnLugares = findViewById(R.id.btn_lugares);
        btnLugares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLugares();
            }
        });

        final Button btnSobre = findViewById(R.id.btn_sobre);
        btnSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSobre();
            }
        });

        final Button btnArtistas = findViewById(R.id.btn_artistas);
        btnArtistas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToArtistas();
            }
        });
    }


    public void goToLugares() {
        Intent intent = new Intent(this, LugaresActivity.class);
        intent.putExtra(MainActivity.PAIS_SELECIONADO, this.selecionado);
        startActivity(intent);
    }

    public void goToSobre() {
        Intent intent = new Intent(this, SobreActivity.class);
        intent.putExtra(MainActivity.PAIS_SELECIONADO, this.selecionado);
        startActivity(intent);
    }

    public void goToArtistas() {
        Intent intent = new Intent(this, ArtistasActivity.class);
        intent.putExtra(MainActivity.PAIS_SELECIONADO, this.selecionado);
        startActivity(intent);
    }

}
