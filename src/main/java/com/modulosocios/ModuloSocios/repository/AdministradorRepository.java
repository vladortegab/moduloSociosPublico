
package com.modulosocios.ModuloSocios.repository;

import com.modulosocios.ModuloSocios.model.Administrador;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anima
 */
@Repository

public interface AdministradorRepository extends JpaRepository<Administrador, Integer>{
    
            List <Administrador> findByNombreAdminStartingWith(String nombre);

}
