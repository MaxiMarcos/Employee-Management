
package com.gestionempleados.administrador.Controller;


import com.gestionempleados.administrador.IService.ISchedule;
import com.gestionempleados.administrador.Model.Schedule;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerSchedule {
    
    @Autowired
    ISchedule scheduleServ;
    
    @GetMapping("get-all-schedule")
    public ResponseEntity<List<Schedule>> getAllSchedule(){
        
        List<Schedule> schedule = scheduleServ.getAllSchedule();
        
        if(schedule != null){
                return new ResponseEntity<>(schedule,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping
    public ResponseEntity<Schedule> getSchedule(Long id){
        
        Schedule schedule = scheduleServ.getSchedule(id);
        
        if(schedule != null){
                return new ResponseEntity<>(schedule,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/schedule/create")
    public ResponseEntity<String> createSchedule(@RequestBody Schedule schedule){
        
        scheduleServ.createSchedule(schedule);
        
        return new ResponseEntity<>("The schedule was created successfully", HttpStatus.OK);    
    }
}
