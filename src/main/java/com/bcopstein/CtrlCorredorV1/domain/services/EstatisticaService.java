package com.bcopstein.CtrlCorredorV1.domain.services;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.domain.dtos.EstatisticasDTO;
import com.bcopstein.CtrlCorredorV1.domain.utils.EventosUtils;
import com.bcopstein.CtrlCorredorV1.view.models.Evento;
import com.bcopstein.CtrlCorredorV1.view.repositories.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstatisticaService {

  @Autowired
  private EventoRepository eventoRepository;
  public EstatisticasDTO estatisticas(int distancia) {
    List<Evento> eventos = this.eventoRepository.getEventosByDistancia(distancia);
    EventosUtils.OrdenarEventosPorData(eventos);

    if(!eventos.isEmpty()){
        return new EstatisticasDTO(eventos);
    }
    return null;
}
}
