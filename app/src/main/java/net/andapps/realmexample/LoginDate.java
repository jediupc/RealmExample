/*
Created by Helm  31/01/2017.
*/


package net.andapps.realmexample;

import io.realm.RealmObject;

import java.util.Date;

public class LoginDate extends RealmObject {

    java.util.Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
