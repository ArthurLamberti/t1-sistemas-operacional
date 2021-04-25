package com.bcopstein.CtrlCorredorV1.aplicacao.servicos;

import java.util.List;
import java.util.stream.Collectors;

import com.bcopstein.CtrlCorredorV1.aplicacao.dtos.EstatisticasDTO;
import com.bcopstein.CtrlCorredorV1.negocio.entidades.Evento;
import com.bcopstein.CtrlCorredorV1.negocio.repositorios.IEventoRepository;
import com.bcopstein.CtrlCorredorV1.negocio.util.EventoUtils;

import org.springframework.beans.factory.annotation.Autowired;

public class EstatisticaNormal implements ICalculoEstatistica {
    private IEventoRepository eventoRep;
    
    @Autowired
    public EstatisticaNormal(IEventoRepository eventoRep){
        this.eventoRep = eventoRep;
    }

    public EstatisticasDTO calculaEstatisticas(int distancia){
        
        List<Evento> eventos = eventoRep.getEventosByDistancia(distancia);
        Double media = EventoUtils.calcularMedia(eventos);
        Double mediana = EventoUtils.calcularMediana(eventos);
        Double desvioPadrao = EventoUtils.calcularDesvio(eventos, media);
        if(!eventos.isEmpty()){
            return new EstatisticasDTO(media, mediana, desvioPadrao);
        }
        return null;
    }
}
