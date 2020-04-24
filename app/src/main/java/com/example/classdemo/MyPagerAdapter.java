package com.example.classdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyang
 * on 20-4-23
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fms;

    MyPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Fragment> fms) {
        super(fm, behavior);
        this.fms = fms;
    }

    @Override
    public int getCount() {
        return fms.size();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fms.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "" + position;
    }

    void hide() {
        for (Fragment f : fms) {
            ((TestFragment01)f).hide();
        }
    }
}
