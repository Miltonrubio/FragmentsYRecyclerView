package com.example.myfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);


        String imageName = "b"; // Nombre de la imagen sin extensión
        int resID = getResources().getIdentifier(imageName, "drawable", getPackageName());


        List<Item> items = new ArrayList<Item>();

        items.add(new Item("Milton", "a@gmail.com", resID ));

        items.add(new Item("Hilario", "b@gmail.com", R.drawable.b));

        items.add(new Item("Juan", "c@gmail.com", R.drawable.c));

        items.add(new Item("Pepe", "d@gmail.com", R.drawable.d));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items));

    }


    public void nuevo(View view) {
        {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        }


    }
}