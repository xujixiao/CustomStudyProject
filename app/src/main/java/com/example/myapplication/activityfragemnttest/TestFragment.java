package com.example.myapplication.activityfragemnttest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.testdata.ThirdActivity;

/**
 * create by xujixiao on 2019-09-10 14:45
 */
public class TestFragment extends Fragment {
    public static TestFragment newInstance() {

        Bundle args = new Bundle();

        TestFragment fragment = new TestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_first_layout, null);
        view.findViewById(R.id.tv_test_first).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), ThirdActivity.class);
                        startActivityForResult(intent, 10);
                    }
                }
        );
        return view;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("xujixiao", "TestFragment---requestCode---" + requestCode + "---resultCode--" + resultCode + "----data---" + data.getStringExtra("data"));
    }

}
