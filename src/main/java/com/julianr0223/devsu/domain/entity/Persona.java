package com.julianr0223.devsu.domain.entity;

import com.julianr0223.devsu.domain.Auditable;
import com.julianr0223.devsu.domain.enums.Genero;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "personas")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Where(clause = "fecha_eliminacion IS NULL")
public class Persona extends Auditable{
    @Id
    private String identificacion;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    private LocalDate fechaNacimiento;

    private String direccion;

    private String telefono;
}

