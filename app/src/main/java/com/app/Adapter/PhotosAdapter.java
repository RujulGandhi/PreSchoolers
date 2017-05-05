package com.app.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.vaishali.preschoolers.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ravi archi on 2/21/2017.
 */

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.MyViewHolder> {
    public String Id;
    private Context context;

    public PhotosAdapter(Context context/*, ArrayList<UserProfileDetails> arraylist*/) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_photoslist, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.adapter_photos_list_layout)
        LinearLayout layoutFollower;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
