package com.example.fragmentactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationMenu;
    AddFragment addFragment;
    SearchFragment searchFragment;
    FilterFragment filterFragment;
    LinearLayout searchbar;
    BottomSheetDialog bottomSheetDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        addFragment = new AddFragment();
        searchFragment = new SearchFragment();
        filterFragment = new FilterFragment();
        SetFragment(addFragment);


        bottomNavigationMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId()){
                    case R.id.add:
                        bottomNavigationMenu.setItemBackgroundResource(R.color.colorAccent);
                        SetFragment(addFragment);
                        return true;
                    case R.id.search:
                        bottomNavigationMenu.setItemBackgroundResource(R.color.Green);
                        SetFragment(searchFragment);
                        return true;
                    case R.id.filter:
                        bottomNavigationMenu.setItemBackgroundResource(R.color.Yellow);
                        SetFragment(filterFragment);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }


    private void SetFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainframe,fragment);
        fragmentTransaction.commit();

    }

    private void init() {
        bottomNavigationMenu = findViewById(R.id.bottomnavigationbar);

    }
}
