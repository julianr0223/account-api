package com.julianr0223.devsu.infrastructure.repository_imp;

import com.julianr0223.devsu.application.service.utils.DTOMapper;
import com.julianr0223.devsu.domain.dto.ClienteDTO;
import com.julianr0223.devsu.domain.repository.ClienteRepository;
import com.julianr0223.devsu.infrastructure.entity.Cliente;
import com.julianr0223.devsu.infrastructure.repository_imp.jpa.ClienteRepositoryJPA;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {
    @Autowired
    private ClienteRepositoryJPA clienteRepositoryJPA;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DTOMapper dtoMapper;

    @Override
    public ClienteDTO crear(ClienteDTO clienteACrearDto) {
        Cliente clienteACrear = dtoMapper.convertToEntity(clienteACrearDto, Cliente.class);
        Cliente clienteGuardado = clienteRepositoryJPA.save(clienteACrear);
        return dtoMapper.convertToDTO(clienteGuardado, ClienteDTO.class);
    }

    @Override
    public ClienteDTO buscarPorIdentificador(Long idCliente) {
        Cliente cliente = obtenerClientePorIdentificacion(idCliente);
        return dtoMapper.convertToDTO(cliente, ClienteDTO.class);
    }

    @Override
    public List<ClienteDTO> obtenerTodos() {
        return clienteRepositoryJPA.findAll().stream()
                .map(cliente -> dtoMapper.convertToDTO(cliente, ClienteDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO actualizar(Long idCliente, ClienteDTO clienteAActualizarDto) {
        Cliente clienteDestino = obtenerClientePorIdentificacion(idCliente);
        Cliente clienteOrigen = dtoMapper.convertToEntity(clienteAActualizarDto, Cliente.class);
        modelMapper.map(clienteOrigen, clienteDestino);
        Cliente clienteActualizado = clienteRepositoryJPA.save(clienteDestino);
        return dtoMapper.convertToDTO(clienteActualizado, ClienteDTO.class);
    }

    @Override
    public void eliminar(Long idCliente) {
        Cliente clienteAEliminar = obtenerClientePorIdentificacion(idCliente);
        clienteAEliminar.setFechaEliminacion(LocalDateTime.now());
        clienteRepositoryJPA.save(clienteAEliminar);
    }

    private Cliente obtenerClientePorIdentificacion(Long idCliente) {
        return clienteRepositoryJPA.findById(idCliente)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
    }
}
