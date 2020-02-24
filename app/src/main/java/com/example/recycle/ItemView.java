package com.example.recycle;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.appcompat.app.AppCompatActivity;

public class ItemView extends AppCompatActivity {

    public static String EXTRA_DATA = "extra_data";
    private ImageView adivGambarHero;
    private TextView adtvNamaHero, adtvDescHero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero_details);

        adivGambarHero   = findViewById(R.id.iv_gambar_hero);
        adtvNamaHero    = findViewById(R.id.tv_nama_hero);
        adtvDescHero    = findViewById(R.id.tv_desc_hero);

        heromodel hero = getIntent().getParcelableExtra(EXTRA_DATA);
        int image       = hero.getGambarHero();
        String name     = hero.getNamaHero();
        String desc     = hero.getDescHero();

        if (hero != null) {
            Glide.with(this).load(image).into(adivGambarHero);
            adtvNamaHero.setText(name);
            adtvDescHero.setText(desc);
        }
    }
}