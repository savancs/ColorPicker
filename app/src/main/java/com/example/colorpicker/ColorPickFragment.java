package com.example.colorpicker;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

public class ColorPickFragment extends Fragment {

    private String[] colors;
    private GridLayout grid;

    private OnMessageSendListener mListener;

    private View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int buttonIndex = grid.indexOfChild(v);
            Toast.makeText(getActivity(), colors[buttonIndex], Toast.LENGTH_LONG).show();
            //context.OnMessageSend

        }
    };

    public ColorPickFragment() {
        // Empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnMessageSendListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnMessageSendListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // get the resources String Array bellow
        colors = null;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment here
        View var = inflater.inflate(R.layout.fragment_color_pick, container, false);
        grid = var.findViewById(R.id.lightGrid);

        // set the color of each button here
        colors = getResources().getStringArray(R.array.colors_array);


        // bind the listener to each button


        for(int i =0; i < grid.getChildCount(); i++){
            Button currentButton = (Button) grid.getChildAt(i);
            currentButton.setOnClickListener(buttonListener);
            currentButton.setBackgroundColor(Color.parseColor(colors[i]));
        }
        return var;
    }
}