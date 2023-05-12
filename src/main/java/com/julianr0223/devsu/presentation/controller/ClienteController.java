package com.julianr0223.devsu.presentation.controller;

import com.julianr0223.devsu.application.service.ClienteService;
import infrastructure.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> crearCliente(@RequestBody ClienteDTO clienteAActualizarDto) throws URISyntaxException {
        ClienteDTO clienteCreado = clienteService.crearCliente(clienteAActualizarDto);
        return ResponseEntity.created(new URI("/api/clientes/" + clienteCreado.getIdentificacion())).body(clienteCreado);
    }

    @GetMapping("/{identificacion}")
    public ResponseEntity<ClienteDTO> obtenerCliente(@PathVariable String identificacion) {
        ClienteDTO cliente = clienteService.obtenerCliente(identificacion);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> obtenerClientes() {
        List<ClienteDTO> clientes = clienteService.obtenerClientes();
        return ResponseEntity.ok(clientes);
    }

    @PutMapping("/{identificacion}")
    public ResponseEntity<ClienteDTO> actualizarCliente(@PathVariable String identificacion, @RequestBody ClienteDTO clienteAActualizar) {
        ClienteDTO clienteActualizado = clienteService.actualizarCliente(identificacion, clienteAActualizar);
        return ResponseEntity.ok(clienteActualizado);
    }

    @DeleteMapping(("/{identificacion}"))
    public ResponseEntity<Void> eliminarCliente(@PathVariable String identificacion) {
        clienteService.eliminarcliente(identificacion);
        return ResponseEntity.noContent().build();
    }
}
