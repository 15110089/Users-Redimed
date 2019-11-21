package com.example.users_redimed;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.users_redimed.Model.Request;
import com.example.users_redimed.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class RequestSent extends AppCompatActivity {

    ListView listViewTrack;
    Database databasel;
    String user;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    ArrayList<String>arlKeyRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_sent);

        //ánh xạ
        listViewTrack = (ListView) findViewById(R.id.listViewTrack);
        databasel = new Database(this,"redimed.sqlite",null,1);
        Cursor itemTest = databasel.GetData("SELECT * FROM TabelUser WHERE Id = 1");
        while (itemTest.moveToNext()){
            user = itemTest.getString(1);
        }
        //code
        //
        String[] keys = user.split("@");
        String key = keys[0];
        myRef.child("Patient").child(key).child("Request").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                ArrayList<ItemRequestSent> arlRequestSent = new ArrayList<>();
                arlKeyRequest = new ArrayList<>();
                for(DataSnapshot node:dataSnapshot.getChildren()) {
                    Request request = node.getValue(Request.class);
                    if(request.State.equals("4")){
                    }
                    else{
                        int fb = 1;
                        if(request.Feedback==null)
                            fb = 0;
                        ItemRequestSent item = new ItemRequestSent(request.Name,node.getKey(),fb);
                        arlRequestSent.add(item);
                        arlKeyRequest.add(node.getKey());
                    }
                }
                AdapterRequestSent adapter = new AdapterRequestSent(RequestSent.this,R.layout.item_request_sent,arlRequestSent);
                listViewTrack.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        listViewTrack.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it  =new Intent(RequestSent.this,TrackWaiting.class);
                it.putExtra("KEY",arlKeyRequest.get(position) );
                startActivity(it);
            }
        });
        //

    }
}
