package com.example.DriveFast.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DriveFast.domain.dto.locacao.LocacaoCreateDTO;
import com.example.DriveFast.domain.dto.locacao.LocacaoResponseDTO;
import com.example.DriveFast.domain.dto.mensagem.MensagemDTO;
import com.example.DriveFast.service.LocacaoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/locacoes") 
@RequiredArgsConstructor
public class LocacaoController {

    private final LocacaoService service;

    @PostMapping
    public ResponseEntity<LocacaoResponseDTO> save(@RequestBody LocacaoCreateDTO createDTO) {
        LocacaoResponseDTO response = service.save(createDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<LocacaoResponseDTO>> listAll() {
        List<LocacaoResponseDTO> response = service.listAll();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemDTO> delete(@PathVariable Long id) {
        MensagemDTO response = service.Deletar(id);
        return ResponseEntity.ok(response);
    }
}