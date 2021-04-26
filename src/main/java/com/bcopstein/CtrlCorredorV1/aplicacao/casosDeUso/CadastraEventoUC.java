package com.bcopstein.CtrlCorredorV1.aplicacao.casosDeUso;

import com.bcopstein.CtrlCorredorV1.negocio.entidades.EventoJpa;
import com.bcopstein.CtrlCorredorV1.negocio.servicos.ServicoEvento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraEventoUC {
    @Autowired
    private ServicoEvento servicoEvento;
    
    public boolean cadastrar(EventoJpa evento){
        return servicoEvento.cadastra(evento);
    }    
}
