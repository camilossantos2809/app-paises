package br.pucpr.apppaises;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class LugaresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }


        Intent intent = getIntent();
        String selecionado = intent.getStringExtra(MainActivity.PAIS_SELECIONADO);
        String url = MainActivity.LIST_PAISES_DATA.get(selecionado).getUrl();
        Toast.makeText(this, url, Toast.LENGTH_LONG).show();

        final ImageView img1 = findViewById(R.id.img_1);
        setImage(img1, selecionado + "-1.jpg");

        final ImageView img2 = findViewById(R.id.img_2);
        setImage(img2, selecionado + "-2.jpg");

        final ImageView img3 = findViewById(R.id.img_3);
        setImage(img3, selecionado + "-3.jpg");
    }

    public void setImage(ImageView image, String name){
        try {
            // get input stream
            InputStream ims = getAssets().open(name);
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            image.setImageDrawable(d);
            image.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ims.close();
        } catch (IOException ex) {
            return;
        }
    }
}
