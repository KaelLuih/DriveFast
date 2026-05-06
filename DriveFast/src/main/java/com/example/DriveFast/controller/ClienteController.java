package com.example.DriveFast.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DriveFast.domain.dto.cliente.ClienteCreateDTO;
import com.example.DriveFast.domain.dto.cliente.ClienteGastos;
import com.example.DriveFast.domain.dto.cliente.ClienteResponseDTO;
import com.example.DriveFast.domain.dto.cliente.ClienteUpdateDTO;
import com.example.DriveFast.domain.dto.mensagem.MensagemDTO;
import com.example.DriveFast.service.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> save(@RequestBody ClienteCreateDTO createDTO) {
        ClienteResponseDTO response = service.save(createDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listAll() {
        List<ClienteResponseDTO> response = service.listAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> listById(@PathVariable Long id) {
        ClienteResponseDTO response = service.listById(id);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/gastos")
    public ResponseEntity<List<ClienteGastos>> totalGastos() {
        List<ClienteGastos> response = service.totalGastos();
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ClienteUpdateDTO> atualizar(@PathVariable Long id, @RequestBody ClienteUpdateDTO updateDTO) {
        ClienteUpdateDTO response = service.atualizar(id, updateDTO);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemDTO> deletar(@PathVariable Long id) {
        MensagemDTO response = service.deletar(id);
        return ResponseEntity.ok(response);
    }
}