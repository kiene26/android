package com.example.letrungnghia_19dh111072;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment {
    EditText edtName, edtEmail, edtPass, edtUsername;
    //RadioGroup rdbGender;
    RadioButton rdb1,rdb2;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
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
        inflater.inflate(R.menu.option_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        SharedPreferences pref = this.getActivity().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        edtName=getView().findViewById(R.id.edtName);
        edtEmail=getView().findViewById(R.id.edtEmail);
        rdb1=getView().findViewById(R.id.radiobutton1);
        rdb2=getView().findViewById(R.id.radiobutton2);
        editor.putString("email",edtEmail.getText().toString());
        editor.putString("name",edtName.getText().toString());
        editor.putBoolean("male",rdb1.isChecked());
        editor.putBoolean("female",rdb2.isChecked());
        editor.apply();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edtEmail = view.findViewById(R.id.edtEmail);
        SharedPreferences pref = this.getActivity().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        edtUsername = getView().findViewById(R.id.edtUsername);
        edtUsername.setInputType(InputType.TYPE_NULL);edtUsername.setTextColor(Color.BLACK);
        edtPass = getView().findViewById(R.id.edtPass);
        edtPass.setInputType(InputType.TYPE_NULL);edtPass.setTextColor(Color.BLACK);
        rdb1=getView().findViewById(R.id.radiobutton1);
        rdb2=getView().findViewById(R.id.radiobutton2);
        edtName=getView().findViewById(R.id.edtName);
        edtEmail=getView().findViewById(R.id.edtEmail);
        rdb1.setChecked(pref.getBoolean("male",false));
        rdb2.setChecked(pref.getBoolean("female",false));
        edtUsername.setText(pref.getString("username",null));
        edtPass.setText(pref.getString("password",null));
        edtName.setText(pref.getString("name",null));
        edtEmail.setText(pref.getString("email",null));
    }
}