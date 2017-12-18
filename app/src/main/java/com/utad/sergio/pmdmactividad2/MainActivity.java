package com.utad.sergio.pmdmactividad2;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;

import fragments.LoginFragment;
import fragments.LoginFragmentListener;
import fragments.RegisterFragment;
import fragments.RegisterFragmentListener;

public class MainActivity extends AppCompatActivity {

    public LoginFragment loginFragment;
    public RegisterFragment registerFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialización y vinculación de los fragments
        loginFragment = (LoginFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentLogin);
        registerFragment = (RegisterFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentRegister);
        MainActivityEvents mainActivityEvents=new MainActivityEvents(this); // Inicialización del gestor de eventos

        //Definimos a través de setters el listener de los fragments
        loginFragment.setListener(mainActivityEvents);
        registerFragment.setListener(mainActivityEvents);
        DataHolder.instance.fireBaseAdmin.setListener(mainActivityEvents);

        // Transición para mostrar y ocultar fragments
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.show(loginFragment);
        transaction.hide(registerFragment);
        transaction.commit();

        DataHolder.instance.fireBaseAdmin.UserLog("tesdt@test.com", "1234567890", this);


        }
    }

class MainActivityEvents implements LoginFragmentListener, RegisterFragmentListener, FireBaseAdminListener{
    MainActivity mainActivity;

    public MainActivityEvents(MainActivity mainActivity){
        this.mainActivity=mainActivity;
    }

    @Override
    public void OnLogFragmentBtnClicked(String sUser,String sPass) {
        DataHolder.instance.fireBaseAdmin.UserLog(sUser,sPass,mainActivity);
    }

    @Override
    public void OnRegFragmentBtnClicked() {
        FragmentTransaction transaction = mainActivity.getSupportFragmentManager().beginTransaction();
        transaction.hide(mainActivity.loginFragment);
        transaction.show(mainActivity.registerFragment);
        transaction.commit();
    }

    @Override
    public void OnRegisterFragmentBtnAccClicked(String sUser,String sPass) {
        DataHolder.instance.fireBaseAdmin.UserReg(sUser,sPass,mainActivity);

    }

    @Override
    public void OnRegisterFragmentBtnCancelClicked() {
        FragmentTransaction transaction = mainActivity.getSupportFragmentManager().beginTransaction();
        transaction.show(mainActivity.loginFragment);
        transaction.hide(mainActivity.registerFragment);
        transaction.commit();
    }

    @Override
    public void fireBaseAdmin_RegisterOK(boolean blOK) {
        Log.v("MAINACTIVITYEVENTS", "RESULTADO DE REGISTER"+ blOK);
        if(blOK){
            Intent intent = new Intent(mainActivity,SecondActivity.class);
            mainActivity.startActivity(intent);
            mainActivity.finish();
        } else {

        }
    }

    @Override
    public void fireBaseAdmin_LoginOK(boolean blOK) {
        if(blOK){
            Intent intent = new Intent(mainActivity,SecondActivity.class);
            mainActivity.startActivity(intent);
            mainActivity.finish();
        } else {

        }
    }

    @Override
    public void fireBaseAdmin_DownloadedBranch(String branch, DataSnapshot dataSnapshot) {

    }
}