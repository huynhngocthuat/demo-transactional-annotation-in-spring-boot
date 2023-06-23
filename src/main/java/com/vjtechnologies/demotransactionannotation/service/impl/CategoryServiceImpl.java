package com.vjtechnologies.demotransactionannotation.service.impl;

import com.vjtechnologies.demotransactionannotation.model.Category;
import com.vjtechnologies.demotransactionannotation.repository.CategoryRepository;
import com.vjtechnologies.demotransactionannotation.service.CategoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
  private final CategoryRepository categoryRepository;

  @Override
  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

  @Override
  public Category save(Category category) {
    return categoryRepository.save(category);
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public void saveWithPropagationRequired(Category category) {
    categoryRepository.save(category);
    categoryRepository.save(new Category()); // Hàm lỗi để thực hiện rollback
  }

  @Override
  @Transactional(propagation = Propagation.SUPPORTS)
  public void saveWithPropagationSupports(Category category) {
    categoryRepository.save(category);
    categoryRepository.save(new Category()); // Hàm lỗi để thực hiện rollback
  }

  @Override
  @Transactional(propagation = Propagation.NOT_SUPPORTED)
  public void saveWithPropagationNotSupported(Category category) {
    categoryRepository.save(category);
    categoryRepository.save(new Category()); // Hàm lỗi để thực hiện rollback
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void saveWithPropagationRequiresNew(Category category) {
    categoryRepository.save(category);
  }

  @Override
  @Transactional(propagation = Propagation.NEVER)
  public void saveWithPropagationNever(Category category) {
    categoryRepository.save(category);
  }

  @Override
  @Transactional(propagation = Propagation.MANDATORY)
  public void saveWithPropagationMandatory(Category category) {
    categoryRepository.save(category);
  }
}
