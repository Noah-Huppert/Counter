package com.noahhuppert.counter.fragments.CounterNameFragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.noahhuppert.counter.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class CounterListFragment extends Fragment {

    private RecyclerView counterRecyclerView;

    public CounterListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_counter_list, container, false);

        // Counter Recycler View Setup
        counterRecyclerView = (RecyclerView) view.findViewById(R.id.counter_recycler_view);
        counterRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}
