package com.app.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.Activity.MainActivity;
import com.example.vaishali.preschoolers.R;

public class BillsFragment extends Fragment {

    public RecyclerView billRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.bills_fragment, container, false);

        billRecyclerView=(RecyclerView)view.findViewById(R.id.bills_fragment_recycleview);
        ((MainActivity) getActivity()).setOnBackPressedListener(new OnBackPrenerssedListner() {
            @Override
            public void doBack() {

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contain_main, new AdminHomeFragment()).commit();

            }
        });
         return view;
    }
}
