package br.com.evento.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.deser.std.NumberDeserializers.LongDeserializer;

import br.com.evento.model.Usuario;
import br.com.evento.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
public class IndexController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // @GetMapping(value = "/", produces = "application/json")
    // public ResponseEntity init(@RequestParam(value = "nome", required = false) String nome, @RequestParam(value = "login", defaultValue = "sem valor") String login, @RequestParam(value = "salario", defaultValue = "sem salario") String salario){
    //     return new ResponseEntity("Olá mundo: " + nome + " - Login: " + login + " - Salario: " + salario, HttpStatus.OK);
    // }

    @GetMapping(value = "/get")
    public ResponseEntity init2(){
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Jose");
        usuario.setLogin("josee");
        usuario.setSenha("123");
        return new ResponseEntity(usuario, HttpStatus.OK);
    }

    @GetMapping(value = "/get2", produces = "application/json")
    public ResponseEntity init3(){
        Usuario usuario1 = new Usuario();
        usuario1.setId(1L);
        usuario1.setNome("Jose");
        usuario1.setLogin("josee");
        usuario1.setSenha("123");

        Usuario usuario2 = new Usuario();
        usuario2.setId(2L);
        usuario2.setNome("João");
        usuario2.setLogin("joao51");
        usuario2.setSenha("456");

        List<Usuario> list = new ArrayList<Usuario>();
        list.add(usuario1);
        list.add(usuario2);

        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Usuario> get(@PathVariable(value = "id") Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        return new ResponseEntity(usuario.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Usuario>> getAll(){
        try{
            List<Usuario> list = (List<Usuario>)usuarioRepository.findAll();
    
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity("no such user", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}/relatorio/{dias}", produces = "application/json")
    public ResponseEntity relatorio(@PathVariable(value = "id")Long id, 
                                    @PathVariable(value = "dias")Long dias){
        return new ResponseEntity("Relatório do usuário " + id + " para os " + dias + " dias anteriores", HttpStatus.OK);
    }

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return new ResponseEntity(usuarioSalvo, HttpStatus.OK);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<Usuario> atualizar (@RequestBody Usuario usuario){
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = "application/text")
    public String apagar(@PathVariable(value = "id")Long id){
        usuarioRepository.deleteById(id);
        return "ok";
    }
}


