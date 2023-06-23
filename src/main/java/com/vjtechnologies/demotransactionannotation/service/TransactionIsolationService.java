package com.vjtechnologies.demotransactionannotation.service;

import com.vjtechnologies.demotransactionannotation.model.Category;
import java.util.List;
import java.util.Map;

public interface TransactionIsolationService {
  Map<String, List<Category>> getRepeatableRead() throws InterruptedException;
  Map<String, List<Category>> getSerializable() throws InterruptedException;
}
