package com.julianr0223.devsu.infrastructure.repository_imp;

import com.julianr0223.devsu.application.service.utils.DTOMapper;
import com.julianr0223.devsu.domain.dto.CuentaDTO;
import com.julianr0223.devsu.domain.repository.CuentaRepository;
import com.julianr0223.devsu.infrastructure.entity.Cliente;
import com.julianr0223.devsu.infrastructure.entity.Cuenta;
import com.julianr0223.devsu.infrastructure.repository_imp.jpa.ClienteRepositoryJPA;
import com.julianr0223.devsu.infrastructure.repository_imp.jpa.CuentaRepositoryJPA;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CuentaRepositoryImpl implements CuentaRepository {

    @Autowired
    private CuentaRepositoryJPA cuentaRepositoryJPA;

    @Autowired
    private ClienteRepositoryJPA clienteRepositoryJPA;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DTOMapper dtoMapper;

    @Override
    public CuentaDTO guardar(Long idCliente, CuentaDTO cuantaACrearDto) {
        Cliente cliente = clienteRepositoryJPA.findById(idCliente).orElseThrow(() -> new IllegalArgumentException("No se encuentra el cliente"));
        Cuenta cuentaACrear = dtoMapper.convertToEntity(cuantaACrearDto, Cuenta.class);
        cuentaACrear.setCliente(cliente);
        Cuenta cuentaCreada = cuentaRepositoryJPA.save(cuentaACrear);
        return dtoMapper.convertToDTO(cuentaCreada, CuentaDTO.class);
    }

    @Override
    public CuentaDTO buscarPorIdentificador(Long idCuenta) {
        Cuenta cuenta = obtenerCuentaPorId(idCuenta);
        return dtoMapper.convertToDTO(cuenta, CuentaDTO.class);
    }

    @Override
    public List<CuentaDTO> obtenerTodas() {
        return cuentaRepositoryJPA.findAll().stream()
                .map(cuenta -> dtoMapper.convertToDTO(cuenta, CuentaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CuentaDTO actualizar(Long cuentaId, CuentaDTO cuentaAActualizarDto) {
        Cuenta cuentaDestino = obtenerCuentaPorId(cuentaId);
        Cuenta cuentaOrigen = dtoMapper.convertToEntity(cuentaAActualizarDto, Cuenta.class);
        modelMapper.map(cuentaOrigen, cuentaDestino);
        Cuenta cuentaActualizada = cuentaRepositoryJPA.save(cuentaDestino);
        return dtoMapper.convertToDTO(cuentaActualizada, CuentaDTO.class);
    }

    @Override
    public void eliminar(Long idCuenta) {
        Cuenta cuentaAEliminar = obtenerCuentaPorId(idCuenta);
        cuentaAEliminar.setFechaEliminacion(LocalDateTime.now());
        cuentaRepositoryJPA.save(cuentaAEliminar);
    }

    private Cuenta obtenerCuentaPorId(Long idCuenta) {
        return cuentaRepositoryJPA.findById(idCuenta)
                .orElseThrow(() -> new EntityNotFoundException("Cuenta no encontrado"));
    }
}
