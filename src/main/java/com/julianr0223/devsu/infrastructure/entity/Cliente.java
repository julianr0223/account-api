package com.julianr0223.devsu.infrastructure.entity;

import com.julianr0223.devsu.domain.enums.EstadoCliente;
import com.julianr0223.devsu.domain.enums.Genero;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@Where(clause = "fecha_eliminacion IS NULL")
public class Cliente extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clienteId;

    @Column(unique = true, nullable = false)
    private String identificacion;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    private LocalDate fechaNacimiento;

    private String direccion;

    private String telefono;

    private String contrasena;

    @Enumerated(EnumType.STRING)
    private EstadoCliente estado;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cuenta> cuentas = new ArrayList<>();
}
