package com.example.sportsapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sportsapp.DetailActivity;
import com.example.sportsapp.R;
import com.example.sportsapp.modellaliga.TeamsItemLaliga;
import com.example.sportsapp.modelpremier.TeamsItemPremier;
import com.example.sportsapp.viewholder.LaligaViewHolder;
import com.example.sportsapp.viewholder.PremierViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LaligaAdapter extends RecyclerView.Adapter<LaligaViewHolder> {

    Context context;
    private List<TeamsItemLaliga> data;

    public LaligaAdapter(Context context, List<TeamsItemLaliga> data ) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public LaligaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_holder_laliga, null);
        return new LaligaViewHolder(v, context);
    }

    @Override
    public void onBindViewHolder(@NonNull LaligaViewHolder laligaViewHolder, final int i) {
        laligaViewHolder.tvNama.setText(data.get(i).getStrTeam());
        laligaViewHolder.tvNamaStadium.setText(data.get(i).getStrStadium());
        laligaViewHolder.tvLokasiStadium.setText(data.get(i).getStrStadiumLocation());
        Picasso.get().load(data.get(i).getStrTeamBadge()).into(laligaViewHolder.imgLogo);
        laligaViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move = new Intent(context, DetailActivity.class);
                move.putExtra("a", data.get(i).getStrDescriptionEN());
                move.putExtra("b", data.get(i).getStrTeamBadge());
                context.startActivity(move);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
