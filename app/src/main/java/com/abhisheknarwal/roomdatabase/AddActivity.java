package com.abhisheknarwal.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    EditText etName, etPhno;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        etName = findViewById(R.id.etName);
        etPhno = findViewById(R.id.etPhno);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                Long phno = 0l;
                Intent intent = new Intent();
                try{
                    phno = Long.parseLong(etPhno.getText().toString());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(AddActivity.this, "Check the phone number\nand try again", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(name == ""){
                    setResult(RESULT_CANCELED,intent);
                }else{
                    intent.putExtra("name",name);
                    intent.putExtra("phno",phno);
                    setResult(RESULT_OK,intent);
                }
                finish();
            }
        });
    }
}
