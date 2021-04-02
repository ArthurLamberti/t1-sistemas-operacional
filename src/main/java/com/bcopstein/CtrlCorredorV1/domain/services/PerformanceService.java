package com.bcopstein.CtrlCorredorV1.domain.services;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.domain.dtos.PerformanceDTO;
import com.bcopstein.CtrlCorredorV1.domain.utils.EventosUtils;
import com.bcopstein.CtrlCorredorV1.view.models.Evento;
import com.bcopstein.CtrlCorredorV1.view.repositories.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerformanceService {

    @Autowired
    private EventoRepository eventoRepository;
    
    public PerformanceDTO getPerformance(int distancia, int ano) {
        List<Evento> eventos = eventoRepository.getEventosByDistanciaAno(distancia, ano);
        if(eventos.size() < 2){
            return null;
        }
        
        EventosUtils.OrdenarEventosPorData(eventos);
        Evento evento1 = null; //eventos.get(0);
        Evento evento2 = null; //eventos.get(1);
        int reducaoTempo =  0; //evento1.getMinutos() - evento2.getMinutos() > 0 ? evento1.getMinutos() - evento2.getMinutos() : 0 ; //se for numero negativo, houve uma piora no tempo
        for(int i =0; i < eventos.size()-1; i++){
            if(eventos.get(i).getMinutos() - eventos.get(i+1).getMinutos() > reducaoTempo) {
                evento1 = eventos.get(i);
                evento2 = eventos.get(i+1);
                reducaoTempo = eventos.get(i).getMinutos() - eventos.get(i+1).getMinutos();
            }
        }
        
        return new PerformanceDTO(evento1, evento2); 
    }
}
