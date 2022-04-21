package com.basha.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is the Entity class which persist the {@code Employee} into EMP_TB
 * with all the required columns
 */
@Setter
@Getter
@Entity
@Table(name = "EMP_TB")
public class Employee {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String department;
    private double salary;
}
