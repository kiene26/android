package com.example.letrungnghia_19dh111072;

import java.io.Serializable;
import java.lang.reflect.Array;

public class Furniture implements Serializable {
    String name;
    String des;
    int image;
    public Furniture(String name,String des,int image)
    {
        this.name=name;
        this.des=des;
        this.image=image;
    }
}
