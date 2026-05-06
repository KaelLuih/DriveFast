package com.example.DriveFast.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.DriveFast.domain.dto.cliente.ClienteCreateDTO;
import com.example.DriveFast.domain.dto.cliente.ClienteGastos;
import com.example.DriveFast.domain.dto.cliente.ClienteResponseDTO;
import com.example.DriveFast.domain.dto.cliente.ClienteUpdateDTO;
import com.example.DriveFast.domain.dto.mensagem.MensagemDTO;
import com.example.DriveFast.mapper.ClienteMapper;
import com.example.DriveFast.model.Cliente;
import com.example.DriveFast.repository.ClienteRepository;

import jakarta.persistence.EntityNotFoundException;
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
    public ClienteResponseDTO listById(Long id){
        Cliente cliente = repository.findById(id).orElseThrow(()-> new RuntimeException());
        return mapper.toResponseDTO(cliente);
    }

    public ClienteUpdateDTO atualizar(Long id,ClienteUpdateDTO updateDTO ){
        Cliente cliente = repository.findById(id).orElseThrow(()-> new RuntimeException());
        cliente.setNome(updateDTO.nome());
        cliente.setEmail(updateDTO.email());
        Cliente clienteAtualizado = repository.save(cliente);
        return new ClienteUpdateDTO(clienteAtualizado.getNome(), clienteAtualizado.getEmail());

    }
    public MensagemDTO deletar(Long id){
       if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Cliente nao encontrado");
       } 
       repository.deleteById(id);
       return new MensagemDTO("Cliente removido com sucesso");
    }
    public List<ClienteGastos>totalGastos(){
        return  repository.buscarTotalGastoPorClientes().stream().map(mapper::toListgastos).toList();
    }

}
