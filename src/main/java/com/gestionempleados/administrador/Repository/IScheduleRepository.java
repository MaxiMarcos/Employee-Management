
package com.gestionempleados.administrador.Repository;

import com.gestionempleados.administrador.Model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IScheduleRepository extends JpaRepository <Schedule,Long>  {
    
}
