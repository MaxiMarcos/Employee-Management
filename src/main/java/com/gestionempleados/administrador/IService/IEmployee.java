
package com.gestionempleados.administrador.IService;

import com.gestionempleados.administrador.Model.Employee;
import java.util.Date;
import java.util.List;


public interface IEmployee {
   
    public List<Employee> getAllEmployees();
    
    public Employee getEmployee(Long id);
    
    public void createEmployee (Employee employee);
    
    public void editEmployee(Long idOriginal,String firstnameNew,String lastnameNew, String emailNew, Long phoneNew,
            Date dateHireNew, Long salaryNew, String assessmentNew, String skillsNew, int ageNew);
    
    public void deleteEmployee (Long id);
}