package br.com.evento.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Organizador extends Pessoa{
    private String cnpj;

    @OneToMany(mappedBy = "organizador", cascade = CascadeType.ALL)
    private List<Evento> eventos = new ArrayList<Evento>();
}
