package com.example.abe.firebasetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 4925011 on 2017/03/31.
 */

public class CustomListAdapter extends BaseAdapter {

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    ArrayList<Tweet> mTweetList = new ArrayList<Tweet>();

    public CustomListAdapter(Context context){
        mContext = context;
        mLayoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setTweetList(ArrayList<Tweet> tweetList) {
        mTweetList = tweetList;
    }

    @Override
    public int getCount() {
        return mTweetList.size();
    }

    @Override
    public Object getItem(int i) {
        return  mTweetList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view = mLayoutInflater.inflate(R.layout.tweet,parent,false);

        ((TextView)view.findViewById(R.id.name)).setText(mTweetList.get(position).getName());
        ((TextView)view.findViewById(R.id.tweet)).setText(mTweetList.get(position).getContents());

        return null;
    }
}
