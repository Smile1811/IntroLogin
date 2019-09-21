package com.duykhanh.intrologin.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.duykhanh.intrologin.R;
import com.duykhanh.intrologin.adapter.IntroAdapter;
import com.duykhanh.intrologin.model.Course;
import com.duykhanh.intrologin.view.login.LoginRegisterFragment;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements OnSkipNextListener, View.OnClickListener {

    private ViewPager viewPager;
    private static OnSkipNextListener callback;
    private int currentPage = 0;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        viewPager = view.findViewById(R.id.viewPager);

        callback = this;

        CourseFragment javaFragment = CourseFragment.newInstance(callback);
        CourseFragment androidFragment = CourseFragment.newInstance(callback);
        CourseFragment iosFragment = CourseFragment.newInstance(callback);
        LoginRegisterFragment loginRegisterFragment = LoginRegisterFragment.newInstance();

        ArrayList fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(javaFragment);
        fragmentArrayList.add(androidFragment);
        fragmentArrayList.add(iosFragment);
        fragmentArrayList.add(loginRegisterFragment);

        ArrayList<Course> listCourses = new ArrayList<>();
        Course javaCourse = new Course(getString(R.string.java_title), getString(R.string.java_description), R.drawable.fish);
        Course androidCourse = new Course(getString(R.string.java_title).replace("Java", "Android"), getString(R.string.java_description).replace("Java", "Android"), R.drawable.car);
        Course iosCourse = new Course(getString(R.string.java_title).replace("Java", "Ios"), getString(R.string.java_description).replace("Java", "Ios"), R.drawable.cat);

        listCourses.add(javaCourse);
        listCourses.add(androidCourse);
        listCourses.add(iosCourse);

        IntroAdapter adapter = new IntroAdapter(getFragmentManager(), fragmentArrayList, listCourses);
        viewPager.setAdapter(adapter);

        final View indicator1 = view.findViewById(R.id.indicator1);
        final View indicator2 = view.findViewById(R.id.indicator2);
        final View indicator3 = view.findViewById(R.id.indicator3);

        TextView tvSkip = view.findViewById(R.id.tv_skip);
        TextView tvNext = view.findViewById(R.id.tv_next);

        final RelativeLayout relativeLayout = view.findViewById(R.id.rl_bottom);

        tvSkip.setOnClickListener(this);
        tvNext.setOnClickListener(this);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        relativeLayout.setVisibility(View.VISIBLE);
                        indicator1.setBackgroundResource(R.drawable.bg_indicator_active);
                        indicator2.setBackgroundResource(R.drawable.bg_indicator_inactive);
                        indicator3.setBackgroundResource(R.drawable.bg_indicator_inactive);
                        break;
                    case 1:
                        relativeLayout.setVisibility(View.VISIBLE);
                        indicator1.setBackgroundResource(R.drawable.bg_indicator_inactive);
                        indicator2.setBackgroundResource(R.drawable.bg_indicator_active);
                        indicator3.setBackgroundResource(R.drawable.bg_indicator_inactive);
                        break;
                    case 2:
                        relativeLayout.setVisibility(View.VISIBLE);
                        indicator1.setBackgroundResource(R.drawable.bg_indicator_inactive);
                        indicator2.setBackgroundResource(R.drawable.bg_indicator_inactive);
                        indicator3.setBackgroundResource(R.drawable.bg_indicator_active);
                        break;
                    case 3:
                        relativeLayout.setVisibility(View.GONE);
                        break;
                }
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }

    @Override
    public void onClickSkip() {
//        viewPager.setCurrentItem(4, true);
    }

    @Override
    public void onClickNext(int currentPage) {
//        viewPager.setCurrentItem(currentPage + 1);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_skip:
                viewPager.setCurrentItem(4, true);
                break;
            case R.id.tv_next:
                viewPager.setCurrentItem(currentPage + 1);
                break;
        }
    }
}
