
package com.gestionempleados.administrador.Controller;

import com.gestionempleados.administrador.IService.IAttendance;
import com.gestionempleados.administrador.IService.IEmployee;
import com.gestionempleados.administrador.Model.Attendance;
import com.gestionempleados.administrador.Model.Employee;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendance")
public class ControllerAttendance {
    
    @Autowired
    IAttendance attendanceServ;
    
    @Autowired
    IEmployee employeeServ;
    
    @GetMapping("/get-all")
     public ResponseEntity<List<Attendance>> getAllEmployees(){
    
        List<Attendance> attendance = attendanceServ.getAllAttendance();
        
        if(attendance.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(attendance, HttpStatus.OK);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Attendance> getAttendance(@PathVariable Long id){
    
        Attendance attendance = attendanceServ.getAttendance(id);
        
        if(attendance != null){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(attendance, HttpStatus.OK);
        }
    }
    
    @PostMapping("/create")
    public ResponseEntity <String> createAttendance(@RequestBody Attendance attendance){

    Long employeeId = attendance.getEmployee().getId();
        
    Employee employee = employeeServ.getEmployee(employeeId);
    if(employee == null) {
        // Manejar el caso en el que no se encuentra el empleado
        return new ResponseEntity<>("Employee not found with ID: " + employeeId, HttpStatus.NOT_FOUND);
    }
    
    // Establecer el empleado en la asistencia
    attendance.setEmployee(employee);
        
        
        attendanceServ.createAttendance(attendance);    
        return new ResponseEntity<>("The Attendance was created successfully", HttpStatus.OK);    
    }

    @DeleteMapping("/delete")
    public ResponseEntity <String> deleteAttendance (Long id){
        
        attendanceServ.deleteAttendance(id);
        return new ResponseEntity<>("The employee was deleted successfully", HttpStatus.OK);    
    }
}
    
