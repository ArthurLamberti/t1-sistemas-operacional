package com.bcopstein.CtrlCorredorV1.aplicacao.servicos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.bcopstein.CtrlCorredorV1.aplicacao.dtos.EstatisticasDTO;
import com.bcopstein.CtrlCorredorV1.negocio.entidades.EventoJpa;

import com.bcopstein.CtrlCorredorV1.negocio.repositorios.IEventoRepositoryJpa;

import org.springframework.beans.factory.annotation.Autowired;

public class EstatisticaDesconsidera implements ICalculoEstatistica {

    @Autowired
    private IEventoRepositoryJpa eventoRepository;

    public EstatisticasDTO calculaEstatisticas(int distancia) {
       
        Iterable<EventoJpa> eventosIterable = eventoRepository.findByDistancia(distancia);
        System.out.println("Buscou");
        List<EventoJpa> eventos = StreamSupport.stream(eventosIterable.spliterator(), false).collect(Collectors.toList());
       
        // Obtém um stream com os valores ordenados
        List<Double> valores = eventos.stream()
                .map(e -> e.getHoras() * 60 * 60 + e.getMinutos() * 60.0 + e.getSegundos()).sorted()
                .collect(Collectors.toList());
        // Se tem mais de 2 elementos emove o primeiro e o último
        if (eventos.size() >= 3){
            eventos.remove(0);
            eventos.remove(eventos.size()-1);
        }
        // Calcula a média
        double media = valores.stream().mapToDouble(v -> v).average().orElse(Double.NaN);
        // Calcula mediana
        Double mediana = Double.NaN;
        if (valores.size() > 0) {
            mediana = ((valores.size() % 2 == 0)
                    ? (valores.get(valores.size() / 2 - 1)) + (valores.get(valores.size() / 2)) / 2.0
                    : (valores.get(valores.size() / 2)));
        }
        // Calcula o desvio padrao
        double varianca;
        double desvioPadrao = Double.NaN;
        if (mediana != Double.NaN) {
            varianca = valores.stream().mapToDouble(v -> v - media).map(v -> v * v).average().getAsDouble();
            desvioPadrao = Math.sqrt(varianca);
        }
        return new EstatisticasDTO(media+500, mediana, desvioPadrao);
    }
}
