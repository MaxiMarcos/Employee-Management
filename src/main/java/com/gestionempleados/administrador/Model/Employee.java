
package com.gestionempleados.administrador.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Date;
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
    String assessment;
    String skills;
    int age;
    @OneToOne
    private Schedule schedule;
   
}
