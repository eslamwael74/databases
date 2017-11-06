package com.example.eslamwael74.databaseass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by eslamwael74 on 06/11/17.
 */

public class ManagerAdapter extends RecyclerView.Adapter<ManagerAdapter.MyViewHolder> {

    ArrayList<Employee> employees;
    FragmentActivity fragmentActivity;

    public ManagerAdapter(ArrayList<Employee> employees, FragmentActivity fragmentActivity) {
        this.employees = employees;
        this.fragmentActivity = fragmentActivity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(fragmentActivity)
                .inflate(R.layout.item1, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.fName.setText(employees.get(position).getfName());
        holder.lName.setText(employees.get(position).getlName());
        holder.minit.setText(employees.get(position).getMinit());
        holder.bdate.setText(employees.get(position).getbDate());
        holder.address.setText(employees.get(position).getAddress());
        holder.sex.setText(employees.get(position).getSex());
        holder.salry.setText(employees.get(position).getSalary());
        holder.email.setText(employees.get(position).getEmail());

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(fragmentActivity,EmpActivity.class);
                intent.putExtra("ssn",employees.get(position).getSsn());
                fragmentActivity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.fname)
        TextView fName;

        @BindView(R.id.lname)
        TextView lName;

        @BindView(R.id.minit)
        TextView minit;

        @BindView(R.id.bdate)
        TextView bdate;

        @BindView(R.id.address)
        TextView address;

        @BindView(R.id.sex)
        TextView sex;

        @BindView(R.id.salary)
        TextView salry;

        @BindView(R.id.email)
        TextView email;

        @BindView(R.id.card)
        CardView card;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }

}
