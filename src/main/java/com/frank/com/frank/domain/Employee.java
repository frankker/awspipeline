package com.frank.com.frank.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Employee {

  private String name;
  private Integer salary;
}
