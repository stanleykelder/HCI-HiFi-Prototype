package com.example.stanley.hi_fivolunteeringprototype;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
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

//        Toolbar myToolbar = (Toolbar) getView().findViewById(R.id.my_toolbar);
//        myToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);


//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                return;
//                getActivity().onBackPressed();
//            }
//        });
    }
}