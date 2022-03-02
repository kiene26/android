package com.example.letrungnghia_19dh111072;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoriesDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class    CategoriesDetailFragment extends Fragment implements CategoriesAdapter.Listener {

    RecyclerView rcCategoriesDetail;
    ArrayList<Furniture> arrayList;
    CategoriesAdapter categoriesAdapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CategoriesDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoriesDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoriesDetailFragment newInstance(String param1, String param2) {
        CategoriesDetailFragment fragment = new CategoriesDetailFragment();
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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcCategoriesDetail=view.findViewById(R.id.rcCategoriesDetail);
        arrayList=Utilities.dataHomeFromCate;
        categoriesAdapter=new CategoriesAdapter(arrayList,this::onClick);
        rcCategoriesDetail.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rcCategoriesDetail.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
        rcCategoriesDetail.setAdapter(categoriesAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories_detail, container, false);
    }

    @Override
    public void onClick(Furniture furniture) {
        Toast.makeText(getContext(),"SAVE",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(getContext(),DetailActivity.class);
        intent.putExtra("furniture",furniture);
        startActivity(intent);
    }
}