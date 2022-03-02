package com.example.letrungnghia_19dh111072;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HomeFurnitureAdapter extends RecyclerView.Adapter<HomeFurnitureAdapter.HomeFurnitureVH> implements Filterable {
    ArrayList<Furniture> arrayList;
    ArrayList<Furniture> arrayListFilter;
    boolean flag=false;
    Listener listener;
    public HomeFurnitureAdapter(ArrayList<Furniture> arrayList,Listener listener){
        this.arrayList=arrayList;this.listener=listener;this.arrayListFilter=arrayList;
    }
    @NonNull
    @Override
    public HomeFurnitureVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);
        return new HomeFurnitureVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeFurnitureVH holder, int position) {
        Furniture furniture=arrayListFilter.get(position);
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
      if(arrayListFilter==null) return 0;else  return arrayListFilter.size();
    }

    @Override
    public Filter getFilter() {
        return new FurnitureFilter();
    }
    class HomeFurnitureVH extends RecyclerView.ViewHolder{
        TextView txtName,txtDescription;
        ImageView imgFurniture;
        public HomeFurnitureVH(@NonNull View itemView)
        {
            super(itemView);
            txtName =itemView.findViewById(R.id.txtName);
            txtDescription=itemView.findViewById(R.id.txtDescription);
            imgFurniture=itemView.findViewById(R.id.imgFurniture);

        }
    }
    class FurnitureFilter extends Filter{
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String charString=constraint.toString();
            if(charString.isEmpty())
            {
                arrayListFilter=arrayList;
            }
            else {
                ArrayList<Furniture> filteredlist =new ArrayList<>();
                for(Furniture row:arrayList)
                if(row.name.toLowerCase().contains(charString.toLowerCase())||row.des.contains(charString))
                {
                filteredlist.add(row);
                }
                arrayListFilter=filteredlist;
            }
            FilterResults filterResults=new FilterResults();
            filterResults.values=arrayListFilter;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            arrayListFilter= ( ArrayList<Furniture> ) results.values;
            notifyDataSetChanged();
        }
    }
    interface Listener{
        void onClick(Furniture furniture);
    }
}
