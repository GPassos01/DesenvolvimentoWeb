package br.com.evento.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate data;
    private Double total;
    private String forma_pagamento;
    private String status;

    @OneToOne
    @JoinColumn(name = "carrinho_id", referencedColumnName = "id")
    private Carrinho carrinho;
}
