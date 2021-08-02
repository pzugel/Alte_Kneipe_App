package com.ffm.altekneipeapp.dashboard.items;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import com.ffm.altekneipeapp.MainActivity;
import com.ffm.altekneipeapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DashboardStartScreen extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.dashboard_startscreen_fragment, container, false);
        FloatingActionButton fab = view.findViewById(R.id.arrow_button);

        final OvershootInterpolator interpolator = new OvershootInterpolator();

        TranslateAnimation animation1 = new TranslateAnimation(0, 20, 0, 20);
        TranslateAnimation animation2 = new TranslateAnimation(20,0,20,0);

        animation1.setFillAfter(true);
        animation2.setFillAfter(true);

        animation1.setDuration(800);
        animation1.setStartOffset(50);

        animation1.setAnimationListener(new Animation.AnimationListener(){

            @Override
            public void onAnimationEnd(Animation arg0) {
                // start animation2 when animation1 ends (continue)
                fab.startAnimation(animation2);
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onAnimationStart(Animation arg0) {
                // TODO Auto-generated method stub
            }

        });


        animation2.setDuration(800);
        animation2.setStartOffset(50);

        //animation2 AnimationListener
        animation2.setAnimationListener(new Animation.AnimationListener(){

            @Override
            public void onAnimationEnd(Animation arg0) {
                // start animation1 when animation2 ends (repeat)
                fab.startAnimation(animation1);
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationStart(Animation arg0) {
                // TODO Auto-generated method stub

            }

        });

        fab.startAnimation(animation1);

        /*
        ViewCompat.animate(fab).translationX(50f).translationY(50f).
                withLayer().
                setDuration(1000).
                setInterpolator(interpolator).
                start();
    */

        return view;
    }
}
