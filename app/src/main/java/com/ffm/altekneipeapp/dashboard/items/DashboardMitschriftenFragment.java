package com.ffm.altekneipeapp.dashboard.items;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import com.ffm.altekneipeapp.MainActivity;
import com.ffm.altekneipeapp.R;

public class DashboardMitschriftenFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.dashboard_mitschriften_fragment, container, false);

        ImageButton expandButton_0 = view.findViewById(R.id.expand_button_0);
        final OvershootInterpolator interpolator = new OvershootInterpolator();


        TextView mitschrift_0 = view.findViewById(R.id.mitschrift_0);
        expandButton_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mitschrift_0.getVisibility() == View.GONE){
                    mitschrift_0.setVisibility(View.VISIBLE);
                    ViewCompat.animate(expandButton_0).
                            rotation(90f).
                            withLayer().
                            setDuration(300).
                            setInterpolator(interpolator).
                            start();
                } else {
                    mitschrift_0.setVisibility(View.GONE);
                    ViewCompat.animate(expandButton_0).
                            rotation(0f).
                            withLayer().
                            setDuration(300).
                            setInterpolator(interpolator).
                            start();
                }

            }
        });

        ImageButton expandButton_1 = view.findViewById(R.id.expand_button_1);
        TextView mitschrift_1 = view.findViewById(R.id.mitschrift_1);
        expandButton_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mitschrift_1.getVisibility() == View.GONE){
                    mitschrift_1.setVisibility(View.VISIBLE);
                    expandButton_1.setImageResource(R.drawable.ic_expand);
                } else {
                    mitschrift_1.setVisibility(View.GONE);
                    expandButton_1.setImageResource(R.drawable.ic_unexpanded);
                }

            }
        });

        ImageButton expandButton_2 = view.findViewById(R.id.expand_button_2);
        TextView mitschrift_2 = view.findViewById(R.id.mitschrift_2);
        expandButton_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mitschrift_2.getVisibility() == View.GONE){
                    mitschrift_2.setVisibility(View.VISIBLE);
                    expandButton_2.setImageResource(R.drawable.ic_expand);
                } else {
                    mitschrift_2.setVisibility(View.GONE);
                    expandButton_2.setImageResource(R.drawable.ic_unexpanded);
                }

            }
        });

        ImageButton expandButton_3 = view.findViewById(R.id.expand_button_3);
        TextView mitschrift_3 = view.findViewById(R.id.mitschrift_3);
        expandButton_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mitschrift_3.getVisibility() == View.GONE){
                    mitschrift_3.setVisibility(View.VISIBLE);
                    expandButton_3.setImageResource(R.drawable.ic_expand);
                } else {
                    mitschrift_3.setVisibility(View.GONE);
                    expandButton_3.setImageResource(R.drawable.ic_unexpanded);
                }

            }
        });

        return view;
    }
}
