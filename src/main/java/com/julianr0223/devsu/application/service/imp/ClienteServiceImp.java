package com.julianr0223.devsu.application.service.imp;

import com.julianr0223.devsu.application.service.ClienteService;
import com.julianr0223.devsu.domain.entity.Cliente;
import com.julianr0223.devsu.domain.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente obtenerCliente(String identificacion) {
        return clienteRepository.findById(identificacion)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente actualizarCliente(String identificacion, Cliente clienteAActualizar) {
        Cliente clienteExistente = this.obtenerCliente(identificacion);

        modelMapper.map(clienteAActualizar, clienteExistente);
        return clienteRepository.save(clienteExistente);
    }

    @Override
    public void eliminarcliente(String identificacion) {
        Cliente clienteAEliminar = obtenerCliente(identificacion);
        clienteAEliminar.setFechaEliminacion(LocalDateTime.now());
        clienteRepository.save(clienteAEliminar);
    }
}
