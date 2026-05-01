package com.example.DriveFast.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.DriveFast.model.Locacao;
@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long>{

        @Query("""
                SELECT l 
                FROM locacao
                WHERE l.cliente.id =:clienteId
                """)
                List<Locacao> findByClienteId(@Param("id")Long id);


}
