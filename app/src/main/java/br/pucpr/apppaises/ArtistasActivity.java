package br.pucpr.apppaises;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import java.util.stream.Collectors;

public class ArtistasActivity extends AppCompatActivity {
    public static final String ARTISTA_SELECIONADO = "br.pucpr.apppaises.ARTISTA_SELECIONADO";
    String selecionado;
    List<ArtistaData> artistas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artistas);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        this.selecionado = intent.getStringExtra(MainActivity.PAIS_SELECIONADO);
        this.artistas = MainActivity.LIST_PAISES_DATA.get(selecionado).getArtistas();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, this.artistas.stream().map(ArtistaData::getNome).collect(Collectors.toList()));
        ListView listView = findViewById(R.id.lst_artistas);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(messageClickedHandler);
    }

    private AdapterView.OnItemClickListener messageClickedHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {

                Intent intent = new Intent(v.getContext(), ArtistaDetailActivity.class);
                intent.putExtra(ArtistasActivity.ARTISTA_SELECIONADO, artistas.get(position).getNome());
                intent.putExtra(MainActivity.PAIS_SELECIONADO, selecionado);
                startActivity(intent);

        }
    };
}
