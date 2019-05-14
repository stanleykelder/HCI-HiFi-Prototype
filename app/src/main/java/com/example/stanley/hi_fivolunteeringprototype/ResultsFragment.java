package com.example.stanley.hi_fivolunteeringprototype;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class ResultsFragment extends Fragment {

    private RecyclerView recyclerView;
//    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.fragment_results, container, false);

            View rootView = inflater.inflate(R.layout.fragment_results, container, false);
            // 1. get a reference to recyclerView
            RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycleView);

            // 2. set layoutManger
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

            // this is data fro recycler view
            Resources res = getResources();
            String[] planets = res.getStringArray(R.array.planets_array);

            // 3. create an adapter
            MyAdapter mAdapter = new MyAdapter(planets);
            // 4. set adapter
            recyclerView.setAdapter(mAdapter);
            // 5. set item animator to DefaultAnimator
//            recyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }
}