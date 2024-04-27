
package com.gestionempleados.administrador.Repository;

import com.gestionempleados.administrador.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository <Employee,Long>  {
    
}
