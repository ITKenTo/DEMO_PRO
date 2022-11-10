package com.example.demoroom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student1")
public class Student {
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name= "name")
    String name;
    @ColumnInfo(name= "addres")
    String addres;

    public Student(int id, String name, String addres) {
        this.id = id;
        this.name = name;
        this.addres = addres;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }
}
