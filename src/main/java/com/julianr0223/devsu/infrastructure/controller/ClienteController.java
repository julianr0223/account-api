package com.julianr0223.devsu.infrastructure.controller;

import com.julianr0223.devsu.application.service.ClienteService;
import com.julianr0223.devsu.domain.dto.ClienteDTO;
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

    @GetMapping("/{idCliente}")
    public ResponseEntity<ClienteDTO> obtenerCliente(@PathVariable Long idCliente) {
        ClienteDTO cliente = clienteService.obtenerCliente(idCliente);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> obtenerClientes() {
        List<ClienteDTO> clientes = clienteService.obtenerClientes();
        return ResponseEntity.ok(clientes);
    }

    @PutMapping("/{idCliente}")
    public ResponseEntity<ClienteDTO> actualizarCliente(@PathVariable Long idCliente, @RequestBody ClienteDTO clienteAActualizar) {
        ClienteDTO clienteActualizado = clienteService.actualizarCliente(idCliente, clienteAActualizar);
        return ResponseEntity.ok(clienteActualizado);
    }

    @DeleteMapping(("/{idCliente}"))
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long idCliente) {
        clienteService.eliminarcliente(idCliente);
        return ResponseEntity.noContent().build();
    }
}
