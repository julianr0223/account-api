package com.julianr0223.devsu.application.service;

import com.julianr0223.devsu.domain.dto.MovimientoDTO;

import java.util.List;

public interface MovimientoService {
    MovimientoDTO crearMovimiento(Long idCuenta, MovimientoDTO movimientoACrear);
    MovimientoDTO obtenerMovimiento(Long idMovimiento);
    List<MovimientoDTO> obtenerMovimientos();
    MovimientoDTO actualizarMovimiento(Long idMovimiento, MovimientoDTO movimientoAActualizar);
    void eliminarMovimiento(Long idMovimiento);
}
