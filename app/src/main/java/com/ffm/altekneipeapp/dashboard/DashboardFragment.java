package com.ffm.altekneipeapp.dashboard;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.ffm.altekneipeapp.MainActivity;
import com.ffm.altekneipeapp.dashboard.items.DashboardKontoFragment;
import com.ffm.altekneipeapp.dashboard.items.DashboardMitschriftenFragment;
import com.ffm.altekneipeapp.dashboard.items.DashboardStartScreen;
import com.ffm.altekneipeapp.databinding.FragmentDashboardBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.ffm.altekneipeapp.R;

import org.jetbrains.annotations.NotNull;

public class DashboardFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentDashboardBinding binding;
    private DrawerLayout drawer;
    private NavigationView navigationView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Create navigation toolbar
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        drawer = view.findViewById(R.id.dashboard_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = view.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Navigation item to display on start
        SharedPreferences settings = getActivity().getSharedPreferences(MainActivity.PREFS_NAME, 0);

        int itemID = settings.getInt("navigation_item_id", 0);

        if(itemID == 0){
            Log.d("IF", "NULL");
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new DashboardStartScreen()).commit();
        } else {
            Log.d("ELSE", String.valueOf(itemID));

            switch (itemID){

                case R.id.dashboard_konto_menu:
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new DashboardKontoFragment()).commit();
                    break;
                case R.id.dashboard_mitschriften_menu:
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new DashboardMitschriftenFragment()).commit();
                    break;
                case R.id.dashboard_teilen_menu:
                    Log.d("TEILEN", "selected share");
                    Toast.makeText(getContext(), "Share", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.dashboard_logout_menu:
                    Log.d("LOGOUT", "selected logout");
                    Toast.makeText(getContext(), "Logout", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {

        Log.d("Switch", String.valueOf(item.getItemId()));
        SharedPreferences settings = getActivity().getSharedPreferences(MainActivity.PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("navigation_item_id", item.getItemId());
        editor.commit();

        switch (item.getItemId()){

            case R.id.dashboard_konto_menu:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DashboardKontoFragment()).commit();
                break;
            case R.id.dashboard_mitschriften_menu:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DashboardMitschriftenFragment()).commit();
                break;
            case R.id.dashboard_teilen_menu:
                Log.d("TEILEN", "selected share");
                Toast.makeText(getContext(), "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dashboard_logout_menu:
                Log.d("LOGOUT", "selected logout");
                Toast.makeText(getContext(), "Logout", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}