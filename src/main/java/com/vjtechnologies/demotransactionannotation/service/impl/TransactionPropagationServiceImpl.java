package com.vjtechnologies.demotransactionannotation.service.impl;

import com.vjtechnologies.demotransactionannotation.model.Category;
import com.vjtechnologies.demotransactionannotation.repository.CategoryRepository;
import com.vjtechnologies.demotransactionannotation.service.CategoryService;
import com.vjtechnologies.demotransactionannotation.service.TransactionPropagationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionPropagationServiceImpl implements TransactionPropagationService {

  private final CategoryRepository categoryRepository;
  private final CategoryService categoryService;

  // Hàm saveWithPropagationRequired để chế độ Propagation.REQUIRED
  // * Nếu hàm propagationRequired để transaction thì hàm trên sẽ sử dụng transaction đã tạo
  // * Nếu hàm propagationRequired không để transaction thì hàm trên sẽ tạo mới transaction của
  // riêng nó
  @Transactional(propagation = Propagation.REQUIRED)
  public boolean propagationRequired() {
    Category category = new Category();
    category.setName("Propagation.REQUIRED");
    categoryService.saveWithPropagationRequired(category);
    //    categoryRepository.save(new Category()); // Hàm lỗi để thực hiện rollback
    return true;
  }

  // Hàm saveWithPropagationSupports để chế độ Propagation.SUPPORTS
  // * Nếu hàm propagationSupports để transaction thì hàm trên sẽ sử dụng transaction đã tạo
  // * Nếu hàm propagationSupports không để transaction thì hàm trên không có transaction
  @Transactional(propagation = Propagation.REQUIRED)
  public boolean propagationSupports() {
    Category category = new Category();
    category.setName("Propagation.SUPPORTS");
    categoryService.saveWithPropagationSupports(category);
    return true;
  }

  // Hàm saveWithPropagationNotSupported để chế độ Propagation.NOT_SUPPORTED
  // Nên hàm saveWithPropagationNotSupported không có transaction
  @Transactional(propagation = Propagation.REQUIRED)
  public boolean propagationNotSupported() {
    Category category = new Category();
    category.setName("Propagation.NOT_SUPPORTED");
    categoryService.saveWithPropagationNotSupported(category);
    return true;
  }

  // Hàm saveWithPropagationRequiresNew để chế độ Propagation.REQUIRES_NEW
  // Nên hàm trên luôn tạo mới transaction của riêng nó
  @Transactional(propagation = Propagation.REQUIRED)
  public boolean propagationRequiresNew() {
    Category category = new Category();
    category.setName("Propagation.REQUIRES_NEW");
    categoryService.saveWithPropagationRequiresNew(category);
    categoryRepository.save(new Category()); // Hàm lỗi để thực hiện rollback
    return true;
  }

  // Hàm saveWithPropagationNever để chế độ Propagation.NEVER
  // Nên hàm bên dưới không được để Propagation.REQUIRED
  @Transactional(propagation = Propagation.REQUIRED)
  public boolean propagationNever() {
    Category category = new Category();
    category.setName("Propagation.NEVER");
    categoryService.saveWithPropagationNever(category);
    return true;
  }

  // Hàm saveWithPropagationMandatory để chế độ Propagation.MANDATORY
  // Nên hàm bên dưới không để @Transactional
  //  @Transactional(propagation = Propagation.REQUIRED)
  public boolean propagationMandatory() {
    Category category = new Category();
    category.setName("Propagation.MANDATORY");
    categoryService.saveWithPropagationMandatory(category);
    return true;
  }
}
