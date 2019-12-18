package com.example.lab5;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentA extends Fragment {
    String value;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            value = getArguments().getString("MSG");
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View RootView = inflater.inflate(R.layout.fragment_a, container, false);
        TextView textView = (TextView) RootView.findViewById(R.id.fragment_a);

        textView.setText(getProperText(value));

        return RootView;
    }

    public String getProperText(String text) {
        int vowelcount = text.replaceAll("(?i)[^a]", "").length();
        return "Vowels : " + vowelcount;
    }

}
