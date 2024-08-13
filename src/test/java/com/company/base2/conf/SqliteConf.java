package com.company.base2.conf;

import com.company.base2.PojaGenerated;
import org.springframework.test.context.DynamicPropertyRegistry;

@PojaGenerated
@SuppressWarnings("all")
public class SqliteConf {

  void configureProperties(DynamicPropertyRegistry registry) {
    registry.add("driverClassName", () -> "org.sqlite.JDBC");
    registry.add("spring.datasource.url", () -> "jdbc:sqlite:/tmp/sqlite-data:db?cache=shared");
    registry.add("spring.datasource.username", () -> "sa");
    registry.add("spring.datasource.password", () -> "sa");
  }
}