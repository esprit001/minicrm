package com.example.minicrm.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Log;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.multidex.BuildConfig;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.example.minicrm.bussiness.FontBussiness;
import com.example.minicrm.util.LanguageUtil;
import com.example.minicrm.util.SharedPref;
import com.facebook.stetho.Stetho;

import java.util.ArrayList;
import java.util.Locale;


public class App extends MultiDexApplication {
    public static final String TAG = "ApplicationAndroid";

    private static App sInstance;


    private LocalBroadcastManager localBroadcastManager;
    private FontBussiness mFontBussiness;

    private SharedPref pref;

    private static boolean mIsVisible = false;

    private Resources mResousce;

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
//        FabiTracker.init(this);
        sInstance = this;
        Log.d(TAG, "ON APP");
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
            SharedPref config = new SharedPref(this);
            String sethoe = config.getString(Constants.KEY_ANDROID_STETHO, "1");
            if ("1".equals(sethoe)) {
                Stetho.initializeWithDefaults(this);
            }
        }
        initBussiness();

        initResouce();



    }


    private void initBussiness() {

        pref = new SharedPref(this);
        mFontBussiness = new FontBussiness(this);
        setLocale(this);

    }


    public static void setIsVisible(boolean visible) {
        mIsVisible = visible;
    }


    public static boolean getIsVisible() {
        return mIsVisible;
    }


    public FontBussiness getFontBussiness() {

        return mFontBussiness;
    }

    public static synchronized App getInstance() {
        return sInstance;
    }


    private void initResouce() {

        Locale locale = LanguageUtil.getLocale();
        Locale.setDefault(locale);
        Configuration config = getResources().getConfiguration();
        config.setLocale(locale);
        mResousce = new Resources(getResources().getAssets(), getResources().getDisplayMetrics(), config);


    }

    public void setLocale(Context context) {

        Locale locale = LanguageUtil.getLocale();
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        context.getResources().updateConfiguration(config, null);
        initResouce();

    }
    public SharedPref getShapref() {
        return pref;
    }


}
