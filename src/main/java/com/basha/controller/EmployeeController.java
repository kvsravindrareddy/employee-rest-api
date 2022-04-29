package com.basha.controller;

import com.basha.data.EmployeeData;
import com.basha.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This the Rest Controller to perform the Employee Crud Operations
 */
@RestController
public class EmployeeController {

    /**Create {@code EmployeeService} reference*/
    private EmployeeService employeeService;

    /**
     * Constructor injection
     * @param {@code {@code EmployeeService}} employeeService
     */
    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    /**
     * This method to create the new Employee
     * @param employeeData
     * @return {@code EmployeeData}
     */
    @PostMapping(value="/emp")
    public ResponseEntity<EmployeeData> createEmployee(@RequestBody EmployeeData employeeData)
    {
        return new ResponseEntity<>(employeeService.createEmployee(employeeData), HttpStatus.CREATED);
    }

    /**
     * This method used find the employee by id
     * @param id
     * @return {@code EmployeeData}
     */
    @GetMapping("/emp")
    public ResponseEntity<EmployeeData> findByEmployeeId(@RequestParam("id")long id)
    {
        return new ResponseEntity<>(employeeService.findByEmployeeId(id), HttpStatus.OK);
    }

    /**
     * This method to update the {@code Employee} for the given employee id
     * @param employeeData
     * @param id
     * @return
     */
    @PutMapping("/emp")
    public ResponseEntity<EmployeeData> updateEmployeeById(@RequestBody EmployeeData employeeData,@RequestParam("id")long id)
    {
        return new ResponseEntity<EmployeeData>(employeeService.updateEmployeeById(employeeData, id), HttpStatus.OK);
    }


    /**
     * This method to delete the employee for the given employee id
     * @param id
     */
    @DeleteMapping("/emp")
    public void deleteEmployee(@RequestParam("id")long id)
    {
        employeeService.deleteEmployee(id);
    }
}