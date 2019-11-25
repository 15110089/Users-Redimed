package com.app.users_redimed;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class LichSu2Activity extends AppCompatActivity {

    ImageView Img1;
    ImageView Img2;
    ImageView Img3;
    ImageView Img4;
    EditText txtQuestion1;
    TextView txtRegion;
    EditText txtQuestion2;
    EditText txtQuestion3;
    EditText txtQuestion4;
    CheckBox cbQuestion1;
    CheckBox cbQuestion2;
    CheckBox cbQuestion3;
    CheckBox cbQuestion4;
    CheckBox cbQuestion5;
    CheckBox cbQuestion6;
    CheckBox cbQuestion7;
    CheckBox cbQuestion8;
    CheckBox cbQuestion9;
    CheckBox cbQuestion10;
    CheckBox cbQuestion11;
    Button btSend;
    Database databasel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su2);
        //ánh xạ
        databasel = new Database(this,"redimed.sqlite",null,1);
        btSend = (Button) findViewById(R.id.btSendId);
        Img1 = (ImageView) findViewById(R.id.idImg1);
        Img2 = (ImageView) findViewById(R.id.idImg2);
        Img3 = (ImageView) findViewById(R.id.idImg3);
        Img4 = (ImageView) findViewById(R.id.idImg4);
        txtRegion = (TextView) findViewById(R.id.txtRegion);
        txtQuestion1 = (EditText) findViewById(R.id.txtQuestion1);
        txtQuestion2 = (EditText) findViewById(R.id.txtQuestion2);
        txtQuestion3 = (EditText) findViewById(R.id.txtQuestion3);
        txtQuestion4 = (EditText) findViewById(R.id.txtQuestion4);
        cbQuestion1 = (CheckBox) findViewById(R.id.cbQuestion1);
        cbQuestion2 = (CheckBox) findViewById(R.id.cbQuestion2);
        cbQuestion3 = (CheckBox) findViewById(R.id.cbQuestion3);
        cbQuestion4 = (CheckBox) findViewById(R.id.cbQuestion4);
        cbQuestion5 = (CheckBox) findViewById(R.id.cbQuestion5);
        cbQuestion6 = (CheckBox) findViewById(R.id.cbQuestion6);
        cbQuestion7 = (CheckBox) findViewById(R.id.cbQuestion7);
        cbQuestion8 = (CheckBox) findViewById(R.id.cbQuestion8);
        cbQuestion9 = (CheckBox) findViewById(R.id.cbQuestion9);
        cbQuestion10 = (CheckBox) findViewById(R.id.cbQuestion10);
        cbQuestion11 = (CheckBox) findViewById(R.id.cbQuestion11);
        //region
        Cursor itemName = databasel.GetData("SELECT * FROM TabelName WHERE Id = 1");
        while (itemName.moveToNext()){
            txtRegion.setText(itemName.getString(2));
        }
        //Get id
        //get image 1
        Cursor itemimage1 = databasel.GetData("SELECT * FROM TabelImage1 WHERE Id = 1");
        while (itemimage1.moveToNext()){
            String Image1 = itemimage1.getString(1);
            Img1.setImageBitmap(StringToBitMap(Image1));
        }
        //get image 2
        Cursor itemimage2 = databasel.GetData("SELECT * FROM TabelImage2 WHERE Id = 1");
        while (itemimage2.moveToNext()){
            String Image2 = itemimage2.getString(1);
            Img2.setImageBitmap(StringToBitMap(Image2));
        }
        //get image 3
        Cursor itemimage3 = databasel.GetData("SELECT * FROM TabelImage3 WHERE Id = 1");
        while (itemimage3.moveToNext()){
            String Image3 = itemimage3.getString(1);
            Img3.setImageBitmap(StringToBitMap(Image3));
        }
        //get image 4
        Cursor itemimage4 = databasel.GetData("SELECT * FROM TabelImage4 WHERE Id = 1");
        while (itemimage4.moveToNext()){
            String Image4 = itemimage4.getString(1);
            Img4.setImageBitmap(StringToBitMap(Image4));
        }
        //question
        Cursor itemQuestioin = databasel.GetData("SELECT * FROM TabelQuestion WHERE Id = 1");
        while (itemQuestioin.moveToNext()){
            txtQuestion1.setText(itemQuestioin.getString(1));
            txtQuestion2.setText(itemQuestioin.getString(2));
            txtQuestion3.setText(itemQuestioin.getString(3));
            txtQuestion4.setText(itemQuestioin.getString(4));
            if(itemQuestioin.getString(5).equals("1"))
                cbQuestion1.setChecked(true);
            if(itemQuestioin.getString(6).equals("1"))
                cbQuestion2.setChecked(true);
            if(itemQuestioin.getString(7).equals("1"))
                cbQuestion3.setChecked(true);
            if(itemQuestioin.getString(8).equals("1"))
                cbQuestion4.setChecked(true);
            if(itemQuestioin.getString(9).equals("1"))
                cbQuestion5.setChecked(true);
            if(itemQuestioin.getString(10).equals("1"))
                cbQuestion6.setChecked(true);
            if(itemQuestioin.getString(11).equals("1"))
                cbQuestion7.setChecked(true);
            if(itemQuestioin.getString(12).equals("1"))
                cbQuestion8.setChecked(true);
            if(itemQuestioin.getString(13).equals("1"))
                cbQuestion9.setChecked(true);
            if(itemQuestioin.getString(14).equals("1"))
                cbQuestion10.setChecked(true);
            if(itemQuestioin.getString(15).equals("1"))
                cbQuestion11.setChecked(true);
        }

    }
    public Bitmap StringToBitMap(String encodedString){
        try{
            byte [] encodeByte= Base64.decode(encodedString,Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        }catch(Exception e){
            e.getMessage();
            return null;
        }
    }
    public String BitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] b=baos.toByteArray();
        String temp=Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }
}
