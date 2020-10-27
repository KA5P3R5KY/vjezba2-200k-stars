package com.example.vjezba2;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private GithubApi githubApi;
    final ArrayList<MyData> myDataset = new ArrayList<MyData>();
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createGithubAPI();
        githubApi.getRepositories().enqueue(repositoriesCallback);

        RecyclerView recyclerView = findViewById(R.id.recView);
        recyclerView.setHasFixedSize(true);

        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MyAdapter(myDataset);
        recyclerView.setAdapter(adapter);

    }

    Callback<GithubRepositoryResponse> repositoriesCallback = new Callback<GithubRepositoryResponse>() {
        @Override
        public void onResponse(Call<GithubRepositoryResponse> call, Response<GithubRepositoryResponse> response) {

            if (response.isSuccessful()) {
                GithubRepositoryResponse repositories = response.body();
                 for (Item repository : repositories.items)
                {
                     // -- avatar --
                     String avatarUrl = repository.owner.avatar_url;
                     // -- naziv repositorija --
                     String repositoryName = repository.name;
                     // -- broj zvjezdica --
                     int stars =  repository.stargazers_count;

                     MyData myDataset1 = new MyData(avatarUrl, repositoryName, stars);
                     myDataset.add(myDataset1);
                }
                adapter.notifyDataSetChanged();
            } else {
                Log.d("repositoriesCallback", "Code: " + response.code() + " Message: " + response.message());
            }
        }

        @Override
        public void onFailure(Call<GithubRepositoryResponse> call, Throwable t) {
            t.printStackTrace();
            Log.d("ccc", "ccc: Message: ");
        }
    };

    private void createGithubAPI() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GithubApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        githubApi = retrofit.create(GithubApi.class);
    }
}