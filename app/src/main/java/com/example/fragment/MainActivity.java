package com.example.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Fragment fragment1, fragment2;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new FragmentOne();
        fragment2 = new FragmentTwo();

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, fragment1);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void change(View view) {
        Fragment fragment = null;

        switch (view.getId()) {
            case R.id.button:
                fragment = new FragmentOne();
                break;
            case R.id.button2:
                fragment = new FragmentTwo();
                break;
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment, fragment);
        ft.commit();
    }
}
