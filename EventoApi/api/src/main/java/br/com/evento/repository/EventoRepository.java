package br.com.evento.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.evento.model.Evento;

@Repository
public interface EventoRepository extends CrudRepository<Evento, Long>{

}
