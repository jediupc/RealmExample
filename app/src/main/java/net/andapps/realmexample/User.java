/*
Created by Helm  31/01/2017.
*/


package net.andapps.realmexample;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject {

    @PrimaryKey
    private String name;
    private String pass;
    private RealmList<LoginDate> myList = new RealmList<>();

    public RealmList<LoginDate> getMyList() {
        return myList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setMyList(RealmList<LoginDate> myList) {
        this.myList = myList;
    }

    public String getName() {
        return name;
    }
}
