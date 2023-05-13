package com.julianr0223.devsu.domain.dto;

import com.julianr0223.devsu.domain.enums.EstadoCliente;
import com.julianr0223.devsu.domain.enums.Genero;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClienteDTO {
    private Long clienteId;
    private String identificacion;
    private String nombre;
    private Genero genero;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String telefono;
    private String contrasena;
    private EstadoCliente estado;
}
