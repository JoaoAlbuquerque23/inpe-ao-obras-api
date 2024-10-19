package com.inspecao.obras.api.inspecao_obras_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inspecao.obras.api.inspecao_obras_api.model.Inspecao;

@Repository
public interface InspecaoRepository extends JpaRepository<Inspecao, Long> {
    List<Inspecao> findByObra_Id(long id);

    List<Inspecao> findByStatus(String status);
     

    

    
}
