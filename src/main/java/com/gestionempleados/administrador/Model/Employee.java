
package com.gestionempleados.administrador.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    Long id;
    String firstname;
    String lastname;
    String email;
    Long phone;
    Date dateHire;
    Long salary;
    String skills;
    int age;
    @ManyToMany
    private List<Schedule> listaSchedule;
    double averageSchedule;
   
}
