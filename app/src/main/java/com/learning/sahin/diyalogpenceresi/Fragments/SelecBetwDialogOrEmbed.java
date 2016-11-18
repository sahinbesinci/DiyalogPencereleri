package com.learning.sahin.diyalogpenceresi.Fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.learning.sahin.diyalogpenceresi.R;

/**
 * Created by Sahin on 18.11.2016.
 */

public class SelecBetwDialogOrEmbed extends DialogFragment {
    public static SelecBetwDialogOrEmbed newInstance() {
        return new SelecBetwDialogOrEmbed();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.selecting_between_dialog_or_embedding_layout, container, false);
        View tv = v.findViewById(R.id.tvSelecBetwDiaOrEmbed);
        ((TextView)tv).setText("This is an instance of SelecBetwDialogOrEmbed");
        return v;
    }
}