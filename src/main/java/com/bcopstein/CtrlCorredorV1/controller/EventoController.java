package com.bcopstein.CtrlCorredorV1.controller;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.domain.dtos.EstatisticasDTO;
import com.bcopstein.CtrlCorredorV1.domain.dtos.PerformanceDTO;
import com.bcopstein.CtrlCorredorV1.domain.services.EstatisticaService;
import com.bcopstein.CtrlCorredorV1.domain.services.EventoService;
import com.bcopstein.CtrlCorredorV1.domain.services.PerformanceService;
import com.bcopstein.CtrlCorredorV1.view.models.Evento;
import com.bcopstein.CtrlCorredorV1.view.repositories.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("eventos")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @Autowired
    private EstatisticaService estatisticaService;

    @Autowired
    private PerformanceService performanceService;

    @GetMapping
    @CrossOrigin(origins = "*")
    public List<Evento> listarEventos(){
        return eventoService.consultaEventos();
    }


    @PostMapping
    @CrossOrigin(origins = "*")
    public boolean cadastrarEvento(@RequestBody final Evento evento){
        return eventoService.informaEvento(evento);
    }
    
    @GetMapping("/estatisticas")
    @CrossOrigin(origins = "*")
    public EstatisticasDTO estatisticas(@RequestParam final int distancia) {
        return estatisticaService.estatisticas(distancia);
    }
  
    @GetMapping("/aumentoPerformance")
    @CrossOrigin(origins = "*")
    public PerformanceDTO aumentoPerformance(@RequestParam final int distancia, @RequestParam final int ano) {
        return performanceService.getPerformance(distancia, ano);
    }
}
