package com.bcopstein.CtrlCorredorV1.aplicacao.casosDeUso;

import com.bcopstein.CtrlCorredorV1.aplicacao.dtos.PerformanceDTO;
import com.bcopstein.CtrlCorredorV1.aplicacao.servicos.ServicoEstatistica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaPerformanceUC {
    @Autowired
    private ServicoEstatistica servicoEstatistica;

    public PerformanceDTO buscarMelhorPerformace(int distancia,int ano){
        return servicoEstatistica.calculaAumentoPerformance(distancia, ano);
    }
}
    