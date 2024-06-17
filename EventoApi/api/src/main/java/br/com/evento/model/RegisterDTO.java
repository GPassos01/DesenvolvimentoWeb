package br.com.evento.model;

import java.time.LocalDate;

public record RegisterDTO(String login, 
        String senha, 
        String nome, 
        UserRole role,
        String telefone,
        Endereco endereco,
        String cpf,
        LocalDate data_nascimento,
        String cnpj) {

}
