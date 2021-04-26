package com.bcopstein.CtrlCorredorV1.aplicacao.servicos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.bcopstein.CtrlCorredorV1.aplicacao.dtos.EstatisticasDTO;
import com.bcopstein.CtrlCorredorV1.negocio.entidades.Evento;
import com.bcopstein.CtrlCorredorV1.negocio.entidades.EventoJpa;
import com.bcopstein.CtrlCorredorV1.negocio.repositorios.IEventoRepository;
import com.bcopstein.CtrlCorredorV1.negocio.repositorios.IEventoRepositoryJpa;
import com.bcopstein.CtrlCorredorV1.negocio.util.EventoUtils;
import com.bcopstein.CtrlCorredorV1.negocio.util.EventoUtilsJpa;

import org.springframework.beans.factory.annotation.Autowired;

public class EstatisticaNormal implements ICalculoEstatistica {
    private IEventoRepository eventoRep;

    @Autowired
    private IEventoRepositoryJpa eventoRepository;
    
    @Autowired
    public EstatisticaNormal(IEventoRepository eventoRep){
        this.eventoRep = eventoRep;
    }

    public EstatisticasDTO calculaEstatisticas(int distancia){
        
        Iterable<EventoJpa> eventosIterable = eventoRepository.findByDistancia(distancia);
        System.out.println("Buscou");
        List<EventoJpa> eventos = StreamSupport.stream(eventosIterable.spliterator(), false).collect(Collectors.toList());
        Double media = EventoUtilsJpa.calcularMedia(eventos);
        Double mediana = EventoUtilsJpa.calcularMediana(eventos);
        Double desvioPadrao = EventoUtilsJpa.calcularDesvio(eventos, media);
        if(!eventos.isEmpty()){
            return new EstatisticasDTO(media, mediana, desvioPadrao);
        }
        return null;
    }
}
