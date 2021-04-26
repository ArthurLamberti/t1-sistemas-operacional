package com.bcopstein.CtrlCorredorV1.aplicacao.casosDeUso;

import java.util.List;


import com.bcopstein.CtrlCorredorV1.negocio.entidades.CorredorJpa;
import com.bcopstein.CtrlCorredorV1.negocio.servicos.ServicoCorredor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaCorredoresUC {
    @Autowired
    private ServicoCorredor servicoCorredor;
    
    public List<CorredorJpa> buscar(){
        return servicoCorredor.todos();
    }    
}
