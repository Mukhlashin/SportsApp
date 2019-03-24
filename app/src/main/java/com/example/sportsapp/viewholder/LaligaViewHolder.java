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

public class LaligaViewHolder extends RecyclerView.ViewHolder {

    public TextView tvNama, tvNamaStadium, tvLokasiStadium;
    public ImageView imgLogo;

    public LaligaViewHolder(@NonNull View itemView, Context context) {
        super(itemView);

        tvLokasiStadium = itemView.findViewById(R.id.tv_laliga_lokasi_stadium);
        tvNama = itemView.findViewById(R.id.tv_laliga_nama_club);
        tvNamaStadium = itemView.findViewById(R.id.tv_laliga_nama_stadium);
        imgLogo = itemView.findViewById(R.id.img_laliga_logo);
    }
}
