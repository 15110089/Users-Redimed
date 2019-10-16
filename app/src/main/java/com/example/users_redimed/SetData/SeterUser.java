package com.example.users_redimed.SetData;

import androidx.lifecycle.ViewModel;

import com.example.users_redimed.Model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SeterUser extends ViewModel {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    public void PostUser(User user) {
          myRef.child("User").child(user.Email).setValue(user);
    }

}
