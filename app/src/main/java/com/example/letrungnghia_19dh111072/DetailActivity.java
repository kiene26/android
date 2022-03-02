package com.example.letrungnghia_19dh111072;

    import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

public class DetailActivity extends AppCompatActivity {
    TextView txtNamedetail,txtDecriptiondetail;
    ImageView imgfurnituredetail;
    Toolbar toolbardetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent=getIntent();
        toolbardetail=findViewById(R.id.toolbardetail);
        Furniture furniture=(Furniture) intent.getSerializableExtra("furniture");
        String titlename=furniture.name;
        toolbardetail.setTitle(titlename);
        setSupportActionBar(toolbardetail);
        txtNamedetail=findViewById(R.id.txtNamedetail);
        txtDecriptiondetail=findViewById(R.id.txtDescriptiondetail);
        imgfurnituredetail=findViewById(R.id.imgFurnituredetail);
        txtNamedetail.setText(furniture.name);
        txtDecriptiondetail.setText(furniture.des);
        imgfurnituredetail.setImageResource(furniture.image);
    }
}