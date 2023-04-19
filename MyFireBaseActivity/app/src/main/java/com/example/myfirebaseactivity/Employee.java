package com.example.myfirebaseactivity;

public class Employee {
    private String lastName, firstName;
    Employee(){
        this.lastName="";
        this.firstName="";
    }
    Employee(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getlastName(){
        return this.lastName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

}
