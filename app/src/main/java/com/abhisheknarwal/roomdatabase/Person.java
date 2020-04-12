package com.abhisheknarwal.roomdatabase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "person_table")
public class Person {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    @ColumnInfo(name = "name_column")
    private String name;

    @NonNull
    @ColumnInfo(name = "Phno")
    private Long phno;

    @NonNull
    public String getName() {
        return name;
    }

    public Person(@NonNull String name,@NonNull Long phno) {
        this.name = name;
        this.phno = phno;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public Long getPhno() {
        return phno;
    }

    public void setPhno(long phno) {
        this.phno = phno;
    }
}

