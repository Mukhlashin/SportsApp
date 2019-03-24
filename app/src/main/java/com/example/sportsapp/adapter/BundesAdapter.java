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
import com.example.sportsapp.modelbundesliga.TeamsItemBundes;
import com.example.sportsapp.viewholder.BundesViewHolder;
import com.example.sportsapp.viewholder.LaligaViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BundesAdapter extends RecyclerView.Adapter<BundesViewHolder> {

    Context context;
    private List<TeamsItemBundes> data;

    public BundesAdapter(Context context, List<TeamsItemBundes> data ) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public BundesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_holder_bundes, null);
        return new BundesViewHolder(v, context);
    }

    @Override
    public void onBindViewHolder(@NonNull BundesViewHolder bundesViewHolder, final int i) {
        bundesViewHolder.tvNama.setText(data.get(i).getStrTeam());
        bundesViewHolder.tvNamaStadium.setText(data.get(i).getStrStadium());
        bundesViewHolder.tvLokasiStadium.setText(data.get(i).getStrStadiumLocation());
        Picasso.get().load(data.get(i).getStrTeamBadge()).into(bundesViewHolder.imgLogo);
        bundesViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
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
