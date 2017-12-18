package com.utad.sergio.pmdmactividad2;

import android.provider.ContactsContract;

/**
 * Created by sergio on 18/12/17.
 */

public class DataHolder {
    public static DataHolder instance = new DataHolder();

    public FireBaseAdmin fireBaseAdmin;

    public DataHolder(){
        fireBaseAdmin=new FireBaseAdmin();
    }
}
