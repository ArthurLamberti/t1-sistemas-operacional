package com.bcopstein.CtrlCorredorV1.view.repositories;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.view.models.Evento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventoRepository {
    private JdbcTemplate   jdbcTemplate;

    @Autowired
    public EventoRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;

        this.jdbcTemplate.execute("DROP TABLE eventos IF EXISTS");
        this.jdbcTemplate.execute("CREATE TABLE eventos("
                + "id int, nome VARCHAR(255), dia int, mes int, ano int, distancia int, horas int, minutos int, segundos int,PRIMARY KEY(id))");

        // cadastrarEvento(new Evento(1, "EventoTeste", 20, 01, 2020, 5,0,35,32));

        //                          ID | NOME | DIA |   MES |   ANO |   DISTANCIA | HORAS | MINUTOS | SEGUNDOS
        cadastrarEvento(new Evento( 1,  "Corrida 1",    10,     01,     2021,   5,          0,      38,         32)); /// 1 2 3 7 8 4 
        cadastrarEvento(new Evento( 2,  "Corrida 2",    12,     01,     2021,   5,          0,      30,         32));
        cadastrarEvento(new Evento( 3,  "Corrida 3",    15,     01,     2021,   5,          0,      30,         32));
        cadastrarEvento(new Evento( 4,  "Corrida 4",    17,     01,     2021,   5,          0,      24,         32));
        // cadastrarEvento(new Evento( 8,  "8",    14,     01,     2021,   5,          0,      35,         32));
        // cadastrarEvento(new Evento( 2,  "2",    11,     01,     2021,   5,          0,      35,         32));
    }

    public boolean cadastrarEvento(Evento evento){
        this.jdbcTemplate.update("INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES (?,?,?,?,?,?,?,?,?)", 
            evento.getId(),
            evento.getNome(),
            evento.getDia(),
            evento.getMes(),
            evento.getAno(),
            evento.getDistancia(),
            evento.getHoras(),
            evento.getMinutos(),
            evento.getSegundos()
        );

        return true;
    }

    public List<Evento> listarEventos() {
        List<Evento> response = this.jdbcTemplate.query("SELECT * FROM eventos",
            (rs, rowNum) -> new Evento(rs.getInt("id"), rs.getString("nome"), rs.getInt("dia"), rs.getInt("mes"),
            rs.getInt("ano"), rs.getInt("distancia"), rs.getInt("horas"), rs.getInt("minutos"),
            rs.getInt("segundos"))
        );

        return response;
    }

    public List<Evento> getEventosByDistancia(int distancia) {
        List<Evento> response = this.jdbcTemplate.query("SELECT * FROM eventos where distancia="+distancia,
            (rs, rowNum) -> new Evento(rs.getInt("id"), rs.getString("nome"), rs.getInt("dia"), rs.getInt("mes"),
            rs.getInt("ano"), rs.getInt("distancia"), rs.getInt("horas"), rs.getInt("minutos"),
            rs.getInt("segundos"))
        );
        return response;
    }

    public List<Evento> getEventosByDistanciaAno(int distancia, int ano) {
        String query = String.format("SELECT * FROM eventos where distancia=%s AND ano=%s", distancia, ano);
        List<Evento> response = this.jdbcTemplate.query(query,
            (rs, rowNum) -> new Evento(rs.getInt("id"), rs.getString("nome"), rs.getInt("dia"), rs.getInt("mes"),
            rs.getInt("ano"), rs.getInt("distancia"), rs.getInt("horas"), rs.getInt("minutos"),
            rs.getInt("segundos"))
        );
        return response;
    }
}
