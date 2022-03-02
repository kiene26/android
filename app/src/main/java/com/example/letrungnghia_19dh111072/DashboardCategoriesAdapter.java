package com.example.letrungnghia_19dh111072;
import android.net.sip.SipSession;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DashboardCategoriesAdapter extends RecyclerView.Adapter<DashboardCategoriesAdapter.CategoriesVH> {
    ArrayList<Categories> arrayList;
    Listener listener;
    public DashboardCategoriesAdapter (ArrayList<Categories> arrayList,Listener listener)
    {
        this.arrayList=arrayList;this.listener=listener;
    }
    @NonNull
    @Override
    public CategoriesVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cell,parent,false);
        return new CategoriesVH(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesVH holder, int position) {
        Categories categories=arrayList.get(position);
        holder.imgCate.setImageResource(categories.image);
        holder.txtCate.setText(categories.name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  listener.onClick(categories);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class CategoriesVH extends RecyclerView.ViewHolder{
        ImageView imgCate;
        TextView txtCate;
        public CategoriesVH(@NonNull View itemView)
        {
            super(itemView);
            imgCate=itemView.findViewById(R.id.imgCategory);
            txtCate=itemView.findViewById(R.id.txtCategories);
        }
    }
    interface Listener{
        void onClick(Categories categories);
    }
}
