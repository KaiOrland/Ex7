package com.example.madaim.ex7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void sendResult(View v){
        Intent intent = new Intent();//creates default intent
        EditText firstName = (EditText)findViewById(R.id.editText);
        EditText lastName = (EditText)findViewById(R.id.editText2);
        RadioGroup rd = (RadioGroup)findViewById(R.id.rdGroup);
        String firstNameStr = firstName.getText().toString();
        String lastNameStr = (String)lastName.getText().toString();
        int radioGroupid = rd.getCheckedRadioButtonId();

        if((firstNameStr.isEmpty())||(lastNameStr.isEmpty())||(radioGroupid==-1)){//if the data isnt filled by the user, go back to MainActivity
            Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            intent.putExtra("First",firstNameStr);//
            intent.putExtra("Last",lastNameStr);
            intent.putExtra("gender", radioGroupid==R.id.radioButton?"Mr.":"Mrs.");
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
