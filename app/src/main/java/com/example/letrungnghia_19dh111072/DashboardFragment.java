package com.example.letrungnghia_19dh111072;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment implements DashboardCategoriesAdapter.Listener{

    RecyclerView rcCategories;
    ArrayList<Categories> arrayList;
    DashboardCategoriesAdapter dashboardCategoriesAdapter;
    ArrayList<Furniture> itemlist;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcCategories = view.findViewById(R.id.rcCategories);
        arrayList =init();
        itemlist = init1();
        dashboardCategoriesAdapter=new DashboardCategoriesAdapter(arrayList,this::onClick);
        rcCategories.setLayoutManager(new GridLayoutManager(getContext(),2));
        rcCategories.setAdapter(dashboardCategoriesAdapter);
    }
    public  ArrayList<Categories> init(){
        Context context =getContext();
        ArrayList<Categories> tmp = new ArrayList<>();
        tmp.add(new Categories(R.drawable.bed_room,"Bed room"));
        tmp.add(new Categories(R.drawable.living_room,"Living room"));
        tmp.add(new Categories(R.drawable.accessories,"Accessories"));
        tmp.add(new Categories(R.drawable.meeting_room,"Meeting room"));
        return tmp;
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
    public boolean check(int ii)
    {
        if(Utilities.dataHomeFromCate==null) return true;
        for(int i=0;i<Utilities.dataHomeFromCate.size();i++)
        if(Utilities.dataHomeFromCate.get(i).name.equals(itemlist.get(ii).name)) return false;
        return true;
    }
    @Override
    public void onClick(Categories categories) {
        Context context =getContext();

        if(categories.name.equals("Bed room"))
        {   if(Utilities.dataHomeFromCate!=null)Utilities.dataHomeFromCate.clear();
            if(check(3)) Utilities.getInstanceFromCate().add(itemlist.get(3));}
        else if(categories.name.equals("Living room"))
        {if(Utilities.dataHomeFromCate!=null)Utilities.dataHomeFromCate.clear();
            if(check(0)) Utilities.getInstanceFromCate().add(itemlist.get(0));}
        else if(categories.name.equals("Accessories"))
        {if(Utilities.dataHomeFromCate!=null)Utilities.dataHomeFromCate.clear();
            if(check(1)) Utilities.getInstanceFromCate().add(itemlist.get(1));
            if(check(4)) Utilities.getInstanceFromCate().add(itemlist.get(4));}
        else if(categories.name.equals("Meeting room"))
        {if(Utilities.dataHomeFromCate!=null)Utilities.dataHomeFromCate.clear();
            if(check(2)) Utilities.getInstanceFromCate().add(itemlist.get(2));}

        Toast.makeText(getContext(),"SAVE",Toast.LENGTH_SHORT).show();
        FragmentTransaction ft = getParentFragmentManager().beginTransaction();
        ft.replace(R.id.content,new CategoriesDetailFragment());
        ft.addToBackStack(" ");
        ft.commit();
    }
}