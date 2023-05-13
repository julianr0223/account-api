package com.julianr0223.devsu.domain.repository;

import com.julianr0223.devsu.domain.dto.MovimientoDTO;

import java.util.List;

public interface MovimientoRepository {
    MovimientoDTO guardar(MovimientoDTO movimiento);

    MovimientoDTO buscarPorId(Long idMovimiento);

    List<MovimientoDTO> obtenerTodos();

    MovimientoDTO actualizar(Long idMovimiento, MovimientoDTO movimientoAActualizarDTO);

    void eliminar(Long idMovimiento);
}
