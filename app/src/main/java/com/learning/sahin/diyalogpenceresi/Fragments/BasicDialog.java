package com.learning.sahin.diyalogpenceresi.Fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.learning.sahin.diyalogpenceresi.Activities.Main;
import com.learning.sahin.diyalogpenceresi.R;

/**
 * Created by Sahin on 18.11.2016.
 */

public class BasicDialog extends DialogFragment implements View.OnClickListener{

    public static BasicDialog newInstance(int num) {
        BasicDialog f = new BasicDialog();

        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int style = DialogFragment.STYLE_NORMAL,theme;
        //style = DialogFragment.STYLE_NO_TITLE;
        //style = DialogFragment.STYLE_NO_FRAME;
        //style = DialogFragment.STYLE_NO_INPUT;

        theme = android.R.style.Theme_Holo_Light_Panel;
        //theme = android.R.style.Theme_Holo;
        //theme = android.R.style.Theme_Holo_Light;
        //theme = android.R.style.Theme_Holo_Light_Dialog;
        //theme = android.R.style.Theme_Holo_Light_Panel;

        setStyle(style, theme);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.basic_fragment_layout, container, false);
        View tv = v.findViewById(R.id.basic_text);
        ((TextView)tv).setText("Text Alanı");

        Button button = (Button)v.findViewById(R.id.basic_show);
        Button btnClose = (Button)v.findViewById(R.id.basic_close);
        button.setOnClickListener(this);
        btnClose.setOnClickListener(this);

        return v;
    }

    @Override
    public void onStop() {
        this.dismiss();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.basic_show:
                ((Main)getActivity()).basicDialog();
                break;
            case R.id.basic_close:
                getDialog().dismiss();
                break;
            default:break;
        }
    }
}
