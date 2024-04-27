/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestionempleados.administrador.Service;

import com.gestionempleados.administrador.IService.IAttendance;
import com.gestionempleados.administrador.Model.Attendance;
import com.gestionempleados.administrador.Model.Employee;
import com.gestionempleados.administrador.Repository.IAttendanceRepository;
import com.gestionempleados.administrador.Repository.IEmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceImpl implements IAttendance {
    
    @Autowired
    IAttendanceRepository attendanceRepo;
    
    @Override
    public List<Attendance> getAllAttendance() {
        
        List<Attendance> attendance = attendanceRepo.findAll();
        
        return attendance;
    }

    @Override
    public Attendance getAttendance(Long id) {

        return attendanceRepo.findById(id).orElse(null);
    }

    @Override
    public void createAttendance(Attendance attendance) {
        
        attendanceRepo.save(attendance);
    }

    @Override
    public void deleteAttendance(Long id) {
        attendanceRepo.deleteById(id);
    }

    @Override
    public void editAttendance(Long idOriginal, Employee employeeNew, LocalDate dateNew, boolean presentNew) {
        
        Attendance attendance = getAttendance(idOriginal);
        
        attendance.setEmployee(employeeNew);
        attendance.setDate(dateNew);
        attendance.setPresent(presentNew);
        
        attendanceRepo.save(attendance);
    }
    
}
