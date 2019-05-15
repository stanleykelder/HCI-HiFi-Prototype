package com.example.stanley.hi_fivolunteeringprototype;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class AddFriendsFragment extends Fragment {
    private FriendsListAdapter adapter;
    private ListView friendsListView;
    private EditText etSearch;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_friends, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setTitle("Add Friends");
        ((MainActivity) getActivity()).addArrow();
//        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);

        adapter = new FriendsListAdapter(this.getContext());
        friendsListView = getView().findViewById(R.id.article_list);
        friendsListView.setAdapter(adapter);

        etSearch = getView().findViewById(R.id.etSearch);
        etSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Call back the Adapter with current character to Filter
                adapter.getFilter().filter(s.toString());
                Log.d("6: ", adapter.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
