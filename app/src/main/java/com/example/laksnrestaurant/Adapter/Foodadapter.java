package com.example.laksnrestaurant.Adapter;


import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laksnrestaurant.Listoffooditems;
import com.example.laksnrestaurant.Model.Foodmodel;
import com.example.laksnrestaurant.Placeorder;
import com.example.laksnrestaurant.R;

import java.util.ArrayList;

public class Foodadapter extends RecyclerView.Adapter<Foodadapter.viewholder> {
    ArrayList<Foodmodel> list = new ArrayList<>();
    Integer c = 0;
    int qn = 0;
    private Listoffooditems listoffooditems;

    public Foodadapter(ArrayList<Foodmodel> list,Listoffooditems listoffooditems) {
        this.list = list;
        this.listoffooditems = listoffooditems;
    }


    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_fooditem,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
            final Foodmodel foodmodel = list.get(position);
            holder.imgfood.setImageResource(foodmodel.getImg());
            holder.foodprice.setText(foodmodel.getPrice());
            holder.foodname.setText(foodmodel.getFoodname());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), foodmodel.getFoodname(), Toast.LENGTH_SHORT).show();
                }
            });
            holder.imgselected.setVisibility(View.INVISIBLE);
            holder.imgselect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.selectquatity.show();
                    holder.food.setText(foodmodel.getFoodname());
                    holder.price.setText(foodmodel.getPrice());

                    holder.inquantity.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            qn++;
                            if(qn>=11){
                                Toast.makeText(v.getContext(), "Maximun 10 Orders Allowed", Toast.LENGTH_SHORT).show();
                            }else {
                                Integer priceup = Integer.parseInt(foodmodel.getPrice());
                                priceup = priceup*qn;
                                String abc1 = String.valueOf(priceup);
                                holder.price.setText(abc1);
                                holder.dequantity.setVisibility(View.VISIBLE);
                                String abc = String.valueOf(qn);
                                holder.quantity.setText(abc);
                                listoffooditems.selection(position);
                                holder.select.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        holder.selectquatity.dismiss();
                                        qn = 0;
                                        holder.imgselect.setVisibility(View.INVISIBLE);
                                        holder.imgselected.setVisibility(View.VISIBLE);
                                        StringBuilder stringBuilder = new StringBuilder();
                                        StringBuilder stringBuilder1 = new StringBuilder();
                                        StringBuilder stringBuilder2 = new StringBuilder();
                                        stringBuilder2.append(abc1).append("+");
                                        if(c ==1){
                                            stringBuilder.append(foodmodel.getFoodname());
                                            stringBuilder1.append(abc1);
                                        }else{
                                            stringBuilder.append("\n").append(foodmodel.getFoodname());
                                            stringBuilder1.append("\n").append(abc1);
                                        }
                                        listoffooditems.getdata(stringBuilder,stringBuilder1,stringBuilder2);
                                    }
                                });
                            }
                        }
                    });


                    holder.dequantity.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            qn--;
                            if(qn==0){
                               holder.dequantity.setVisibility(View.INVISIBLE);
                            }else {
                                String abc = String.valueOf(qn);
                                holder.quantity.setText(abc);
                            }

                        }
                    });
                    c++;
                }
            });
            holder.imgselected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.imgselected.setVisibility(View.INVISIBLE);
                holder.imgselect.setVisibility(View.VISIBLE);
                c--;
                qn = 1;
            }
        });
            holder.cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.selectquatity.dismiss();
                }
            });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public ArrayList<Foodmodel> selected (){
        ArrayList<Foodmodel> selecteditem = new ArrayList<>();
        for(Foodmodel foodmodel : list){
            if(c >= 1){
                selecteditem.add(foodmodel);
            }
        }
        return selecteditem;
    }



    public class viewholder extends RecyclerView.ViewHolder {

        ImageView imgfood,imgselect,imgselected;
        TextView foodname,foodprice,inquantity,dequantity,quantity,cancel,select,food,price;
        CardView cardview;
        Dialog selectquatity;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            imgfood = itemView.findViewById(R.id.imageView12);
            imgselect = itemView.findViewById(R.id.imageView13);
            imgselected = itemView.findViewById(R.id.imageView14);
            foodname = itemView.findViewById(R.id.textView7);
            foodprice = itemView.findViewById(R.id.textView);
            cardview = itemView.findViewById(R.id.cardview);
            selectquatity = new Dialog(itemView.getContext());
            selectquatity.setContentView(R.layout.selectquantity);
            inquantity = selectquatity.findViewById(R.id.textView10);
            dequantity = selectquatity.findViewById(R.id.textView9);
            quantity = selectquatity.findViewById(R.id.textView19);
            cancel = selectquatity.findViewById(R.id.textView11);
            select = selectquatity.findViewById(R.id.textView12);
            food = selectquatity.findViewById(R.id.food);
            price = selectquatity.findViewById(R.id.price);




        }
    }
}
