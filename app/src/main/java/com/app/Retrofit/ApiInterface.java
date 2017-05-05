package com.app.Retrofit;

import com.app.Retrofit.Login.LoginMainStatus;
import com.app.Retrofit.Request.AddRoomRequest;
import com.app.Retrofit.Request.UserRequest;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @Headers({
            "Content-type: application/x-www-form-urlencoded",
    })
    @POST("Home/ValidateForSchoolOwnerSignin")
    Call<LoginMainStatus> loginUsers(@FieldMap HashMap<String, String> map);

    @FormUrlEncoded
    @Headers({
            "Content-type: application/x-www-form-urlencoded",
    })
    @POST("Home/SchoolSignup")
    Call<LoginMainStatus> schoolSingup(@FieldMap HashMap<String, String> map);


    @Headers({
            "Content-type: application/json",
    })
    @POST("School/GetRooms")
    Call<ArrayList<RoomDetail>> getRoom(@Body UserRequest roomObj);

    @Headers({
            "Content-type: application/json",
    })
    @POST("School/GetRooms")
    Call<ArrayList<RoomDetail>> addRoom(@Body AddRoomRequest roomObj);
}