package com.bcopstein.CtrlCorredorV1.negocio.repositorios;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.negocio.entidades.Evento;
import com.bcopstein.CtrlCorredorV1.negocio.entidades.EventoJpa;

public interface IEventoRepositoryJpa {
    
    Iterable<EventoJpa> findAll();
    EventoJpa save(EventoJpa eventoJpa);
    Iterable<EventoJpa> findByDistanciaAndAno(int distancia, int ano);
    Iterable<EventoJpa> findByDistancia(int distancia);
}
