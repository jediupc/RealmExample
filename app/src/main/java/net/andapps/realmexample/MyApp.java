/*
Created by Helm  31/01/2017.
*/


package net.andapps.realmexample;

import android.app.Application;
import io.realm.Realm;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
