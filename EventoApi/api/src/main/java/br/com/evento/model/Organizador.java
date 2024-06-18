package br.com.evento.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("Organizador")
public class Organizador extends Usuario{
    private String cnpj;
    
    public Organizador(String login, String senha, String nome, UserRole role, Endereco endereco, String telefone, String cnpj){
        super();
        setLogin(login);
        setSenha(senha);
        setNome(nome);
        setRole(role);
        setEndereco(endereco);
        setTelefone(telefone);
        this.cnpj = cnpj;
    }

    public Organizador(){

    }
    
    @OneToMany(mappedBy = "organizador", cascade = CascadeType.ALL)
    private List<Evento> eventos = new ArrayList<Evento>();

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}
