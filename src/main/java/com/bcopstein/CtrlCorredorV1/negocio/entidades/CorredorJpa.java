package com.bcopstein.CtrlCorredorV1.negocio.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "corredores")
// @Table(name = "CORREDORES")
public class CorredorJpa {
    @Id
    @Column(name = "cpf")
    private String cpf;
    
    @Column(name = "NOME")
    private String nome;
    
    @Column(name = "DIADN")
    private int diaDn;

    @Column(name = "MESDN")
    private int mesDn;

    @Column(name = "ANODN")
    private int anoDn;

    @Column(name = "GENERO")
    private String genero;

    public CorredorJpa(String cpf, String nome, int diaDn,int mesDn,int anoDn, String genero) {
        this.cpf = cpf;
        this.nome = nome;
        this.diaDn = diaDn;
        this.mesDn = mesDn;
        this.anoDn = anoDn;
        this.genero = genero;
    }

    protected CorredorJpa(){}

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public int getDiaDn() {
        return diaDn;
    }

    public int getMesDn() {
        return mesDn;
    }
    public int getAnoDn() {
        return anoDn;
    }

    public String getGenero() {
        return genero;
    }

}