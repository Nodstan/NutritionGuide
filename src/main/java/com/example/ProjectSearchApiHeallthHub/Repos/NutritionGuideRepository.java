package com.example.ProjectSearchApiHeallthHub.Repos;

import com.example.ProjectSearchApiHeallthHub.Model.NutritionGuide;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.List;

public interface NutritionGuideRepository extends MongoRepository<NutritionGuide, String> {
    Optional<NutritionGuide> findByConditionIgnoreCase(String condition);
    List<NutritionGuide> findByConditionContainingIgnoreCase(String keyword); // for fuzzy match
}
