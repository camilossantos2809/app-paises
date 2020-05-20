package br.pucpr.apppaises;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ArtistaDetailActivity extends AppCompatActivity {
    String nomeArtistaSelecionado;
    String paisSelecionado;
    List<ArtistaData> artistas;
    ArtistaData artista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artista_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        this.paisSelecionado = intent.getStringExtra(MainActivity.PAIS_SELECIONADO);
        PaisData paisData = MainActivity.LIST_PAISES_DATA.get(this.paisSelecionado);
        if (paisData != null) {
            this.artistas = paisData.getArtistas();
            this.artista = this.artistas.stream().filter(art -> art.getNome().equalsIgnoreCase(intent.getStringExtra(ArtistasActivity.ARTISTA_SELECIONADO))).findFirst().get();
            this.nomeArtistaSelecionado = intent.getStringExtra(ArtistasActivity.ARTISTA_SELECIONADO);

            TextView txtNome = findViewById(R.id.txt_nome);
            txtNome.setText("Nome: " + this.artista.getNome());

            TextView txtTipo = findViewById(R.id.txt_tipo);
            txtTipo.setText("Tipo: " + this.artista.getTipo());

            TextView txtDataNasc = findViewById(R.id.txt_data);
            txtDataNasc.setText("Data Nasc: " + this.artista.getDataNasc());

            EditText txtAreaSobre = findViewById(R.id.txt_area_sobre);
            txtAreaSobre.setText(this.artista.getSobre());
        }


    }
}
