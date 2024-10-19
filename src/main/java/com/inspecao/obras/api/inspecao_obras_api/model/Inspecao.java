package com.inspecao.obras.api.inspecao_obras_api.model;


import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inspecao.obras.api.inspecao_obras_api.constants.InspecaoStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity(name = "TB.INPECOES")
public class Inspecao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public InspecaoStatus status;
    
    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    public LocalDateTime datahora;

    @ManyToOne
    @JoinColumn(nullable = false)
    public Obra obra;

}
