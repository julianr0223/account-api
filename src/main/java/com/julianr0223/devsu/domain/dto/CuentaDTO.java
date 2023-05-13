package com.julianr0223.devsu.domain.dto;

import com.julianr0223.devsu.domain.enums.EstadoCuenta;
import com.julianr0223.devsu.domain.enums.TipoCuenta;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CuentaDTO {
    private Long numeroCuenta;
    private TipoCuenta tipoCuenta;
    private BigDecimal saldoInicial;
    private EstadoCuenta estado;
}
