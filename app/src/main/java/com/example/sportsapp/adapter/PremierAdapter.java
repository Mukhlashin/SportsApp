package com.example.sportsapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sportsapp.DetailActivity;
import com.example.sportsapp.R;
import com.example.sportsapp.modelpremier.TeamsItemPremier;
import com.example.sportsapp.viewholder.PremierViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PremierAdapter extends RecyclerView.Adapter<PremierViewHolder> {

    Context context;
    private List<TeamsItemPremier> data;

    public PremierAdapter(Context context, List<TeamsItemPremier> data ) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public PremierViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_holder_premier, null);
        return new PremierViewHolder(v, context);
    }

    @Override
    public void onBindViewHolder(@NonNull PremierViewHolder premierViewHolder, final int i) {
        premierViewHolder.tvNama.setText(data.get(i).getStrTeam());
        premierViewHolder.tvNamaStadium.setText(data.get(i).getStrStadium());
        premierViewHolder.tvLokasiStadium.setText(data.get(i).getStrStadiumLocation());
        Picasso.get().load(data.get(i).getStrTeamBadge()).into(premierViewHolder.imgLogo);
        premierViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
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
