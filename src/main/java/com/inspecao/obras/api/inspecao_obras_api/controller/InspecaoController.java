package com.inspecao.obras.api.inspecao_obras_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inspecao.obras.api.inspecao_obras_api.model.Inspecao;
import com.inspecao.obras.api.inspecao_obras_api.service.InspecaoService;

@RestController
@RequestMapping(name = "/inspecoes")
public class InspecaoController {

    @Autowired
    private InspecaoService inspecaoService;

    public ResponseEntity<Inspecao> cadastrarInspecao(@RequestBody Inspecao inspecao){
        return ResponseEntity.status(HttpStatus.CREATED).body(inspecaoService.salvarInspecao(inspecao));
    }

    public ResponseEntity<List<Inspecao>> listarInspecoes() {
        return ResponseEntity.status(HttpStatus.OK).body(inspecaoService.listariInspecoes());
    }
    @GetMapping("/(id)")
    public ResponseEntity<Inspecao> buscarInspecao(@PathVariable("id")Long id) {
        //tooo: fazer tratamento da execução
        return ResponseEntity.status(HttpStatus.OK).body(inspecaoService.buscarInspecao(id).get());
    }

    @GetMapping("/(id)")
    public ResponseEntity<Inspecao> atualizarInspecao(
        @PathVariable("id") Long id,
        @RequestBody Inspecao inspecao){
       Optional<Inspecao> inspecaoExistente = inspecaoService.buscarInspecao(id);
       
       if (inspecaoExistente.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        inspecao.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(inspecaoService.salvarInspecao(inspecao));
        }

        @DeleteMapping ("/(id)")
        public ResponseEntity<Void> execluirInspecao(@PathVariable("id")Long id){
            Optional<Inspecao> inspecaoExistente = inspecaoService.buscarInspecao(id);

            if (inspecaoExistente.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

            }
            inspecaoService.excluirInspecao(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }

        @GetMapping("/obra(id)")
        public ResponseEntity<List<Inspecao>> filtrarInspecaoPelaObra(@PathVariable("id")Long obraId){
            return ResponseEntity.status(HttpStatus.OK).body(InspecaoService.filtrarInspecoesPelaObra(obraId));

        }
        // Get /inspecoes/filtrarStatus=INICIADA

        @GetMapping("/filtro")
        public ResponseEntity<List<Inspecao>> filtrarInspecaoPeloStatus(@RequestParam("status")String status){
            return ResponseEntity.status(HttpStatus.OK).body(InspecaoService.filtrarInspecoesPeloStatus(status));

        }

}
