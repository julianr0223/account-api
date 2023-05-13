package com.julianr0223.devsu.application.service;

import com.julianr0223.devsu.domain.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {
    ClienteDTO crearCliente(ClienteDTO cliente);
    ClienteDTO obtenerCliente(Long  idCliente);
    List<ClienteDTO> obtenerClientes();
    ClienteDTO actualizarCliente(Long  idCliente, ClienteDTO cliente);
    void eliminarcliente(Long idCliente);
}
