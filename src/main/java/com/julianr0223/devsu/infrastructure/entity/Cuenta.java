package com.julianr0223.devsu.infrastructure.entity;

import com.julianr0223.devsu.domain.enums.EstadoCuenta;
import com.julianr0223.devsu.domain.enums.TipoCuenta;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cuentas")
@Getter
@Setter
@Slf4j
@Where(clause = "fecha_eliminacion IS NULL")
public class Cuenta extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numeroCuenta;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoCuenta tipoCuenta;

    @Column(precision = 15, scale = 2)
    private BigDecimal saldoInicial;

    @Enumerated(EnumType.STRING)
    private EstadoCuenta estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Movimiento> movimientos;

    public void setEstado(EstadoCuenta estado) {
        log.info("Estado de la cuenta {}", estado);
        if(Strings.isEmpty(estado.name())) {
            log.info("Setear estado de la cuenta por defecto a ACTIVO");
            this.estado = EstadoCuenta.ACTIVO;
        } else {
            this.estado = estado;
        }
    }
}
