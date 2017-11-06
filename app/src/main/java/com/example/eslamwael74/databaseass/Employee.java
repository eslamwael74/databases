package com.example.eslamwael74.databaseass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by eslamwael74 on 06/11/17.
 */

public class Employee {

    @SerializedName("Fname")
    @Expose
    String fName;

    @SerializedName("Minit")
    @Expose
    String minit;

    @SerializedName("Lname")
    @Expose
    String lName;


    @SerializedName("Bdate")
    @Expose
    String bDate;


    @SerializedName("Address")
    @Expose
    String address;


    @SerializedName("Sex")
    @Expose
    String sex;

    @SerializedName("Salary")
    @Expose
    String salary;

    @SerializedName("Email")
    @Expose
    String email;

    @SerializedName("Ssn")
    @Expose
    String ssn;

    public Employee(String fName, String minit, String lName, String bDate, String address, String sex, String salary, String email) {
        this.fName = fName;
        this.minit = minit;
        this.lName = lName;
        this.bDate = bDate;
        this.address = address;
        this.sex = sex;
        this.salary = salary;
        this.email = email;
    }

    public String getSsn() {
        return ssn;
    }

    public String getfName() {
        return fName;
    }

    public String getMinit() {
        return minit;
    }

    public String getlName() {
        return lName;
    }

    public String getbDate() {
        return bDate;
    }

    public String getAddress() {
        return address;
    }

    public String getSex() {
        return sex;
    }

    public String getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }
}
