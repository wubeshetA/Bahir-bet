package com.bahirbet.org.bahirbet;

import android.app.Application;
import android.content.Context;

import com.bahirbet.org.bahirbet.helper.LocaleHelper;

public class MainApplicationOfLanguage extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base,"en"));
    }
}
