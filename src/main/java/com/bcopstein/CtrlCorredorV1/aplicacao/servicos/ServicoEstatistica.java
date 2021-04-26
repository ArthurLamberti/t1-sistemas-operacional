package com.bcopstein.CtrlCorredorV1.aplicacao.servicos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.bcopstein.CtrlCorredorV1.aplicacao.dtos.EstatisticasDTO;
import com.bcopstein.CtrlCorredorV1.aplicacao.dtos.PerformanceDTO;
import com.bcopstein.CtrlCorredorV1.negocio.entidades.EventoJpa;

import com.bcopstein.CtrlCorredorV1.negocio.repositorios.IEventoRepositoryJpa;
import com.bcopstein.CtrlCorredorV1.negocio.util.EventoUtilsJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoEstatistica {

    @Autowired
    private ICalculoEstatistica calculoEstatistica;

    @Autowired
    private IEventoRepositoryJpa eventoRepository;

    public EstatisticasDTO calculaEstatisticas(int distancia){
        return calculoEstatistica.calculaEstatisticas(distancia);
    }

    public PerformanceDTO calculaAumentoPerformance(int distancia,int ano){
        Iterable<EventoJpa> eventosIterable = eventoRepository.findByDistanciaAndAno(distancia, ano);
        System.out.println("Buscou");
        List<EventoJpa> eventos = StreamSupport.stream(eventosIterable.spliterator(), false).collect(Collectors.toList());
        if(eventos.size() < 2){
            System.out.println(String.format("Menos de 2 eventos para o ano de %s na distancia de %dkm", ano, distancia));
            return null;
        }
        
        EventoUtilsJpa.OrdenarEventosPorData(eventos);
        EventoJpa evento1 = eventos.get(0); //eventos.get(0);
        EventoJpa evento2 = eventos.get(1); //eventos.get(1);
        int reducaoTempo =  0; //evento1.getMinutos() - evento2.getMinutos() > 0 ? evento1.getMinutos() - evento2.getMinutos() : 0 ; //se for numero negativo, houve uma piora no tempo
        for(int i =0; i < eventos.size()-1; i++){
            if(eventos.get(i).getMinutos() - eventos.get(i+1).getMinutos() > reducaoTempo) {
                evento1 = eventos.get(i);
                evento2 = eventos.get(i+1);
                reducaoTempo = eventos.get(i).getMinutos() - eventos.get(i+1).getMinutos();
            }
        }
        
        return new PerformanceDTO(evento1.getNome(), evento2.getNome(), reducaoTempo); 
    }
}
