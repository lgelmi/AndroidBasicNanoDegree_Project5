package com.example.android.pathadvisor;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
        ViewPager pager = findViewById(R.id.pager);
        pager.setAdapter(new CategoryPageAdapter(getSupportFragmentManager(), this));
        TabLayout tabs = findViewById(R.id.main_tabs);
        tabs.setupWithViewPager(pager);
    }
}
