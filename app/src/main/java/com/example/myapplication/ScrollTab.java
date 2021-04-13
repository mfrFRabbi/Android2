package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ScrollTab extends FragmentActivity {
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_tab);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new CustomAda(getSupportFragmentManager()));

    }
}
class  CustomAda extends FragmentStatePagerAdapter{


    public CustomAda(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if(position == 0){
            fragment = new FragmentOne();
        }
        else if(position == 1){
            fragment = new FragmentTwo();
        }
        else if(position == 2){
            fragment = new FragmentThree();

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position){
        if(position == 0){
          return "FragmentOne";
        }
        else if(position == 1){
            return "FragmentTwo";
        }
        else if(position == 2){
            return "FragmentTree";

        }
        return null;
    }

}