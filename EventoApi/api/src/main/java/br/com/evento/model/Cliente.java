package br.com.evento.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cliente extends Pessoa {
    private String cpf;
    private LocalDate data_nascimento;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Carrinho> carrinho;
}
