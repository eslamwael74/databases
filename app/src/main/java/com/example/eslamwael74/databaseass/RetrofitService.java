package com.example.eslamwael74.databaseass;


import java.util.ArrayList;

import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface RetrofitService {

    //Register API NUMBER 1
    @GET("mangers.php")
    Call<ArrayList<Employee>> managers();

    //Register API NUMBER 1
    @Multipart
    @POST("employee.php")
    Call<ArrayList<Employee>> emp(@Part("Ssn") RequestBody ssn);

    //Register API NUMBER 1
    @Multipart
    @POST("delete.php")
    Call<Employee> del(@Part("ssn") RequestBody ssn);

    //Register API NUMBER 1
    @Multipart
    @POST("insert.php")
    Call<ResponseBody> Insertemp(
            @Part("Fname") RequestBody fname,
            @Part("Minit") RequestBody minit,
            @Part("Lname") RequestBody Lname,
            @Part("Bdate") RequestBody Bdate,
            @Part("Address") RequestBody Address,
            @Part("Sex") RequestBody Sex,
            @Part("Salary") RequestBody Salary,
            @Part("Email") RequestBody email,
            @Part("Manger_ssn") RequestBody mangerssn);


}