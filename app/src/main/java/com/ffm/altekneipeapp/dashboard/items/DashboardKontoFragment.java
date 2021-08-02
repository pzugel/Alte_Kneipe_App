package com.ffm.altekneipeapp.dashboard.items;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.ffm.altekneipeapp.MainActivity;
import com.ffm.altekneipeapp.R;
import com.ffm.altekneipeapp.databinding.DashboardKontoFragmentBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DashboardKontoFragment extends Fragment {

    public final double DRINK0_PRICE = 1.0;
    public final double DRINK1_PRICE = 1.0;
    public final double DRINK2_PRICE = 1.0;

    private DashboardKontoFragmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        SharedPreferences settings = getActivity().getSharedPreferences(MainActivity.PREFS_NAME, 0);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.dashboard_konto_fragment, container, false);

        //Add buttons
        FloatingActionButton btn_addDrink0 = (FloatingActionButton) view.findViewById(R.id.add_drink0);
        FloatingActionButton btn_addDrink1 = (FloatingActionButton) view.findViewById(R.id.add_drink1);
        FloatingActionButton btn_addDrink2 = (FloatingActionButton) view.findViewById(R.id.add_drink2);

        //Sub buttons
        FloatingActionButton btn_subDrink0 = (FloatingActionButton) view.findViewById(R.id.sub_drink0);
        FloatingActionButton btn_subDrink1 = (FloatingActionButton) view.findViewById(R.id.sub_drink1);
        FloatingActionButton btn_subDrink2 = (FloatingActionButton) view.findViewById(R.id.sub_drink2);

        //Pay Button
        TextView amount_pay = (TextView) view.findViewById(R.id.amount_pay);

        //Pay Label
        Button btn_pay = (Button) view.findViewById(R.id.btn_pay);

        //Drink Labels
        EditText amount_drink0 = (EditText) view.findViewById(R.id.amount_drink0_text);
        EditText amount_drink1 = (EditText) view.findViewById(R.id.amount_drink1_text);
        EditText amount_drink2 = (EditText) view.findViewById(R.id.amount_drink2_text);

        btn_addDrink0.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Increase amount counter
                int amt = settings.getInt("amount_drink0", 0);
                ++ amt;
                amount_drink0.setText(String.valueOf(amt));

                //Update total price
                int amt_Pay = settings.getInt("amount_pay", 0);
                amt_Pay += DRINK0_PRICE;
                amount_pay.setText(String.valueOf(amt_Pay)+"€");

                //Save state
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt("amount_drink0", amt);
                editor.putInt("amount_pay", amt_Pay);
                editor.commit();
            }
        });
        btn_subDrink0.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int amt = settings.getInt("amount_drink0", 0);
                int amt_Pay = settings.getInt("amount_pay", 0);
                if(amt > 0 && amt_Pay > 0){
                    //Decrease amount counter
                    -- amt;
                    amount_drink0.setText(String.valueOf(amt));

                    //Update total price
                    amt_Pay -= DRINK0_PRICE;
                    amount_pay.setText(String.valueOf(amt_Pay)+"€");

                    //Save state
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("amount_drink0", amt);
                    editor.putInt("amount_pay", amt_Pay);
                    editor.commit();
                }
            }
        });

        btn_addDrink1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Increase amount counter
                int amt = settings.getInt("amount_drink1", 0);
                ++ amt;
                amount_drink1.setText(String.valueOf(amt));

                //Update total price
                int amt_Pay = settings.getInt("amount_pay", 0);
                amt_Pay += DRINK1_PRICE;
                amount_pay.setText(String.valueOf(amt_Pay)+"€");

                //Save state
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt("amount_drink1", amt);
                editor.putInt("amount_pay", amt_Pay);
                editor.commit();
            }
        });
        btn_subDrink1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int amt = settings.getInt("amount_drink1", 0);
                int amt_Pay = settings.getInt("amount_pay", 0);
                if(amt > 0 && amt_Pay > 0){
                    //Decrease amount counter
                    -- amt;
                    amount_drink1.setText(String.valueOf(amt));

                    //Update total price
                    amt_Pay -= DRINK1_PRICE;
                    amount_pay.setText(String.valueOf(amt_Pay)+"€");

                    //Save state
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("amount_drink1", amt);
                    editor.putInt("amount_pay", amt_Pay);
                    editor.commit();
                }
            }
        });

        btn_addDrink2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Increase amount counter
                int amt = settings.getInt("amount_drink2", 0);
                ++ amt;
                amount_drink2.setText(String.valueOf(amt));

                //Update total price
                int amt_Pay = settings.getInt("amount_pay", 0);
                amt_Pay += DRINK2_PRICE;
                amount_pay.setText(String.valueOf(amt_Pay)+"€");

                //Save state
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt("amount_drink2", amt);
                editor.putInt("amount_pay", amt_Pay);
                editor.commit();
            }
        });
        btn_subDrink2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int amt = settings.getInt("amount_drink2", 0);
                int amt_Pay = settings.getInt("amount_pay", 0);
                if(amt > 0 && amt_Pay > 0){
                    //Decrease amount counter
                    -- amt;
                    amount_drink2.setText(String.valueOf(amt));

                    //Update total price
                    amt_Pay -= DRINK2_PRICE;
                    amount_pay.setText(String.valueOf(amt_Pay)+"€");

                    //Save state
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("amount_drink2", amt);
                    editor.putInt("amount_pay", amt_Pay);
                    editor.commit();
                }
            }
        });


        btn_pay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.context, R.style.AlertDialog)
                        .setTitle("Check-Out")
                        .setMessage("Jetzt bezahlen?")

                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton("Ja", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                amount_pay.setText("0€");
                                amount_drink0.setText(String.valueOf("0"));
                                amount_drink1.setText(String.valueOf("0"));
                                amount_drink2.setText(String.valueOf("0"));

                                SharedPreferences.Editor editor = settings.edit();
                                editor.putInt("amount_drink0", 0);
                                editor.putInt("amount_drink1", 0);
                                editor.putInt("amount_drink2", 0);
                                editor.putInt("amount_pay", 0);
                                editor.commit();
                            }
                        })

                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton("Nein", null)
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .show();
                dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.teal_700));
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.teal_700));


            }
        });

        //Load drink amounts
        int amount_drink0_int = settings.getInt("amount_drink0", 0);
        amount_drink0.setText(String.valueOf(amount_drink0_int));
        int amount_drink1_int = settings.getInt("amount_drink1", 0);
        amount_drink1.setText(String.valueOf(amount_drink1_int));
        int amount_drink2_int = settings.getInt("amount_drink2", 0);
        amount_drink2.setText(String.valueOf(amount_drink2_int));

        int amount_pay_int = settings.getInt("amount_pay", 0);
        amount_pay.setText(String.valueOf(amount_pay_int) + "€");

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
