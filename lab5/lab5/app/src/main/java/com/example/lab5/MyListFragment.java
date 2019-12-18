package com.example.lab5;

import android.app.ListFragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.app.Fragment;


public class MyListFragment extends ListFragment implements OnItemClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Masinos, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        String itemString = getListView().getItemAtPosition(position).toString();

        Bundle msg = new Bundle();
        msg.putString("MSG", itemString);

        Toast.makeText(getActivity(), itemString, Toast.LENGTH_SHORT).show();

        if (itemString.toLowerCase().contains("a")) {
                FragmentA fragmentA = new FragmentA();
                fragmentA.setArguments(msg);

                getActivity().getFragmentManager().beginTransaction()
                        .replace(R.id.fragment1, fragmentA, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
        }
        else {
            FragmentNoA fragmentNoA = new FragmentNoA();
            fragmentNoA.setArguments(msg);

            getActivity().getFragmentManager().beginTransaction()
                    .replace(R.id.fragment1, fragmentNoA, "findThisFragment")
                    .addToBackStack(null)
                    .commit();
        }
    }
}