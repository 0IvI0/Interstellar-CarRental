package com.interstellarcarrental.carrental.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "EMPLOYEE")
@SuperBuilder
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Employee extends User {

    @Column(name = "EMPLOYEE_NR", nullable = false, unique = true)
    private String employeeNr;
}