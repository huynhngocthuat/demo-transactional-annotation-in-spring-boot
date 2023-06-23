package com.vjtechnologies.demotransactionannotation.repository;

import com.vjtechnologies.demotransactionannotation.model.Category;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {}
