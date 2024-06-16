package br.com.evento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Ingresso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer quantidade_disponivel;
    private Double preco;
    private String tipo;
    private String sertor;

    @ManyToOne
    @JoinColumn(name = "evento_id", referencedColumnName = "id")
    private Evento evento;

    @OneToOne
    @JoinColumn(name = "compra_id", referencedColumnName = "id")
    private Compra compra;

    public Integer getQuantidade_disponivel() {
        return quantidade_disponivel;
    }
    public void setQuantidade_disponivel(Integer quantidade_disponivel) {
        this.quantidade_disponivel = quantidade_disponivel;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getSertor() {
        return sertor;
    }
    public void setSertor(String sertor) {
        this.sertor = sertor;
    }
}
