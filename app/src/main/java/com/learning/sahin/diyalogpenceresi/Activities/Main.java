package com.learning.sahin.diyalogpenceresi.Activities;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.learning.sahin.diyalogpenceresi.Fragments.AlertDialog2Ex;
import com.learning.sahin.diyalogpenceresi.Fragments.AlertDialogEx;
import com.learning.sahin.diyalogpenceresi.Fragments.BasicDialog;
import com.learning.sahin.diyalogpenceresi.Fragments.SelecBetwDialogOrEmbed;
import com.learning.sahin.diyalogpenceresi.R;

/**
 * Created by Sahin on 18.11.2016.
 */

public class Main extends FragmentActivity implements View.OnClickListener{
    Button btnBasicDialog,btnAlertDialog,btnAlert2Dialog,btnEmbeddingDialog;
    static int mStackLevel = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        install_elements();
    }


    ////////////////////  Basic Dialog Butonu     -----------------------
    public void basicDialog() {
        mStackLevel++;
        // DialogFragment.show() will take care of adding the fragment
        // in a transaction.  We also want to remove any currently showing
        // dialog, so make our own transaction and take care of that here.
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        // Create and show the dialog.
        DialogFragment newFragment = BasicDialog.newInstance(mStackLevel);
        newFragment.show(ft, "dialog");
    }


    ////////////////////  Alert Dialog Butonu     -----------------------
    public void AlertDialogShow() {
        DialogFragment newFragment = AlertDialogEx.newInstance(R.string.alert_dialog_two_buttons_title);
        newFragment.show(getFragmentManager(), "dialog2");
    }

    public void doPositiveClick() {
        // Do stuff here.
        Log.i("AlertDialogShow", "Positive click!");
    }

    public void doNegativeClick() {
        // Do stuff here.
        Log.i("AlertDialogShow", "Negative click!");
    }

    ////////////////////   Alert Dialog 2 Butonu    -----------------------
    public void AlertDialog2Show() {
        DialogFragment newFragment = AlertDialog2Ex.newInstance(R.string.alert_dialog_two_buttons_title);
        newFragment.show(getFragmentManager(), "dialog3");
    }

    public void doPositiveClick2() {
        // Do stuff here.
        Log.i("AlertDialog2Show", "Positive click!");
    }

    public void doNegativeClick2() {
        // Do stuff here.
        Log.i("AlertDialog2Show", "Negative click!");
    }
    public void doNeutralClick() {
        // Do stuff here.
        Log.i("AlertDialog2Show", "Neutral click!");
    }

    ////////////////////   Selecting Between Dialog Or Embedding Butonu    -----------------------

    void SelectingBetweenDialogOrEmbedding() {
        // Create the fragment and show it as a dialog.
        DialogFragment newFragment = SelecBetwDialogOrEmbed.newInstance();
        newFragment.show(getFragmentManager(), "dialog");
    }



    private void install_elements()
    {
        btnBasicDialog = (Button) findViewById(R.id.btnBasicDialog);
        btnAlertDialog = (Button) findViewById(R.id.btnAlertDialog);
        btnAlert2Dialog = (Button) findViewById(R.id.btnAlert2Dialog);
        btnEmbeddingDialog = (Button) findViewById(R.id.btnEmbeddingDialog);
        btnBasicDialog.setOnClickListener(this);
        btnAlertDialog.setOnClickListener(this);
        btnAlert2Dialog.setOnClickListener(this);
        btnEmbeddingDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnBasicDialog:
                basicDialog();
                break;
            case R.id.btnAlertDialog:
                AlertDialogShow();
                break;
            case R.id.btnAlert2Dialog:
                AlertDialog2Show();
                break;
            case R.id.btnEmbeddingDialog:
                SelectingBetweenDialogOrEmbedding();
                break;
            default:break;
        }
    }
}
