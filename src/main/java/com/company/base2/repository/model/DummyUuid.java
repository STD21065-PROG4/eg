package com.company.base2.repository.model;

import com.company.base2.PojaGenerated;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@PojaGenerated
@SuppressWarnings("all")
@Entity
@Getter
@Setter
public class DummyUuid {
  @Id private String id;
}
