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

import br.com.evento.model.Cliente;
import br.com.evento.repository.ClienteRepository;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente){
        Cliente clienteSalvo = clienteRepository.save(cliente);

        return new ResponseEntity(clienteSalvo, HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Cliente>> getAll(){
        try{
            List<Cliente> list = (List<Cliente>)clienteRepository.findAll();

            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity("No such endereco", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<Cliente> atualizar (@RequestBody Cliente cliente){
        Cliente clienteSalvo = clienteRepository.save(cliente);

        return new ResponseEntity<Cliente>(clienteSalvo, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public String apagar(@PathVariable(value = "id")Long id){
        clienteRepository.deleteById(id);
        
        return "ok";
    }

}
