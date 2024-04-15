package br.com.evento.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.evento.model.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long>{
}
