package br.com.evento.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@DiscriminatorValue("Cliente")
public class Cliente extends Usuario {
    private String cpf;
    private LocalDate data_nascimento;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Compra> compras;

    public Cliente(String login, String senha, String nome, UserRole role, Endereco endereco, String telefone, String cpf, LocalDate data){
        super();
        setLogin(login);
        setSenha(senha);
        setNome(nome);
        setRole(role);
        setEndereco(endereco);
        setTelefone(telefone);
        this.cpf = cpf;
        this.data_nascimento = data;
    }
    public Cliente(){

    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
}
