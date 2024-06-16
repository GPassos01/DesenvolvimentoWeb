package br.com.evento.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.evento.model.Evento;
import br.com.evento.repository.EventoRepository;

@RestController
@RequestMapping(value = "/evento")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Evento> cadastrar(@RequestBody Evento evento){
        Evento eventoSalvo = eventoRepository.save(evento);

        return new ResponseEntity(eventoSalvo, HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Evento>> getAll(){
        try{
            List<Evento> list = (List<Evento>)eventoRepository.findAll();

            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity("No such evento", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<Evento> atualizar (@RequestBody Evento endereco){
        Evento enderecoSalvo = eventoRepository.save(endereco);

        return new ResponseEntity<Evento>(enderecoSalvo, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public String apagar(@PathVariable(value = "id")Long id){
        eventoRepository.deleteById(id);
        
        return "ok";
    }
}
