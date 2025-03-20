package com.springboot.prod_ready_features.prod_ready_features.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDTO { //POJO class (Plain Old Java Object

    private Long id;

    private String name;

    private String email;

    private Integer age;

    private String role;

    private Double salary;

    private LocalDate dateOfJoining;

    private Boolean isActive;
}
