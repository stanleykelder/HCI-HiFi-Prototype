package com.example.stanley.hi_fivolunteeringprototype;

import android.content.Context;
import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;


import java.util.ArrayList;



public class FriendsListAdapter extends BaseAdapter implements Filterable {
    private Context context; //context


    ArrayList<String> friends = new ArrayList<String>() {{
        add("Stanley Kelder");
        add("Yerai Zamorano");
        add("Jie Gao");
        add("Periandros Papamarkos");
        add("Lukas Bittner");
    }};
    ArrayList<String> filteredFriends = friends;

    //public constructor
    public FriendsListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return filteredFriends.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return filteredFriends.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.friend_list_item, parent, false);
        }

        // get current item to be displayed
        String currentItem = (String) getItem(position);

        // get the TextView for item name and item description
        TextView textViewItemTitle = convertView.findViewById(R.id.name);
        textViewItemTitle.setText(currentItem);

        // returns the view for the current row
        return convertView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                filteredFriends = (ArrayList<String>) results.values; // has the filtered values
                notifyDataSetChanged();  // notifies the data with new filtered values
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();        // Holds the results of a filtering operation in values
                ArrayList<String> FilteredArrList = new ArrayList<String>();

                if (friends == null) {
                    friends = new ArrayList<String>(filteredFriends); // saves the original data in mOriginalValues
                }

                /********
                 *
                 *  If constraint(CharSequence that is received) is null returns the mOriginalValues(Original) values
                 *  else does the Filtering and returns FilteredArrList(Filtered)
                 *
                 ********/
                if (constraint == null || constraint.length() == 0) {

                    // set the Original result to return
                    results.count = friends.size();
                    results.values = friends;
                } else {
                    constraint = constraint.toString().toLowerCase();
                    for (int i = 0; i < friends.size(); i++) {
                        String data = friends.get(i);
                        if (data.toLowerCase().startsWith(constraint.toString())) {
                            FilteredArrList.add(friends.get(i));
                        }
                    }
                    // set the Filtered result to return
                    results.count = FilteredArrList.size();
                    results.values = FilteredArrList;
                }
                return results;
            }

        };
        return filter;
    }
}
