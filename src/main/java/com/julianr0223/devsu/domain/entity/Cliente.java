package com.julianr0223.devsu.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@Where(clause = "fecha_eliminacion IS NULL")
public class Cliente extends Persona{
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clienteId;

    private String contrasena;

    private String estado;
}
