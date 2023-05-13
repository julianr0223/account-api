package com.julianr0223.devsu.application.service.imp;

import com.julianr0223.devsu.application.service.CuentaService;
import com.julianr0223.devsu.domain.dto.CuentaDTO;
import com.julianr0223.devsu.domain.repository.CuentaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService {
    private CuentaRepository cuentaRepository;

    public CuentaServiceImpl(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public CuentaDTO crearCuenta(Long idCliente, CuentaDTO cuantaACrearDto) {
        return cuentaRepository.guardar(idCliente, cuantaACrearDto);
    }

    @Override
    public CuentaDTO obtenerCuenta(Long cuentaId) {
        return cuentaRepository.buscarPorIdentificador(cuentaId);
    }

    @Override
    public List<CuentaDTO> obtenerCuentas() {
        return cuentaRepository.obtenerTodas();
    }

    @Override
    public CuentaDTO actualizarCuenta(Long cuentaId, CuentaDTO cuentaAActualizarDto) {
        return cuentaRepository.actualizar(cuentaId, cuentaAActualizarDto);
    }

    @Override
    public void eliminarCuenta(Long idCuenta) {
        cuentaRepository.eliminar(idCuenta);
    }

    @Override
    public CuentaDTO actualizarSaldo(Long idCuenta, BigDecimal valor) {
        CuentaDTO cuenta = this.obtenerCuenta(idCuenta);
        cuenta.actualizarSaldo(valor);
        this.actualizarCuenta(idCuenta, cuenta);
        return cuenta;
    }


}
