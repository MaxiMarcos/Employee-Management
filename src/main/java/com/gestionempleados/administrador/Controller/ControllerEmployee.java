
package com.gestionempleados.administrador.Controller;

import com.gestionempleados.administrador.IService.IEmployee;
import com.gestionempleados.administrador.Model.Employee;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEmployee {
    
    @Autowired
    IEmployee employeeServ;
    
    @GetMapping("/get-all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
    
        List<Employee> employees = employeeServ.getAllEmployees();
        
        if(employees.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
    }
    
    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        
        Employee employee = employeeServ.getEmployee(id);
        
        if(employee != null){
                return new ResponseEntity<>(employee,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/employees/create")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee){
        
        employeeServ.createEmployee(employee);
        
        return new ResponseEntity<>("The employee was created successfully", HttpStatus.OK);    
    }
    
    @PutMapping("/edit")
    public ResponseEntity<Employee> editEmployee(@PathVariable Long idOriginal,
        @RequestParam(required = false, name = "firstname") String firstnameNew,
        @RequestParam(required = false, name = "lastname")String lastnameNew,
        @RequestParam(required = false, name = "email")String emailNew,
        @RequestParam(required = false, name = "phone")Long phoneNew,
        @RequestParam(required = false, name = "dateHire")Date dateHireNew,
        @RequestParam(required = false, name = "salary")Long salaryNew,
        @RequestParam(required = false, name = "assessment")String assessmentNew,
        @RequestParam(required = false, name = "skills")String skillsNew,
        @RequestParam(required = false, name = "age")int ageNew) {
        
        employeeServ.editEmployee(idOriginal, firstnameNew, lastnameNew, emailNew, phoneNew, dateHireNew, salaryNew, assessmentNew, skillsNew, ageNew);
        
        Employee employee = employeeServ.getEmployee(idOriginal);
        
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
