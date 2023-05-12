package com.julianr0223.devsu.domain.entity;

import com.julianr0223.devsu.domain.Auditable;
import com.julianr0223.devsu.domain.enums.TipoCuenta;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cuentas")
@Getter
@Setter
@Where(clause = "fecha_eliminacion IS NULL")
public class Cuenta extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numeroCuenta;

    @Enumerated(EnumType.STRING)
    private TipoCuenta tipoCuenta;

    @Column(precision = 15, scale = 2)
    private BigDecimal saldoInicial;

    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Movimiento> movimientos;
}
