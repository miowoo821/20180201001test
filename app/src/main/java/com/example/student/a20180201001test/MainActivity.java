package com.example.student.a20180201001test;

import android.app.Fragment;

import android.support.v4.app.FragmentPagerAdapter;

import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static ViewPager viewPager;
    private TabLayout tabLayout;
    public static int lastPosition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager=(ViewPager)findViewById(R.id.vp1);
        tabLayout=(TabLayout)findViewById(R.id.tab1);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                lastPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setupViewPager(viewPager);

        tabLayout=new TabLayout(this);


      tabLayout.setupWithViewPager(viewPager);


    }





    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter1 adapter = new ViewPagerAdapter1(getSupportFragmentManager());
        adapter.addFragment(new Order_Fragment(), "Title 1");
        adapter.addFragment(new Activity_Fragment(), "Title 2");

        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter1 extends FragmentPagerAdapter {
        private final List<android.support.v4.app.Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();
        public ViewPagerAdapter1(android.support.v4.app.FragmentManager manager) {
            super(manager);//回去找父類別的建構式，裡面沒有FragmentManager的類型
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(android.support.v4.app.Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }


//    class ViewPagerAdapter extends FragmentPagerAdapter {
//        private final List<Fragment> mFragmentList = new ArrayList<>();
//        private final List<String> mFragmentTitleList = new ArrayList<>();
//
//        public ViewPagerAdapter(android.support.v4.app.FragmentManager manager) {
//            super(manager);//回去找父類別的建構式，裡面沒有FragmentManager的類型
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return mFragmentList.get(position);
//        }
//
//        @Override
//        public int getCount() {
//            return mFragmentList.size();
//        }
//
//        public void addFragment(Fragment fragment, String title) {
//            mFragmentList.add(fragment);
//            mFragmentTitleList.add(title);
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return mFragmentTitleList.get(position);
//        }
//    }

}
