package com.companyname.demoapp.controller;

import org.springframework.web.bind.annotation.*;
import com.companyname.demoapp.dto.Employee;

@RestController //
public class EmployeeController {
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
}
