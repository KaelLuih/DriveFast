package com.example.DriveFast.domain.dto.locacao;

import java.math.BigDecimal;

public record LocacaoResponseDTO(Long id , Integer dias , BigDecimal valorTotal ,String NomeDoCliente,String ModeloVeiculo) {
    
}
