package com.example.appbanhang.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.appbanhang.Adapter.ImgAdapter;
import com.example.appbanhang.Models.AppImg;
import com.example.appbanhang.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator3;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImgAdapter imgAdapter;
    ArrayList<AppImg> list;
    Toolbar toolbar;
    ViewPager2 viewPager2;
    CircleIndicator3 circleIndicator3;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ánh xạ
        drawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView=(NavigationView) findViewById(R.id.navigation_view);
        toolbar=(Toolbar) findViewById(R.id.toolbar_top);
        viewPager2=(ViewPager2) findViewById(R.id.view_pager2);
        circleIndicator3=(CircleIndicator3) findViewById(R.id.circleindicator_3);
        //xử lí toolBar
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        imgAdapter=new ImgAdapter(this,getArrayList());
        viewPager2.setAdapter(imgAdapter);
        circleIndicator3.setViewPager(viewPager2);
    }

    private ArrayList<AppImg> getArrayList() {
        list=new ArrayList<>();
        list.add(new AppImg(R.drawable.img_quangcao1));
        list.add(new AppImg(R.drawable.img_quangcao2));
        list.add(new AppImg(R.drawable.img_quangcao3));
        return list;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
}