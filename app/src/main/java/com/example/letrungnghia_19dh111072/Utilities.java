package com.example.letrungnghia_19dh111072;

import android.util.Log;

import java.util.ArrayList;

public class Utilities {
    public static ArrayList<Furniture> data;
    public static ArrayList<Furniture> dataHomeFromCate;
    public Utilities(){

    }
    public static ArrayList<Furniture> getInstance(){
        if(data==null)
        {
            data=new ArrayList<Furniture>();
        }

        return data;
    }
    public static ArrayList<Furniture> getInstanceFromCate(){

        if(dataHomeFromCate==null)
        {
            dataHomeFromCate=new ArrayList<Furniture>();
        }

        return dataHomeFromCate;
    }
}
