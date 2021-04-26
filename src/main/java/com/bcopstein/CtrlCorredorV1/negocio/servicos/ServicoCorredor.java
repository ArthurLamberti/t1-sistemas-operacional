package com.bcopstein.CtrlCorredorV1.negocio.servicos;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.bcopstein.CtrlCorredorV1.adaptadores.repositorios.CorredorRepositoryJpa;
import com.bcopstein.CtrlCorredorV1.negocio.entidades.Corredor;
import com.bcopstein.CtrlCorredorV1.negocio.entidades.CorredorJpa;
import com.bcopstein.CtrlCorredorV1.negocio.repositorios.ICorredorRepository;
import com.bcopstein.CtrlCorredorV1.negocio.repositorios.ICorredorRepositoryJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoCorredor {
    public ICorredorRepository corredorRep;

    @Autowired
    public ICorredorRepositoryJpa corredorRepository;

    @Autowired
    private CorredorRepositoryJpa cr;

    @Autowired
    public ServicoCorredor(ICorredorRepository corredorRep){
        this.corredorRep = corredorRep;
    }

    public List<CorredorJpa> todos(){
        // return corredorRep.todos();
        Iterable<CorredorJpa> corredor2 = corredorRepository.findAll();
        return StreamSupport.stream(corredor2.spliterator(), false).collect(Collectors.toList());
    }

    public boolean cadastraCorredor(CorredorJpa corredor){
        // corredorRep.removeTodos();
        // corredorRep.cadastra(corredor);
        corredorRepository.deleteAll();
        corredorRepository.save(corredor);
        return true;
    }
    
}
