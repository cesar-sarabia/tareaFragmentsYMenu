package com.example.tareamascotasrecycler;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.tareamascotasrecycler.adapter.MascotaAdapter;
import com.example.tareamascotasrecycler.pojo.MascotaDataModel;

import java.util.ArrayList;

public class PetsFavorite extends AppCompatActivity {

    private static RecyclerView rv_listFavPet;
    private   ArrayList<MascotaDataModel> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets_favorite);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBarSecond);
        setSupportActionBar(toolbar);

        ActionBar actionbar= getSupportActionBar();
        if (actionbar!=null){
            actionbar.setDisplayHomeAsUpEnabled(true);
        }


        rv_listFavPet =(RecyclerView) findViewById(R.id.rvFavMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv_listFavPet.setLayoutManager(llm);
        initiateData();
        initiateAdapter();
    }


    private void initiateData(){
        data = new ArrayList<MascotaDataModel>();
        for (int i=0; i<MyData.nameArray.length; i++){
            if (MyData.favArray[i]>0){
                data.add(new MascotaDataModel(
                        MyData.nameArray[i],
                        MyData.drawableArray[i],
                        MyData.favArray[i]

                ));
            }

        }
    }

    private  void initiateAdapter(){
        MascotaAdapter adapter = new MascotaAdapter(data, this);
        rv_listFavPet.setAdapter(adapter);
    }


}
