package com.example.DriveFast.mapper;

import org.springframework.stereotype.Component;

import com.example.DriveFast.domain.dto.locacao.LocacaoResponseDTO;
import com.example.DriveFast.model.Locacao;

@Component
public class LocacaoMapper {
    

    public LocacaoResponseDTO toResponse(Locacao locacao){
        return new LocacaoResponseDTO(locacao.getId(), locacao.getDias(), locacao.getValorTotal(), locacao.getCliente().getNome(), locacao.getVeiculo().getModelo());
    }

}
