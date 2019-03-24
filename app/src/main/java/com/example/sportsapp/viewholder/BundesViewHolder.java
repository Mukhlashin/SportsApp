package com.example.sportsapp.viewholder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sportsapp.R;

public class BundesViewHolder extends RecyclerView.ViewHolder {

    public TextView tvNama, tvLokasiStadium, tvNamaStadium;
    public ImageView imgLogo;

    public BundesViewHolder(@NonNull View itemView, Context context) {
        super(itemView);

        tvNama = itemView.findViewById(R.id.tv_bundes_nama_club);
        tvLokasiStadium = itemView.findViewById(R.id.tv_bundes_lokasi_stadium);
        tvNamaStadium = itemView.findViewById(R.id.tv_bundes_nama_stadium);
        imgLogo = itemView.findViewById(R.id.img_bundes_logo);

    }
}
