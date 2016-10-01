package com.gymapp.gymapp.Model.DataConnection;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by hungbin on 9/23/2016.
 */
public abstract class DataConnection {
    protected static DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    protected DatabaseReference userRef;// = rootRef.child("")


    protected static Firebase firebaseRoot;
    protected Firebase firebaseUser;

    //init userRef
    {
        String emailKey = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        emailKey = emailKey.replace("@","_").replace(".","_");
        userRef = rootRef.child(emailKey);

        firebaseRoot = new Firebase("https://gymapp-b116c.firebaseio.com/");
        firebaseUser = firebaseRoot.child(emailKey);
    }

}
