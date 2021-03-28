package com.bcopstein.CtrlCorredorV1.services;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.dtos.EstatisticasDTO;
import com.bcopstein.CtrlCorredorV1.dtos.PerformanceDTO;
import com.bcopstein.CtrlCorredorV1.models.Evento;
import com.bcopstein.CtrlCorredorV1.repositories.EventoRepository;
import com.bcopstein.CtrlCorredorV1.utils.EventosUtils;

import org.springframework.stereotype.Service;

@Service
public class PerformanceService {

    private EventoRepository eventoRepository;
    
    public PerformanceDTO getPerformance(int distancia, int ano){
        List<Evento> eventos = this.eventoRepository.getEventosByDistanciaAno(distancia, ano);
        
        if(!eventos.isEmpty() && eventos.size() >= 2){
            for(Evento evento: eventos){
                System.out.println(evento.toString());
            }
            System.out.println("\n===========\n");
            EventosUtils.OrdenarEventosPorData(eventos);
            for(Evento evento: eventos){
                System.out.println(evento.toString());
            }
            // return new PerformanceDTO(eventos);
        }
        return null;
    }
}
