package com.example.stanley.hi_fivolunteeringprototype;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class SearchFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);


//        View rootview =
//        return rootview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Search");
        ((MainActivity) getActivity()).removeArrow();


//        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_container, new ResultsFragment());
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();

        //Handle the Child Fragment.
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
//        ResultsFragment elf = new ResultsFragment();
        ft.replace(R.id.fragment_container, new ResultsFragment());
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();
    }
}