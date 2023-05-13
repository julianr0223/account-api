package com.julianr0223.devsu.builders;

import com.julianr0223.devsu.domain.dto.CuentaDTO;
import com.julianr0223.devsu.domain.dto.MovimientoDTO;
import com.julianr0223.devsu.domain.enums.EstadoCuenta;
import com.julianr0223.devsu.domain.enums.TipoCuenta;
import com.julianr0223.devsu.domain.enums.TipoMovimiento;

import java.math.BigDecimal;

public class CuentaBuilder {
    private CuentaDTO cuentaDTO;

    public CuentaBuilder(){
        this.cuentaDTO = new CuentaDTO();
        this.cuentaDTO.setTipoCuenta(TipoCuenta.AHORROS);
        this.cuentaDTO.setSaldo(BigDecimal.valueOf(0));
        this.cuentaDTO.setEstado(EstadoCuenta.ACTIVO);
    }
    public CuentaDTO build() {
        return this.cuentaDTO;
    }

    public CuentaBuilder withSaldoInicial(BigDecimal saldoInicial) {
        this.cuentaDTO.setSaldo(saldoInicial);
        return this;
    }
}
