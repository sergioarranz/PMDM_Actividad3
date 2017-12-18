package com.utad.sergio.pmdmactividad2;

import com.google.firebase.database.DataSnapshot;

/**
 * Created by sergio on 18/12/17.
 */

public interface FireBaseAdminListener {
    public void fireBaseAdmin_RegisterOK(boolean blOK);
    public void fireBaseAdmin_LoginOK(boolean blOK);
    public void fireBaseAdmin_DownloadedBranch(String branch,DataSnapshot dataSnapshot);

}
