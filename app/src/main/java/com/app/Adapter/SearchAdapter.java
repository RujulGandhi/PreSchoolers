package com.app.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vaishali.preschoolers.R;

/**
 * Created by ravi-archi on 3/30/2017.
 */

public class SearchAdapter  extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {


    public class MyViewHolder extends RecyclerView.ViewHolder {


        public MyViewHolder(View itemView) {
            super(itemView);

        }
    }
    @Override
    public SearchAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_search, parent, false);
        //   view.setOnClickListener(MainActivity.myOnClickListener);
        SearchAdapter.MyViewHolder myViewHolder = new SearchAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
