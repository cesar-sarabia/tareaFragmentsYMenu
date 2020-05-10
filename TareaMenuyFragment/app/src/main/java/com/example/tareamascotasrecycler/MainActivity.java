package com.example.tareamascotasrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


import com.example.tareamascotasrecycler.adapter.MascotaAdapter;
import com.example.tareamascotasrecycler.adapter.PageAdapter;
import com.example.tareamascotasrecycler.fragment.PerfilFragment;
import com.example.tareamascotasrecycler.fragment.RecyclerViewFragment;
import com.example.tareamascotasrecycler.pojo.MascotaDataModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private Toolbar myChildToolBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadToolBar();

        tabLayout=(TabLayout) findViewById(R.id.tlTabMain);
        viewPager=(ViewPager) findViewById(R.id.vpPager);

        setUpViewPager();
    }

    public void loadToolBar(){
        Toolbar actionBar = findViewById(R.id.toolBarMain);
        actionBar.inflateMenu(R.menu.menu);
        ImageButton imgBtnStar=actionBar.findViewById(R.id.imbRighStart);

        imgBtnStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getApplicationContext(), PetsFavorite.class);
                startActivity(intent);
            }
        });

        actionBar.setOnMenuItemClickListener(new
            Toolbar.OnMenuItemClickListener() {
                @Override
                    public boolean onMenuItemClick(MenuItem item) {
                      switch (item.getItemId()){
                          case R.id.action_about:
                              Intent intentabout = new Intent(MainActivity.this,about.class );
                              startActivity(intentabout);
                              break;
                          case R.id.action_contacto:
                              Intent intentcontact = new Intent(MainActivity.this,contacto.class);
                              startActivity(intentcontact);
                              break;
                          default:
                              break;
                      }
                      return true;
                    }
        });
    }

    private ArrayList<Fragment> addFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return  fragments;
    }

    //load viewpager
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),addFragments(),1));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ichouse);
        tabLayout.getTabAt(1).setIcon(R.drawable.icdogpaw);
    }


}
