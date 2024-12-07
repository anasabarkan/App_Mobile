package com.example.food__app;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UnsplashApi {
    @GET("recipes/random")
    Call<RecipeResponse> getRandomRecipes(
            @Query("apiKey") String apiKey,
            @Query("number") int number,
            @Query("tags") String tags
    );
}
