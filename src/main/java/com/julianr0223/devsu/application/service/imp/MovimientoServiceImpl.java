package com.julianr0223.devsu.application.service.imp;

import com.julianr0223.devsu.application.service.MovimientoService;
import com.julianr0223.devsu.domain.dto.MovimientoDTO;
import com.julianr0223.devsu.domain.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Override
    public MovimientoDTO crearMovimiento(Long idCuenta, MovimientoDTO movimientoACrear) {
        return movimientoRepository.guardar(idCuenta, movimientoACrear);
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
