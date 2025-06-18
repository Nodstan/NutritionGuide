package com.example.ProjectSearchApiHeallthHub.Controller;

import com.example.ProjectSearchApiHeallthHub.Model.NutritionGuide;
import com.example.ProjectSearchApiHeallthHub.Repos.NutritionGuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/nutrition")
@CrossOrigin
public class NutritionGuideController {

    @Autowired
    private NutritionGuideRepository nutritionRepo;

    // ✅ POST /nutrition – Admin adds guide
    @PostMapping
    public ResponseEntity<NutritionGuide> addGuide(@RequestBody NutritionGuide guide) {
        NutritionGuide saved = nutritionRepo.save(guide);
        return ResponseEntity.ok(saved);
    }

    // ✅ GET /nutrition/{condition} – Get specific guide
    @GetMapping("/{condition}")
    public ResponseEntity<NutritionGuide> getByCondition(@PathVariable String condition) {
        Optional<NutritionGuide> guide = nutritionRepo.findByConditionIgnoreCase(condition);
        return guide.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ Optional fuzzy search
    @GetMapping("/search")
    public ResponseEntity<List<NutritionGuide>> searchByCondition(@RequestParam("q") String keyword) {
        if (keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        List<NutritionGuide> results = nutritionRepo.findByConditionContainingIgnoreCase(keyword);
        if (results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(results);
    }

    // Optional: List all
    @GetMapping("/all")
    public List<NutritionGuide> getAll() {
        return nutritionRepo.findAll();
    }
}
