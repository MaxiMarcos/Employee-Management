
package com.gestionempleados.administrador.Service;

import com.gestionempleados.administrador.IService.IEmployee;
import com.gestionempleados.administrador.Model.Employee;
import com.gestionempleados.administrador.Repository.IEmployeeRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeImpl implements IEmployee {
    
    
    @Autowired
    IEmployeeRepository employeeRepo;
    
    @Override
    public List<Employee> getAllEmployees(){
        
       return employeeRepo.findAll();
    }  

    @Override
    public Employee getEmployee(Long id) {
        
        return employeeRepo.findById(id).orElse(null);
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public void editEmployee(Long idOriginal, String firstnameNew, String lastnameNew, String emailNew, Long phoneNew, Date dateHireNew, Long salaryNew, String assessmentNew, String skillsNew, int ageNew) {
        
        Employee emplo = this.getEmployee(idOriginal);
        emplo.setFirstname(firstnameNew);
        emplo.setLastname(lastnameNew);
        emplo.setEmail(emailNew);
        emplo.setPhone(phoneNew);
        emplo.setDateHire(dateHireNew);
        emplo.setSalary(salaryNew);
        emplo.setAssessment(assessmentNew);
        emplo.setSkills(skillsNew);
        emplo.setAge(ageNew);
    }

    
    
}
