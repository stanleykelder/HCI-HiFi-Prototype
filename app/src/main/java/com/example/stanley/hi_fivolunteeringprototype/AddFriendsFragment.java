package com.example.stanley.hi_fivolunteeringprototype;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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
        friendsListView = getView().findViewById(R.id.event_list);
        friendsListView.setAdapter(adapter);

        etSearch = getView().findViewById(R.id.search_friend);
        etSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Call back the Adapter with current character to Filter
                adapter.getFilter().filter(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        Button invite = getView().findViewById(R.id.invite_friend);
        invite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText email = getView().findViewById(R.id.input_invite_friend);
                if(email.getText().equals(null))
                {
                    Toast.makeText(getActivity(), "Please insert valid a email address.", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getActivity(), "Invitation send to " + email.getText() + ".", Toast.LENGTH_LONG).show();
                    email.setText(null);
                }
            }
        });
    }
}
