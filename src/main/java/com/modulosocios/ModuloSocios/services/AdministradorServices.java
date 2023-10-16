
package com.modulosocios.ModuloSocios.services;

import com.modulosocios.ModuloSocios.dtos.AdministradorDto;
import com.modulosocios.ModuloSocios.mapper.AdministradorMapper;
import com.modulosocios.ModuloSocios.model.Administrador;
import com.modulosocios.ModuloSocios.model.Administrador;
import com.modulosocios.ModuloSocios.repository.AdministradorRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 *
 * @author anima
 */
@Service
public class AdministradorServices {
    
    private final AdministradorRepository administradorRepository;
    private final AdministradorMapper administradorMapper;

    //Inyeccion Dependencias por Constructor
    public AdministradorServices(AdministradorRepository administradorRepository, AdministradorMapper administradorMapper){
        this.administradorRepository = administradorRepository;
        this.administradorMapper = administradorMapper;
    }

    public AdministradorDto findById(Integer id) {
        if (Objects.isNull(id)) {
            throw new RuntimeException("ex.administrador.object_not_found");
        }
        Optional<Administrador> administradorOptional = this.administradorRepository.findById(id);
        if(administradorOptional.isPresent()){
            return this.administradorMapper.toDto(administradorOptional.get());
        }else{
            throw new RuntimeException("ex.administrador.data_not_found");
        }
    }
    
    //lista de socios
    public List<Administrador> findByname(String nombre){
        var administrador = administradorRepository.findByNombreAdminStartingWith(nombre);
        
        return administrador;
    }
    public List<Administrador> findAll() {

        var administradorList = administradorRepository.findAll();
        return administradorList;

    }
}
