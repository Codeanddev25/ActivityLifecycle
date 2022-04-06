package com.gupta.activitylifecycle;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class sampleFragment_two extends Fragment {

    public static final String TAG = sampleFragment_two.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        Log.i(TAG, "in method onCreateView");
        return inflater.inflate(R.layout.fragment_sample_two,container,false);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        Log.i(TAG, "in method onAttach");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "in method onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "in method onViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStop() {
        Log.i(TAG, "in method onStop");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "in method onDestroy");
        super.onDestroy();
    }

    @Override
    public void onPause() {
        Log.i(TAG, "in method onPause");
        super.onPause();
    }

    @Override
    public void onResume() {
        Log.i(TAG, "in method onResume");
        super.onResume();
    }

    @Override
    public void onStart() {
        Log.i(TAG, "in method onStart");
        super.onStart();
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, "in method onDestroyView");
        super.onDestroyView();
    }
}

