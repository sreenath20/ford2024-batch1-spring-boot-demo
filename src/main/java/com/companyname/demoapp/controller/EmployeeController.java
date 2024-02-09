package com.companyname.demoapp.controller;

import org.springframework.web.bind.annotation.*;
import com.companyname.demoapp.dto.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController //
public class EmployeeController {

    private Map<Integer,Employee> employeeMap = new HashMap<>();

    //Create Read Update Delete
    // C-POST
    // R-GET
    // U-PUT [PATCH - partial update]
    // D-DELETE
   @GetMapping("/") // API HTTP(GET):localhost:8090/
    public String greeting(){ // handler method
        return "Hello Ford !";
    }
    //URL should be in small case and a noun / represent resource

    @GetMapping("employee") //// API HTTP(GET):localhost:8090/employee
    public Employee getEmployee(){
       return new Employee(1,"India",50000.0);
    }

    @PostMapping("/") // creation of new resource
    public String addNewResore(){
        return "Called POST mapping";
    }
    @PutMapping("/") // replace the existing resource
    public String updateResore(){
       return "Called PUT mapping";
   }
   @PatchMapping("/") // partial changes to data
    public String partialUpdateResource(){
       return "called PatchMapping";
   }

   @DeleteMapping("/")
    public String deleteResorce(){
       return "Delete mapping";
   }

   // API to do CRUD on employee app
    @PostMapping("employee") // URL should be a noun
    public Employee addNewEmployee(@RequestBody Employee newEmployee){
       this.employeeMap.put(newEmployee.getId(),newEmployee);
       return this.employeeMap.get(newEmployee.getId()); // Jakson will convert to JSON @ResponseBody
    }
    @GetMapping("employee/{id}") // id thru URL @PathVariable
    public Employee getEmployeeByID(@PathVariable("id") Integer employeeId ){
       return this.employeeMap.get(employeeId);
    }
    @PutMapping("employee")
    public Employee replaceEmployee(@RequestBody Employee updateEmployee){
       this.employeeMap.replace(updateEmployee.getId(),updateEmployee);
       return this.employeeMap.get(updateEmployee.getId());
    }

    @PatchMapping("employee/salary")
    public Employee updateEmployeeSalry(@RequestBody Employee updateEmployee){
       Employee foundEmployee = this.employeeMap.get(updateEmployee.getId());
       foundEmployee.setSalary(updateEmployee.getSalary());
       return foundEmployee;
    }
    @DeleteMapping("empolyee/{employeeId}")
    public Employee deleteEmployeeById(@PathVariable("employeeId") Integer id){
      return this.employeeMap.remove(id);
    }
    @GetMapping("employees")
    public Collection<Employee> getAllEmployee(){
       return this.employeeMap.values();
    }
    // 1. get all employees sorted by id/ name/salary
    @GetMapping("sorted/employees/id")
    public List<Employee> getAllEmployeesSortedById(){

        return this.employeeMap.values().stream().sorted().collect(Collectors.toList());
    }
    // get all employee name [map]
    // get sum of all salary


}
