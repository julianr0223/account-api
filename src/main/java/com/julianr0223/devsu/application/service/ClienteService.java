package com.julianr0223.devsu.application.service;

import com.julianr0223.devsu.domain.entity.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente crearCliente(Cliente cliente);
    Cliente obtenerCliente(String identificacion);
    List<Cliente> obtenerClientes();
    Cliente actualizarCliente(String identificacion, Cliente cliente);
    void eliminarcliente(String identificacion);
}
