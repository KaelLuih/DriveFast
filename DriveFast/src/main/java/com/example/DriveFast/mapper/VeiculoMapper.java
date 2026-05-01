package com.example.DriveFast.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.DriveFast.domain.dto.veiculo.VeiculoCreateDTO;
import com.example.DriveFast.domain.dto.veiculo.VeiculoResponseDTO;
import com.example.DriveFast.model.Veiculo;

@Component
public class VeiculoMapper {
   


    public Veiculo toEntity(VeiculoCreateDTO createDTO){
        return Veiculo.builder()
        .marca(createDTO.marca())
        .modelo(createDTO.modelo())
        .placa(createDTO.placa())
        .valorDiaria(createDTO.valorDiaria())
        .disponivel(createDTO.disponivel()).build();

    }

    public VeiculoResponseDTO toResponse(Veiculo veiculo){
        return new VeiculoResponseDTO(
        veiculo.getId(), veiculo.getMarca(), 
        veiculo.getModelo(),veiculo.getPlaca(), 
        veiculo.getValorDiaria(), 
      veiculo.getDisponivel());
    }


    public List<VeiculoResponseDTO> toList(List<Veiculo> veiculos){
        return veiculos.stream().map(this::toResponse).toList();
    }
}
