package com.bcopstein.CtrlCorredorV1.controller;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.domain.dtos.EstatisticasDTO;
import com.bcopstein.CtrlCorredorV1.domain.dtos.PerformanceDTO;
import com.bcopstein.CtrlCorredorV1.domain.services.PerformanceService;
import com.bcopstein.CtrlCorredorV1.domain.utils.EventosUtils;
import com.bcopstein.CtrlCorredorV1.view.models.Corredor;
import com.bcopstein.CtrlCorredorV1.view.models.Evento;
import com.bcopstein.CtrlCorredorV1.view.repositories.CorredorRepository;
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


 
}
