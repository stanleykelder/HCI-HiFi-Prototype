package com.example.stanley.hi_fivolunteeringprototype;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.stanley.hi_fivolunteeringprototype.ListFragment.OnListFragmentInteractionListener;
//import com.example.stanley.hi_fivolunteeringprototype.dummy.DummyContent.DummyItem;
import com.example.stanley.hi_fivolunteeringprototype.dummy.Content.Item;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Item} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<Item> mValues;
    private final List<String> Titles;
    private final List<String> Locations;
    private final List<String> Dates;
    private final List<String> Descriptions;
    private final List<Integer> Pictures;
    private final OnListFragmentInteractionListener mListener;

    public MyItemRecyclerViewAdapter(List<Item> items, List<String> titles, List<String> locations, List<String> dates, List<String> descriptions, List<Integer> pictures, OnListFragmentInteractionListener listener) {
        mValues = items;
        Titles = titles;
        Locations = locations;
        Dates = dates;
        Descriptions = descriptions;
        Pictures = pictures;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(Titles.get(position));
        holder.mLocationView.setText(Locations.get(position));
        holder.mDateView.setText(Dates.get(position));
        holder.mContentView.setText(Descriptions.get(position));
        holder.mImageView.setImageResource(Pictures.get(position));
        holder.mLocationIcon.setImageResource(R.drawable.ic_location_on_black_24dp);
        holder.mCalendarIcon.setImageResource(R.drawable.ic_date_range_black_24dp);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onEventSelected(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public final TextView mLocationView;
        public final TextView mDateView;
        public final ImageView mImageView;
        public final ImageView mLocationIcon;
        public final ImageView mCalendarIcon;

        public Item mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
            mLocationView = (TextView) view.findViewById(R.id.text_location);
            mDateView = (TextView) view.findViewById(R.id.text_date);
            mImageView = (ImageView) view.findViewById(R.id.cardImage);
            mLocationIcon = (ImageView) view.findViewById(R.id.location_icon);
            mCalendarIcon = (ImageView) view.findViewById(R.id.calendar_icon);;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
