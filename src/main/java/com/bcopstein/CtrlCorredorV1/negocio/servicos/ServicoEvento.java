package com.bcopstein.CtrlCorredorV1.negocio.servicos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.bcopstein.CtrlCorredorV1.negocio.entidades.EventoJpa;

import com.bcopstein.CtrlCorredorV1.negocio.repositorios.IEventoRepositoryJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoEvento {

    @Autowired
    private IEventoRepositoryJpa eventoRepository;

    public List<EventoJpa> todos(){
        Iterable<EventoJpa> eventos = eventoRepository.findAll();
        System.out.println("Buscou");
        eventos.spliterator().forEachRemaining(t -> System.out.println(t.getNome()));
        return StreamSupport.stream(eventos.spliterator(), false).collect(Collectors.toList());
    }

    public boolean cadastra(EventoJpa evento){
        eventoRepository.save(evento);
        return true;
        // return eventoRep.cadastra(evento);
    }
    
}
