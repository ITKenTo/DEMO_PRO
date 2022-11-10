package com.example.demoroom;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.viewholder>{
    List<Student> list;
    Context context;

    public void setDAta(List<Student> list1, Context context) {
        this.list=list1;
        this.context=context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        Student student=list.get(position);
        holder.tv_id.setText(student.getId()+"");
        holder.tv_name.setText(student.getName());
        holder.tv_adress.setText(student.getAddres());
        holder.img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student1= list.get(position);
                AppDatabase.getInstance(context).studentDAO().delete(student1);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewholder extends RecyclerView.ViewHolder {
        TextView tv_id;
        TextView tv_name;
        TextView tv_adress;
        ImageView img_delete;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            tv_id=itemView.findViewById(R.id.tv_id);
            tv_name=itemView.findViewById(R.id.tv_name);
            tv_adress=itemView.findViewById(R.id.tv_adress);
            img_delete=itemView.findViewById(R.id.img_delete);
        }
    }
}
