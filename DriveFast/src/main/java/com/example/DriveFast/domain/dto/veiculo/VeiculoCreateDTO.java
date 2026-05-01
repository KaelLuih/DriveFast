package com.example.DriveFast.domain.dto.veiculo;

import java.math.BigDecimal;

public record VeiculoCreateDTO(
    
    String marca,

     String modelo,

     String placa,

     BigDecimal valorDiaria,

     Boolean disponivel
    
    ) {
    
}
