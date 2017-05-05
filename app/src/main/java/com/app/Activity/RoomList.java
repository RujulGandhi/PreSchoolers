package com.app.Activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.app.Adapter.RoomAdapter;
import com.app.Retrofit.ApiClient;
import com.app.Retrofit.ApiInterface;
import com.app.Retrofit.Login.LoginMainStatus;
import com.app.Retrofit.RoomDetail;
import com.app.Retrofit.Request.UserRequest;
import com.app.Widgets.BaseAppCompactActivity;
import com.example.vaishali.preschoolers.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.app.Utils.Constant.LOGIN_RESULT;
import static com.app.Utils.Constant.SELECTEDSCHOOLID;
import static com.app.Utils.Utils.GsonToObject;

/**
 * Created by archirayan on 17-Apr-17.
 */

public class RoomList extends BaseAppCompactActivity {
    private LoginMainStatus mainProfile;
    @BindView(R.id.fragment_rooms_recycler)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_rooms);
        ButterKnife.bind(this);
        mainProfile = GsonToObject(read(LOGIN_RESULT), LoginMainStatus.class);
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        UserRequest req = new UserRequest();
        req.seteMail(mainProfile.getEmail());
        req.setSchoolId(read(SELECTEDSCHOOLID));
        req.setSecurityToken(mainProfile.getSecurityToken());
        req.setUserId(mainProfile.getId());

        Call<ArrayList<RoomDetail>> call = apiService.getRoom(req);
        call.enqueue(new Callback<ArrayList<RoomDetail>>() {
            public GridLayoutManager lLayout;

            @Override
            public void onResponse(Call<ArrayList<RoomDetail>> call, Response<ArrayList<RoomDetail>> response) {

                lLayout = new GridLayoutManager(RoomList.this, 2);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(lLayout);
                recyclerView.setAdapter(new RoomAdapter(RoomList.this, response.body()));

            }

            @Override
            public void onFailure(Call<ArrayList<RoomDetail>> call, Throwable t) {

            }
        });

    }
}
