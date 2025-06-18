package com.example.ProjectSearchApiHeallthHub.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "NutritionGuides")
public class NutritionGuide {

    @Id
    private String id;

    private String condition;
    private List<String> recommendedFoods;
    private List<String> foodsToAvoid;

    public NutritionGuide() {}

    public NutritionGuide(String condition, List<String> recommendedFoods, List<String> foodsToAvoid) {
        this.condition = condition;
        this.recommendedFoods = recommendedFoods;
        this.foodsToAvoid = foodsToAvoid;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    public List<String> getRecommendedFoods() { return recommendedFoods; }
    public void setRecommendedFoods(List<String> recommendedFoods) { this.recommendedFoods = recommendedFoods; }

    public List<String> getFoodsToAvoid() { return foodsToAvoid; }
    public void setFoodsToAvoid(List<String> foodsToAvoid) { this.foodsToAvoid = foodsToAvoid; }
}
