package br.com.evento.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.evento.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
    @Query("SELECT u FROM Usuario u WHERE u.login = ?1")
    Usuario findByLogin(String login);
}
