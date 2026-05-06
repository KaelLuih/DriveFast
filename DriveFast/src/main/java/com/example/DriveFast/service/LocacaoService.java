package com.example.DriveFast.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.DriveFast.domain.dto.locacao.LocacaoCreateDTO;
import com.example.DriveFast.domain.dto.locacao.LocacaoResponseDTO;
import com.example.DriveFast.domain.dto.mensagem.MensagemDTO;
import com.example.DriveFast.mapper.LocacaoMapper;
import com.example.DriveFast.model.Cliente;
import com.example.DriveFast.model.Locacao;
import com.example.DriveFast.model.Veiculo;
import com.example.DriveFast.repository.ClienteRepository;
import com.example.DriveFast.repository.LocacaoRepository;
import com.example.DriveFast.repository.VeiculoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocacaoService {
    
    private final LocacaoRepository repository;
    private final LocacaoMapper mapper;
    private final VeiculoRepository veiculoRepository;
    private final ClienteRepository clienteRepository;

    public LocacaoResponseDTO save(LocacaoCreateDTO createDTO){
       
        Veiculo veiculo = veiculoRepository.findById(createDTO.veiculoId())
        .orElseThrow(() -> new RuntimeException());
        
        Cliente cliente = clienteRepository.findById(createDTO.clienteId())
        .orElseThrow(() -> new RuntimeException());

        BigDecimal valorTotal = veiculo.getValorDiaria().multiply(BigDecimal.valueOf(createDTO.dias()));

        Locacao locacao = Locacao.builder()
                .cliente(cliente)
                .veiculo(veiculo)
                .dias(createDTO.dias())
                .valorTotal(valorTotal)
                .build();
                
        veiculo.setDisponivel(false);
        veiculoRepository.save(veiculo); 
        
        Locacao locacaoSalva = repository.save(locacao);
        
        return mapper.toResponse(locacaoSalva);
    
    }
    public List<LocacaoResponseDTO> listAll(){
        List<Locacao> locacaos = repository.findAll();
        return mapper.toList(locacaos);
    }
    public MensagemDTO Deletar(Long id){
        if(!repository.existsById(id)){
            throw new RuntimeException("Locacao nao encontrada");
        }
        repository.deleteById(id);
        return new MensagemDTO("Veículo \r\n" + //
                        "devolvido e locação encerrada!\"\r\n" + //
                        "");
    } 


}
