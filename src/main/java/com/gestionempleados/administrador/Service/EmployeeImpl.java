
package com.gestionempleados.administrador.Service;

import com.gestionempleados.administrador.IService.IEmployee;
import com.gestionempleados.administrador.Model.Employee;
import com.gestionempleados.administrador.Model.Schedule;
import com.gestionempleados.administrador.Repository.IEmployeeRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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

        
        Employee savedEmployee = employeeRepo.save(employee);
        this.createAverageSchedule(employee.getId());
        


    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }

    /* @Override
    public void editEmployee(Long idOriginal, Employee employee) {
        
        Employee newEmployee = this.getEmployee(idOriginal);
        
        newEmployee.setFirstname(employee.getFirstname());
        newEmployee.setLastname(employee.getLastname());
        newEmployee.setEmail(employee.getEmail());
        newEmployee.setPhone(employee.getPhone());
        newEmployee.setDateHire(employee.getDateHire());
        newEmployee.setSalary(employee.getSalary());
        newEmployee.setSkills(employee.getSkills());
        newEmployee.setAge(employee.getAge());
        
        this.createEmployee(newEmployee);

    } */

    public void createAverageSchedule(Long employeeId) {
    Optional<Employee> employeeOptional = employeeRepo.findById(employeeId);

    if (employeeOptional.isPresent()) {
        Employee employee = employeeOptional.get();
        List<Schedule> schedules = employee.getListaSchedule();

        // Filtrar la lista de Schedule para obtener solo los que tienen la propiedad deseada

        List<Long> valoresPropiedad = schedules.stream()
            .filter(schedule -> schedule.getHoursWorked() != null) // Filtrar los horarios que tengan un valor no nulo para hoursWorked
            .map(Schedule::getHoursWorked)
            .collect(Collectors.toList());
        
        // Calcular el promedio de los valores obtenidos
        double promedio = 0;
        if (valoresPropiedad != null && !valoresPropiedad.isEmpty()) {
            double suma = valoresPropiedad.stream().mapToInt(Long::intValue).sum();
            
             employee.setAverageSchedule(suma);

        }

    } else {
        // Manejar el caso en que no se encuentre el empleado con el ID proporcionado
        throw new IllegalArgumentException("Empleado no encontrado con el ID: " + employeeId);
    }
    
}
    
}
