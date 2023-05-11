package com.julianr0223.devsu.presentation.controller;

import com.julianr0223.devsu.application.service.ClienteService;
import com.julianr0223.devsu.domain.entity.Cliente;
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
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) throws URISyntaxException {
        Cliente clienteCreado = clienteService.crearCliente(cliente);
        return ResponseEntity.created(new URI("/api/clientes/" + clienteCreado.getIdentificacion())).body(clienteCreado);
    }

    @GetMapping("/{identificacion}")
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable String identificacion) {
        Cliente cliente = clienteService.obtenerCliente(identificacion);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> obtenerClientes() {
        List<Cliente> clientes = clienteService.obtenerClientes();
        return ResponseEntity.ok(clientes);
    }

    @PutMapping("/{identificacion}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable String identificacion, @RequestBody Cliente clienteAActualizar) {
        Cliente clienteActualizado = clienteService.actualizarCliente(identificacion, clienteAActualizar);
        return ResponseEntity.ok(clienteActualizado);
    }

    @DeleteMapping(("/{identificacion}"))
    public ResponseEntity<Void> eliminarCliente(@PathVariable String identificacion) {
        clienteService.eliminarcliente(identificacion);
        return ResponseEntity.noContent().build();
    }
}
