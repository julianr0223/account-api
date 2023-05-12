package com.julianr0223.devsu.application.service.imp;

import com.julianr0223.devsu.application.service.ClienteService;
import com.julianr0223.devsu.application.service.utils.DTOMapper;
import com.julianr0223.devsu.domain.entity.Cliente;
import com.julianr0223.devsu.domain.repository.ClienteRepository;
import infrastructure.dto.ClienteDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImp implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DTOMapper dtoMapper;

    @Override
    public ClienteDTO crearCliente(ClienteDTO clienteACrearDto) {
        Cliente clienteACrear = dtoMapper.convertToEntity(clienteACrearDto, Cliente.class);
        Cliente clienteGuardado = clienteRepository.save(clienteACrear);
        return dtoMapper.convertToDTO(clienteGuardado, ClienteDTO.class);
    }

    @Override
    public ClienteDTO obtenerCliente(String identificacion) {
        Cliente cliente = obtenerClientePorIdentificacion(identificacion);
        return dtoMapper.convertToDTO(cliente, ClienteDTO.class);
    }

    @Override
    public List<ClienteDTO> obtenerClientes() {
        return clienteRepository.findAll().stream()
                .map(cliente -> dtoMapper.convertToDTO(cliente, ClienteDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO actualizarCliente(String identificacion, ClienteDTO clienteAActualizarDto) {
        Cliente clienteExistente = obtenerClientePorIdentificacion(identificacion);
        Cliente clienteAActualizar = dtoMapper.convertToEntity(clienteAActualizarDto, Cliente.class);
        modelMapper.map(clienteExistente, clienteAActualizar);
        Cliente clienteGuardado = clienteRepository.save(clienteExistente);
        return dtoMapper.convertToDTO(clienteGuardado, ClienteDTO.class);
    }

    @Override
    public void eliminarcliente(String identificacion) {
        Cliente clienteAEliminar = obtenerClientePorIdentificacion(identificacion);
        clienteAEliminar.setFechaEliminacion(LocalDateTime.now());
        clienteRepository.save(clienteAEliminar);
    }

    private Cliente obtenerClientePorIdentificacion(String identificacion) {
        return clienteRepository.findById(identificacion)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
    }
}
