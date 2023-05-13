package com.julianr0223.devsu.application.service.imp;

import com.julianr0223.devsu.application.service.CuentaService;
import com.julianr0223.devsu.application.service.MovimientoService;
import com.julianr0223.devsu.builders.CuentaBuilder;
import com.julianr0223.devsu.builders.MovimientoBuilder;
import com.julianr0223.devsu.domain.dto.CuentaDTO;
import com.julianr0223.devsu.domain.dto.MovimientoDTO;
import com.julianr0223.devsu.domain.enums.TipoMovimiento;
import com.julianr0223.devsu.domain.exception.SaldoInsuficienteException;
import com.julianr0223.devsu.domain.repository.CuentaRepository;
import com.julianr0223.devsu.domain.repository.MovimientoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class MovimientoServiceImplTest {

    @Mock
    MovimientoRepository movimientoRepository;

    @Mock
    CuentaRepository cuentaRepository;

    CuentaService cuentaService;

    MovimientoService movimientoService;

    @BeforeEach
    public void setUp() {
        cuentaService = new CuentaServiceImpl(cuentaRepository);
        movimientoService = new MovimientoServiceImpl(movimientoRepository, cuentaService);
    }

    @Test
    void crearRetiroCuandoSaldoEsInsuficiente() {

        Long idCuenta = 1L;
        MovimientoDTO movimiento = new MovimientoBuilder()
                .withTipoDeposito(TipoMovimiento.RETIRO)
                .withValor(BigDecimal.valueOf(100))
                .build();

        CuentaDTO cuenta = new CuentaBuilder().build();

        when(movimientoRepository.guardar(any())).thenReturn(any());
        when(cuentaService.obtenerCuenta(idCuenta)).thenReturn(cuenta);

        assertThrows(SaldoInsuficienteException.class, () -> {
            movimientoService.crearMovimiento(idCuenta, movimiento);
        }, CuentaDTO.SALDO_INSUFICIENTE_MESSAGE);
    }

    @Test
    void crearRetiroCuandoSaldoEsSuficiente() {

        Long idCuenta = 1L;
        MovimientoDTO movimiento = new MovimientoBuilder()
                .withTipoDeposito(TipoMovimiento.RETIRO)
                .withValor(BigDecimal.valueOf(100))
                .build();

        CuentaDTO cuenta = new CuentaBuilder()
                .withSaldoInicial(BigDecimal.valueOf(150))
                .build();

        when(movimientoRepository.guardar(any())).thenReturn(movimiento);
        when(cuentaService.obtenerCuenta(idCuenta)).thenReturn(cuenta);

        MovimientoDTO movimientoDTO = movimientoService.crearMovimiento(idCuenta, movimiento);
        BigDecimal saldo = movimientoDTO.getCuenta().getSaldo();

        assertEquals(BigDecimal.valueOf(50), saldo);
    }
}