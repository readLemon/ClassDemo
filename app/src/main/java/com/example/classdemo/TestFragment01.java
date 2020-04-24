package com.example.classdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyang
 * on 20-4-23
 */
public class TestFragment01 extends Fragment {

    private int index = 1;
    private View v;

    private TabLayout TlInner;
    private ViewPager VpInner;
    private AppCompatTextView tv;

    TestFragment01() {
    }

    TestFragment01(int index) {
        this.index = index;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test_01, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        v = view;
        tv = view.findViewById(R.id.tv_fragment_01);
        TlInner = view.findViewById(R.id.tl_fragment_01);
        VpInner = view.findViewById(R.id.vp_fragment_01);
        tv.setText("this is fragment " + index);

        List<Fragment> fms = new ArrayList<>();
        fms.add(new InnerFragment());
        fms.add(new InnerFragment());
        fms.add(new InnerFragment());
        fms.add(new InnerFragment());
        MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fms);
        VpInner.setAdapter(adapter);
        TlInner.setupWithViewPager(VpInner);

    }

    void hide() {
        v.findViewById(R.id.tl_fragment_01).setVisibility(View.INVISIBLE);
        v.findViewById(R.id.vp_fragment_01).setVisibility(View.INVISIBLE);
    }
}
