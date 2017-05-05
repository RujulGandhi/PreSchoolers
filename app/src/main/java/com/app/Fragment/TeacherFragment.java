package com.app.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.Activity.MainActivity;
import com.example.vaishali.preschoolers.R;

public class TeacherFragment extends Fragment {

    public RecyclerView searchRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_tearcherspage, container, false);
        searchRecyclerView=(RecyclerView)view.findViewById(R.id.search_fragment_recycleview);
        ((MainActivity) getActivity()).setOnBackPressedListener(new OnBackPrenerssedListner() {
            @Override
            public void doBack() {

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contain_main, new AdminHomeFragment()).commit();

            }
        });
        return view;
    }
}
