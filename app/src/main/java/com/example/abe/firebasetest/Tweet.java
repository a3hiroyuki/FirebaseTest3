package com.example.abe.firebasetest;

/**
 * Created by 4925011 on 2017/03/31.
 */

public class Tweet {
    private String mName;
    private String mContents;

    public void setName(String name){
        mName = name;
    }

    public void setContetns(String contetns){
        mContents = contetns;
    }

    public String getName(){
        return mName;
    }

    public String getContents(){
        return mContents;
    }

}
