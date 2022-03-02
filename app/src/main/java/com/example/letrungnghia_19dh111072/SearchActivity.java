package com.example.letrungnghia_19dh111072;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements HomeFurnitureAdapter.Listener {
    Toolbar toolbar;
    SearchView searchView;
    HomeFurnitureAdapter furnitureAdapter;
    ArrayList<Furniture> arrayList;
    RecyclerView rcFurnitureFilter;
    LinearLayout linearEmpty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        toolbar =findViewById(R.id.toolbar);
        searchView=toolbar.findViewById(R.id.searchView);
        linearEmpty=findViewById(R.id.LinearEmpty);

        rcFurnitureFilter=findViewById(R.id.rcFurnitureFilter);
        arrayList=App.init(this);
        furnitureAdapter=new HomeFurnitureAdapter(arrayList,this::onClick);
        rcFurnitureFilter.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rcFurnitureFilter.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        rcFurnitureFilter.setAdapter(furnitureAdapter);
        setVisible(false);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                furnitureAdapter.getFilter().filter(newText);
                if(furnitureAdapter.arrayListFilter.size()==0||newText.isEmpty()) setVisible(false);
                else setVisible(true);
                return false;
            }
        });
    }
    public void setVisible(boolean flag)
    {
        if(!flag){
            linearEmpty.setVisibility(View.VISIBLE);
            rcFurnitureFilter.setVisibility(View.GONE);
        }
        else
        {
            linearEmpty.setVisibility(View.GONE);
            rcFurnitureFilter.setVisibility(View.VISIBLE);
        }
    }
    public boolean check(String s)
    {
        if(Utilities.data==null) return true;
        for(int i=0;i<Utilities.data.size();i++)
            if(Utilities.data.get(i).name.equals(s))return false;
        return true;
    }
    @Override
    public void onClick(Furniture furniture) {
         if(check(furniture.name))
         Utilities.getInstance().add(furniture);
    }
}