package com.app.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.Retrofit.ApiClient;
import com.app.Retrofit.ApiInterface;
import com.app.Retrofit.Login.LoginMainStatus;
import com.app.Retrofit.Login.School;
import com.app.Widgets.BaseAppCompactActivity;
import com.example.vaishali.preschoolers.R;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.app.Utils.Constant.LOGIN_RESULT;
import static com.app.Utils.Constant.SELECTEDSCHOOL;
import static com.app.Utils.Constant.SELECTEDSCHOOLID;
import static com.app.Utils.Constant.USERID;
import static com.app.Utils.Utils.GsonToObject;
import static com.app.Utils.Utils.ReadSharePrefrence;

public class Dashboard extends BaseAppCompactActivity {

    @BindView(R.id.admin_dashboard_room)
    public ImageView roomsIv;

    @BindView(R.id.admin_dashboard_bills)
    public ImageView billsIv;

    @BindView(R.id.admin_dashboard_planner)
    public ImageView plannerIv;

    @BindView(R.id.admin_dashboard_report)
    public ImageView reportIv;

    @BindView(R.id.admin_dashboard_search)
    public ImageView searchIv;

    @BindView(R.id.admin_dashboard_teacher)
    public ImageView teacherIv;

    @BindView(R.id.admin_dashboard_spinner)
    public MaterialSpinner schoolDropDown;

    @BindView(R.id.admin_dashboard_add_school)
    public TextView addSchoolTv;

    public EditText schoolNameEdt;
    public EditText schoolWebEdt;
    public Dialog dialog;
    public TextView addSchoolSubmit;
    private LoginMainStatus userDetails;
    public ArrayList<String> schoolList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!read(USERID).equalsIgnoreCase("")) {
            setContentView(R.layout.activity_dashboard);
            ButterKnife.bind(this);
            String allLoginInfo = ReadSharePrefrence(Dashboard.this, LOGIN_RESULT);
            userDetails = GsonToObject(allLoginInfo, LoginMainStatus.class);
            schoolList = new ArrayList<>();
            for (School school : userDetails.getSchools()) {
                schoolList.add(school.getSchoolName());
            }
            schoolDropDown.setItems(schoolList);
            schoolDropDown.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
                @Override
                public void onItemSelected(MaterialSpinner view, int position, long id, String item) {

                }
            });
        } else {
            Intent in = new Intent(Dashboard.this, LoginActivity.class);
            startActivity(in);
        }
    }

    @OnClick(R.id.admin_dashboard_room)
    public void room() {
        int position = schoolDropDown.getSelectedIndex();
        write(SELECTEDSCHOOL, userDetails.getSchools().get(position).getSchoolName());
        write(SELECTEDSCHOOLID, userDetails.getSchools().get(position).getId());
        startActivity(RoomList.class);
    }

    @OnClick(R.id.admin_dashboard_add_school)
    public void addSchool() {
        dialog = new Dialog(Dashboard.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_add_school);
        schoolNameEdt = (EditText) dialog.findViewById(R.id.add_school_schoolname);
        schoolWebEdt = (EditText) dialog.findViewById(R.id.add_school_schoolweb);
        addSchoolSubmit = (TextView) dialog.findViewById(R.id.add_school_submit);
        dialog.show();
        addSchoolSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiInterface apiService =
                        ApiClient.getClient().create(ApiInterface.class);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("name", "");
                hashMap.put("email", userDetails.getEmail());
                hashMap.put("password", "SCHOOL123");
                hashMap.put("schoolName", schoolNameEdt.getText().toString());
                hashMap.put("webSite", schoolWebEdt.getText().toString());
                Call<LoginMainStatus> call = apiService.schoolSingup(hashMap);
                call.enqueue(new Callback<LoginMainStatus>() {
                    @Override
                    public void onResponse(Call<LoginMainStatus> call, Response<LoginMainStatus> response) {
//                        LoginMainStatus details = response.body();
//                        WriteSharePrefrence(Dashboard.this, LOGIN_RESULT, convertToGson(details));
//                        WriteSharePrefrence(Dashboard.this, TOKEN, details.getSecurityToken());
//                        Intent signin = new Intent(Dashboard.this, Dashboard.class);
//                        startActivity(signin);
                    }

                    public void onFailure(Call<LoginMainStatus> call, Throwable t) {
                        Toast.makeText(Dashboard.this, getString(R.string.somethingwentwrong), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            clear();
            startActivity(LoginActivity.class, true);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


