package com.example.users_redimed;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class AddItem1 extends AppCompatActivity {

//    Button btAddItem2;
    int countItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item1);

        Bundle bd = getIntent().getExtras();
        if(bd!=null)
        {
            countItem = bd.getInt("CI");
        }
        //ánh xạ
//        btAddItem2 = (Button) findViewById(R.id.btAddItem2Id);

        //code
//        btAddItem2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent it  =new Intent(AddItem1.this,AddItem2.class);
//                startActivity(it);
//            }
//        });
        Intent intent  = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode==1&&resultCode==RESULT_OK&&data!=null)
        {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            Intent it  =new Intent(AddItem1.this,AddItem2.class);
            it.putExtra("CI",countItem);
            startActivity(it);
        }


        super.onActivityResult(requestCode, resultCode, data);
    }
}
