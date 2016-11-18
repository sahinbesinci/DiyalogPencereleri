package com.learning.sahin.diyalogpenceresi.Fragments;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import com.learning.sahin.diyalogpenceresi.Activities.Main;
import com.learning.sahin.diyalogpenceresi.R;

/**
 * Created by Sahin on 18.11.2016.
 */

public class AlertDialog2Ex extends DialogFragment {
    public static AlertDialog2Ex newInstance(int title) {
        AlertDialog2Ex frag = new AlertDialog2Ex();
        Bundle args = new Bundle();
        args.putInt("title", title);
        frag.setArguments(args);
        return frag;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int title = getArguments().getInt("title");

        return new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setMessage("Mesaj Bölümü!")
                .setPositiveButton("Positive", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ((Main)getActivity()).doPositiveClick2();
                    }
                })
                .setNegativeButton("Negative", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ((Main)getActivity()).doNegativeClick2();
                    }
                })
                .setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((Main)getActivity()).doNeutralClick();
                        dialog.cancel();
                    }
                })
                .setIcon(R.drawable.ic_action_account_circle)
                .show();
    }
}
