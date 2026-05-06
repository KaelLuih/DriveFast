package com.example.DriveFast.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.DriveFast.domain.dto.cliente.ClienteCreateDTO;
import com.example.DriveFast.domain.dto.cliente.ClienteGastos;
import com.example.DriveFast.domain.dto.cliente.ClienteResponseDTO;
import com.example.DriveFast.model.Cliente;
import com.example.DriveFast.projection.GastoPorClienteProjection;

@Component
public class ClienteMapper {
    

    public Cliente toEntity(ClienteCreateDTO createDTO){
        return Cliente.builder()
         .nome(createDTO.nome())
         .cnh(createDTO.cnh())
         .email(createDTO.email())
        .build();
    }

    public ClienteResponseDTO toResponseDTO(Cliente cliente){
        return new ClienteResponseDTO(cliente.getId(), cliente.getNome(), cliente.getCnh(), cliente.getEmail());
    }

    public List<ClienteResponseDTO> toList(List<Cliente> clientes){
        return clientes.stream().map(this::toResponseDTO).toList();
    }
    
    public ClienteGastos toListgastos(GastoPorClienteProjection clientes){
        return new ClienteGastos(clientes.getNomeCliente(),clientes.getTotalGasto()) ;
    }
    
}
