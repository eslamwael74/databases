package com.example.eslamwael74.databaseass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by eslamwael74 on 06/11/17.
 */

public class EmpActivity extends AppCompatActivity {

    int f;

    @BindView(R.id.recylerview)
    RecyclerView recylerview;

    @BindView(R.id.lin)
    LinearLayout lin;


    @BindView(R.id.fname)
    EditText sfname;

    @BindView(R.id.lastname)
    EditText lname;

    @BindView(R.id.minit)
    EditText minit;

    @BindView(R.id.Bdate)
    EditText Bdate;


    @BindView(R.id.address)
    EditText address;


    @BindView(R.id.sex)
    EditText sex;

    @BindView(R.id.salary)
    EditText salary;


    @BindView(R.id.email)
    EditText email;

    @BindView(R.id.btn1)
    Button btn1;

    @BindView(R.id.btn2)
    Button btn2;

    @OnClick(R.id.btn1)
    void click() {
        insert();
        lin.setVisibility(View.GONE);
        btn2.setText("Show");
        f = 0;
    }
    @OnClick(R.id.btn2)
    void click2() {

        if (f == 0){
            lin.setVisibility(View.VISIBLE);
            btn2.setText("Hide");
            f = 1;
        }
        else{
            lin.setVisibility(View.GONE);
            btn2.setText("Show");
            f = 0;
        }

    }

    String ssn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp);
        ButterKnife.bind(this);

        ssn = getIntent().getStringExtra("ssn");


        getData();


    }
    void insert(){

        RequestBody fname = RequestBody.create(MediaType.parse("text/plain"),sfname.getText().toString());
        RequestBody lName = RequestBody.create(MediaType.parse("text/plain"),lname.getText().toString());
        RequestBody lMinit = RequestBody.create(MediaType.parse("text/plain"),minit.getText().toString());
        RequestBody lBDate = RequestBody.create(MediaType.parse("text/plain"),Bdate.getText().toString());
        RequestBody lAdd = RequestBody.create(MediaType.parse("text/plain"),address.getText().toString());
        RequestBody lSex = RequestBody.create(MediaType.parse("text/plain"),sex.getText().toString());
        RequestBody lSalary = RequestBody.create(MediaType.parse("text/plain"),salary.getText().toString());
        RequestBody lEmail = RequestBody.create(MediaType.parse("text/plain"),email.getText().toString());
        RequestBody lSSN = RequestBody.create(MediaType.parse("text/plain"),ssn);


        RetrofitWebService.getService().Insertemp(fname,lMinit,lName,lBDate,lAdd,lSex,lSalary,lEmail,lSSN).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(EmpActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                getData();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void setAdapter(ArrayList<Employee> employees) {

        ManagerAdapter managerAdapter = new ManagerAdapter(employees, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recylerview.setLayoutManager(manager);
        recylerview.setAdapter(managerAdapter);


    }

    void getData() {

        RequestBody Rssn = RequestBody.create(MediaType.parse("text/plain"), ssn);

        RetrofitWebService.getService().emp(Rssn).enqueue(new Callback<ArrayList<Employee>>() {
            @Override
            public void onResponse(Call<ArrayList<Employee>> call, Response<ArrayList<Employee>> response) {
                setAdapter(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Employee>> call, Throwable t) {

            }
        });


    }


}
