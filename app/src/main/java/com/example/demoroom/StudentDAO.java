package com.example.demoroom;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;


import java.util.List;

@Dao
public interface StudentDAO {

    @Query("Select * from student1")
    List<Student> getAll();

    @Insert
    void insertAll(Student...students);

    @Delete
    void delete(Student student);


}
