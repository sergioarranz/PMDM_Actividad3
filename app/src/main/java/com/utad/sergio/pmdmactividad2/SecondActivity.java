package com.utad.sergio.pmdmactividad2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.GenericTypeIndicator;
import com.utad.sergio.pmdmactividad2.FBObjects.FBCoches;
import com.utad.sergio.pmdmactividad2.FBObjects.Message;
import com.utad.sergio.pmdmactividad2.adapters.MessagesListAdapter;

import java.util.ArrayList;
import java.util.Map;

import fragments.ListaFragment;

public class SecondActivity extends AppCompatActivity {

    ListaFragment messagesListFragment, listaFragmentCoches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SecondActivityEvents events = new SecondActivityEvents(this);
        DataHolder.instance.fireBaseAdmin.setListener(events);

        messagesListFragment=(ListaFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentMsgList);
        listaFragmentCoches=(ListaFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentListCoches);

        DataHolder.instance.fireBaseAdmin.GetAndObserveBranch("messages");
        DataHolder.instance.fireBaseAdmin.GetAndObserveBranch("Coches");

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
        if(branch.equals("messages")){
            GenericTypeIndicator<Map<String, Message>> indicator = new GenericTypeIndicator<Map<String, Message>>(){};
            Map<String, Message> msgs = dataSnapshot.getValue(indicator);
            Log.v("SecondActivity", "MENSAJES CONTIENE: "+msgs.values());
            MessagesListAdapter messagesListAdapter = new MessagesListAdapter(new ArrayList<Message>(msgs.values()));
            secondActivity.messagesListFragment.recyclerView.setAdapter(messagesListAdapter);

        } else if (branch.equals("Coches")){
            GenericTypeIndicator<ArrayList<FBCoches>> indicator = new GenericTypeIndicator<ArrayList<FBCoches>>(){};
            <ArrayList<FBCoches>> coches = dataSnapshot.getValue(indicator);
            Log.v("SecondActivity", "MENSAJES CONTIENE: "+coches);
            MessagesListAdapter messagesListAdapter = new MessagesListAdapter(new ArrayList<Message>(msgs.values()));
            secondActivity.messagesListFragment.recyclerView.setAdapter(messagesListAdapter);
        }
        //Messages messages=dataSnapshot.getValue(Messages.class);

    }

    @Override
    public void fireBaseAdmin_RegisterOK(boolean blOK) {

    }

    @Override
    public void fireBaseAdmin_LoginOK(boolean blOK) {

    }
}