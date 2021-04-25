package com.bcopstein.CtrlCorredorV1.negocio.repositorios;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.negocio.entidades.Evento;

public interface IEventoRepository {
    List<Evento> todos();
    boolean cadastra(Evento evento);
    List<Evento> getEventosByDistanciaAno(int distancia, int ano);
    List<Evento> getEventosByDistancia(int distancia);
}
