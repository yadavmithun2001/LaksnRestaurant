package com.example.laksnrestaurant.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laksnrestaurant.Allorders;
import com.example.laksnrestaurant.Model.Ordermodel;
import com.example.laksnrestaurant.R;

import java.util.ArrayList;

public class Orderadapter extends RecyclerView.Adapter<Orderadapter.viewholder>{
    ArrayList<Ordermodel> ordermodels = new ArrayList<>();
    private Allorders allorder;

    public Orderadapter(ArrayList<Ordermodel> ordermodels, Allorders allorder) {
        this.ordermodels = ordermodels;
        this.allorder = allorder;
    }


    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_myorder,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final Ordermodel ordermodel = ordermodels.get(position);
        holder.foodname.setText(ordermodel.getFoodname());
        holder.price.setText(ordermodel.getPrice());
        holder.liked.setVisibility(View.INVISIBLE);
        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.liked.setVisibility(View.VISIBLE);
                holder.like.setVisibility(View.INVISIBLE);
                Toast.makeText(v.getContext(), ordermodel.getFoodname()+" Liked", Toast.LENGTH_SHORT).show();
            }
        });
        holder.liked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.like.setVisibility(View.VISIBLE);
                holder.liked.setVisibility(View.INVISIBLE);
                Toast.makeText(v.getContext(), ordermodel.getFoodname()+" DisLiked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return ordermodels.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView foodname,price,name,table;
        ImageView like,liked;
         public viewholder(@NonNull  View itemView) {
             super(itemView);
             foodname = itemView.findViewById(R.id.foodname);
             price = itemView.findViewById(R.id.price);
             like = itemView.findViewById(R.id.imageView16);
             liked = itemView.findViewById(R.id.imageView17);
         }
     }

}
