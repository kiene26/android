package com.example.letrungnghia_19dh111072;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesVHH>{
    ArrayList<Furniture> arrayList;
    Listener listener;
    public CategoriesAdapter(ArrayList<Furniture> arrayList,Listener listener)
    {
        this.arrayList=arrayList;
        this.listener=listener;
    }
    @NonNull
    @Override
    public CategoriesVHH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);
         return new CategoriesAdapter.CategoriesVHH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesVHH holder, int position) {
        Furniture furniture=arrayList.get(position);
        holder.txtName.setText(furniture.name);
        holder.txtDescription.setText(furniture.des);
        holder.imgFurniture.setImageResource(furniture.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(furniture);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class CategoriesVHH extends RecyclerView.ViewHolder{
        TextView txtName,txtDescription;
        ImageView imgFurniture;
        public CategoriesVHH(@NonNull View itemView) {
            super(itemView);
            txtName =itemView.findViewById(R.id.txtName);
            txtDescription=itemView.findViewById(R.id.txtDescription);
            imgFurniture=itemView.findViewById(R.id.imgFurniture);
        }
    }
    interface Listener{
        void onClick(Furniture furniture);
    }
}
