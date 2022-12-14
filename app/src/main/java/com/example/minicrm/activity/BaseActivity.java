package com.example.minicrm.activity;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.minicrm.app.ApplicationMiniCrm;
import com.example.minicrm.bussiness.FontBussiness;
import com.example.minicrm.util.SharedPref;
import com.example.minicrm.util.Utilities;
import com.kaopiz.kprogresshud.KProgressHUD;


public class BaseActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_PICK_LOCATION = 1001;
    protected String TAG = getClass().getSimpleName();

    protected SharedPref config;
    protected Handler mHandler;
    protected FontBussiness mFontBussiness;
    protected boolean isKeyBoard = false;
    protected int keyboardHeight;
    protected FragmentManager mFragmentManager;
    protected FragmentTransaction mFragmentTransaction;
    protected boolean isKeyBoardVisible;


    protected KProgressHUD hud;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "OnCreate " + savedInstanceState);
        overridePendingTransition(0, 0);

        ApplicationMiniCrm.getInstance().setLocale(this);

        super.onCreate(savedInstanceState);

        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        mFragmentManager = getSupportFragmentManager();
        config = new SharedPref(this);
        mHandler = new Handler();
        mFontBussiness = ApplicationMiniCrm.getInstance().getFontBussiness();
        ApplicationMiniCrm.setIsVisible(true);




    }

    private void hidenNavigationBar() {
        int currentApiVersion = Build.VERSION.SDK_INT;

        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        // This work only for android 4.4+
        if (currentApiVersion >= Build.VERSION_CODES.KITKAT) {

            getWindow().getDecorView().setSystemUiVisibility(flags);

            // Code below is to handle presses of Volume up or Volume down.
            // Without this, after pressing volume buttons, the navigation bar will
            // show up and won't hide
            final View decorView = getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(visibility -> {
                if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                    decorView.setSystemUiVisibility(flags);
                }
            });
        }
    }

    protected void showKeyboard() {

    }

    protected void hidenKeyboard() {

    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult " + data);


    }

    //Click outside hide soft keybroad
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ApplicationMiniCrm.setIsVisible(false);
        Log.d(TAG, "Ondes troy");
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    public void onStop() {


        super.onStop();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }

    @Override
    protected void onStart() {
        super.onStart();
        ApplicationMiniCrm.setIsVisible(true);

    }


    @Override
    protected void onResume() {
        super.onResume();
        ApplicationMiniCrm.setIsVisible(true);
    }

    @Override
    public void finish() {

        super.finish();
        overridePendingTransition(0, 0);
    }

    public void onBackPressFinishHidenKey(View v) {
        super.onBackPressed();
        Utilities.hideKeyboard(v, this);
    }




    public void superOnBackPress() {

        super.onBackPressed();
    }

    public void showProgressHub(Activity activity) {
        dismissProgressHub();
        hud = KProgressHUD.create(activity)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setDimAmount(0.5f);

        hud.show();
    }

    public void dismissProgressHub() {
        if (hud != null && hud.isShowing())
            hud.dismiss();
    }


}
