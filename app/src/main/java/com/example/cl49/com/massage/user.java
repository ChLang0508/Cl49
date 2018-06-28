package com.example.cl49.com.massage;

public class user {
    public int _id;
    public String username;
    public String user_pass;
    public String sex;


    public user(){}
    public user(int _id,String username,String user_pass,String sex){
        this._id=_id;
        this.sex=sex;
        this.username=username;
        this.user_pass=user_pass;
    }
}
