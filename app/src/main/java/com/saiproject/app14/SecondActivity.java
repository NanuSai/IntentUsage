package com.saiproject.app14;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {


    TextView txtName;
    TextView txtEmail;
    TextView txtUserName;
    TextView txtPassword;
    TextView txtGenderType;
    ImageView imgReceived;
    
    
    
    public void initialize(){
        
        txtName = findViewById(R.id.txtNameReceived);
        txtEmail = findViewById(R.id.txtEmailRecevied);
        txtUserName = findViewById(R.id.txtUserNameReceived);
        txtPassword = findViewById(R.id.txtPasswordReceived);
        txtGenderType = findViewById(R.id.txtGenderTypeReceived);
        imgReceived = findViewById(R.id.imgReceived);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initialize();


        Bundle extras =  getIntent().getExtras();
        txtName.setText(extras.getString("NAME"));
        txtEmail.setText(extras.getString("EMAIL"));
        txtUserName.setText(extras.getString("USERNAME"));
        txtPassword.setText(extras.getString("PASSWORD"));
        txtGenderType.setText(extras.getString("GENDER_TYPE"));



        byte[] byteArray = extras.getByteArray("PICTURE");
        Bitmap bm = BitmapFactory.decodeByteArray(byteArray,0,byteArray.length);  //Name of array, starting point, length
        imgReceived.setImageBitmap(bm);


    }
}
