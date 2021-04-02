package com.bcopstein.CtrlCorredorV1.domain.utils;

import java.sql.Date;
import java.util.List;

import com.bcopstein.CtrlCorredorV1.view.models.Evento;

public class EventosUtils {
    public static void OrdenarEventosPorData(List<Evento> eventos) {
        
        for (int i = 0; i < eventos.size(); i++) {
            for (int j = 0; j < eventos.size(); j++) {
                Date dataEventoI = new Date(eventos.get(i).getAno(), eventos.get(i).getMes(), eventos.get(i).getDia());
                Date dataEventoJ = new Date(eventos.get(j).getAno(), eventos.get(j).getMes(), eventos.get(j).getDia());
                if (dataEventoJ.after(dataEventoI)) {
                    Evento aux = eventos.get(i);
                    eventos.set(i, eventos.get(j));
                    eventos.set(j, aux);
                }
            }
        }
    }
}
