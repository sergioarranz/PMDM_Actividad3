package com.utad.sergio.pmdmactividad2;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.utad.sergio.pmdmactividad2.FBObjects.Messages;
import com.utad.sergio.pmdmactividad2.adapters.MessagesListAdapter;

import java.util.ArrayList;

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

        DataHolder.instance.fireBaseAdmin.GetAndObserveBranch("messages");
        //Log.v("SecondActivity","------- EMAIL DEL USUARIO: --------"+DataHolder.instance.fireBaseAdmin.user.getEmail());

        /*ArrayList<String> mData=new ArrayList<>();
        mData.add("MENSAJE 1");
        mData.add("MENSAJE 2");
        mData.add("MENSAJE 3");
        mData.add("MENSAJE 4");

        MessagesListAdapter messagesListAdapter = new MessagesListAdapter(mData);
        messagesListFragment.recyclerView.setAdapter(messagesListAdapter);*/
    }
}

class SecondActivityEvents implements FireBaseAdminListener {

    SecondActivity secondActivity;

    public SecondActivityEvents(SecondActivity secondActivity){
        this.secondActivity=secondActivity;
    }
    @Override
    public void fireBaseAdmin_DownloadedBranch(String branch, DataSnapshot dataSnapshot) {
        Log.v("SecondActivity", branch+" ------- "+dataSnapshot);
        Messages messages=dataSnapshot.getValue(Messages.class);
        Log.v("SecondActivity", "OBJETO MENSAJES TIENE LOS SIGUIENTES MENSAJES: "+messages.msgs);
    }

    @Override
    public void fireBaseAdmin_RegisterOK(boolean blOK) {

    }

    @Override
    public void fireBaseAdmin_LoginOK(boolean blOK) {

    }
}