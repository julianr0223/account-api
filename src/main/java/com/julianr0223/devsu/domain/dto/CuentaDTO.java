package com.julianr0223.devsu.domain.dto;

import com.julianr0223.devsu.domain.enums.EstadoCuenta;
import com.julianr0223.devsu.domain.enums.TipoCuenta;
import com.julianr0223.devsu.domain.exception.SaldoInsuficienteException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Data
@Slf4j
public class CuentaDTO {
    public static final String SALDO_INSUFICIENTE_MESSAGE = "No se puede realizar la transacción, El saldo no es suficiente";
    private Long numeroCuenta;
    private TipoCuenta tipoCuenta;
    private BigDecimal saldo;
    private EstadoCuenta estado;

    public void actualizarSaldo(BigDecimal valor) {
        BigDecimal nuevoSaldo = this.saldo.add(valor);
        if (nuevoSaldo.compareTo(BigDecimal.ZERO) < 0) {
            log.warn(SALDO_INSUFICIENTE_MESSAGE);
            throw new SaldoInsuficienteException("Saldo no  disponible");
        }
        this.saldo = nuevoSaldo;
    }
}


