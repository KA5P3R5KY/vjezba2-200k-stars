package com.example.vjezba2;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

        ImageView imageView = new ImageView(this);
        //imageView.setImageResource(R.drawable.avatar1);
        ImageView imageView2 = new ImageView(this);
        imageView2.setImageResource(R.drawable.avatar2);
        ImageView imageView3 = new ImageView(this);
        imageView3.setImageResource(R.drawable.avatar3);

        Glide.with(this)
                .load("https://images.fineartamerica.com/images/artworkimages/mediumlarge/3/prison-mike-zapista-ou.jpg") // image url
                .into(imageView);  // imageview object

        MyData myDataset1 = new MyData(imageView, "Repo1", "250000");
        MyData myDataset2 = new MyData(imageView2, "Repo2", "350000");
        MyData myDataset3 = new MyData(imageView3, "Repo3", "150000");
        MyData myDataset4 = new MyData(imageView, "Repo4", "222000");
        MyData myDataset5 = new MyData(imageView3, "Repo5", "279000");
        MyData myDataset6 = new MyData(imageView2, "Repo6", "124000");
        final ArrayList<MyData> myDataset = new ArrayList<MyData>();
        myDataset.add(myDataset1);
        myDataset.add(myDataset2);
        myDataset.add(myDataset3);
        myDataset.add(myDataset4);
        myDataset.add(myDataset5);
        myDataset.add(myDataset6);


        final RecyclerView.Adapter adapter = new MyAdapter(myDataset);
        recyclerView.setAdapter(adapter);


    }
}