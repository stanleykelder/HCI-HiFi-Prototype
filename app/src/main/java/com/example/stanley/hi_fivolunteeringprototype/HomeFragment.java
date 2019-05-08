package com.example.stanley.hi_fivolunteeringprototype;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_constraint, container, false);
        }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //This code sets title and arrow (in this case removes it)
        ((MainActivity) getActivity()).setTitle("Home");
        ((MainActivity) getActivity()).removeArrow();

        final Context context = getActivity().getApplicationContext();

        ImageView button = (ImageView) getView().findViewById(R.id.find_where_to_help);
            button.setOnClickListener(new View.OnClickListener() {
            Fragment selectedFragment = new SearchFragment();
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();
            }
        });

        ImageView helps = (ImageView) getView().findViewById(R.id.helps_image);
        helps.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Fragment nextFragment = new HelpsFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new HelpsFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    };
}