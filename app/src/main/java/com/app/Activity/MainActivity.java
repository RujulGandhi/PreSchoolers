package com.app.Activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.Fragment.AdminHomeFragment;
import com.app.Fragment.OnBackPrenerssedListner;
import com.example.vaishali.preschoolers.R;

import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ivUser, ivback, ivmenu;
    private TextView tvTitle, adminTv, roomsTv, billsTv, searchTv;
    private RelativeLayout drawerView;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    private FrameLayout frame_layout;
    private Toolbar mToolbar;
    private ImageView img;
    private DrawerLayout mDrawerLayout;
    private RelativeLayout mainView;
    private NavigationView navigationView;
    protected OnBackPrenerssedListner onBackPressedListener;
    public ActionBarDrawerToggle toggle;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation2);

        frame_layout = (FrameLayout) findViewById(R.id.frame_container);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layoutn);
        mToolbar = (Toolbar) findViewById(R.id.toolbarn);
        img = (ImageView) mToolbar.findViewById(R.id.toolbar_notification);
        navigationView = (NavigationView) findViewById(R.id.navigation);
        setSupportActionBar(mToolbar);

        toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                mToolbar.setTranslationZ(slideOffset * drawerView.getWidth());
                frame_layout.setTranslationZ(-slideOffset * drawerView.getWidth());
                mDrawerLayout.bringChildToFront(drawerView);
                mDrawerLayout.requestLayout();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                toggle.setHomeAsUpIndicator(R.mipmap.ic_menu);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                toggle.setHomeAsUpIndicator(R.mipmap.ic_menu);
            }
        };
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(R.mipmap.ic_menu);
        toggle.syncState();
        mDrawerLayout.setDrawerListener(toggle);
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDrawerLayout.isDrawerVisible(GravityCompat.START)) {
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.frame_container, new AdminHomeFragment())
                .commit();


    }


    @OnClick({R.id.Home_event, R.id.Mess_event, R.id.Sett_event})
    public void onClick(View view) {
        Fragment fragment = null;
        String title = null;
        switch (view.getId()) {
            case R.id.Home_event:
                title = "";
                //fragment = new HomeFragment();
                break;
            case R.id.Mess_event:
                title = "MESSAGE";
                //fragment = new MessaageFragment();
                break;
            case R.id.Sett_event:
                title = "SETTING";
                //fragment = new SettingFragment();
                break;
        }


        //TODO fragment replace

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.contain_main, fragment);
            fragmentTransaction.commit();
        }


    }

    //TODO backprssed in fragments

    public void setOnBackPressedListener(OnBackPrenerssedListner onBackPressedListener) {
        this.onBackPressedListener = onBackPressedListener;
    }

    @Override
    public void onBackPressed() {

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawers();
        } else {
            if (onBackPressedListener != null) {
                onBackPressedListener.doBack();
            } else {
                finish();
            }
        }
    }
}
