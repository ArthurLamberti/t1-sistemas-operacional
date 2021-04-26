package com.bcopstein.CtrlCorredorV1.aplicacao.casosDeUso;

import com.bcopstein.CtrlCorredorV1.negocio.entidades.Corredor;
import com.bcopstein.CtrlCorredorV1.negocio.entidades.CorredorJpa;
import com.bcopstein.CtrlCorredorV1.negocio.servicos.ServicoCorredor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraCorredoresUC {
    @Autowired
    private ServicoCorredor servicoCorredor;
    
    public boolean cadastrar(CorredorJpa corredor){
        return servicoCorredor.cadastraCorredor(corredor);
    }
    
}
