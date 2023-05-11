package com.julianr0223.devsu.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Where(clause = "fecha_eliminacion IS NULL")
public class Cliente extends Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clienteId;

    private String contrasena;

    private String estado;
}
