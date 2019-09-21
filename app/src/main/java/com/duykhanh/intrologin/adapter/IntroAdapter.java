package com.duykhanh.intrologin.adapter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.duykhanh.intrologin.model.Course;

import java.util.ArrayList;

public class IntroAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> mListFragment;
    private ArrayList<Course> mCourseList;

    public IntroAdapter(FragmentManager fm,ArrayList<Fragment> ListFragment,ArrayList<Course> courses) {
        super(fm);
        this.mListFragment = ListFragment;
        this.mCourseList = courses;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = mListFragment.get(position);
        if(position < mListFragment.size() -1) {
            Bundle bundle = new Bundle();
            bundle.putInt("position", position);
            // put 1 object
            bundle.putSerializable("course", mCourseList.get(position));
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mListFragment.size();
    }
}
