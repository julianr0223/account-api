package com.julianr0223.devsu.infrastructure.controller;

import com.julianr0223.devsu.application.service.ClienteService;
import com.julianr0223.devsu.domain.dto.ClienteDTO;
import com.julianr0223.devsu.domain.exception.ClienteNoEncontradoException;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @Test
    void obtenerClienteNotFound() throws Exception {
        Long clienteId = 123L;

        BDDMockito.given(clienteService.obtenerCliente(clienteId)).willThrow(new ClienteNoEncontradoException("Cliente no encontrado"));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/clientes" + clienteId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}