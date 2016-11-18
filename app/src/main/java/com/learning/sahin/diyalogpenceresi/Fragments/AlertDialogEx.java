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

public class AlertDialogEx extends DialogFragment {
    public static AlertDialogEx newInstance(int title) {
        AlertDialogEx frag = new AlertDialogEx();
        Bundle args = new Bundle();
        args.putInt("title", title);
        frag.setArguments(args);
        return frag;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int title = getArguments().getInt("title");

        return new AlertDialog.Builder(getActivity())
                .setIcon(R.drawable.ic_action_group_work)
                .setTitle(title)
                .setPositiveButton(R.string.alert_dialog_ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                ((Main)getActivity()).doPositiveClick();
                            }
                        }
                )
                .setNegativeButton(R.string.alert_dialog_cancel,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                ((Main)getActivity()).doNegativeClick();
                            }
                        }
                )
                .create();
    }

}
