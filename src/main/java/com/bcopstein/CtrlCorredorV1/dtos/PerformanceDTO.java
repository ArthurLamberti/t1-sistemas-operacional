package com.bcopstein.CtrlCorredorV1.dtos;

import com.bcopstein.CtrlCorredorV1.models.Evento;

public class PerformanceDTO {
  private String evento1;
  private String evento2;

  public PerformanceDTO(Evento evento1, Evento evento2){
    this.evento1 = evento1.getNome();
    this.evento2 = evento2.getNome();
  }

  public String getEvento1(){
    return evento1;
  }

  public String getEvento2(){
    return evento2;
  }
}
