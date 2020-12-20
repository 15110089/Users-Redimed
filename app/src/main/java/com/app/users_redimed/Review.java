package com.app.users_redimed;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.users_redimed.Model.NewRequest;
import com.app.users_redimed.Model.NewRequest_Profile;
import com.app.users_redimed.Model.NewRequest_Request;
import com.app.users_redimed.Model.Request;
import com.app.users_redimed.Model.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Review extends AppCompatActivity {

    ImageView Img1;
    ImageView imgBody;
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
    Button btChange;
    String key;
    ProgressDialog progress;
    String strKeyRequest;
    int image1Invalid = 0;
    int image2Invalid = 0;
    int image3Invalid = 0;
    int image4Invalid = 0;
    int bodyFace = 1;

    Button btSend;
    String user;
    User userInfor;
    Database databasel;
    Request rq = new Request();
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReference();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        //Get id
        databasel = new Database(this,"redimed.sqlite",null,1);
        Cursor itemTest = databasel.GetData("SELECT * FROM TabelUser WHERE Id = 1");
        while (itemTest.moveToNext()){
            user = itemTest.getString(1);
        }
        //ánh xạ
        progress = new ProgressDialog(Review.this);
        btSend = (Button) findViewById(R.id.btSendId);
        Img1 = (ImageView) findViewById(R.id.idImg1);

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
        imgBody = (ImageView) findViewById(R.id.imgBody);
        btChange = (Button) findViewById(R.id.btChange);
        //user infor
        key = user;
        myRef.child("Patient").child(key).child("Profile").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {

                userInfor = dataSnapshot.getValue(User.class);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        //code
        imgBody.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int[] viewCoords = new int[2];
                imgBody.getLocationOnScreen(viewCoords);

                int touchX = (int) event.getX();
                int touchY = (int) event.getY();

                int pX = (touchX * 100) / imgBody.getMeasuredWidth();
                int pY = (touchY * 100) / imgBody.getMeasuredHeight();

                String localBody = "";


                if (bodyFace == 1) {
                    if (11 < pX && pX < 28 && 16 < pY && pY < 56) {
                        Log.i(">local<:", "1");
                        localBody = "Right Hand";
                        imgBody.setImageResource(R.drawable.body_f_1);
                    }
                    if (64 < pX && pX < 84 && 16 < pY && pY < 56) {
                        Log.i(">local<:", "2");
                        localBody = "Left Hand";
                        imgBody.setImageResource(R.drawable.body_f_2);
                    }
                    if (28 < pX && pX < 64 && 15 < pY && pY < 44) {
                        Log.i(">local<:", "3");
                        localBody = "Body";
                        imgBody.setImageResource(R.drawable.body_f_3);
                    }
                    if (28 < pX && pX < 47 && 43 < pY && pY < 98) {
                        Log.i(">local<:", "4");
                        localBody = "Right Foot";
                        imgBody.setImageResource(R.drawable.body_f_4);
                    }
                    if (47 < pX && pX < 61 && 41 < pY && pY < 99) {
                        Log.i(">local<:", "5");
                        localBody = "Left Foot";
                        imgBody.setImageResource(R.drawable.body_f_5);
                    }
                    if (37 < pX && pX < 54 && 1 < pY && pY < 11) {
                        Log.i(">local<:", "6");
                        localBody = "Head";
                        imgBody.setImageResource(R.drawable.body_f_6);
                    }
                } else {

                    //Back
                    if (66 < pX && pX < 83 && 15 < pY && pY < 55) {
                        Log.i(">local<:", "2");
                        localBody = "Left Hand";
                        imgBody.setImageResource(R.drawable.body_b_2);
                    }
                    if (11 < pX && pX < 32 && 16 < pY && pY < 56) {
                        Log.i(">local<:", "1");
                        localBody = "Right Hand";
                        imgBody.setImageResource(R.drawable.body_b_1);
                    }
                    if (31 < pX && pX < 66 && 15 < pY && pY < 41) {
                        Log.i(">local<:", "3");
                        localBody = "Body";
                        imgBody.setImageResource(R.drawable.body_b_3);
                    }
                    if (49 < pX && pX < 67 && 42 < pY && pY < 98) {
                        Log.i(">local<:", "5");
                        localBody = "Left Foot";
                        imgBody.setImageResource(R.drawable.body_b_5);
                    }
                    if (31 < pX && pX < 48 && 42 < pY && pY < 98) {
                        Log.i(">local<:", "4");
                        localBody = "Right Foot";
                        imgBody.setImageResource(R.drawable.body_b_4);
                    }
                    if (42 < pX && pX < 59 && 1 < pY && pY < 11) {
                        Log.i(">local<:", "6");
                        localBody = "Head";
                        imgBody.setImageResource(R.drawable.body_b_6);
                    }
                }




                if (bodyFace == 1) {
                    if (localBody != "")
                        txtRegion.setText(localBody + " Front");
                } else {
                    if (localBody != "")
                        txtRegion.setText(localBody + " Back");
                }

                return true;

            }

        });
        btChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bodyFace == 1){
                    imgBody.setImageResource(R.drawable.bodyback);
                    bodyFace = 0;
                }else{
                    imgBody.setImageResource(R.drawable.bodyface);
                    bodyFace = 1;
                }
            }
        });
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progress.setTitle("Request is being sent");
                progress.setMessage("Waiting ...");
                progress.setCancelable(false);
                progress.show();

                key = user;
                myRef.child("Patient").child(key).child("Request").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                        long keyRequest =  dataSnapshot.getChildrenCount();
                        keyRequest = keyRequest +  1;
                        strKeyRequest = keyRequest+"";
                        rq.Region = txtRegion.getText().toString();
                         rq.State = "1";
                        rq.Question1 = txtQuestion1.getText().toString();
                        rq.Question2 = txtQuestion2.getText().toString();
                        rq.Question3 = txtQuestion3.getText().toString();
                        rq.Question4 = txtQuestion4.getText().toString();
                        if(cbQuestion1.isChecked()){
                            rq.Question5 = "1";
                        }else{
                            rq.Question5 = "0";
                        }
                        if(cbQuestion2.isChecked()){
                            rq.Question6 = "1";
                        }else{
                            rq.Question6 = "0";
                        }
                        if(cbQuestion3.isChecked()){
                            rq.Question7 = "1";
                        }else{
                            rq.Question7 = "0";
                        }
                        if(cbQuestion4.isChecked()){
                            rq.Question8 = "1";
                        }else{
                            rq.Question8 = "0";
                        }
                        if(cbQuestion5.isChecked()){
                            rq.Question9 = "1";
                        }else{
                            rq.Question9 = "0";
                        }
                        if(cbQuestion6.isChecked()){
                            rq.Question10 = "1";
                        }else{
                            rq.Question10 = "0";
                        }
                        if(cbQuestion7.isChecked()){
                            rq.Question11 = "1";
                        }else{
                            rq.Question11 = "0";
                        }
                        if(cbQuestion8.isChecked()){
                            rq.Question12 = "1";
                        }else{
                            rq.Question12 = "0";
                        }
                        if(cbQuestion9.isChecked()){
                            rq.Question13 = "1";
                        }else{
                            rq.Question13 = "0";
                        }
                        if(cbQuestion10.isChecked()){
                            rq.Question14 = "1";
                        }else{
                            rq.Question14 = "0";
                        }
                        if(cbQuestion11.isChecked()){
                            rq.Question15 = "1";
                        }else{
                            rq.Question15 = "0";
                        }
                rq.Name = "Lesson " + strKeyRequest;
                myRef.child("Patient").child(key).child("Request").child(strKeyRequest).setValue(rq);
                        NewRequest newRequest = new NewRequest();
                        newRequest.User = key;
                        newRequest.Key = strKeyRequest;
//                myRef.child("NewRequest").push().setValue(newRequest)

                        NewRequest_Profile newRequest_Profile = new  NewRequest_Profile(userInfor.Name,userInfor.Birth,userInfor.Phone,userInfor.Gender);
                        myRef.child("NewRequest").child(key).child("Profile").setValue(newRequest_Profile);
                        Date currentTime = Calendar.getInstance().getTime();
                        SimpleDateFormat postFormater = new SimpleDateFormat("dd/MM/yyyy");
                        String newDateStr = postFormater.format(currentTime);
                        NewRequest_Request newRequest_Request = new NewRequest_Request(rq.Name,newDateStr);
                        myRef.child("NewRequest").child(key).child("Request").child(strKeyRequest).setValue(newRequest_Request);

//                myRef.child("Request").child("01").setValue(rq);
                //ảnh 1
                if (image1Invalid == 1) {
                    StorageReference mountainsRef = storageRef.child("Patient").child(key).child(strKeyRequest).child("Image.jpg");
                    Img1.setDrawingCacheEnabled(true);
                    Img1.buildDrawingCache();
                    Bitmap bitmap = ((BitmapDrawable) Img1.getDrawable()).getBitmap();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                    byte[] data = baos.toByteArray();

                    UploadTask uploadTask = mountainsRef.putBytes(data);
                    uploadTask.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            // Handle unsuccessful uploads
                            Toast.makeText(Review.this, "Save That bai", Toast.LENGTH_LONG).show();

                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                            // ...
                            Toast.makeText(Review.this, "Request has been sent", Toast.LENGTH_LONG).show();
                            Intent it = new Intent(Review.this, Option.class);
                            startActivity(it);

                            storageRef.child("Patient").child(key).child(strKeyRequest).child("Image.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    // Got the download URL for 'users/me/profile.png'
                                    myRef.child("Patient").child(key).child("Request").child(strKeyRequest).child("LinkImage1").setValue(uri.toString());
                                    //https://serverredimed20200103113642.azurewebsites.net/v1/test2/0326055411/1/https%3A**n****n**encrypted-tbn0.gstatic.com**n**images%3Fq%3Dtbn%3AANd9GcSlSjQxZe_tte_QOFNFfCIyn0jf6s3PIl2pzJuTedovz70SOz5S%26s
                                    String path = "https://serverredimed20201220013926.azurewebsites.net//v1/test2/"+key+"/"+strKeyRequest+"/";
                                    String path2 = uri.toString();
                                    try {
                                        path2 = path2.replace("/", "**n**");
                                        path2 = path2.replace("%2F", "**nn**");
                                        String encodedURL = URLEncoder.encode(path2, "UTF-8");
                                        new Review.ReadJSONObject().execute(path + encodedURL);
                                    } catch (UnsupportedEncodingException   e) {
                                        e.printStackTrace();
                                    }
                                    progress.dismiss();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception exception) {
                                    // Handle any errors
                                    Toast.makeText(Review.this, "That bai", Toast.LENGTH_LONG).show();
                                    Log.d("<<<", "hu hu");
                                }
                            });

                        }
                    });
                }
                else{
                    Toast.makeText(Review.this, "Image not yet", Toast.LENGTH_LONG).show();
                    myRef.child("Patient").child(key).child("Request").child(strKeyRequest).removeValue();
                    myRef.child("NewRequest").child(key).child("Profile").removeValue();
                    myRef.child("NewRequest").child(key).child("Request").child(strKeyRequest).removeValue();
                    progress.dismiss();
                }
//                //ảnh 2
//                if (image2Invalid == 1) {
//                    StorageReference mountainsRef2 = storageRef.child("01").child("anh2.jpg");
//                    Img2.setDrawingCacheEnabled(true);
//                    Img2.buildDrawingCache();
//                    Bitmap bitmap2 = ((BitmapDrawable) Img2.getDrawable()).getBitmap();
//                    ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
//                    bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, baos2);
//                    byte[] data2 = baos2.toByteArray();
//
//                    UploadTask uploadTask2 = mountainsRef2.putBytes(data2);
//                    uploadTask2.addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception exception) {
//                            // Handle unsuccessful uploads
//                            Toast.makeText(Review.this, "Save That bai", Toast.LENGTH_LONG).show();
//
//                        }
//                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                        @Override
//                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                            // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
//                            // ...
//                            Toast.makeText(Review.this, "50%", Toast.LENGTH_LONG).show();
//
//                            storageRef.child("01").child("anh2.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                                @Override
//                                public void onSuccess(Uri uri) {
//                                    // Got the download URL for 'users/me/profile.png'
//                                    myRef.child("Request").child("01").child("linkImage2").setValue(uri.toString());
//                                }
//                            }).addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception exception) {
//                                    // Handle any errors
//                                    Toast.makeText(Review.this, "That bai", Toast.LENGTH_LONG).show();
//                                    Log.d("<<<", "hu hu");
//                                }
//                            });
//
//                        }
//                    });
//                }
//                //ảnh 3
//                if (image3Invalid == 1) {
//                    StorageReference mountainsRef3 = storageRef.child("01").child("anh3.jpg");
//                    Img3.setDrawingCacheEnabled(true);
//                    Img3.buildDrawingCache();
//                    Bitmap bitmap3 = ((BitmapDrawable) Img3.getDrawable()).getBitmap();
//                    ByteArrayOutputStream baos3 = new ByteArrayOutputStream();
//                    bitmap3.compress(Bitmap.CompressFormat.JPEG, 100, baos3);
//                    byte[] data3 = baos3.toByteArray();
//
//                    UploadTask uploadTask3 = mountainsRef3.putBytes(data3);
//                    uploadTask3.addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception exception) {
//                            // Handle unsuccessful uploads
//                            Toast.makeText(Review.this, "Save That bai", Toast.LENGTH_LONG).show();
//
//                        }
//                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                        @Override
//                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                            // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
//                            // ...
//                            Toast.makeText(Review.this, "75%", Toast.LENGTH_LONG).show();
//
//                            storageRef.child("01").child("anh3.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                                @Override
//                                public void onSuccess(Uri uri) {
//                                    // Got the download URL for 'users/me/profile.png'
//                                    myRef.child("Request").child("01").child("linkImage3").setValue(uri.toString());
//                                }
//                            }).addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception exception) {
//                                    // Handle any errors
//                                    Toast.makeText(Review.this, "That bai", Toast.LENGTH_LONG).show();
//                                    Log.d("<<<", "hu hu");
//                                }
//                            });
//
//                        }
//                    });
//                }
//                //ảnh 4
//                if (image1Invalid == 1) {
//                    StorageReference mountainsRef4 = storageRef.child("01").child("anh4.jpg");
//                    Img4.setDrawingCacheEnabled(true);
//                    Img4.buildDrawingCache();
//                    Bitmap bitmap4 = ((BitmapDrawable) Img4.getDrawable()).getBitmap();
//                    ByteArrayOutputStream baos4 = new ByteArrayOutputStream();
//                    bitmap4.compress(Bitmap.CompressFormat.JPEG, 100, baos4);
//                    byte[] data4 = baos4.toByteArray();
//
//                    UploadTask uploadTask4 = mountainsRef4.putBytes(data4);
//                    uploadTask4.addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception exception) {
//                            // Handle unsuccessful uploads
//                            Toast.makeText(Review.this, "Save That bai", Toast.LENGTH_LONG).show();
//
//                        }
//                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                        @Override
//                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                            // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
//                            // ...
//                            Toast.makeText(Review.this, "100%", Toast.LENGTH_LONG).show();
//
//                            storageRef.child("01").child("anh4.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                                @Override
//                                public void onSuccess(Uri uri) {
//                                    // Got the download URL for 'users/me/profile.png'
//                                    myRef.child("Request").child("01").child("linkImage4").setValue(uri.toString());
//                                }
//                            }).addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception exception) {
//                                    // Handle any errors
//                                    Toast.makeText(Review.this, "That bai", Toast.LENGTH_LONG).show();
//                                    Log.d("<<<", "hu hu");
//                                }
//                            });
//
//                        }
//                    });
//
//
//                }

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }
        });
        //code
        Img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1);

            }
        });

        //region
        Cursor itemName = databasel.GetData("SELECT * FROM TabelName WHERE Id = 1");
        while (itemName.moveToNext()){
            rq.Region = itemName.getString(1);
            txtRegion.setText(itemName.getString(1));

            ///////
            if(itemName.getString(1).equals("Right Hand Front")){
                imgBody.setImageResource(R.drawable.body_f_1);
                bodyFace = 1;
            }
            if(itemName.getString(1).equals("Left Hand Front")){
                imgBody.setImageResource(R.drawable.body_f_2);
                bodyFace = 1;
            }
            if(itemName.getString(1).equals("Body Front")){
                imgBody.setImageResource(R.drawable.body_f_3);
                bodyFace = 1;
            }
            if(itemName.getString(1).equals("Right Foot Front")){
                imgBody.setImageResource(R.drawable.body_f_4);
                bodyFace = 1;
            }
            if(itemName.getString(1).equals("Left Foot Front")){
                imgBody.setImageResource(R.drawable.body_f_5);
                bodyFace = 1;
            }
            if(itemName.getString(1).equals("Head Front")){
                imgBody.setImageResource(R.drawable.body_f_6);
                bodyFace = 1;
            }

            if(itemName.getString(1).equals("Right Hand Back")){
                imgBody.setImageResource(R.drawable.body_b_1);
                bodyFace = 0;
            }
            if(itemName.getString(1).equals("Left Hand Back")){
                imgBody.setImageResource(R.drawable.body_b_2);
                bodyFace = 0;
            }
            if(itemName.getString(1).equals("Body Back")){
                imgBody.setImageResource(R.drawable.body_b_3);
                bodyFace = 0;
            }
            if(itemName.getString(1).equals("Right Foot Back")){
                imgBody.setImageResource(R.drawable.body_b_4);
                bodyFace = 0;
            }
            if(itemName.getString(1).equals("Left Foot Back")){
                imgBody.setImageResource(R.drawable.body_b_5);
                bodyFace = 0;
            }
            if(itemName.getString(1).equals("Head Back")){
                imgBody.setImageResource(R.drawable.body_b_6);
                bodyFace = 0;
            }
        }
        //Get id
        //get image 1
        Cursor itemimage1 = databasel.GetData("SELECT * FROM TabelImage1 WHERE Id = 1");
        while (itemimage1.moveToNext()){
            String Image1 = itemimage1.getString(1);
            image1Invalid = 1;
            Img1.setImageBitmap(StringToBitMap(Image1));
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
            rq.Question1 = itemQuestioin.getString(1);
            rq.Question2 = itemQuestioin.getString(2);
            rq.Question3 = itemQuestioin.getString(3);
            rq.Question4 = itemQuestioin.getString(4);
            rq.Question5 = itemQuestioin.getString(5);
            rq.Question6 = itemQuestioin.getString(6);
            rq.Question7 = itemQuestioin.getString(7);
            rq.Question8 = itemQuestioin.getString(8);
            rq.Question9 = itemQuestioin.getString(9);
            rq.Question10 = itemQuestioin.getString(10);
            rq.Question11 = itemQuestioin.getString(11);
            rq.Question12 = itemQuestioin.getString(12);
            rq.Question13 = itemQuestioin.getString(13);
            rq.Question14 = itemQuestioin.getString(14);
            rq.Question15 = itemQuestioin.getString(15);
        }


    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode==1&&resultCode==RESULT_OK&&data!=null)
        {

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            Img1.setImageBitmap(bitmap);
            String UrlImage = BitMapToString(bitmap);
            image1Invalid = 1;
            databasel.QueryData("UPDATE TabelImage1 SET Image ='"+ UrlImage +"' WHERE Id = 1");
        }



        super.onActivityResult(requestCode, resultCode, data);
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

    private class ReadJSONObject extends AsyncTask<String, Void,String> {
        @Override
        protected String doInBackground(String... strings) {
            StringBuffer content = new StringBuffer();
            try {
                URL url = new URL(strings[0]);
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line);
                }
                bufferedReader.close();

            } catch (MalformedURLException e) {
                Log.d(">>>>>>>>>>", "Ko on roi 1");
                e.printStackTrace();
            } catch (IOException e) {
                Log.d(">>>>>>>>>>", "Ko on roi 2");
                e.printStackTrace();
            }
            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject object = new JSONObject(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }



}


