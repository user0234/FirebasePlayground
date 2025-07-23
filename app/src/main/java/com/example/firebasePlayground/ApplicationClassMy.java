package com.example.firebasePlayground;

import android.app.Application;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class ApplicationClassMy extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(getApplicationContext());
        FirebaseAuth.getInstance().signInAnonymously()
                .addOnSuccessListener(authResult -> {
                    Log.d("AUTH", " Signed in anonymously");
                   // deleteOldHighscoreEntries(this);
                })
                .addOnFailureListener(e -> {
                    Log.e("AUTH", " Anonymous auth failed: " + e.getMessage());
                });
    }
}
