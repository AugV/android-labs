package com.example.lab5;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentNoA extends Fragment {

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

        View RootView = inflater.inflate(R.layout.fragment_no_a, container, false);
        TextView textView = (TextView) RootView.findViewById(R.id.fragment_no_a);

        textView.setText(getProperText(value));

        return RootView;
    }

    public String getProperText(String text) {
        int length = text.length();
        int vowelcount = text.replaceAll("(?i)[^aeiou]", "").length();
        int lowercount = text.replaceAll("(?i)[^[A-Z]]", "").length()-1;
        int uppercount = text.replaceAll("(?i)[^[a-z]]", "").length()-1;
        return "Text length: " + length + "\nVowel count: "+ vowelcount + "\nlowercase: "+ (lowercount) + "\nuppercount: " + (length - lowercount);
    }
}
