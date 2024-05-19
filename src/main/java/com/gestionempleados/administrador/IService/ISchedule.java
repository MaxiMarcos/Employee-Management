
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
    
    public void createSchedule (Schedule schedule);
    
    public void editSchedule(Long idOriginal, LocalDate date, boolean present, LocalDateTime entryTimeNew, LocalDateTime exitTimeNew);
    
    public void deleteSchedule (Long id);
}
