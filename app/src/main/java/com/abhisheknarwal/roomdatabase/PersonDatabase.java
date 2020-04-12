package com.abhisheknarwal.roomdatabase;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
@Database(entities = {Person.class},version = 2,exportSchema =  false)
public abstract class PersonDatabase extends RoomDatabase {

    private static volatile PersonDatabase INSTANCE;

    public abstract PersonDAO getPersonDao();


    public static  PersonDatabase
    getDatabase(Context context){
        if(INSTANCE == null){
            synchronized (PersonDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),PersonDatabase.class,"person_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(dabasecallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    private static RoomDatabase.Callback dabasecallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db){
            super.onCreate(db);
        }
    };
}
