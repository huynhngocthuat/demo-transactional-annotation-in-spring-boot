package com.vjtechnologies.demotransactionannotation.service;

import com.vjtechnologies.demotransactionannotation.model.Category;
import java.util.List;

public interface CategoryService {
  List<Category> findAll();

  Category save(Category category);

  void saveWithPropagationRequired(Category category);

  void saveWithPropagationSupports(Category category);

  void saveWithPropagationNotSupported(Category category);

  void saveWithPropagationRequiresNew(Category category);

  void saveWithPropagationNever(Category category);

  void saveWithPropagationMandatory(Category category);
}
