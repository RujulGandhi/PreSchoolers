package com.app.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.app.Fragment.AdminHomeFragment;
import com.app.Fragment.RoomsFragment;
import com.app.Fragment.ParentHomeFragment;
import com.example.vaishali.preschoolers.R;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    public ImageView ivProfileImage;
    public EditText etName_Signup, etCity_Signup, etEmail_Signup, etMoNo_Signup, etPassword_Signup, etConfirmPassword_Signup;
    public Button btSignup;
    public String Name, City, Email, Mobile, Password, ConfirmPassword, ProfilePic;
    public String Teacher, Parent, Admin;
    public FragmentManager fragmentManager;
    public FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sign_up);
        findById();
        click();
    }

    private void click() {
        btSignup.setOnClickListener(this);

    }

    private void findById() {
        ivProfileImage = (ImageView) findViewById(R.id.ivProfileImage);
        etName_Signup = (EditText) findViewById(R.id.etName_Signup);
        etCity_Signup = (EditText) findViewById(R.id.etCity_Signup);
        etEmail_Signup = (EditText) findViewById(R.id.etEmail_Signup);
        etMoNo_Signup = (EditText) findViewById(R.id.etMoNo_Signup);
        etPassword_Signup = (EditText) findViewById(R.id.etPassword_Signup);
        etConfirmPassword_Signup = (EditText) findViewById(R.id.etConfirmPassword_Signup);
        btSignup = (Button) findViewById(R.id.btSignup);
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()) {
            case R.id.btSignup:
                Admin = "admin@gmail.com";
                Teacher = "teacher@gmail.com";
                Parent = "parent@gmail.com";
                Name = etName_Signup.getText().toString().trim();
                City = etCity_Signup.getText().toString().trim();
                Email = etEmail_Signup.getText().toString().trim();
                Mobile = etMoNo_Signup.getText().toString().trim();
                Password = etPassword_Signup.getText().toString().trim();
                ConfirmPassword = etConfirmPassword_Signup.getText().toString().trim();
                //ProfilePic = ivProfileImage;
                if (Email.equalsIgnoreCase(Admin)) {
                    fragment = new AdminHomeFragment();
                } else if (Email.equalsIgnoreCase(Teacher)) {
                    fragment = new RoomsFragment();

                } else if (Email.equalsIgnoreCase(Parent)) {
                    fragment = new ParentHomeFragment();
                }

                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.contain_main, fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                break;
        }
    }
}
