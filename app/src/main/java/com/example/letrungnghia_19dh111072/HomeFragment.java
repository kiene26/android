package com.example.letrungnghia_19dh111072;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements HomeFurnitureAdapter.Listener{

    RecyclerView rvFurniture;
    ArrayList<Furniture> arrayList;
    HomeFurnitureAdapter homeFurnitureAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.search_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent=new Intent(getContext(),SearchActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Context context =getContext();
        rvFurniture = view.findViewById(R.id.rvFuniture);
        /*for(int i=0;i<init1().size();i++)
        App.getInstance().add(init1().get(i));*/
        arrayList = App.init(context);
        homeFurnitureAdapter = new HomeFurnitureAdapter(arrayList,this::onClick);
        rvFurniture.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvFurniture.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
        rvFurniture.setAdapter(homeFurnitureAdapter);
        super.onViewCreated(view, savedInstanceState);
    }
    public  ArrayList<Furniture> init1(){
        Context context =getContext();
        ArrayList<Furniture> tmp = new ArrayList<>();
        tmp.add(new Furniture(context.getString(R.string.name_product_one),
                context.getString(R.string.product_one),
                R.drawable.hinh_1));
        tmp.add(new Furniture(context.getString(R.string.name_product_tow),
                context.getString(R.string.product_tow),
                R.drawable.hinh_2));
        tmp.add(new Furniture(context.getString(R.string.name_product_three),
                context.getString(R.string.product_three),
                R.drawable.hinh_3));
        tmp.add(new Furniture(context.getString(R.string.name_product_four),
                context.getString(R.string.product_four),
                R.drawable.hinh_4));
        tmp.add(new Furniture(context.getString(R.string.name_product_five),
                context.getString(R.string.product_five),
                R.drawable.hinh_5));
        return tmp;
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
        if(check(furniture.name)) Utilities.getInstance().add(furniture);
        Toast.makeText(getContext(),"SAVE",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(getContext(),DetailActivity.class);
        intent.putExtra("furniture",furniture);
        startActivity(intent);
    }
}

