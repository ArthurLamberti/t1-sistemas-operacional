package com.bcopstein.CtrlCorredorV1.negocio.util;

import java.sql.Date;
import java.util.List;

import com.bcopstein.CtrlCorredorV1.negocio.entidades.EventoJpa;

public class EventoUtilsJpa {
    public static void OrdenarEventosPorData(List<EventoJpa> eventos) {

        for (int i = 0; i < eventos.size(); i++) {
            for (int j = 0; j < eventos.size(); j++) {
                Date dataEventoI = new Date(eventos.get(i).getAno(), eventos.get(i).getMes(), eventos.get(i).getDia());
                Date dataEventoJ = new Date(eventos.get(j).getAno(), eventos.get(j).getMes(), eventos.get(j).getDia());
                if (dataEventoJ.after(dataEventoI)) {
                    EventoJpa aux = eventos.get(i);
                    eventos.set(i, eventos.get(j));
                    eventos.set(j, aux);
                }
            }
        }
    }

    public static double calcularDesvio(List<EventoJpa> eventos, double media) {
        double desvioPadrao = 0;
        for (EventoJpa evento : eventos) {
            double desvioAux = evento.getMinutos() - media;
            desvioPadrao += desvioAux * desvioAux;
        }

        return Math.sqrt(desvioPadrao / eventos.size());
    }

    public static double calcularMediana(List<EventoJpa> eventos) {

        if (eventos.size() % 2 == 0) {
            int soma = eventos.get(eventos.size() / 2).getMinutos();
            soma += eventos.get(eventos.size() / 2 - 1).getMinutos();
            return soma / 2;
        }
        return eventos.get(eventos.size() / 2).getMinutos();
    }

    public static Double calcularMedia(List<EventoJpa> eventos) {
        double minutos = 0.0;
        for (EventoJpa evento : eventos) {
            minutos += evento.getMinutos();
        }

        return minutos / eventos.size();
    }
}
