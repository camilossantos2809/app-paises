package br.pucpr.apppaises;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SobreActivity extends AppCompatActivity {
private PaisData data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }


        Intent intent = getIntent();
        String selecionado = intent.getStringExtra(MainActivity.PAIS_SELECIONADO);
        this.data = MainActivity.LIST_PAISES_DATA.get(selecionado);

        final TextView txtPresidente = findViewById(R.id.txt_presidente);
        txtPresidente.setText("Presidente: "+ this.data.getPresidente());

        final TextView txtLingua= findViewById(R.id.txt_lingua);
        txtLingua.setText("Língua: "+ this.data.getLingua());

        final TextView txtContinente = findViewById(R.id.txt_continente);
        txtContinente.setText("Continente: "+ this.data.getContinente());

        final TextView txtArea = findViewById(R.id.txt_area);
        txtArea.setText("Área: "+ this.data.getArea().toString());

        final TextView txtPopulacao = findViewById(R.id.txt_populacao);
        txtPopulacao.setText("População: "+ this.data.getPopulacao().toString());

        final TextView txtCapital = findViewById(R.id.txt_capital);
        txtCapital.setText("Capital: "+ this.data.getCapital());

        final TextView txtDistancia = findViewById(R.id.txt_distancia);
        txtDistancia.setText("Distância até o Brasil: "+ this.data.getDistancia().toString());

        final TextView txtMoeda = findViewById(R.id.txt_moeda);
        txtMoeda.setText("Moeda: "+ this.data.getMoeda());
    }
}
