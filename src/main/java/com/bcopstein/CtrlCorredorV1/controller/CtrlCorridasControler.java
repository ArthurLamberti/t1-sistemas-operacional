package com.bcopstein.CtrlCorredorV1.controller;

import java.util.List;
import java.util.Objects;

import com.bcopstein.CtrlCorredorV1.dtos.EstatisticasDTO;
import com.bcopstein.CtrlCorredorV1.dtos.PerformanceDTO;
import com.bcopstein.CtrlCorredorV1.models.Corredor;
import com.bcopstein.CtrlCorredorV1.models.Evento;
import com.bcopstein.CtrlCorredorV1.repositories.CorredorRepository;
import com.bcopstein.CtrlCorredorV1.repositories.EventoRepository;
import com.bcopstein.CtrlCorredorV1.services.PerformanceService;
import com.bcopstein.CtrlCorredorV1.utils.EventosUtils;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ctrlCorridas")
public class CtrlCorridasControler {
    private CorredorRepository corredorRepository;
    private EventoRepository eventoRepository;

    @Autowired
    public CtrlCorridasControler(CorredorRepository corredorRepository, EventoRepository eventoRepository) {
        this.corredorRepository = corredorRepository;
        this.eventoRepository = eventoRepository;
    }

    @Autowired
    PerformanceService performanceService;

    @GetMapping("/corredor")
    @CrossOrigin(origins = "*")
    public List<Corredor> consultaCorredor() {
        return corredorRepository.listarCorredores();
    }

    @PostMapping("/corredor")
    @CrossOrigin(origins = "*")
    public boolean cadastraCorredor(@RequestBody final Corredor corredor) {
        this.corredorRepository.apagarCorredores();
        return this.corredorRepository.cadastrarCorredor(corredor);
    }

    @GetMapping("/eventos")
    @CrossOrigin(origins = "*")
    public List<Evento> consultaEventos() {
        return eventoRepository.listarEventos();
    }

    @PostMapping("/eventos") // adiciona evento no único corredor
    @CrossOrigin(origins = "*")
    public boolean informaEvento(@RequestBody final Evento evento) {
        return this.eventoRepository.cadastrarEvento(evento);
    }

    @GetMapping("/estatisticas")
    @CrossOrigin(origins = "*")
    public EstatisticasDTO estatisticas(@RequestParam final int distancia) {
        List<Evento> eventos = this.eventoRepository.getEventosByDistancia(distancia);
        EventosUtils.OrdenarEventosPorData(eventos);

        if(!eventos.isEmpty()){
            return new EstatisticasDTO(eventos);
        }
        return null;
    }

    @GetMapping("/aumentoPerformance")
    @CrossOrigin(origins = "*")
    public PerformanceDTO aumentoPerformance(@RequestParam final int distancia, @RequestParam final int ano) {
        List<Evento> eventos = this.eventoRepository.getEventosByDistanciaAno(distancia, ano);
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
        
        // return performanceService.getPerformance(distancia, ano);
        System.out.println("SAFWF");
        return new PerformanceDTO(evento1, evento2); 
    }
}
