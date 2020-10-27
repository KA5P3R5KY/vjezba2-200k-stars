package com.example.vjezba2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubApi {
	String BASE_URL = "https://api.github.com";

	@GET("/search/repositories?q=stars:\">100000\"")
	Call<GithubRepositoryResponse> getRepositories();
}
