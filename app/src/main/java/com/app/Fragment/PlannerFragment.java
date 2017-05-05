package com.app.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.Activity.MainActivity;
import com.example.vaishali.preschoolers.R;

public class PlannerFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_planner, container, false);
        ((MainActivity) getActivity()).setOnBackPressedListener(new OnBackPrenerssedListner() {
            @Override
            public void doBack() {

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contain_main, new AdminHomeFragment()).commit();

            }
        });
        return view;
    }
}
