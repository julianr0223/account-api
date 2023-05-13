package com.julianr0223.devsu.domain.repository;


import com.julianr0223.devsu.domain.dto.ClienteDTO;

import java.util.List;


public interface ClienteRepository {
    ClienteDTO crear(ClienteDTO cliente);

    ClienteDTO buscarPorIdentificador(Long idCliente);

    List<ClienteDTO> obtenerTodos();

    void eliminar(Long idCliente);

    ClienteDTO actualizar(Long idCliente, ClienteDTO clienteAActualizarDto);
}
