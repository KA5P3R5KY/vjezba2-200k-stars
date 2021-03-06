package com.example.vjezba2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<MyData> mDataset;

    public static class MyViewHolder extends  RecyclerView.ViewHolder {

        public ImageView imageView1;
        public TextView textView1;
        public TextView textView2;
        public MyViewHolder(View v){
            super(v);
            imageView1 = v.findViewById(R.id.imageView1);
            textView1 = v.findViewById(R.id.textView1);
            textView2 = v.findViewById(R.id.textView2);

        }
    }

    public MyAdapter(ArrayList<MyData> myDataset){
        this.mDataset = myDataset;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View viewCell = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.my_view,parent,false);

        MyViewHolder viewHolder = new MyViewHolder(viewCell);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext()).load(mDataset.get(position).avatar).into(holder.imageView1);
        holder.textView1.setText(mDataset.get(position).repoName);
        holder.textView2.setText(Integer.toString(mDataset.get(position).starCount));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}