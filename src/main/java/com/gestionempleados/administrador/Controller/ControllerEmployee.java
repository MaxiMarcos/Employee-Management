
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
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){

        employeeServ.createEmployee(employee);
        
       return new ResponseEntity<>(employee,HttpStatus.OK);    
    }

    /*
    @PutMapping("/edit/{idOriginal}")
    public ResponseEntity<Employee> editEmployee(@PathVariable Long idOriginal, @RequestBody Employee employee) {
        
        employeeServ.editEmployee(idOriginal, employee);
        
        Employee newEmployee = employeeServ.getEmployee(idOriginal);
        
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
 */
}