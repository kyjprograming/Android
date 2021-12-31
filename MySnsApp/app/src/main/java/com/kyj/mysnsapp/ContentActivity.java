package com.kyj.mysnsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ContentActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView, topNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private HomeFrag home;
    private SearchFrag search;
    private UploadFrag upload;
    private FavoriteFrag favorite;
    private ProfileFrag profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        bottomNavigationView = findViewById(R.id.bottom_content);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_home:
                        setFrag(0);
                        break;
                    case R.id.action_search:
                        setFrag(1);
                        break;
                    case R.id.action_upload:
                        setFrag(2);
                        break;
                    case R.id.action_favorite:
                        setFrag(3);
                        break;
                    case R.id.action_profile:
                        setFrag(4);
                        break;
                }
                return true;
            }
        });
        topNavigationView = findViewById(R.id.top_content);
        topNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_upload:
                        Intent intent1 = new Intent(ContentActivity.this, UploadActivity.class);
                        break;
                    case R.id.action_favorite_list:
                        Intent intent2 = new Intent(ContentActivity.this, FavoriteListActivity.class);
                        break;
                    case R.id.action_message:
                        Intent intent3 = new Intent(ContentActivity.this, MessageActivity.class);
                        break;
                }
                return true;
            }
        });
        home = new HomeFrag();
        search = new SearchFrag();
        upload = new UploadFrag();
        favorite = new FavoriteFrag();
        profile = new ProfileFrag();
        setFrag(0); //첫 프래그먼트 화면 지정


    }

    //콘텐트 프래그먼트 교체 실행문
    private void setFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch(n){
            case 0:
                ft.replace(R.id.main_frame, home);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame, search);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame, upload);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_frame, favorite);
                ft.commit();
                break;

            case 4:
                ft.replace(R.id.main_frame, profile);
                ft.commit();
                break;
        }
    }
}