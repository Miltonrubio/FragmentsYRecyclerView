package com.example.myfragments;

import static com.example.myfragments.ItemApi.parseJsonResponse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.android.volley.AuthFailureError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.TimeoutError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class ActivityApi extends AppCompatActivity {



    private RequestQueue queue;
    private String url = "https://pokeapi.co/api/v2/pokemon?offset=1&limit=25";

    private
    int valor1 = 120;
    int valor2 = 13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        queue = Volley.newRequestQueue(this);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        JSONArray resultsArray = response.getJSONArray("results");

                        List<ItemApi> itemList = ItemApi.parseJsonResponse(resultsArray);

                        RecyclerView recyclerView = findViewById(R.id.recyclerviewcoches);
                        recyclerView.setLayoutManager(new LinearLayoutManager(ActivityApi.this));
                        recyclerView.setAdapter(new ItemAdapter(itemList));

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(ActivityApi.this, "Error al procesar JSON", Toast.LENGTH_SHORT).show();
                    }
                },
                error -> {
                    String errorMessage = "Error al obtener los datos";

                    if (error instanceof TimeoutError) {
                        errorMessage = "Tiempo de espera agotado";
                    } else if (error instanceof AuthFailureError) {
                        errorMessage = "Error de autenticación";
                    } else if (error.networkResponse != null) {
                        errorMessage = "Código de error: " + error.networkResponse.statusCode;
                    }

                    Toast.makeText(ActivityApi.this, errorMessage, Toast.LENGTH_SHORT).show();
                });

        queue.add(request);
    }



}