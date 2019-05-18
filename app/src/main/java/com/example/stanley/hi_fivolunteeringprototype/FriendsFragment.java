package com.example.stanley.hi_fivolunteeringprototype;

import android.animation.ObjectAnimator;
import android.app.ListActivity;
import android.content.Context;
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
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.SimpleAdapter;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class FriendsFragment extends Fragment {


    List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
    private EditText search;

    public static void setListViewHeightBasedOnChildren
            (ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) return;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(),
                View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0) view.setLayoutParams(new
                    ViewGroup.LayoutParams(desiredWidth,
                    ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();

        params.height = totalHeight + (listView.getDividerHeight() *
                (listAdapter.getCount() - 1));

        listView.setLayoutParams(params);
        listView.requestLayout();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        ((MainActivity)getActivity()).hideNavBar();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friends, container, false);

        aList.clear();

        return view;
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

        // Array of strings for ListView Title
        String[] name = new String[]{
                "Daenerys Targaryen", "Arya Stark", "Jon Snow", "Cersei Lannister",
        };

        int[] image = new int[]{
                R.drawable.person_1, R.drawable.person_2,R.drawable.person_3,R.drawable.person_4,
        };

        String[] donations = new String[]{
                "5", "3", "8", "0",
        };

        String[] helps = new String[]{
                "7", "1", "5", "0",
        };



        for (int i = 0; i < 4; i++) {
            HashMap<String, String > hm = new HashMap<String, String>();
            hm.put("name", name[i]);
            hm.put("image", Integer.toString(image[i]));
            hm.put("donations", donations[i]);
            hm.put("helps", helps[i]);
            aList.add(hm);
        }

        if(MainActivity.friends){
            HashMap<String, String > hm = new HashMap<String, String>();
            hm.put("name", "Olenna Tyrell");
            hm.put("image", Integer.toString(R.drawable.friends_3));
            hm.put("donations", "10");
            hm.put("helps", "5");
            aList.add(hm);
        }

        String[] from = {"name", "image", "donations", "helps"};
        int[] to = {R.id.name, R.id.profile_img, R.id.donation_number, R.id.helps_number};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), aList, R.layout.friend_status_list, from, to);
        ListView lv = (ListView) view.findViewById(R.id.lista_amigos);
        lv.setAdapter(simpleAdapter);
        setListViewHeightBasedOnChildren(lv);


        // Locate the EditText in listview_main.xml
        search = getView().findViewById(R.id.search_thing);

        // Capture Text in EditText
        search.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {

                String text = search.getText().toString().toLowerCase();

                Log.d("texto",text);
                List<HashMap<String, String>> filtered_List = new ArrayList<HashMap<String, String>>();
                for(int i=0; i < aList.size(); i++){

                    if(aList.get(i).toString().toLowerCase().contains(text)){
                        filtered_List.add(aList.get(i));
                        Log.d("uno",aList.get(i).toString());
                    }
                }

                Log.d("hole",filtered_List.toString());
                String[] from = {"name", "image", "donations", "helps"};
                int[] to = {R.id.name, R.id.profile_img, R.id.donation_number, R.id.helps_number};

                SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), filtered_List, R.layout.friend_status_list, from, to);
                ListView lv = (ListView) getView().findViewById(R.id.lista_amigos);
                lv.setAdapter(simpleAdapter);
                setListViewHeightBasedOnChildren(lv);
            }
        });
    }



}
