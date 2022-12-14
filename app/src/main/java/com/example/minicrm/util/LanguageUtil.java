package com.example.minicrm.util;


import com.example.minicrm.app.ApplicationMiniCrm;
import com.example.minicrm.app.Constants;

import java.util.Locale;

public class LanguageUtil {
    public static final String[] LANGUAGE_CODES = new String[]{"vi", "en"};

    public static Locale getLocale() {
        SharedPref pref = ApplicationMiniCrm.getInstance().getShapref();

        String lang="vi";
        Locale locale = new Locale(lang,getLocaleConstant(lang));
        String language = pref.getString(Constants.KEY_LANG, getDefault(locale));
        return new Locale(language,getLocaleConstant(language));
    }

    private static String getDefault(Locale locale) {

        String language = locale.getLanguage();
        if (language.equalsIgnoreCase("vi")) return LANGUAGE_CODES[0];

        return LANGUAGE_CODES[1];
    }

    public static int getIndexLanguage(){
        SharedPref pref = ApplicationMiniCrm.getInstance().getShapref();
        String language =pref.getString(Constants.KEY_LANG,LANGUAGE_CODES[0]);

        if (language.equalsIgnoreCase("vi")) return 0;
        if (language.equalsIgnoreCase("en")) return 1;

        return 0;

    }
    public static void changeLanguage(int index) {
        SharedPref pref = ApplicationMiniCrm.getInstance().getShapref();
        pref.putString(Constants.KEY_LANG, LANGUAGE_CODES[index]);
    }

    public static String getLocaleConstant(String language) {

        //Log.d("getLocaleConstant", " " + language);
        if (language.equals("vi")) {
            return "VI";
        }
        return "EN";
    }


}
