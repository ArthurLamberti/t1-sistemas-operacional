package com.bcopstein.CtrlCorredorV1.negocio.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "eventos")
public class EventoJpa {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name = "NOME")
    private String nome;
    // Data do evento

    @Column(name = "DIA")
    private int dia;

    @Column(name = "MES")
    private int mes;

    @Column(name = "ANO")
    private int ano;

    // Distancia percorrida

    @Column(name = "DISTANCIA")
    private int distancia; // metros
    // Tempo que o corredor levou para percorrer a distancia

    @Column(name = "HORAS")
    private int horas;

    @Column(name = "MINUTOS")
    private int minutos;

    @Column(name = "SEGUNDOS")
    private int segundos;
    
    public EventoJpa(int id,String nome, int dia, int mes, int ano, int distancia, int horas, int minutos, int segundos) {
        this.id = id;
        this.nome = nome;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.distancia = distancia;
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    protected EventoJpa(){}

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public int getDistancia() {
        return distancia;
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    @Override
    public String toString() {
        return "Evento [ano=" + ano + ", dia=" + dia + ", distancia=" + distancia + ", horas=" + horas + ", id=" + id
                + ", mes=" + mes + ", minutos=" + minutos + ", nome=" + nome + ", segundos=" + segundos + "]";
    }
}
