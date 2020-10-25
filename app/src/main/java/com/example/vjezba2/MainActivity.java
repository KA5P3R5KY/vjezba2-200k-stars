package com.example.vjezba2;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recView);
        recyclerView.setHasFixedSize(true);

        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MyData myDataset1 = new MyData("avatar1.png", "Repo1", "250000");
        MyData myDataset2 = new MyData("avatar2.png", "Repo2", "350000");
        MyData myDataset3 = new MyData("avatar3.png", "Repo3", "150000");
        MyData myDataset4 = new MyData("avatar4.png", "Repo4", "222000");
        MyData myDataset5 = new MyData("avatar5.png", "Repo5", "279000");
        MyData myDataset6 = new MyData("avatar6.png", "Repo6", "124000");
        final ArrayList<MyData> myDataset = new ArrayList<MyData>();
        myDataset.add(myDataset1);
        myDataset.add(myDataset2);
        myDataset.add(myDataset3);
        myDataset.add(myDataset4);
        myDataset.add(myDataset5);
        myDataset.add(myDataset6);



        final RecyclerView.Adapter adapter = new MyAdapter(myDataset);
        recyclerView.setAdapter(adapter);

        /*String url = "https://run.mocky.io/v3/b4974fe8-60f4-4b51-9431-14d4b21e80dc";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                try {
                    JSONArray jsonArray = response.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        MyData myData = gson.fromJson(String.valueOf(jsonObject), MyData.class);
                        myDataset.add(myData);


                    }
                    Log.d("jeee", "evo");
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d("jeee", "lose");
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.d("jeee", error.getMessage());

            }
        }
        );


        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(jsonObjectRequest);
        */
    }
}