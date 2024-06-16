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

import br.com.evento.model.Ingresso;
import br.com.evento.repository.IngressoRepository;

@RestController
@RequestMapping(value = "/ingresso")
public class IngressoController {

    @Autowired
    private IngressoRepository ingressoRepository;

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Ingresso> cadastrar(@RequestBody Ingresso ingresso){
        Ingresso ingressoSalvo = ingressoRepository.save(ingresso);

        return new ResponseEntity(ingressoSalvo, HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Ingresso>> getAll(){
        try{
            List<Ingresso> list = (List<Ingresso>)ingressoRepository.findAll();

            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity("No such ingresso", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<Ingresso> atualizar (@RequestBody Ingresso ingresso){
        Ingresso ingressoSalvo = ingressoRepository.save(ingresso);

        return new ResponseEntity<Ingresso>(ingressoSalvo, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public String apagar(@PathVariable(value = "id")Long id){
        ingressoRepository.deleteById(id);
        
        return "ok";
    }

}
