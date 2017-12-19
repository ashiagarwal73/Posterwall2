package com.example.ashi.posterwall;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout.addTab(tabLayout.newTab().setText("EVENTS"));
        tabLayout.addTab(tabLayout.newTab().setText("SOCIETY"));
        PagerAdapter pagerAdapter=new com.example.ashi.posterwall.PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
