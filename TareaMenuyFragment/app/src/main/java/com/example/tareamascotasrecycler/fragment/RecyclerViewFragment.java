package com.example.tareamascotasrecycler.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tareamascotasrecycler.MyData;
import com.example.tareamascotasrecycler.R;
import com.example.tareamascotasrecycler.adapter.MascotaAdapter;
import com.example.tareamascotasrecycler.pojo.MascotaDataModel;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    private  RecyclerView rv_listPet;
    private  RecyclerView.Adapter adapter;
    private  ArrayList<MascotaDataModel> data;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recycler_view,container,false);


        //view V  tiene fragment_recyclerview, x eso se busca dentro de v
        rv_listPet =(RecyclerView) v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(RecyclerView.VERTICAL);
        rv_listPet.setLayoutManager(llm);

        initiateData();
        initiateAdapter();

        return v;
    }

    private void initiateData(){
        data = new ArrayList<MascotaDataModel>();
        for (int i = 0; i< MyData.nameArray.length; i++){
            data.add(new MascotaDataModel(
                    MyData.nameArray[i],
                    MyData.drawableArray[i],
                    MyData.favArray[i]

            ));
        }
    }

    private  void initiateAdapter(){
        adapter = new MascotaAdapter(data,getActivity());
        rv_listPet.setAdapter(adapter);
    }

}
