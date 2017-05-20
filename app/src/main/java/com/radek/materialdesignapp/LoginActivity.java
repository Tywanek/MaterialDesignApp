package com.radek.materialdesignapp;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Radek on 19.05.2017.
 */

public class LoginActivity extends AppCompatActivity {
    private static String mypassword = "ala";
    @InjectView(R.id.android)
    ImageView android;
    @InjectView(R.id.login)
    EditText login;
    @InjectView(R.id.password)
    EditText password;
    @InjectView(R.id.password_imput_layout)
    TextInputLayout passwordImputLayout;
    @InjectView(R.id.fab)
    FloatingActionButton fab;
    @InjectView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;


    private Animation shake;

    private View.OnClickListener myFabListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Snackbar.make(coordinatorLayout, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            startActivity(new Intent(getApplicationContext(), DetailActivity.class));
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_layout);
        ButterKnife.inject(this);

        setView();
        initToolbar();

        shake = AnimationUtils.loadAnimation(this, R.anim.shake);
       // android.startAnimation(shake);
}


    private void setView() {
        fab.setOnClickListener(myFabListener);
//        android.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                android.clearAnimation();
//            }
//        });

        android.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                    int finalRadius = Math.max(android.getWidth(), android.getHeight()) / 2;
                    Animator anim =
                            ViewAnimationUtils.createCircularReveal(android, (int) event.getX(), (int) event.getY(), 0, finalRadius);
                    android.setVisibility(View.VISIBLE);
                    anim.start();
                    return false;
            }
        });



    }

    private void initToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_launcher);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
