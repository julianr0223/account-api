package com.julianr0223.devsu.domain.repository;

import com.julianr0223.devsu.domain.dto.CuentaDTO;

import java.util.List;

public interface CuentaRepository {
    CuentaDTO guardar(Long idCliente, CuentaDTO cuenta);

    CuentaDTO buscarPorIdentificador(Long idCuenta);

    List<CuentaDTO> obtenerTodas();

    CuentaDTO actualizar(Long cuentaId, CuentaDTO cuentaAActualizarDto);

    void eliminar(Long idCuenta);
}
