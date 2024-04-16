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

import br.com.evento.model.Endereco;
import br.com.evento.repository.EnderecoRepository;

@RestController
@RequestMapping(value = "/local")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Endereco> cadastrar(@RequestBody Endereco endereco){
        Endereco enderecoSalvo = enderecoRepository.save(endereco);

        return new ResponseEntity(enderecoSalvo, HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Endereco>> getAll(){
        try{
            List<Endereco> list = (List<Endereco>)enderecoRepository.findAll();

            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity("No such endereco", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<Endereco> atualizar (@RequestBody Endereco endereco){
        Endereco enderecoSalvo = enderecoRepository.save(endereco);

        return new ResponseEntity<Endereco>(enderecoSalvo, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public String apagar(@PathVariable(value = "id")Long id){
        enderecoRepository.deleteById(id);
        
        return "ok";
    }

}
