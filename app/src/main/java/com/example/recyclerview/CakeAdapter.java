package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class CakeAdapter extends RecyclerView.Adapter<CakeAdapter.viewHolder>{
    public Context context;
    public ArrayList<CakeModel> cakeModels = new ArrayList<>();

    public CakeAdapter(Context context, ArrayList<CakeModel> cakeModels) {
        this.context = context;
        this.cakeModels = cakeModels;
    }

    public ArrayList<CakeModel> getCakeModels() {
        return cakeModels;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cake, parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, final int x) {
        Glide.with(context).load(getCakeModels().get(x).getFotocake()).into(holder.ivCake);
        holder.tvNamaKue.setText(getCakeModels().get(x).getNamacake());
        holder.tvDeskripsiKue.setText(getCakeModels().get(x).getDeskripsi());
        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CakeDetail.class);
                intent.putExtra("namaKue", getCakeModels().get(x).getNamacake());
                intent.putExtra("fotoKue", getCakeModels().get(x).getFotocake());
                intent.putExtra("deskripsiKue", getCakeModels().get(x).getDeskripsi());
                context.startActivity(intent);
            }
        });
        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                String shareSubject = getCakeModels().get(x).getNamacake();
                String shareBody = getCakeModels().get(x).namacake+"\n"+getCakeModels().get(x).getDeskripsi();
                share.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                share.putExtra(Intent.EXTRA_TEXT, shareBody);
                context.startActivity(Intent.createChooser(share,"Share using"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return cakeModels.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
     ImageView ivCake;
     TextView tvNamaKue, tvDeskripsiKue;
     Button btnDetail, btnShare;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ivCake = itemView.findViewById(R.id.ivCake);
            tvNamaKue = itemView.findViewById(R.id.tvNamaKue);
            tvDeskripsiKue = itemView.findViewById(R.id.tvDeskripsiKue);
            btnDetail = itemView.findViewById(R.id.btnDetail);
            btnShare = itemView.findViewById(R.id.btnShare);

        }
    }
}
