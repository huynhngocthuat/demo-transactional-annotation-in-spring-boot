package com.vjtechnologies.demotransactionannotation.service.impl;

import com.vjtechnologies.demotransactionannotation.model.Category;
import com.vjtechnologies.demotransactionannotation.repository.CategoryRepository;
import com.vjtechnologies.demotransactionannotation.service.TransactionIsolationService;
import java.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionIsolationServiceImpl implements TransactionIsolationService {

  // Ví dụ tạo mới 1 transaction
  //  BEGIN TRANSACTION;
  //  SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
  //  SELECT * ....
  //  COMMIT;


  private final CategoryRepository categoryRepository;

  // isolation = Isolation.REPEATABLE_READ
  // Kiểm tra dữ liệu giữa 2 lần lấy dữ liệu trong cùng 1 transaction (Function)
  // Thực hiện update 1 record bất kỳ giữa 2 lần get data
  // Kết quả:
  //     * Nếu không dùng Isolation.REPEATABLE_READ thì sẽ cho ra  kết quả khác nhau
  //     * Nếu dùng Isolation.REPEATABLE_READ thì sẽ cho ra  kết quả giống nhau
  //     Note: Mặc định không dùng vấn cho ra kết quả giống nhau
  @Override
  @Transactional(isolation = Isolation.REPEATABLE_READ)
  public Map<String, List<Category>> getRepeatableRead() throws InterruptedException {
    Map<String, List<Category>> response = new HashMap<>();
    response.put("Lấy dữ liệu lần 1", categoryRepository.findAll());
    Thread.sleep(5000); // Thực hiện update 1 record category - call {{local}}/categories PUT
    response.put("Lấy dữ liệu lần 2", categoryRepository.findAll());
    return response;
  }


  // isolation = Isolation.SERIALIZABLE
  // So sánh dữ liệu giữa 2 lần lấy dữ liệu trong cùng 1 transaction
  // Thực hiện tạo mới category giữa 2 lần get data (findAll)
  // Kết quả:
  //     * Nếu không dùng Isolation.SERIALIZABLE thì sẽ cho ra  kết quả khác nhau
  //     * Nếu dùng Isolation.SERIALIZABLE thì sẽ cho ra  kết quả giống nhau
  @Override
  @Transactional(isolation = Isolation.SERIALIZABLE)
  public Map<String, List<Category>> getSerializable() throws InterruptedException {
    Map<String, List<Category>> response = new HashMap<>();
    response.put("Lấy dữ liệu lần 1", categoryRepository.findAll());
    Thread.sleep(5000); // Thực hiện tạo mới hoặc xoá 1 category - call {{local}}/categories POST
    response.put("Lấy dữ liệu lần 2", categoryRepository.findAll());
    return response;
  }
}
