package com.bcopstein.CtrlCorredorV1.aplicacao.casosDeUso;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.negocio.entidades.EventoJpa;
import com.bcopstein.CtrlCorredorV1.negocio.servicos.ServicoEvento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaEventosUC {
    @Autowired
    private ServicoEvento servicoEvento;
    
    public List<EventoJpa> listar(){
        return servicoEvento.todos();
    }    
    
}
