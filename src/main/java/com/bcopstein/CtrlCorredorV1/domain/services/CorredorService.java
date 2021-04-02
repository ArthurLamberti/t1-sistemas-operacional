package com.bcopstein.CtrlCorredorV1.domain.services;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.view.models.Corredor;
import com.bcopstein.CtrlCorredorV1.view.repositories.CorredorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorredorService {
    @Autowired
    private CorredorRepository corredorRepository;

    public List<Corredor> findAllCorredores(){
        return corredorRepository.listarCorredores();
    }

    public boolean cadastrarCorredor(Corredor corredor){
        corredorRepository.apagarCorredores();
        return corredorRepository.cadastrarCorredor(corredor);
    }
}
