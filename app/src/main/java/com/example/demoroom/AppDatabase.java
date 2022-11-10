package com.example.demoroom;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.security.PublicKey;

@Database(entities = {Student.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE="student1.db";
    private static AppDatabase intence;
    public static synchronized AppDatabase getInstance(Context context){
        if (intence==null) {
            intence= Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,DATABASE)
                    .allowMainThreadQueries().build();
        }
        return intence;
    }

    public abstract  StudentDAO studentDAO();

}
