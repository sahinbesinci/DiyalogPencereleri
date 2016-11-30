package com.learning.sahin.diyalogpenceresi.Activities;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
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
    Button btnBasicDialog,btnAlertDialog,btnAlert2Dialog,btnEmbeddingDialog,btnProgressDialog;

    ProgressDialog progressBar;
    private int progressBarStatus = 0;
    private Handler progressBarHandler = new Handler();
    private long fileSize = 0;

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
        btnProgressDialog = (Button) findViewById(R.id.btnProgressDialog);
        btnBasicDialog.setOnClickListener(this);
        btnAlertDialog.setOnClickListener(this);
        btnAlert2Dialog.setOnClickListener(this);
        btnEmbeddingDialog.setOnClickListener(this);
        btnProgressDialog.setOnClickListener(this);
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
            case R.id.btnProgressDialog:
                ProgressDialogShow();
            default:break;
        }
    }

    private void ProgressDialogShow() {
        // prepare for a progress bar dialog
        progressBar = new ProgressDialog(this);
        progressBar.setCancelable(true);
        progressBar.setMessage("File downloading ...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.show();
        //reset progress bar status
        progressBarStatus = 0;
        //reset filesize
        fileSize = 0;
        new Thread(new Runnable() {
            public void run() {
                while (progressBarStatus < 100) {
                    // process some tasks
                    progressBarStatus = doSomeTasks();
                    // your computer is too fast, sleep 1 second
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // Update the progress bar
                    progressBarHandler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressBarStatus);
                        }
                    });
                }
                // ok, file is downloaded,
                if (progressBarStatus >= 100) {
                    // sleep 2 seconds, so that you can see the 100%
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // close the progress bar dialog
                    progressBar.dismiss();
                }
            }
        }).start();
    }
    public int doSomeTasks() {
        while (fileSize <= 1000000) {
            fileSize++;
            if (fileSize == 100000) {
                return 10;
            } else if (fileSize == 200000) {
                return 20;
            } else if (fileSize == 300000) {
                return 30;
            }
        }
        return 100;
    }
}
