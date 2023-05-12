package com.julianr0223.devsu.domain.entity;

import com.julianr0223.devsu.domain.Auditable;
import com.julianr0223.devsu.domain.enums.TipoMovimiento;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimientos")
@Getter
@Setter
@Where(clause = "fecha_eliminacion IS NULL")
public class Movimiento extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMovimiento tipoMovimiento;

    @Column(precision = 15, scale = 2, nullable = false)
    private BigDecimal valor;

    @Column(precision = 15, scale = 2, nullable = false)
    private BigDecimal saldo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numero_cuenta")
    private Cuenta cuenta;
}
