package com.utad.sergio.pmdmactividad2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;

import fragments.MessagesListFragment;

public class SecondActivity extends AppCompatActivity {

    MessagesListFragment messagesListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SecondActivityEvents events = new SecondActivityEvents(this);
        DataHolder.instance.fireBaseAdmin.setListener(events);

        messagesListFragment=(MessagesListFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentMsgList);
        //Log.v("SecondActivity","------- EMAIL DEL USUARIO: --------"+DataHolder.instance.fireBaseAdmin.user.getEmail());
    }
}

class SecondActivityEvents implements FireBaseAdminListener {

    SecondActivity secondActivity;

    public SecondActivityEvents(SecondActivity secondActivity){
        this.secondActivity=secondActivity;
    }
    @Override
    public void fireBaseAdmin_DownloadedBranch(String branch, DataSnapshot dataSnapshot) {

    }

    @Override
    public void fireBaseAdmin_RegisterOK(boolean blOK) {

    }

    @Override
    public void fireBaseAdmin_LoginOK(boolean blOK) {

    }
}