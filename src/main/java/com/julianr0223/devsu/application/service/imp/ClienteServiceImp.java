package com.julianr0223.devsu.application.service.imp;

import com.julianr0223.devsu.application.service.ClienteService;
import com.julianr0223.devsu.domain.dto.ClienteDTO;
import com.julianr0223.devsu.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClienteDTO crearCliente(ClienteDTO clienteACrearDto) {
        return clienteRepository.crear(clienteACrearDto);
    }

    @Override
    public ClienteDTO obtenerCliente(Long idCliente) {
        return clienteRepository.buscarPorIdentificador(idCliente);
    }

    @Override
    public List<ClienteDTO> obtenerClientes() {
        return clienteRepository.obtenerTodos();
    }

    @Override
    public ClienteDTO actualizarCliente(Long idCliente, ClienteDTO clienteAActualizarDto) {
        return clienteRepository.actualizar(idCliente, clienteAActualizarDto);
    }

    @Override
    public void eliminarcliente(Long idCliente) {
        clienteRepository.eliminar(idCliente);
    }
}
