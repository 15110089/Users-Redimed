package com.example.users_redimed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class AddItem2 extends AppCompatActivity {

    EditText txtQuestion1;
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
    Database databasel;
    Button btFinish;
    int countItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item2);

        Bundle bd = getIntent().getExtras();
        if(bd!=null)
        {
            countItem = bd.getInt("CI");
        }

        //ánh xạ
        databasel = new Database(this,"redimed.sqlite",null,1);
        String query =
                "CREATE TABLE IF NOT EXISTS TabelQuestion(Id INTEGER PRIMARY KEY, " +
                "txtQuestion1 VARCHAR(500) , " +
                "txtQuestion2 VARCHAR(500) , " +
                "txtQuestion3 VARCHAR(500) , " +
                "txtQuestion4 VARCHAR(500) , " +
                "cbQuestion1 VARCHAR(500) , " +
                "cbQuestion2 VARCHAR(500) , " +
                "cbQuestion3 VARCHAR(500) , " +
                "cbQuestion4 VARCHAR(500) , " +
                "cbQuestion5 VARCHAR(500) , " +
                "cbQuestion6 VARCHAR(500) , " +
                "cbQuestion7 VARCHAR(500) , " +
                "cbQuestion8 VARCHAR(500) , " +
                "cbQuestion9 VARCHAR(500) , " +
                "cbQuestion10 VARCHAR(500) , " +
                "cbQuestion11 VARCHAR(500))";
        databasel.QueryData(query);
        btFinish = (Button) findViewById(R.id.btFinishId);
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
        countItem ++;
        //code
        databasel.QueryData("DELETE FROM TabelQuestion WHERE Id = 1");
        btFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strTxtQuestion1 ;
                String strTxtQuestion2 ;
                String strTxtQuestion3 ;
                String strTxtQuestion4 ;
                String strCbQuestion1 = "0" ;
                String strCbQuestion2 = "0";
                String strCbQuestion3 = "0";
                String strCbQuestion4 = "0";
                String strCbQuestion5 = "0";
                String strCbQuestion6 = "0";
                String strCbQuestion7 = "0";
                String strCbQuestion8 = "0";
                String strCbQuestion9 = "0";
                String strCbQuestion10 = "0";
                String strCbQuestion11 = "0";
                strTxtQuestion1 = txtQuestion1.getText().toString();
                strTxtQuestion2 = txtQuestion2.getText().toString();
                strTxtQuestion3 = txtQuestion3.getText().toString();
                strTxtQuestion4 = txtQuestion4.getText().toString();

                if(cbQuestion1.isChecked()){
                    strCbQuestion1 = "1";
                }
                if(cbQuestion2.isChecked()){
                    strCbQuestion2 = "1";
                }
                if(cbQuestion3.isChecked()){
                    strCbQuestion3 = "1";
                }
                if(cbQuestion4.isChecked()){
                    strCbQuestion4 = "1";
                }
                if(cbQuestion5.isChecked()){
                    strCbQuestion5 = "1";
                }
                if(cbQuestion6.isChecked()){
                    strCbQuestion6 = "1";
                }
                if(cbQuestion7.isChecked()){
                    strCbQuestion7 = "1";
                }
                if(cbQuestion8.isChecked()){
                    strCbQuestion8 = "1";
                }
                if(cbQuestion9.isChecked()){
                    strCbQuestion9 = "1";
                }
                if(cbQuestion10.isChecked()){
                    strCbQuestion10 = "1";
                }
                if(cbQuestion11.isChecked()){
                    strCbQuestion11 = "1";
                }
                databasel.QueryData("INSERT INTO TabelQuestion VALUES(1" +
                        ",'" +strTxtQuestion1+ "'" +
                        ",'" +strTxtQuestion2+ "'" +
                        ",'" +strTxtQuestion3+ "'" +
                        ",'" +strTxtQuestion4+ "'" +
                        ",'" +strCbQuestion1+ "'" +
                        ",'" +strCbQuestion2+ "'" +
                        ",'" +strCbQuestion3+ "'" +
                        ",'" +strCbQuestion4+ "'" +
                        ",'" +strCbQuestion5+ "'" +
                        ",'" +strCbQuestion6+ "'" +
                        ",'" +strCbQuestion7+ "'" +
                        ",'" +strCbQuestion8+ "'" +
                        ",'" +strCbQuestion9+ "'" +
                        ",'" +strCbQuestion10+ "'" +
                        ",'" +strCbQuestion11+ "'" +
                        ")");
                Intent it  =new Intent(AddItem2.this,Review.class);
                it.putExtra("CI",countItem);
                startActivity(it);

            }
        });

    }
}
