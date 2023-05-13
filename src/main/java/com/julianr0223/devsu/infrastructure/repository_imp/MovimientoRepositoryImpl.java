package com.julianr0223.devsu.infrastructure.repository_imp;

import com.julianr0223.devsu.application.service.utils.DTOMapper;
import com.julianr0223.devsu.domain.dto.MovimientoDTO;
import com.julianr0223.devsu.domain.repository.MovimientoRepository;
import com.julianr0223.devsu.infrastructure.entity.Movimiento;
import com.julianr0223.devsu.infrastructure.repository_imp.jpa.CuentaRepositoryJPA;
import com.julianr0223.devsu.infrastructure.repository_imp.jpa.MovimientoRepositoryJPA;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovimientoRepositoryImpl implements MovimientoRepository {
    @Autowired
    private MovimientoRepositoryJPA movimientoRepositoryJPA;

    @Autowired
    private CuentaRepositoryJPA cuentaRepositoryJPA;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DTOMapper dtoMapper;

    @Override
    public MovimientoDTO guardar(MovimientoDTO movimientoACrearDTO) {
        Movimiento movimientoACrear = dtoMapper.convertToEntity(movimientoACrearDTO, Movimiento.class);
        Movimiento movimientoCreado = movimientoRepositoryJPA.save(movimientoACrear);
        return dtoMapper.convertToDTO(movimientoCreado, MovimientoDTO.class);
    }

    @Override
    public MovimientoDTO buscarPorId(Long idMovimiento) {
        Movimiento movimiento = obtenerMovimientoPorId(idMovimiento);
        return dtoMapper.convertToDTO(movimiento, MovimientoDTO.class);
    }

    @Override
    public List<MovimientoDTO> obtenerTodos() {
        return movimientoRepositoryJPA.findAll().stream()
                .map(movimiento -> dtoMapper.convertToDTO(movimiento, MovimientoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public MovimientoDTO actualizar(Long idMovimiento, MovimientoDTO movimientoAActualizarDTO) {
        Movimiento movimientoDestino = obtenerMovimientoPorId(idMovimiento);
        Movimiento movimientoOrigen = dtoMapper.convertToEntity(movimientoAActualizarDTO, Movimiento.class);
        modelMapper.map(movimientoOrigen, movimientoDestino);
        Movimiento cuentaActualizada = movimientoRepositoryJPA.save(movimientoDestino);
        return dtoMapper.convertToDTO(cuentaActualizada, MovimientoDTO.class);
    }

    @Override
    public void eliminar(Long idMovimiento) {
        Movimiento movimientoAEliminar = obtenerMovimientoPorId(idMovimiento);
        movimientoAEliminar.setFechaEliminacion(LocalDateTime.now());
        movimientoRepositoryJPA.save(movimientoAEliminar);
    }

    private Movimiento obtenerMovimientoPorId(Long idMovimiento) {
        return movimientoRepositoryJPA.findById(idMovimiento)
                .orElseThrow(() -> new EntityNotFoundException("Movimiento no encontrado"));
    }
}
