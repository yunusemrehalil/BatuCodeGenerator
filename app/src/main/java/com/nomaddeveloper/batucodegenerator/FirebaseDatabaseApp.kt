package com.nomaddeveloper.batucodegenerator

import com.google.firebase.database.FirebaseDatabase

class FirebaseDatabaseApp : android.app.Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}