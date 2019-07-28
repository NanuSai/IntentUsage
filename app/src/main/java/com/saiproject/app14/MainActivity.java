package com.saiproject.app14;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {


    EditText edtName;
    EditText edtUserName;
    EditText edtPassword;
    EditText edtEmail;
    ImageView imgAnimal;
    RadioGroup radioGroup;
    Button btnAdd;
    String genderType = "";
    final int IMAGE_REQUEST_CODE = 1000;
    Bitmap bm;

    public void instantiate() {


        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtUserName = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.editPassword);

        imgAnimal = findViewById(R.id.imgAnimal);
        radioGroup = findViewById(R.id.radioGroup);

        btnAdd = findViewById(R.id.btnAdd);

        radioGroup.setOnCheckedChangeListener(this);

        imgAnimal.setOnClickListener(this);
        btnAdd.setOnClickListener(this);

        bm = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.tiger);         // Always use getApplicationContext().getResources() and not just getResources() or bitmap returns null.
        imgAnimal.setImageBitmap(bm);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        instantiate();


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {


            case R.id.btnAdd:

                Intent intent = new Intent(this, SecondActivity.class);    //Intent is the glue between two classes

                intent.putExtra("NAME", edtName.getText().toString());           //First argument is key, which must be CAPITALIZED
                intent.putExtra("EMAIL", edtEmail.getText().toString());
                intent.putExtra("USERNAME", edtUserName.getText().toString());
                intent.putExtra("PASSWORD", edtPassword.getText().toString());
                intent.putExtra("GENDER_TYPE", genderType);


                ByteArrayOutputStream stream = new ByteArrayOutputStream();     //ByteArrayOutputStream is the required to pass from one activity to other
                bm.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                intent.putExtra("PICTURE", byteArray);

                startActivity(intent);      //StartActivity and do the intent operations
                break;


            case R.id.imgAnimal:

                String action = Intent.ACTION_GET_CONTENT;
                Intent intentImage = new Intent(action);

                intentImage.setType("image/*");         // images/jpg or png etc
                startActivityForResult(intentImage, IMAGE_REQUEST_CODE);          //Pictures folder activity is opened and associated with IMAGE_REQUEST_CODE

                break;


        }


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch(checkedId){


            case R.id.radioMale:

                genderType = "Male";
                break;

            case R.id.radioFemale:

                genderType = "Female";
                break;
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        switch (requestCode) {

            case IMAGE_REQUEST_CODE:

                if (resultCode == RESULT_OK) {

                    Uri chosenImage = data.getData(); //The chosen images path is stored in chosenImage

                    try {

                        bm = MediaStore.Images.Media.getBitmap(getContentResolver(), chosenImage);
                        imgAnimal.setImageBitmap(bm);
                    } catch (IOException e) {

                        e.printStackTrace();

                    }


                    break;

                }
        }

    }

}

