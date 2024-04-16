package br.com.evento.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.evento.model.Organizador;

@Repository
public interface OrganizadorRepository extends CrudRepository<Organizador, Long>{

}
