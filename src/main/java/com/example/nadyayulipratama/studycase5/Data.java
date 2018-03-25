package com.example.nadyayulipratama.studycase5;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Data extends AppCompatActivity {
    private EditText Name, Descripsi, Prority;
    private Database dtbs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        Name = (EditText)findViewById(R.id.editText);
        Descripsi = (EditText)findViewById(R.id.editText5);
        Prority = (EditText)findViewById(R.id.editText6);
        dtbs = new Database(this) {

        };
    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(Data.this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }
    public void addbtn (View view){
        if(dtbs.input(new informasi(Name.getText().toString(), Descripsi.getText().toString(), Prority.getText().toString()))){
        Toast.makeText(this, "List telah di tambah", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Data.this, MainActivity.class));
            this.finish();

    }else{
            Toast.makeText(this, "List kosong ", Toast.LENGTH_SHORT).show();
            Name.setText(null);
            Descripsi.setText(null);
            Prority.setText(null);
        }
    }


}