
package com.gestionempleados.administrador.Service;

import com.gestionempleados.administrador.IService.ISchedule;
import com.gestionempleados.administrador.Model.Employee;
import com.gestionempleados.administrador.Model.Schedule;
import com.gestionempleados.administrador.Repository.IScheduleRepository;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleImpl implements ISchedule {

    @Autowired
    IScheduleRepository scheduleRepo;
    
    @Override
    public List<Schedule> getAllSchedule() {      
        return scheduleRepo.findAll();
    }

    @Override
    public Schedule getSchedule(Long id) {
        return scheduleRepo.findById(id).orElse(null);
    }

    @Override
    public void createSchedule(Schedule schedule) {       
        

        Duration duration = Duration.between(schedule.getEntryTime(), schedule.getExitTime());
        schedule.setHoursWorked(duration.toHours());
        
        scheduleRepo.save(schedule);
    }

    
    @Override
    public void editSchedule(Long idOriginal, LocalDate date, boolean present, LocalDateTime entryTimeNew, LocalDateTime exitTimeNew) {
        Schedule schedule = this.getSchedule(idOriginal);
        
        schedule.setEntryTime(entryTimeNew);
        schedule.setExitTime(exitTimeNew);
        //schedule.setEmployeeId(employeeIdNew);
    }

    @Override
    public void deleteSchedule(Long id) {
        scheduleRepo.deleteById(id);
    }


}
