package com.vjtechnologies.demotransactionannotation.model;

import java.util.UUID;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  private String name;
}
