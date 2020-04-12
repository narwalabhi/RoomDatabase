package com.abhisheknarwal.roomdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{
    private final LayoutInflater layoutInflater;
    private List<Person> personList;
    private Context context;
    public RecyclerAdapter( Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(view);
    }

    public void setPersonList(List<Person> personList){
        this.personList = personList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        if(personList != null) {
            Person person = personList.get(position);
            holder.tvPhno.append(person.getPhno().toString());
            holder.tvName.append(person.getName());
        }else{
            Toast.makeText(context, "No Person Found!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        if(personList != null){
            return personList.size();
        }else{
            return 0;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName, tvPhno;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPhno = itemView.findViewById(R.id.tvPhno);
        }
    }
}
