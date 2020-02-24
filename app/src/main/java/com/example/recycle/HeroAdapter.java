package com.example.recycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ListViewHolder> {
    private Context context;
    private ArrayList<heromodel> heromodels;


    public  HeroAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<heromodel> getHeromodels(){
        return heromodels;
    }

    public void setHeromodels(ArrayList<heromodel>heromodels){
        this.heromodels = heromodels;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hero_details,viewGroup,false);
        return new ListViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroAdapter.ListViewHolder holder, int i) {
        Glide.with(context)
                .load(getHeromodels()
                .get(i).getGambarHero())
                .into(holder.ivGambarHero);
        holder.tvNamaHero.setText(getHeromodels().get(i).getNamaHero());
    }

    @Override
    public int getItemCount() {
        return getHeromodels().size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivGambarHero;
        private TextView tvNamaHero;

        public ListViewHolder (@NonNull View itemView){
            super(itemView);
            ivGambarHero = itemView.findViewById(R.id.gambar_hero);
            tvNamaHero = itemView.findViewById(R.id.nama_hero);
        }
    }
}
