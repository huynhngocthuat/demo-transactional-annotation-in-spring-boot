package com.vjtechnologies.demotransactionannotation.controller;

import com.vjtechnologies.demotransactionannotation.model.Category;
import com.vjtechnologies.demotransactionannotation.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/categories")
public class CategoryController {
  private final CategoryService categoryService;

  @PostMapping()
  public ResponseEntity<?> create(@RequestBody Category category) {
    return ResponseEntity.ok(categoryService.save(category));
  }

  @PutMapping()
  public ResponseEntity<?> update(@RequestBody Category category) {
    return ResponseEntity.ok(categoryService.save(category));
  }

  @GetMapping()
  public ResponseEntity<?> findAll() {
    return ResponseEntity.ok(categoryService.findAll());
  }
}
