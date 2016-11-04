package com.example.madaim.ex7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final int REGISTER_REQUEST = 1;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if((requestCode==REGISTER_REQUEST)&&(resultCode==RESULT_OK)){
            String firstName = data.getExtras().getString("First");
            String lastName = data.getExtras().getString("Last");
            String gender = data.getExtras().getString("gender");
            Toast.makeText(this, "Welcome" + " " + gender + " " + firstName +" " +  lastName, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onRegister(View v){

        Intent intent = new Intent(this, Register.class);//creates new intent for Register class
        startActivityForResult(intent, REGISTER_REQUEST);
    }
}
