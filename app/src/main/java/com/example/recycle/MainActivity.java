package com.example.recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView rvHero;
private ArrayList<heromodel> listHero = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHero = findViewById(R.id.hero_list);
        rvHero.setHasFixedSize(true);
        listHero.addAll(HeroData.getListData());

        showRecyclerList();

    }

    private void showRecyclerList() {
        rvHero.setLayoutManager(new LinearLayoutManager(this));
        HeroAdapter heroAdapter = new HeroAdapter(this);
        heroAdapter.setHeromodels(listHero);
        rvHero.setAdapter(heroAdapter);

        heroAdapter.setOnItemClickCallback(new HeroAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(heromodel hero) {
                Toast.makeText(MainActivity.this, "Memilih " + hero.getNamaHero(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ItemView.class);
                intent.putExtra(ItemView.EXTRA_DATA, (Parcelable) hero);
                startActivity(intent);
            }
        });
    }
}
