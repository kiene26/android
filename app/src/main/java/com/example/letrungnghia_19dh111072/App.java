package com.example.letrungnghia_19dh111072;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;

public class App extends Application {
    public static ArrayList<Furniture> datahome;
    public App()
    {

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
    public static ArrayList<Furniture> init(Context context){
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
    public static ArrayList<Furniture> getInstance(){
        if(datahome==null)
        {
            datahome=new ArrayList<Furniture>();
        }

        return datahome;
    }
}
