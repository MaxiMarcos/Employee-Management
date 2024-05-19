
package com.gestionempleados.administrador.IService;

import com.gestionempleados.administrador.Model.Employee;
import com.gestionempleados.administrador.Model.Schedule;
import java.util.Date;
import java.util.List;


public interface IEmployee {
   
    public List<Employee> getAllEmployees();
    
    public Employee getEmployee(Long id);
    
    public void createEmployee (Employee employee);
    
   // public void editEmployee(Long idOriginal, Employee employee);
    
    public void createAverageSchedule(Long employeeId);
    
    public void deleteEmployee (Long id);
}