package com.bcopstein.CtrlCorredorV1.adaptadores.repositorios;


import java.util.List;

import com.bcopstein.CtrlCorredorV1.negocio.entidades.EventoJpa;
import com.bcopstein.CtrlCorredorV1.negocio.repositorios.IEventoRepositoryJpa;

import org.springframework.data.repository.CrudRepository;


public interface EventoRepositoryJpa extends CrudRepository<EventoJpa, Integer>, IEventoRepositoryJpa {
    Iterable<EventoJpa> findByDistancia(int distancia);
    Iterable<EventoJpa> findByDistanciaAndAno(int distancia, int ano);
}
