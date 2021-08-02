package com.ffm.altekneipeapp.status;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.ffm.altekneipeapp.App;
import com.ffm.altekneipeapp.MainActivity;
import com.ffm.altekneipeapp.R;
import com.ffm.altekneipeapp.databinding.FragmentStatusBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;

import org.jetbrains.annotations.NotNull;

public class StatusFragment extends Fragment {

    private FragmentStatusBinding binding;
    private static final String TAG = "DASHBOARD_STATUS";
    private Notification notification;
    private NotificationManagerCompat notificationManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SharedPreferences settings = getActivity().getSharedPreferences(MainActivity.PREFS_NAME, 0);


        notificationManager = NotificationManagerCompat.from(getContext());
        notification = new NotificationCompat.Builder(getActivity(), App.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Alte Kneipe App")
                .setContentText("Ab jetzt geöffnet!")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_status, container, false);
        ImageView indicatorOpenImage = view.findViewById(R.id.indcator_open_image);
        TextView indicatorOpenText = view.findViewById(R.id.indcator_open_text);
        Button openCloseButton = view.findViewById(R.id.openClose_button);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference isOpenRef = database.getReference("offen");
        DatabaseReference plenumRef = database.getReference().child("plenum");

        isOpenRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean isOpen = dataSnapshot.getValue(Boolean.class);
                Log.d(TAG, "Alte Kneipe ist geöffnet? " + isOpen);
                if(isOpen){
                    notificationManager.notify(1, notification);
                    indicatorOpenImage.setImageResource(R.drawable.ic_open);
                    indicatorOpenText.setText("Geöffnet");
                    openCloseButton.setText("Schließen");
                    openCloseButton.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.teal_700));
                } else {
                    indicatorOpenImage.setImageResource(R.drawable.ic_close);
                    indicatorOpenText.setText("Geschlossen");
                    openCloseButton.setText("Öffnen");
                    openCloseButton.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.teal_200));
                }

                openCloseButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        isOpenRef.setValue(!isOpen);
                    }


                });
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}