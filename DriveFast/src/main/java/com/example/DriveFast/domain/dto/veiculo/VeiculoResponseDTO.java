package com.example.DriveFast.domain.dto.veiculo;

import java.math.BigDecimal;

public record VeiculoResponseDTO(

     Long id,   
     String marca,

     String modelo,

     String placa,

     BigDecimal valorDiaria,

     Boolean disponivel


) {
    
}
