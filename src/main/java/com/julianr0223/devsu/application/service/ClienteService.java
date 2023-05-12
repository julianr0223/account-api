package com.julianr0223.devsu.application.service;

import infrastructure.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {
    ClienteDTO crearCliente(ClienteDTO cliente);
    ClienteDTO obtenerCliente(String identificacion);
    List<ClienteDTO> obtenerClientes();
    ClienteDTO actualizarCliente(String identificacion, ClienteDTO cliente);
    void eliminarcliente(String identificacion);
}
