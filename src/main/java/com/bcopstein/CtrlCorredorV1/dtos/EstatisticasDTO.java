package com.bcopstein.CtrlCorredorV1.dtos;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.models.Evento;

public class EstatisticasDTO {

  private double media;
  private double mediana;
  private double desvioPadrao;
  private int quantidadeProvas;

  public EstatisticasDTO(List<Evento> eventos) {
    this.media = calcularMedia(eventos);
    this.mediana = calcularMediana(eventos);
    this.desvioPadrao = calcularDesvio(eventos);
    this.quantidadeProvas = eventos.size();
  }

  private double calcularDesvio(List<Evento> eventos) {
    desvioPadrao = 0;
    for(Evento evento: eventos) {
      double desvioAux = evento.getMinutos() - this.media;
      desvioPadrao += desvioAux * desvioAux;
    }

    return Math.sqrt(desvioPadrao / eventos.size());
  }

  private double calcularMediana(List<Evento> eventos) {

    if(eventos.size() % 2 == 0) {
      int soma = eventos.get(eventos.size()/2).getMinutos();
      soma += eventos.get(eventos.size()/2 - 1).getMinutos();
      return soma /2;
    }
    return eventos.get(eventos.size()/2).getMinutos();
  }

  private double calcularMedia(List<Evento> eventos) {
    double minutos = 0.0;
    for(Evento evento: eventos){
      minutos += evento.getMinutos();
    }

    return minutos/eventos.size();
  }

  public double getMedia(){
    return media;
  }
  public double getMediana(){
    return mediana;
  }
  public double getDesvioPadrao(){
    return desvioPadrao;
  }
  public int getQuantidadeProvas(){
    return quantidadeProvas;
  }
  
}
