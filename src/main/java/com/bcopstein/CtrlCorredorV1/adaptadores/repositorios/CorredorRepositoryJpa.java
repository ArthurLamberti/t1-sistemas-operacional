package com.bcopstein.CtrlCorredorV1.adaptadores.repositorios;

import com.bcopstein.CtrlCorredorV1.negocio.entidades.CorredorJpa;
import com.bcopstein.CtrlCorredorV1.negocio.repositorios.ICorredorRepository;
import com.bcopstein.CtrlCorredorV1.negocio.repositorios.ICorredorRepositoryJpa;

import org.springframework.data.repository.CrudRepository;

public interface CorredorRepositoryJpa extends CrudRepository<CorredorJpa, Integer>, ICorredorRepositoryJpa{
    
}
