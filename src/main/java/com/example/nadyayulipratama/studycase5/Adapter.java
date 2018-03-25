package com.example.nadyayulipratama.studycase5;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.holder>{


        private Context ctx;
        private List<informasi> list;
        int color;


        public Adapter (Context ctx, List<informasi> list, int color) {
            this.ctx = ctx;
            this.list = list;
            this.color = color;

        }
        @Override
        public holder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(ctx).inflate(R.layout.content_main, parent, false);
        holder hlr = new holder(view);
        return hlr;
        }

        @Override
        public void onBindViewHolder(holder holder, int position) {
         informasi data = list.get(position);
        holder.Name.setText(data.getName());
        holder.Descripsi.setText(data.getDeskripsi());
        holder.Priority.setText(data.getPriority());
        holder.CardView.setCardBackgroundColor(ctx.getResources().getColor(this.color));

        }

        @Override
        public int getItemCount() {
        return list.size();
        }

        public informasi getData(int position) {
        return list.get(position);
        }

        public void delete(int position) {
        list.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, list.size());
        }


    public class holder extends RecyclerView.ViewHolder {
    public TextView Name, Descripsi, Priority;
    public CardView CardView;
    public holder(View view) {
        super(view);
        Name =view.findViewById(R.id.Name);
        Descripsi =view.findViewById(R.id.Deskripsi);
        Priority = view.findViewById(R.id.number);
        CardView = view.findViewById(R.id.CardView);
    }
}

  }


