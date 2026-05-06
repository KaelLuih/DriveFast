package com.example.DriveFast.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.DriveFast.domain.dto.mensagem.MensagemDTO;
import com.example.DriveFast.domain.dto.veiculo.VeiculoCreateDTO;
import com.example.DriveFast.domain.dto.veiculo.VeiculoResponseDTO;
import com.example.DriveFast.domain.dto.veiculo.VeiculoUpdateDTO;
import com.example.DriveFast.mapper.VeiculoMapper;
import com.example.DriveFast.model.Veiculo;
import com.example.DriveFast.repository.VeiculoRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VeiculoService {
    
    private final VeiculoRepository repository;
    private final VeiculoMapper mapper;


    public VeiculoResponseDTO save(VeiculoCreateDTO createDTO){
        Veiculo veiculo = mapper.toEntity(createDTO);
        veiculo = repository.save(veiculo);
        return mapper.toResponse(veiculo);
    }
    public List<VeiculoResponseDTO> lisrAll(){
        List<Veiculo> veiculos = repository.findAll();
        return mapper.toList(veiculos);
    }
    public VeiculoResponseDTO listById(Long id){
        Veiculo veiculo = repository.findById(id).orElseThrow(() -> new RuntimeException());
        return mapper.toResponse(veiculo);   
    }
    public VeiculoUpdateDTO atualizar(Long id, VeiculoUpdateDTO updateDTO) {
        Veiculo veiculo = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Veículo não encontrado com o ID: " + id));
    
        veiculo.setValorDiaria(updateDTO.valorDiaria());
    
        Veiculo veiculoSalvo = repository.save(veiculo);
    
        return new VeiculoUpdateDTO(veiculoSalvo.getValorDiaria());
    }
    public MensagemDTO deletar(Long id){
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Registro não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
        return new MensagemDTO("Carro removido com sucesso");

    }
}
