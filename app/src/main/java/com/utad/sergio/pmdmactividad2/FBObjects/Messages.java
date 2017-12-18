package com.utad.sergio.pmdmactividad2.FBObjects;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;

/**
 * Created by sergio on 19/12/17.
 */

@IgnoreExtraProperties
public class Messages {

    public HashMap<String,Message> msgs;

    public Messages(){

    }

    public Messages(HashMap<String,Message> messages){
        this.msgs=messages;
    }
}
