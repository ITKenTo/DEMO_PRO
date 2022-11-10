package com.example.demoroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText ed_id,ed_name,ed_adress;
    Button btn_add;
    RecyclerView recyclerView;

    Adapter adapter;
    List<Student>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_name=findViewById(R.id.ed_name);
        ed_adress=findViewById(R.id.ed_adress);
        btn_add=findViewById(R.id.button);
        recyclerView=findViewById(R.id.recy);
        list=AppDatabase.getInstance(this).studentDAO().getAll();
        adapter=new Adapter();
        list=new ArrayList<>();
        adapter.setDAta(list,this);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        btn_add.setOnClickListener(button->{
         add();
        });


    }
    public void add(){
        String name=ed_name.getText().toString().trim();
        String adress=ed_adress.getText().toString().trim();
        Student student=new Student();
        student.name=name;
        student.addres=adress;
        AppDatabase.getInstance(this).studentDAO().insertAll(student);
        Toast.makeText(this, "Thành Công", Toast.LENGTH_SHORT).show();
        ed_name.setText("");
        ed_adress.setText("");

         list=AppDatabase.getInstance(this).studentDAO().getAll();
         adapter.setDAta(list,this);
    }
}