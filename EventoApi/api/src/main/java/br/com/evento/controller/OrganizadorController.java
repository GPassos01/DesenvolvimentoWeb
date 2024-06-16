package br.com.evento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.evento.model.Organizador;
import br.com.evento.repository.OrganizadorRepository;

@RestController
@RequestMapping(value = "/organizador")
public class OrganizadorController {

    @Autowired
    private OrganizadorRepository organizadorRepository;

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Organizador> cadastrar(@RequestBody Organizador organizador){
        Organizador organizadorSalvo = organizadorRepository.save(organizador);

        return new ResponseEntity(organizadorSalvo, HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Organizador>> getAll(){
        try{
            List<Organizador> list = (List<Organizador>)organizadorRepository.findAll();

            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity("No such organizador", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<Organizador> atualizar (@RequestBody Organizador organizador){
        Organizador organizadorSalvo = organizadorRepository.save(organizador);

        return new ResponseEntity<Organizador>(organizadorSalvo, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public String apagar(@PathVariable(value = "id")Long id){
        organizadorRepository.deleteById(id);
        
        return "ok";
    }

}
