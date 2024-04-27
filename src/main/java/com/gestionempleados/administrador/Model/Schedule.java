
package com.gestionempleados.administrador.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
     
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
  //  private Long employeeId; // Referencia al empleado al que pertenece este horario
    
}
