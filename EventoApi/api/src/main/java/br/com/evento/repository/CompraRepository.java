package br.com.evento.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.evento.model.Compra;

@Repository
public interface CompraRepository extends CrudRepository<Compra, Long>{

}
