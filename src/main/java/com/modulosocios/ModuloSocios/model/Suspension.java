
package com.modulosocios.ModuloSocios.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author anima
 */
@Entity
@Table (name = "suspension" )
@Data
public class Suspension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column (name = "id" )
    private Integer id;
    
    @Column (name = "socioid" )
    private Integer socioId;
    
    @Column (name = "fechahorasuspension" )
    private Date fechaHoraSuspension;
    
    @Column (name = "motivo" )
    private String motivo;
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "socioid", insertable = false, updatable = false, nullable = true)
    private Socios socios;
}
