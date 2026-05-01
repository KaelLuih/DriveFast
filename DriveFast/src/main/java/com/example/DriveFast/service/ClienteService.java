package com.example.DriveFast.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.DriveFast.domain.dto.cliente.ClienteCreateDTO;
import com.example.DriveFast.domain.dto.cliente.ClienteResponseDTO;
import com.example.DriveFast.mapper.ClienteMapper;
import com.example.DriveFast.model.Cliente;
import com.example.DriveFast.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
    
    private final ClienteRepository repository;
    private final ClienteMapper mapper;



    public ClienteResponseDTO save(ClienteCreateDTO createDTO){
        Cliente cliente = mapper.toEntity(createDTO);
        cliente = repository.save(cliente);
        return mapper.toResponseDTO(cliente);
    }
    public List<ClienteResponseDTO> listAll(){
        List<Cliente>clientes = repository.findAll();
        return mapper.toList(clientes);
    }

}
