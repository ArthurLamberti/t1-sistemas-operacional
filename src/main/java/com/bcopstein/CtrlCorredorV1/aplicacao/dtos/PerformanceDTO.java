package com.bcopstein.CtrlCorredorV1.aplicacao.dtos;

public class PerformanceDTO {
    private String prova1;
    private String prova2;
    private int reducao;

    public PerformanceDTO(String prova1, String prova2, int reducao) {
        this.prova1 = prova1;
        this.prova2 = prova2;
        this.reducao = reducao;
    }

    public String getProva1() {
        return prova1;
    }

    public String getProva2() {
        return prova2;
    }

    public int getReducao() {
        return reducao;
    }
}
