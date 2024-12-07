package com.example.food__app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UnsplashFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecipeRecyclerAdapter adapter;
    private List<RecipeResponse.Recipe> recipeList;

    public UnsplashFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recipeList = new ArrayList<>();
        adapter = new RecipeRecyclerAdapter(getContext(), recipeList);
        recyclerView.setAdapter(adapter);
        fetchRandomRecipes("dessert", 10); // Example query and number of recipes
    }

    private void fetchRandomRecipes(String tags, int number) {
        UnsplashApi unsplashApi = RetrofitClient.getRetrofitInstance().create(UnsplashApi.class);
        unsplashApi.getRandomRecipes("e261aae914d643e78ba86e37f30526c9", number, tags).enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    recipeList.addAll(response.body().getRecipes());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {
                // Handle failure
            }
        });
    }
}
