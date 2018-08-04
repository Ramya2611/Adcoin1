package com.example.ramya.adkoin;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;

public class Success extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private Cashout cashfragment;
    private Balance balfragment;
    private Banners banfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.navbot);

        cashfragment = new Cashout();
        balfragment = new Balance();
        banfragment = new Banners();

        setFragment(cashfragment);


        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.nav_cash:
                        mMainNav.setItemBackgroundResource(R.color.basic_blue);
                        setFragment(cashfragment);
                        return true;

                    case R.id.nav_bal:
                        mMainNav.setItemBackgroundResource(R.color.basic_blue);
                        setFragment(balfragment);
                        return true;

                    case R.id.nav_ban:
                        mMainNav.setItemBackgroundResource(R.color.basic_blue);
                        setFragment(banfragment);
                        return true;

                    case R.id.nav_more:
                        mMainNav.setItemBackgroundResource(R.color.basic_blue);
                        setFragment(cashfragment);
                        return true;


                    default:return false;

                }

            }
        });

    }

    private void setFragment(android.support.v4.app.Fragment fragment) {

        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();

    }


}
