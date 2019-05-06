package com.example.stanley.hi_fivolunteeringprototype;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.support.design.widget.BottomNavigationView;
import android.widget.Toast;


public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_constraint, container, false);
        }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        final Context context = getActivity().getApplicationContext();

        ImageView button = (ImageView) getView().findViewById(R.id.find_where_to_help);
        // or  (ImageView) view.findViewById(R.id.foo);
            button.setOnClickListener(new View.OnClickListener() {
            Fragment selectedFragment = new SearchFragment();
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();
            }
        });

        ImageView helps = (ImageView) getView().findViewById(R.id.helps_image);
        // or  (ImageView) view.findViewById(R.id.foo);
        helps.setOnClickListener(new View.OnClickListener() {
            Fragment selectedFragment = new HelpDetailsFragment();
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();
            }
        });
    };
}