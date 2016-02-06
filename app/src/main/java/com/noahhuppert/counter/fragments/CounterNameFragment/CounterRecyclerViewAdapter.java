package com.noahhuppert.counter.fragments.CounterNameFragment;

import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.noahhuppert.counter.R;
import com.noahhuppert.counter.models.Counter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CounterRecyclerViewAdapter extends RecyclerView.Adapter<CounterRecyclerViewAdapter.ViewHolder> {
    /* Sorting */
    public static enum SortBy {
        NAME(new Comparator<Counter>() {
            @Override
            public int compare(Counter lhs, Counter rhs) {
                return lhs.name.compareToIgnoreCase(rhs.name);
            }
        }),
        CREATION_DATE(new Comparator<Counter>() {
            @Override
            public int compare(Counter lhs, Counter rhs) {
                return lhs.creationDate.compareTo(rhs.creationDate);
            }
        }),
        LAST_USED_DATE(new Comparator<Counter>() {
            @Override
            public int compare(Counter lhs, Counter rhs) {
                if(lhs.getLastUsedDate() < rhs.getLastUsedDate()) {
                    return -1;
                } else if(lhs.getLastUsedDate() > rhs.getLastUsedDate()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }),
        USER_ORDER(new Comparator<Counter>() {
            @Override
            public int compare(Counter lhs, Counter rhs) {
                return rhs.listPosition - lhs.listPosition;
            }
        });

        Comparator<Counter> comparator;

        SortBy(Comparator<Counter> comparator) {
            this.comparator = comparator;
        }
    }

    /* View Holder */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public String name = "";
        public int count = 0;

        private TextView nameTextView;
        private TextView countTextView;

        public ViewHolder(View view) {
            super(view);
        }

        public void set(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public void updateView() {
            if(nameTextView == null && countTextView == null) {
                nameTextView = (TextView) itemView.findViewById(R.id.name);
                countTextView = (TextView) itemView.findViewById(R.id.count);
            }

            nameTextView.setText(name);
            countTextView.setText(Integer.toString(count));
        }
    }

    /* Adapter */
    private List<Counter> counters;
    private SortBy sortBy;

    public CounterRecyclerViewAdapter(SortBy sortBy) {
        counters = new ArrayList<>();
        this.sortBy = sortBy;
    }

    /* Data Source modification */
    public void sortCounters() {
        Map<Integer, Integer> toFromMap = new HashMap<>();

        for(int i = 0; i < counters.size(); i++) {
            toFromMap.put(counters.get(i).id, i);
        }

        Collections.sort(counters, sortBy.comparator);

        for(int i = 0; i < counters.size(); i++) {
            notifyItemMoved(toFromMap.get(counters.get(i).id), i);
        }
    }

    public void addCounters(List<Counter> countersAddition) {
        int previousSize = counters.size();

        counters.addAll(countersAddition);


        notifyItemRangeInserted(previousSize - 1, countersAddition.size());
    }

    /* Adapter methods */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.counter_list_item, parent, false);

        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name = counters.get(position).name;
        holder.count = counters.get(position).getCount();

        holder.updateView();
    }

    @Override
    public int getItemCount() {
        return counters.size();
    }
}
