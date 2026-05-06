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

import com.example.DriveFast.domain.dto.mensagem.MensagemDTO;
import com.example.DriveFast.domain.dto.veiculo.VeiculoCreateDTO;
import com.example.DriveFast.domain.dto.veiculo.VeiculoResponseDTO;
import com.example.DriveFast.domain.dto.veiculo.VeiculoUpdateDTO;
import com.example.DriveFast.service.VeiculoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/veiculo")
@RequiredArgsConstructor
public class VeiculoController {
    
    private final VeiculoService service;

    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> create(@RequestBody VeiculoCreateDTO createDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(createDTO));
    }
    @GetMapping
    public ResponseEntity<List<VeiculoResponseDTO>> listAll(){
        return ResponseEntity.ok(service.lisrAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> listById(@PathVariable Long id){
        return ResponseEntity.ok(service.listById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoUpdateDTO> update(@PathVariable Long id, @RequestBody VeiculoUpdateDTO updateDTO){
        return ResponseEntity.ok(service.atualizar(id, updateDTO));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.deletar(id));
    }


}
