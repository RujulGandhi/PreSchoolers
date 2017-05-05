package com.app.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.app.Activity.MainActivity;
import com.example.vaishali.preschoolers.R;

/**
 * Created by archi on 29-Mar-17.
 */

public class AdminHomeFragment extends Fragment implements View.OnClickListener {
    public ImageView ivRooms, ivTeachers, ivReports, ivSearch, ivBills, ivPlanner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_admin_home, container, false);
        findById(view);
        click();

         // TODO: 4/6/2017 fragment backpressed

        ((MainActivity) getActivity()).setOnBackPressedListener(new OnBackPrenerssedListner() {
            @Override
            public void doBack() {

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contain_main, new AdminHomeFragment()).commit();

            }
        });
        return view;
    }


    private void click() {
        ivBills.setOnClickListener(this);
        ivRooms.setOnClickListener(this);
        ivReports.setOnClickListener(this);
        ivSearch.setOnClickListener(this);
        ivPlanner.setOnClickListener(this);
        ivTeachers.setOnClickListener(this);
    }

    private void findById(View view) {
        ivRooms = (ImageView) view.findViewById(R.id.ivRooms);
        ivTeachers = (ImageView) view.findViewById(R.id.ivTeacher);
        ivReports = (ImageView) view.findViewById(R.id.ivReports);
        ivSearch = (ImageView) view.findViewById(R.id.ivSearch);
        ivBills = (ImageView) view.findViewById(R.id.ivBills);
        ivPlanner = (ImageView) view.findViewById(R.id.ivPlanner);
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        switch (v.getId()) {
            case R.id.ivRooms:
                fragment = new RoomsFragment();
                break;
            case R.id.ivPlanner:
                fragment = new PlannerFragment();
                break;
            case R.id.ivTeacher:
                fragment = new TeacherFragment();
                break;
            case R.id.ivReports:
                fragment = new ReportFragment();
                break;
            case R.id.ivBills:
                fragment = new BillsFragment();
                break;
            case R.id.ivSearch:
                fragment = new SearchFragment();
                break;
        }
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contain_main, fragment);
        fragmentTransaction.commit();
    }
}

