package br.com.evento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.evento.model.Endereco;
import br.com.evento.repository.EnderecoRepository;

@RestController
@RequestMapping(value = "/local")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Endereco>> getAll(){
        try{
            List<Endereco> list = (List<Endereco>)enderecoRepository.findAll();

            return new ResponseEntity<>(list, HttpStatus.OK)
        }
        catch(Exception ex){
            return new ResponseEntity(body:"No such endereco", HttpStatus.NOT_FOUND)
        }
    }
}
