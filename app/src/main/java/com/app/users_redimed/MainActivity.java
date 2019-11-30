package com.app.users_redimed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent it  =new Intent(MainActivity.this,Login.class);
                startActivity(it);
            }
        }, 1000);

        Log.i(">1<","Token:"+ FirebaseInstanceId.getInstance().getToken());
        //cFSn4UU0M90:APA91bEgsljF4Afny5JCcadRtcXpyFmJ-PBXMGAMAxPOlp0vNj4ZpOhq0v1ftasH7UPZp6_Vyk7Yi-Y808SzKpr4jg4ppdXk-N8xArrFXrNumyx_mOf011UyCzp6P_Ev4yZd5BfR5-f4
    }
}
