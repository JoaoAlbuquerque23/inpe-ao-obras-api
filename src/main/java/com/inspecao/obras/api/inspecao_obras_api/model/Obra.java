package com.inspecao.obras.api.inspecao_obras_api.model;

import com.inspecao.obras.api.inspecao_obras_api.constants.Periodicidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name= "TB.OBRAS")
public class Obra {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @Column(nullable = false)
   public String nome;

   public String endereco;
   
   @Column(nullable = false)
   @Enumerated(EnumType.STRING)
   public Periodicidade periodoinspecoes;


}
