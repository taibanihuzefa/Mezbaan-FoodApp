package com.example.mezbaan;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceActivity;



public class SettingPreference extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting_preference);
    }
}
