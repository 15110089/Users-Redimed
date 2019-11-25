package com.app.users_redimed;


import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.app.users_redimed.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class rootData extends ViewModel {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    //
    // User
    //
    private User User;
    public User getUser() {
        myRef.child("User").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User = dataSnapshot.getValue(User.class);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        });
        return User;
    }
    //&
    public void setUser(User user) {
      //  myRef.child("User").child(user.id).setValue(user);
    }

}
