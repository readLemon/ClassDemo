package com.example.classdemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler(){
        @SuppressLint("HandlerLeak")
        @Override
        public void handleMessage(@NonNull Message msg) {
        }
    };

//    private MyHandler handler = new MyHandler(this);
    private TabLayout tabMain;
    private ViewPager vpMain;
    private SwipeRefreshLayout srlMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        srlMain.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srlMain.setRefreshing(false);
            }
        });

//        Looper.prepare();
//        Looper.loop();
//
//        handler.sendEmptyMessage(2);
//        handler.postDelayed();
//        runOnUiThread();



//        ViewGroup;
//        View
//        List<Fragment> fms = new ArrayList<>();
//        fms.add(new TestFragment01(1));
//        fms.add(new TestFragment01(2));
//        fms.add(new TestFragment01(3));
//        fms.add(new TestFragment01(4));
//        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fms);
//        vpMain.setAdapter(adapter);
//        tabMain.setupWithViewPager(vpMain);



    }

    private void initView() {
        tabMain = findViewById(R.id.tab_main);
        vpMain = findViewById(R.id.vp_main);
        srlMain = findViewById(R.id.srl_main);

        findViewById(R.id.btn_gc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.gc();
            }
        });
    }


    private static class MyHandler extends Handler{

        private WeakReference<MainActivity> weakReference;
        MyHandler(MainActivity activity) {
            weakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
