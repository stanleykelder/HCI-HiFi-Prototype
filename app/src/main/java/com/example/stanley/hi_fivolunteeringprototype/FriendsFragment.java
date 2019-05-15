package com.example.stanley.hi_fivolunteeringprototype;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ProgressBar;

public class FriendsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_friends, container, false);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setTitle("Friends");
        ((MainActivity) getActivity()).addArrow();
//        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
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
