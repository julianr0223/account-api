package com.julianr0223.devsu.infrastructure.controller;

import com.julianr0223.devsu.application.service.CuentaService;
import com.julianr0223.devsu.domain.dto.CuentaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {
    @Autowired
    private CuentaService cuentaService;

    @PostMapping("/{idCliente}")
    public ResponseEntity<CuentaDTO> crearCCuenta(@PathVariable Long idCliente,  @RequestBody CuentaDTO cuentaACrear) throws URISyntaxException {
        CuentaDTO cuentaCreada = cuentaService.crearCuenta(idCliente, cuentaACrear);
        return ResponseEntity.created(new URI("/api/cuentas/" + cuentaCreada.getNumeroCuenta())).body(cuentaCreada);
    }

    @GetMapping("/{idCuenta}")
    public ResponseEntity<CuentaDTO> obtenerCuenta(@PathVariable Long idCuenta) {
        CuentaDTO cuenta = cuentaService.obtenerCuenta(idCuenta);
        return ResponseEntity.ok(cuenta);
    }

    @GetMapping
    public ResponseEntity<List<CuentaDTO>> obtenerCuentas() {
        List<CuentaDTO> clientes = cuentaService.obtenerCuentas();
        return ResponseEntity.ok(clientes);
    }

    @PutMapping("/{idCuenta}")
    public ResponseEntity<CuentaDTO> actualizarCuenta(@PathVariable Long idCuenta, @RequestBody CuentaDTO cuentaAActualizar) {
        CuentaDTO cuentaActualizada = cuentaService.actualizarCuenta(idCuenta, cuentaAActualizar);
        return ResponseEntity.ok(cuentaActualizada);
    }

    @DeleteMapping(("/{idCuenta}"))
    public ResponseEntity<Void> eliminarCuenta(@PathVariable Long idCuenta) {
        cuentaService.eliminarCuenta(idCuenta);
        return ResponseEntity.noContent().build();
    }
}
