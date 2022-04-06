package com.gupta.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    private Button btnAddFragment;
    private TextView fragmentCount;

    FragmentManager fragmentManager ;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "in method OnCreate");
        btnAddFragment = findViewById(R.id.buttonAddFragment);
        fragmentCount = findViewById(R.id.fragmentCounter);

        fragmentManager = getSupportFragmentManager();

        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                fragmentCount.setText(new StringBuilder().append("Fragment count in backstack is ").append(fragmentManager.getBackStackEntryCount()).toString());
            }
        });

        btnAddFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "in method onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "in method onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "in method onPause");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "in method onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "in method onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "in method onDestroy");

    }

    private void addFragment(){
        Fragment fragment;
        fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
        if (fragment instanceof sampleFragment)
            fragment = new sampleFragment_two();
        else if (fragment instanceof sampleFragment_two)
            fragment = new sampleFragment_three();
        else
            fragment = new sampleFragment();

        /*switch(fragmentManager.getBackStackEntryCount()%3){
            case 0 : fragment = new sampleFragment(); break;
            case 1 : fragment = new sampleFragment_two(); break;
            case 2 : fragment = new sampleFragment_three(); break;
            default : fragment = new sampleFragment(); break;
        }*/

        fragmentTransaction  = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, fragment, "demoFragment");
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
        if (fragment != null) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragment);
            fragmentTransaction.commit();
        }else {
            super.onBackPressed();
        }
    }
}