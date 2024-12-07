package com.example.food__app;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class RecipeResponse {
    @SerializedName("recipes")
    private List<Recipe> recipes;

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public static class Recipe {
        @SerializedName("id")
        private String id;

        @SerializedName("title")
        private String title;

        @SerializedName("image")
        private String image;

        @SerializedName("summary")
        private String summary;

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getImage() {
            return image;
        }

        public String getSummary() {
            return summary;
        }
    }
}
