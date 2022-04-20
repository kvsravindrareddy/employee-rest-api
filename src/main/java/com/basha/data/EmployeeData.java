package com.basha.data;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeData {
    private long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String department;
    private double salary;
}
