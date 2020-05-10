package com.example.tareamascotasrecycler.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.example.tareamascotasrecycler.MyData;
import com.example.tareamascotasrecycler.R;
import com.example.tareamascotasrecycler.adapter.MascotaAdapter;
import com.example.tareamascotasrecycler.pojo.MascotaDataModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

   private ArrayList<MascotaDataModel> petProfiles;
   private RecyclerView rv_profilelistpets;
    private  ArrayList<MascotaDataModel> data;
    private  RecyclerView.Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_perfil, container, false);
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        rv_profilelistpets= v.findViewById(R.id.rcvPetsProfile);

        GridLayoutManager grid= new GridLayoutManager(getContext(),3);
        grid.setOrientation(RecyclerView.VERTICAL);
        rv_profilelistpets.setLayoutManager(grid);
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
        rv_profilelistpets.setAdapter(adapter);
    }
}
