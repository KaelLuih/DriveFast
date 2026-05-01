package com.example.DriveFast.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DriveFast.model.Veiculo;
@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo,Long > {
    
    List<Veiculo> findByDisponibilidadeTrue();

}
