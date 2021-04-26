package com.bcopstein.CtrlCorredorV1.aplicacao.casosDeUso;

import com.bcopstein.CtrlCorredorV1.aplicacao.dtos.EstatisticasDTO;
import com.bcopstein.CtrlCorredorV1.aplicacao.servicos.ServicoEstatistica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaEstatisticasUC {
    @Autowired
    private ServicoEstatistica servicoEstatistica;

    public EstatisticasDTO buscarEstatisticas(int distancia){
        return servicoEstatistica.calculaEstatisticas(distancia);
    }
}
