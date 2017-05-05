package com.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.Retrofit.ApiClient;
import com.app.Retrofit.ApiInterface;
import com.app.Retrofit.Login.LoginMainStatus;
import com.app.Widgets.BaseActivity;
import com.example.vaishali.preschoolers.R;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.app.Utils.Constant.LOGIN_RESULT;
import static com.app.Utils.Constant.TOKEN;
import static com.app.Utils.Constant.USERID;
import static com.app.Utils.Utils.WriteSharePrefrence;
import static com.app.Utils.Utils.convertToGson;
import static com.app.Utils.Utils.emailValidator;

public class LoginActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.et_email)
    EditText emailEdt;
    @BindView(R.id.et_password)
    EditText pwdEdt;
    @BindView(R.id.tv_signin)
    TextView singInTv;
    @BindView(R.id.tv_forgotpass)
    TextView forgotPassTv;
    @BindView(R.id.tv_signup)
    TextView signupTv;

    String strEmail, strPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        emailEdt.setText("ompublicschool@gmail.com");
        pwdEdt.setText("SCHOOL123");
    }

    @OnClick(R.id.tv_signup)
    public void signUpClicked() {
        startActivity(SignUpActivity.class);
        Intent signup = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(signup);
    }

    @OnClick(R.id.tv_signin)
    public void signInClicked() {
        strEmail = emailEdt.getText().toString();
        strPassword = pwdEdt.getText().toString();

        if (emailValidator(strEmail)) {
            if (strPassword.length() > 2) {
                ApiInterface apiService =
                        ApiClient.getClient().create(ApiInterface.class);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("password", strPassword);
                hashMap.put("email", strEmail);
                Call<LoginMainStatus> call = apiService.loginUsers(hashMap);
                call.enqueue(new Callback<LoginMainStatus>() {
                    @Override
                    public void onResponse(Call<LoginMainStatus> call, Response<LoginMainStatus> response) {
                        LoginMainStatus details = response.body();
                        WriteSharePrefrence(LoginActivity.this, LOGIN_RESULT, convertToGson(details));
                        WriteSharePrefrence(LoginActivity.this, TOKEN, details.getSecurityToken());
                        WriteSharePrefrence(LoginActivity.this, USERID, details.getId());
                        startActivity(Dashboard.class, true);
                    }

                    public void onFailure(Call<LoginMainStatus> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, getString(R.string.somethingwentwrong), Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                Toast.makeText(this, getString(R.string.somethingwentwrong), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, getString(R.string.somethingwentwrong), Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()) {
            case R.id.tv_signup:

                break;

            case R.id.tv_signin:


//
//
               /* Admin = "admin@gmail.com";
                Teacher = "teacher@gmail.com";
                Parent = "parent@gmail.com";
                Email = etEmail.getText().toString().trim();
                Password = etPassword.getText().toString().trim();
                //ProfilePic = ivProfileImage;

                if (Email.equalsIgnoreCase(Admin)) {
                    Utils.WriteSharePrefrence(LoginActivity.this, Constant.USERTYPE, "1");
                } else if (Email.equalsIgnoreCase(Teacher)) {
                    Utils.WriteSharePrefrence(LoginActivity.this, Constant.USERTYPE, "2");
                } else if (Email.equalsIgnoreCase(Parent)) {
                    Utils.WriteSharePrefrence(LoginActivity.this, Constant.USERTYPE, "3");
                }*/
                break;
        }
    }
}
