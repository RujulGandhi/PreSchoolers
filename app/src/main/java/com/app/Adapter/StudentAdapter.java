package com.app.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.Model.StudentDetails;
import com.example.vaishali.preschoolers.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ravi archi on 2/21/2017.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {
    public String Id;
    private Context context;
    private ArrayList<StudentDetails> arrayList;

    public StudentAdapter(Context context, ArrayList<StudentDetails> arraylist) {
        this.context = context;
        this.arrayList = arraylist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_studentlist, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final StudentDetails details = arrayList.get(position);
        holder.txtStudentName.setText(details.getStudentName());
        Picasso.with(context).load(details.getStudentProfilePic()).placeholder(R.drawable.default_img).into(holder.imgStudentProfilePic);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.adapter_student_list_layout)
        LinearLayout layoutStudentlist;

        @BindView(R.id.adapter_studentlist_txtstudentname)
        TextView txtStudentName;

        @BindView(R.id.adapter_studentlist_imgphoto)
        ImageView imgStudentProfilePic;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
