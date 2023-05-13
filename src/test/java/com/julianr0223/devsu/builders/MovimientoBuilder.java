package com.julianr0223.devsu.builders;

import com.julianr0223.devsu.domain.dto.CuentaDTO;
import com.julianr0223.devsu.domain.dto.MovimientoDTO;
import com.julianr0223.devsu.domain.enums.TipoMovimiento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MovimientoBuilder {
    private MovimientoDTO movimientoDTO;

    public MovimientoBuilder(){
        this.movimientoDTO = new MovimientoDTO();
        this.movimientoDTO.setTipoMovimiento(TipoMovimiento.DEPOSITO);
    }

    public MovimientoBuilder withTipoDeposito(TipoMovimiento tipoMovimiento) {
        this.movimientoDTO.setTipoMovimiento(tipoMovimiento);
        return this;
    }

    public MovimientoBuilder withValor(BigDecimal valor) {
        this.movimientoDTO.setValor(valor);
        return this;
    }

    public MovimientoBuilder withCuenta(CuentaDTO cuenta) {
        this.movimientoDTO.setCuenta(cuenta);
        return this;
    }

    public MovimientoDTO build() {
        return this.movimientoDTO;
    }
}
