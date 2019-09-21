package com.duykhanh.intrologin.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.duykhanh.intrologin.R;
import com.duykhanh.intrologin.model.Course;

/**
 * A simple {@link Fragment} subclass.
 */
public class CourseFragment extends Fragment implements View.OnClickListener {


    private int position;
    private static OnSkipNextListener mCallback;

    public CourseFragment() {
        // Required empty public constructor
    }

    public static CourseFragment newInstance(OnSkipNextListener callback) {
        CourseFragment courseFragment = new CourseFragment();
        mCallback = callback;
        return courseFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_course, container, false);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        TextView tvDescription = view.findViewById(R.id.tv_description);
        ImageView imageView = view.findViewById(R.id.iv_background);

        View indicator1 = view.findViewById(R.id.indicator1);
        View indicator2 = view.findViewById(R.id.indicator2);
        View indicator3 = view.findViewById(R.id.indicator3);

        TextView tvSkip = view.findViewById(R.id.tv_skip);
        TextView tvNext = view.findViewById(R.id.tv_next);

        tvSkip.setOnClickListener(this);
        tvNext.setOnClickListener(this);

        Bundle bundle = getArguments();
        if (bundle != null) {
            position = bundle.getInt("position");
            Log.d("CourseFragment", "position: " + position);
            Course course = (Course) bundle.getSerializable("course");
            tvTitle.setText(course.getTitle());
            tvDescription.setText(course.getDescription());
            imageView.setImageResource(course.getIdImage());

            switch (position) {
                case 0:
                    indicator1.setBackgroundResource(R.drawable.bg_indicator_active);
                    indicator2.setBackgroundResource(R.drawable.bg_indicator_inactive);
                    indicator3.setBackgroundResource(R.drawable.bg_indicator_inactive);
                    break;
                case 1:
                    indicator1.setBackgroundResource(R.drawable.bg_indicator_inactive);
                    indicator2.setBackgroundResource(R.drawable.bg_indicator_active);
                    indicator3.setBackgroundResource(R.drawable.bg_indicator_inactive);
                    break;
                case 2:
                    indicator1.setBackgroundResource(R.drawable.bg_indicator_inactive);
                    indicator2.setBackgroundResource(R.drawable.bg_indicator_inactive);
                    indicator3.setBackgroundResource(R.drawable.bg_indicator_active);
                    break;
            }
        } else {
            Log.e("error", "onCreateView: ");
        }
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_skip:
                mCallback.onClickSkip();
                break;
            case R.id.tv_next:
                mCallback.onClickNext(position);
                break;
        }
    }
}
