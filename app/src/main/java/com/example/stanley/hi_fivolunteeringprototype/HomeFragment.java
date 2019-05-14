package com.example.stanley.hi_fivolunteeringprototype;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.ProgressBar;


public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_constraint, container, false);
        }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //This code sets title and arrow (in this case removes it)
        getActivity().setTitle("Home");
        ((MainActivity) getActivity()).removeArrow();

        final Context context = getActivity().getApplicationContext();

        /*ImageView button = (ImageView) getView().findViewById(R.id.find_where_to_help);
            button.setOnClickListener(new View.OnClickListener() {
            Fragment selectedFragment = new SearchFragment();
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();
            }
        });*/

        ProgressBar helps = getView().findViewById(R.id.help_level);
        helps.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Fragment nextFragment = new HelpsFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new HelpsFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        ObjectAnimator help_animation = ObjectAnimator.ofInt(getView().findViewById(R.id.help_level), "progress", 30);
        help_animation.setDuration(2000);
        help_animation.setInterpolator(new AccelerateDecelerateInterpolator());
        help_animation.start();

        ObjectAnimator donations_animation = ObjectAnimator.ofInt(getView().findViewById(R.id.donation_level), "progress", 80);
        donations_animation.setDuration(2000);
        donations_animation.setInterpolator(new AccelerateDecelerateInterpolator());
        donations_animation.start();



    }


}