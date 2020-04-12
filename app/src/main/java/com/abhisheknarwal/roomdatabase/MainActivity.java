package com.abhisheknarwal.roomdatabase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView recyclerView;
    public static final int NEW_PERSON_ACTIVITY_REQUEST_CODE = 1;
    PersonViewModel model;
    List<Person> personArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = findViewById(R.id.floatingActionButton);
        recyclerView = findViewById(R.id.recyclerView);
        final RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        model = new ViewModelProvider(this).get(PersonViewModel.class);
        model.getmAllPerson().observe(this, new Observer<List<Person>>() {
            @Override
            public void onChanged(List<Person> people) {
                recyclerAdapter.setPersonList(people);
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddActivity.class);
                startActivityForResult(intent,NEW_PERSON_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == NEW_PERSON_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            Person person = new Person(data.getStringExtra("name"),data.getLongExtra("phno",0l));
            model.insert(person);
            Toast.makeText(MainActivity.this, "Data successfully inserted", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "Data not inserted", Toast.LENGTH_SHORT).show();
        }
    }
}
