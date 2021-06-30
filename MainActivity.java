package com.example.fragmenttablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tablayout1;
    TabItem tab1,tab2,tab3;
    ViewPager vpager;
    PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tablayout1 = findViewById(R.id.tablayout1);
        tab1 = findViewById(R.id.tab1);
        tab2 = findViewById(R.id.tab2);
        tab3 = findViewById(R.id.tab3);
        vpager = findViewById(R.id.vpager);

        pageAdapter = new PageAdapter(getSupportFragmentManager(), tablayout1.getTabCount());
        vpager.setAdapter(pageAdapter);

        // Below listener will work, when we select any tab.
        tablayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                vpager.setCurrentItem(tab.getPosition());

                if(tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==1)
                    pageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // Below listener will work, when we swipe the page on screen.
        vpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout1));


    }
}
