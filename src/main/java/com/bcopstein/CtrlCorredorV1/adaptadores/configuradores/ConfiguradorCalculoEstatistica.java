package com.bcopstein.CtrlCorredorV1.adaptadores.configuradores;

import com.bcopstein.CtrlCorredorV1.aplicacao.servicos.EstatisticaDesconsidera;
import com.bcopstein.CtrlCorredorV1.aplicacao.servicos.EstatisticaNormal;
import com.bcopstein.CtrlCorredorV1.aplicacao.servicos.ICalculoEstatistica;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguradorCalculoEstatistica {

    @Bean
    @ConditionalOnProperty(name = "calculo.estatistica", havingValue = "original", matchIfMissing = true)
    public ICalculoEstatistica opcaoRegraClassica() {
        return new EstatisticaNormal();
    }

    @Bean
    @ConditionalOnProperty(name = "calculo.estatistica", havingValue = "desconsidera")
    public ICalculoEstatistica opcaoDesconsidera() {
        return new EstatisticaDesconsidera();
    }
}
