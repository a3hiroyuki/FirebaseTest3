package com.example.abe.firebasetest;


import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.BaseAdapter;

/**
 * Created by 4925011 on 2017/03/31.
 */

public class TweetListFragment extends ListFragment {

    private CustomListAdapter mBaseAdapter;

    public TweetListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set adapter
        mBaseAdapter = new CustomListAdapter(getActivity());
        setListAdapter(mBaseAdapter);
    }





}
