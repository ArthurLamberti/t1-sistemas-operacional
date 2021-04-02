package com.bcopstein.CtrlCorredorV1.domain.services;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.view.models.Evento;
import com.bcopstein.CtrlCorredorV1.view.repositories.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public boolean informaEvento(@RequestBody final Evento evento) {
        return this.eventoRepository.cadastrarEvento(evento);
    }

    public List<Evento> consultaEventos() {
        return eventoRepository.listarEventos();
    }
}
