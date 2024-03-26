package br.com.evento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ingresso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer quantidade_disponivel;
    private Double preco;
    private String qrcode;
    private String tipo;
    private String sertor;

    @ManyToOne
    @JoinColumn(name = "evento_id", referencedColumnName = "id")
    private Evento evento;
}
