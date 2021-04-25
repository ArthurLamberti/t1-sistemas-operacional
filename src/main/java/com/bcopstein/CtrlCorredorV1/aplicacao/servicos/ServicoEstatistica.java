package com.bcopstein.CtrlCorredorV1.aplicacao.servicos;

import java.util.List;
import java.util.stream.Collectors;

import com.bcopstein.CtrlCorredorV1.aplicacao.dtos.EstatisticasDTO;
import com.bcopstein.CtrlCorredorV1.aplicacao.dtos.PerformanceDTO;
import com.bcopstein.CtrlCorredorV1.negocio.entidades.Evento;
import com.bcopstein.CtrlCorredorV1.negocio.repositorios.IEventoRepository;
import com.bcopstein.CtrlCorredorV1.negocio.util.EventoUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoEstatistica {
    private IEventoRepository eventoRep;
    private ICalculoEstatistica calculoEstatistica;

    @Autowired
    public ServicoEstatistica(IEventoRepository eventoRepository,ICalculoEstatistica calculoEstatistica){
        this.eventoRep = eventoRepository;
        this.calculoEstatistica = calculoEstatistica;
    }

    public EstatisticasDTO calculaEstatisticas(int distancia){
        return calculoEstatistica.calculaEstatisticas(distancia);
    }

    public PerformanceDTO calculaAumentoPerformance(int distancia,int ano){
        List<Evento> eventos = eventoRep.getEventosByDistanciaAno(distancia, ano);
        if(eventos.size() < 2){
            System.out.println(String.format("Menos de 2 eventos para o ano de %s na distancia de %dkm", ano, distancia));
            return null;
        }
        
        EventoUtils.OrdenarEventosPorData(eventos);
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
        
        return new PerformanceDTO(evento1.getNome(), evento2.getNome(), reducaoTempo); 
    }
}
