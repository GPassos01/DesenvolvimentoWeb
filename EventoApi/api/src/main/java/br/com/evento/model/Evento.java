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
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
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

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public LocalTime getHorario_inicio() {
        return horario_inicio;
    }
    public void setHorario_inicio(LocalTime horario_inicio) {
        this.horario_inicio = horario_inicio;
    }
    public LocalTime getHorario_fim() {
        return horario_fim;
    }
    public void setHorario_fim(LocalTime horario_fim) {
        this.horario_fim = horario_fim;
    }
    public EClassificacaoIndicativa getClassificacao_indicativa() {
        return classificacao_indicativa;
    }
    public void setClassificacao_indicativa(EClassificacaoIndicativa classificacao_indicativa) {
        this.classificacao_indicativa = classificacao_indicativa;
    }
    public Integer getLotacao_maxima() {
        return lotacao_maxima;
    }
    public void setLotacao_maxima(Integer lotacao_maxima) {
        this.lotacao_maxima = lotacao_maxima;
    }
}
