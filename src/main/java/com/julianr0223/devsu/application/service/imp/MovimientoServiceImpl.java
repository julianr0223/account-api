package com.julianr0223.devsu.application.service.imp;

import com.julianr0223.devsu.application.service.CuentaService;
import com.julianr0223.devsu.application.service.MovimientoService;
import com.julianr0223.devsu.domain.dto.CuentaDTO;
import com.julianr0223.devsu.domain.dto.MovimientoDTO;
import com.julianr0223.devsu.domain.enums.TipoMovimiento;
import com.julianr0223.devsu.domain.repository.MovimientoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MovimientoServiceImpl implements MovimientoService {


    private MovimientoRepository movimientoRepository;

    private CuentaService cuentaService;

    public MovimientoServiceImpl(MovimientoRepository movimientoRepository, CuentaService cuentaService) {
        this.movimientoRepository = movimientoRepository;
        this.cuentaService = cuentaService;
    }

    @Override
    public MovimientoDTO crearMovimiento(Long idCuenta, MovimientoDTO movimientoACrear) {
        BigDecimal valorMovimiento = movimientoACrear.getValor();
        if(TipoMovimiento.RETIRO.equals(movimientoACrear.getTipoMovimiento())) {
            valorMovimiento = valorMovimiento.abs().negate();
        }
        CuentaDTO cuenta = cuentaService.actualizarSaldo(idCuenta, valorMovimiento);
        movimientoACrear.setCuenta(cuenta);
        return movimientoRepository.guardar(movimientoACrear);
    }

    @Override
    public MovimientoDTO obtenerMovimiento(Long idMovimiento) {
        return movimientoRepository.buscarPorId(idMovimiento);
    }

    @Override
    public List<MovimientoDTO> obtenerMovimientos() {
        return movimientoRepository.obtenerTodos();
    }

    @Override
    public MovimientoDTO actualizarMovimiento(Long idMovimiento, MovimientoDTO movimientoAActualizar) {
        return movimientoRepository.actualizar(idMovimiento, movimientoAActualizar);
    }

    @Override
    public void eliminarMovimiento(Long idMovimiento) {
        movimientoRepository.eliminar(idMovimiento);
    }
}
