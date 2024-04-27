
package com.gestionempleados.administrador.IService;

import com.gestionempleados.administrador.Model.Attendance;
import com.gestionempleados.administrador.Model.Employee;
import java.time.LocalDate;
import java.util.List;


public interface IAttendance {
    
    public List<Attendance> getAllAttendance();
    
    public Attendance getAttendance(Long id);
    
    public void createAttendance(Attendance attendance);
    
    public void editAttendance(Long idOriginal, Employee employeeNew, LocalDate dateNew, boolean presentNew);
    
    public void deleteAttendance(Long id);
}
