package com.example.server;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final NewsModel states;
    private onClickerAdapter itemClicker;
    private LinearLayout basic;


    RecyclerAdapter(Context context, NewsModel states, onClickerAdapter itemClicker) {
        this.states = states;
        this.inflater = LayoutInflater.from(context);
        this.itemClicker = itemClicker;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycle, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.textTitel.setText(states.getArticles().get(position).getTitle());

        Picasso.get()
                .load(states.getArticles().get(position).getUrlToImage())
                .resize(700, 700)
                .centerCrop()
                .into(holder.imagenews);

        holder.basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClicker.onClick(states.getArticles().get(position));
            }
        });
    }


    @Override
    public int getItemCount() {
        if (states != null ){
           return states.getArticles().size();
        }else {
            System.out.println("0");
            System.out.println(states);
            System.out.println("0");
            return 0;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textTitel;
        final ImageView imagenews;
        LinearLayout basic;

        ViewHolder(View view){
            super(view);
            textTitel = view.findViewById(R.id.textTitle);
            basic = itemView.findViewById(R.id.basic);
            imagenews = view.findViewById(R.id.imagenews);

        }
    }
}
