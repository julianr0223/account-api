package com.julianr0223.devsu.application.service;

import com.julianr0223.devsu.domain.dto.CuentaDTO;

import java.util.List;

public interface CuentaService {
    CuentaDTO crearCuenta(Long idCliente, CuentaDTO cuantaACrear);
    CuentaDTO obtenerCuenta(Long cuentaId);
    List<CuentaDTO> obtenerCuentas();
    CuentaDTO actualizarCuenta(Long cuentaId, CuentaDTO cuentaAActualizar);
    void eliminarCuenta(Long cuentaId);
}
