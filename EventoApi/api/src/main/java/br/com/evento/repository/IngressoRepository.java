package br.com.evento.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.evento.model.Ingresso;

@Repository
public interface IngressoRepository extends CrudRepository<Ingresso, Long>{

}
