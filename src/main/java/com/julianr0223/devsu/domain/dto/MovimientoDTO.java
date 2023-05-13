package com.julianr0223.devsu.domain.dto;

import com.julianr0223.devsu.domain.enums.TipoMovimiento;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class MovimientoDTO {
    private Long idMovimiento;
    private LocalDateTime fecha;
    private TipoMovimiento tipoMovimiento;
    private BigDecimal valor;
    private BigDecimal saldo;
}
