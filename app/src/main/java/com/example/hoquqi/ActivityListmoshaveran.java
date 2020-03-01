package com.example.hoquqi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.hoquqi.adapter.AdapterMoshaver;
import com.example.hoquqi.dataBase.Database;
import com.example.hoquqi.model.Moshaver;

import java.util.ArrayList;

public class ActivityListmoshaveran extends AppCompatActivity {

    /*create object for xml*/
    ImageView imgBack;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

    /*array type of model moshver*/
    ArrayList<Moshaver> moshaverArrayList = new ArrayList<>();

    /*objet type of AdapterMoshaver*/
    AdapterMoshaver adapterMoshaver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_moshaveran);

        /* Get object from xml file*/
        recyclerView = findViewById(R.id.recycler_view);
        imgBack = findViewById(R.id.img_back);

        /*1.calling method for get data from database and store in array*/
        moshaverArrayList = callDataBase();

        /*2.calling method to set RecyclerAdapter */
        setupRecyclerAdapter(moshaverArrayList);

        /*3.click to back*/
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    /*4.method get array parametr and set from RecyclerAdapter*/
    private void setupRecyclerAdapter(ArrayList<Moshaver> list) {
        adapterMoshaver = new AdapterMoshaver(this, list);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapterMoshaver);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    /*5.method to get data from data bsase and return model array*/
    public ArrayList<Moshaver> callDataBase() {
        ArrayList<Moshaver> moshavers = new ArrayList<>();
        moshavers = Database.getdataMoshaver(getApplicationContext());
        return moshavers;
    }

}
