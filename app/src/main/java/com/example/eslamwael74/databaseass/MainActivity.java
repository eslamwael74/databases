package com.example.eslamwael74.databaseass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<Employee> employees;



    @BindView(R.id.recylerview)
    RecyclerView recylerview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getData();

    }

    void getData(){

        RetrofitWebService.getService().managers().enqueue(new Callback<ArrayList<Employee>>() {
            @Override
            public void onResponse(Call<ArrayList<Employee>> call, Response<ArrayList<Employee>> response) {
                setAdapter(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Employee>> call, Throwable t) {

            }
        });



    }


    public void setAdapter(ArrayList<Employee> employees){

        ManagerAdapter managerAdapter= new ManagerAdapter(employees,this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recylerview.setLayoutManager(manager);
        recylerview.setAdapter(managerAdapter);


    }

}
