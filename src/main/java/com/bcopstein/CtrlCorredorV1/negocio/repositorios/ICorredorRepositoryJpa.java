package com.bcopstein.CtrlCorredorV1.negocio.repositorios;

import com.bcopstein.CtrlCorredorV1.negocio.entidades.CorredorJpa;

public interface ICorredorRepositoryJpa {
    Iterable<CorredorJpa> findAll();
    void deleteAll();
    CorredorJpa save(CorredorJpa corredorJpa);
}
