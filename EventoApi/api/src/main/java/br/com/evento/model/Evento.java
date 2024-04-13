package br.com.evento.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String descricao;
    private LocalDate data;
    private LocalTime horario_inicio;
    private LocalTime horario_fim;
    private EClassificacaoIndicativa classificacao_indicativa;
    private Integer lotacao_maxima;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "organizador_id", referencedColumnName = "id")
    private Organizador organizador;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private List<Ingresso> ingressos = new ArrayList<Ingresso>();
}
