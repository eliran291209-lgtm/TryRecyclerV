package com.example.tryrecyclerv;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<Item> mData;

    public MyAdapter(ArrayList <Item> data){
        mData = data ;
    }
public static class ViewHolder extends RecyclerView.ViewHolder{
    public final ImageView ivImage;
    public final TextView textView4;
    public final TextView textView5;
    public ViewHolder (View ItemView){
        super(ItemView);
        ivImage = itemView.findViewById(R.id.imageView3);
        textView4 = itemView.findViewById(R.id.textView4);
        textView5 = itemView.findViewById(R.id.textView5);
    }
}
    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_layout , parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Item data = mData.get(position);
                Toast.makeText(parent.getContext(), data.getName(),
                        Toast.LENGTH_LONG).show();

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        Item item = mData.get(position) ;
        holder.textView4.setText(item.getName());
        holder.textView5.setText(item.getDescription());
        holder.ivImage.setImageResource(R.drawable.dog);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
