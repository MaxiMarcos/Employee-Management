
package com.gestionempleados.administrador.IService;

import com.gestionempleados.administrador.Model.Employee;
import com.gestionempleados.administrador.Model.Schedule;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;


public interface ISchedule {
    
    public List<Schedule> getAllSchedule();
    
    public Schedule getSchedule(Long id);
    
    public void createSchedule (LocalDateTime entrySchedule, LocalDateTime exitSchedule);
    
    public void editSchedule(Long idOriginal, LocalDateTime entryTimeNew, LocalDateTime exitTimeNew, Long employeeIdNew);
    
    public void deleteSchedule (Long id);
}
