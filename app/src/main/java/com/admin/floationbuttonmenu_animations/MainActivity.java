package com.admin.floationbuttonmenu_animations;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton mFabMenu;
    private FloatingActionButton mFabTakePhoto, mFabChoosePhoto;
    private LinearLayout mTakePhotoLayout, mChoosePhotoLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initHandler();
    }

    private void initHandler() {
        final Animation mShowLayout =
                AnimationUtils.loadAnimation(MainActivity.this,R.anim.show_layout);
        final Animation mHideLayout =
                AnimationUtils.loadAnimation(MainActivity.this, R.anim.hide_layout);

        final Animation mShowButton =
                AnimationUtils.loadAnimation(MainActivity.this, R.anim.show_button);
        final Animation mHideButton =
                AnimationUtils.loadAnimation(MainActivity.this, R.anim.hide_button);

        mFabMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTakePhotoLayout.getVisibility() == View.VISIBLE &&
                        mChoosePhotoLayout.getVisibility() == View.VISIBLE){
                    mTakePhotoLayout.setVisibility(View.GONE);
                    mChoosePhotoLayout.setVisibility(View.GONE);
                    mTakePhotoLayout.startAnimation(mHideLayout);
                    mChoosePhotoLayout.startAnimation(mHideLayout);
                    mFabMenu.startAnimation(mHideButton);
                } else {
                    mTakePhotoLayout.setVisibility(View.VISIBLE);
                    mChoosePhotoLayout.setVisibility(View.VISIBLE);
                    mTakePhotoLayout.startAnimation(mShowLayout);
                    mChoosePhotoLayout.startAnimation(mShowLayout);
                    mFabMenu.startAnimation(mShowButton);

                }
            }
        });

        //takePhoto
        mFabTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //choosePhoto
        mFabChoosePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void initView() {
        mTakePhotoLayout = (LinearLayout)findViewById(R.id.takePhotoLayout);
        mChoosePhotoLayout = (LinearLayout)findViewById(R.id.choosePhotoLayout);
        mFabMenu = (FloatingActionButton)findViewById(R.id.menuFAB);
        mFabTakePhoto = (FloatingActionButton)findViewById(R.id.takePhotoFAB);
        mFabChoosePhoto = (FloatingActionButton)findViewById(R.id.choosePhotoFAB);

    }

}
