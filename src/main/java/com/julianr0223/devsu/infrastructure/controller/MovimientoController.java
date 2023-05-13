package com.julianr0223.devsu.infrastructure.controller;

import com.julianr0223.devsu.application.service.MovimientoService;
import com.julianr0223.devsu.domain.dto.MovimientoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {
    @Autowired
    private MovimientoService movimientoService;

    @PostMapping("/{idCuenta}")
    public ResponseEntity<MovimientoDTO> crearMovimiento(@PathVariable Long idCuenta, @RequestBody MovimientoDTO movimientoACrear) throws URISyntaxException {
        MovimientoDTO movimientoCreado = movimientoService.crearMovimiento(idCuenta, movimientoACrear);
        return ResponseEntity.created(new URI("/api/movimientos/" + movimientoCreado.getIdMovimiento())).body(movimientoCreado);
    }

    @GetMapping("/{idMovimiento}")
    public ResponseEntity<MovimientoDTO> obtenerMovimiento(@PathVariable Long idMovimiento) {
        MovimientoDTO movimiento = movimientoService.obtenerMovimiento(idMovimiento);
        return ResponseEntity.ok(movimiento);
    }

    @GetMapping
    public ResponseEntity<List<MovimientoDTO>> obtenerMovimientos() {
        List<MovimientoDTO> movimientos = movimientoService.obtenerMovimientos();
        return ResponseEntity.ok(movimientos);
    }

    @PutMapping("/{idMovimiento}")
    public ResponseEntity<MovimientoDTO> actualizarMovimiento(@PathVariable Long idMovimiento, @RequestBody MovimientoDTO movimientoAActualizar) {
        MovimientoDTO movimientoActualiazado = movimientoService.actualizarMovimiento(idMovimiento, movimientoAActualizar);
        return ResponseEntity.ok(movimientoActualiazado);
    }

    @DeleteMapping(("/{idMovimiento}"))
    public ResponseEntity<Void> eliminarMovimiento(@PathVariable Long idMovimiento) {
        movimientoService.eliminarMovimiento(idMovimiento);
        return ResponseEntity.noContent().build();
    }
}
