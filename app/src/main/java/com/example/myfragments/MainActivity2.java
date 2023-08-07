package com.example.myfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.myfragments.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    binding = ActivityMain2Binding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());

    binding.bottomNavigationView.setOnItemSelectedListener(item ->{
        switch (item.getItemId()){

            case (R.id.home):
                replaceFragment(new HomeFragment());
                break;
            case (R.id.settings):
                replaceFragment(new SettingsFragment());
                break;
            case (R.id.account):

                replaceFragment(new AccountFragment());
                break;
        }
        return true;
    });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager= getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.framelayout, fragment);

        fragmentTransaction.commit();
    }

}