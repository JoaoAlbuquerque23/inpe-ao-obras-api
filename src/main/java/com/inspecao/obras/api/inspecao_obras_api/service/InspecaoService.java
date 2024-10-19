package com.inspecao.obras.api.inspecao_obras_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspecao.obras.api.inspecao_obras_api.model.Inspecao;
import com.inspecao.obras.api.inspecao_obras_api.repository.InspecaoRepository;

@Service
public class InspecaoService {
   
    @Autowired
    private static InspecaoRepository inspecaoRepository;

    public Inspecao salvarInspecao(Inspecao inspecao){
        return inspecaoRepository.save(inspecao);
    }

   
   
    public List<Inspecao> listariInspecoes(){
        return inspecaoRepository.findAll();
    }

    public Optional<Inspecao> buscarInspecao(Long id){
        return inspecaoRepository.findById(id);
    }

    public void excluirInspecao(Long id){
       inspecaoRepository.deleteById(id);

    }
    public static List<Inspecao> filtrarInspecoesPelaObra(Long obraId){
        return inspecaoRepository.findByObra_Id(obraId);

    }
    public static List<Inspecao> filtrarInspecoesPeloStatus(String status){
        return inspecaoRepository.findByStatus(status);
    }


    
}
