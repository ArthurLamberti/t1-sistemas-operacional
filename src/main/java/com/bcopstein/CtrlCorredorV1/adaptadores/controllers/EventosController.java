package com.bcopstein.CtrlCorredorV1.adaptadores.controllers;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.aplicacao.casosDeUso.CadastraEventoUC;
import com.bcopstein.CtrlCorredorV1.aplicacao.casosDeUso.ConsultaEstatisticasUC;
import com.bcopstein.CtrlCorredorV1.aplicacao.casosDeUso.ConsultaEventosUC;
import com.bcopstein.CtrlCorredorV1.aplicacao.casosDeUso.ConsultaPerformanceUC;
import com.bcopstein.CtrlCorredorV1.aplicacao.dtos.EstatisticasDTO;
import com.bcopstein.CtrlCorredorV1.aplicacao.dtos.PerformanceDTO;
import com.bcopstein.CtrlCorredorV1.negocio.entidades.EventoJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/eventos")
@RestController
public class EventosController {

  @Autowired
  private ConsultaEventosUC consultaEventosUC;

  @Autowired
  private CadastraEventoUC cadastraEventoUC;
  
  @Autowired
  private ConsultaEstatisticasUC consultaEstatisticasUC;

  @Autowired
  private ConsultaPerformanceUC consultaPerformanceUC;

  @PostMapping
  @CrossOrigin(origins = "*")
  public boolean cadastrarEvento(@RequestBody final EventoJpa evento) {
    return cadastraEventoUC.cadastrar(evento);
  }


  @GetMapping
  @CrossOrigin(origins = "*")
  public List<EventoJpa> listarEventos(){
    return consultaEventosUC.listar();
  }

  @GetMapping("/estatisticas")
  @CrossOrigin(origins = "*")
  public EstatisticasDTO estatisticas(@RequestParam final Integer distancia){
    return consultaEstatisticasUC.buscarEstatisticas(distancia);
  }
 
  @GetMapping("/aumentoPerformance")
  @CrossOrigin(origins = "*")
  public PerformanceDTO aumentoPerformance(
    @RequestParam final Integer distancia, 
    @RequestParam final Integer ano
  ){
    return consultaPerformanceUC.buscarMelhorPerformace(distancia, ano);
  }
  
}
