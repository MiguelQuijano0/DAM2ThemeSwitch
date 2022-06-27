package com.example.themeswitcher;

import android.app.Activity;
import android.content.Intent;

public class Utils {
    private static int spinnerTheme;
    public final static int THEME_MATERIAL_LIGHT = 0;
    public final static int THEME_MATERIAL_Dark = 1;
    public final static int Default = 2;

    public static void changeToTheme(Activity activity, int theme) {
        spinnerTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public static void onActivityCreateSetTheme(Activity activity) {
        switch (spinnerTheme) {
            default:
            case THEME_MATERIAL_LIGHT:
                activity.setTheme(R.style.Theme_Material_Light);
                break;
            case THEME_MATERIAL_Dark:
                activity.setTheme(com.google.android.material.R.style.Theme_Material3_Dark);
                break;
            case Default:
                activity.setTheme(R.style.Default);
                break;
        }
    }
}