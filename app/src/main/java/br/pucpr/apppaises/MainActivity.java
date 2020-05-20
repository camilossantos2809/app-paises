package br.pucpr.apppaises;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String PAIS_SELECIONADO = "br.pucpr.apppaises.PAIS_SELECIONADO";
    public static Map<String, PaisData> LIST_PAISES_DATA = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button1 = findViewById(R.id.bt_pais_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select("brasil");
            }
        });

        final Button button2 = findViewById(R.id.bt_pais_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select("argentina");
            }
        });

        final Button btnUruguai = findViewById(R.id.bt_pais_3);
        btnUruguai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select("uruguai");
            }
        });

        final Button btnMexico = findViewById(R.id.bt_pais_4);
        btnMexico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select("mexico");
            }
        });

        final Button btnEua = findViewById(R.id.bt_pais_5);
        btnEua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select("eua");
            }
        });

        final Button btnFinlandia = findViewById(R.id.bt_pais_6);
        btnFinlandia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select("finlandia");
            }
        });

        final Button btnFranca = findViewById(R.id.bt_pais_7);
        btnFranca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select("franca");
            }
        });
        final Button btnRussia = findViewById(R.id.bt_pais_8);
        btnRussia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select("russia");
            }
        });

        final Button btnIndia = findViewById(R.id.bt_pais_9);
        btnIndia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select("india");
            }
        });

        final Button btnAustralia = findViewById(R.id.bt_pais_10);
        btnAustralia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select("australia");
            }
        });

        LIST_PAISES_DATA = loadJSON(this);
    }

    private Map<String, PaisData> loadJSON(Context context) {
        Map<String, PaisData> list = new HashMap<>();
        try {
            JsonReader reader = new JsonReader(new InputStreamReader(context.getAssets().open("data.json")));

            reader.beginObject();
            while (reader.hasNext()) {
                PaisData data = new PaisData();
                String pais = reader.nextName();

                reader.beginObject();
                while(reader.hasNext()){
                    String key = reader.nextName();
                    switch (key) {
                        case "url":
                            data.setUrl(reader.nextString());
                            break;
                        case "presidente":
                            data.setPresidente(reader.nextString());
                            break;
                        case "lingua":
                            data.setLingua(reader.nextString());
                            break;
                        case "continente":
                            data.setContinente(reader.nextString());
                            break;
                        case "area":
                            data.setArea(reader.nextString());
                            break;
                        case "populacao":
                            data.setPopulacao(reader.nextString());
                            break;
                        case "capital":
                            data.setCapital(reader.nextString());
                            break;
                        case "distancia":
                            data.setDistancia(reader.nextString());
                            break;
                        case "moeda":
                            data.setMoeda(reader.nextString());
                            break;
                        case"artistas":
                            reader.beginArray();
                            List<ArtistaData> artistas = new ArrayList<>();
                            while (reader.hasNext()){
                                reader.beginObject();
                                ArtistaData artista = new ArtistaData();
                                while (reader.hasNext()){
                                    String keyArtista = reader.nextName();
                                    switch (keyArtista){
                                        case "nome":
                                            artista.setNome(reader.nextString());
                                            break;
                                        case "tipo":
                                            artista.setTipo(reader.nextString());
                                            break;
                                        case "dataNasc":
                                            artista.setDataNasc(reader.nextString());
                                            break;
                                        case "sobre":
                                            artista.setSobre(reader.nextString());
                                            break;
                                        default:
                                            reader.skipValue();
                                    }
                                }
                                reader.endObject();
                                artistas.add(artista);
                            }
                            reader.endArray();
                            data.setArtistas(artistas);
                            break;
                        default:
                            reader.skipValue();
                    }
                }

                reader.endObject();
                list.put(pais, data);
            }
            reader.endObject();
            reader.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return list;
    }

    public void select(String pais) {
        Intent intent = new Intent(this, PaisActivity.class);
        intent.putExtra(PAIS_SELECIONADO, pais);
        startActivity(intent);
    }
}
