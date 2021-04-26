package com.bcopstein.CtrlCorredorV1.adaptadores.controllers;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.aplicacao.casosDeUso.CadastraCorredoresUC;
import com.bcopstein.CtrlCorredorV1.aplicacao.casosDeUso.ConsultaCorredoresUC;
import com.bcopstein.CtrlCorredorV1.aplicacao.casosDeUso.ConsultaEstatisticasUC;
import com.bcopstein.CtrlCorredorV1.aplicacao.casosDeUso.ConsultaPerformanceUC;
import com.bcopstein.CtrlCorredorV1.aplicacao.dtos.EstatisticasDTO;
import com.bcopstein.CtrlCorredorV1.aplicacao.dtos.PerformanceDTO;
import com.bcopstein.CtrlCorredorV1.negocio.entidades.CorredorJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/corredor")
public class CorredorController {

  @Autowired
  private ConsultaCorredoresUC consultaCorredoresUC;
  
  @Autowired
  private CadastraCorredoresUC cadastraCorredoresUC;


  @PostMapping
  @CrossOrigin(origins = "*")
  public boolean atualizarCorredor(@RequestBody final CorredorJpa corredor){
    return cadastraCorredoresUC.cadastrar(corredor);
  }

  @GetMapping
  @CrossOrigin(origins = "*")
  public List<CorredorJpa> buscarCorredor(){
    return consultaCorredoresUC.buscar();
  }  
}
