/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestionempleados.administrador.Repository;

import com.gestionempleados.administrador.Model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Usuario
 */
public interface IAttendanceRepository extends JpaRepository <Attendance, Long> {
    
}
