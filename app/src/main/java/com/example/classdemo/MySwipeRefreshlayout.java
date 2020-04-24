package com.example.classdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/**
 * Created by chenyang
 * on 20-4-23
 */
public class MySwipeRefreshlayout extends SwipeRefreshLayout {

    private float startX;
    private float startY;
    private float mTouchSlop;


    public MySwipeRefreshlayout(@NonNull Context context) {
        super(context);
    }

    public MySwipeRefreshlayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = ev.getX();
                startY = ev.getY();
                break;

            case MotionEvent.ACTION_MOVE:
                float dX = Math.abs(ev.getX() - startX);
                float dY = Math.abs(ev.getY() - startY);
                if (dX < mTouchSlop && dX > dY) {
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
