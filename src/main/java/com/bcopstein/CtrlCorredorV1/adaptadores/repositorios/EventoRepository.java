package com.bcopstein.CtrlCorredorV1.adaptadores.repositorios;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.negocio.entidades.Evento;
import com.bcopstein.CtrlCorredorV1.negocio.repositorios.IEventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventoRepository implements IEventoRepository{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EventoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;  
        this.jdbcTemplate.execute("DROP TABLE eventos IF EXISTS");
        this.jdbcTemplate.execute("CREATE TABLE eventos("
                + "id int, nome VARCHAR(255), dia int, mes int, ano int, distancia int, horas int, minutos int, segundos int,PRIMARY KEY(id))");
        // Insere eventos
        // cadastra(new Evento(1,"Poa Day Run",22,5,2019,5,0,35,32));
        // cadastra(new Evento(2,"Poa Night Run",12,6,2019,5,0,31,10));
        cadastra(new Evento(3,"Winter Day Run",9,7,2019,5,0,30,17));
        // cadastra(new Evento(4,"Summer Night Run",18,12,2019,5,0,32,25));
    }  

    public List<Evento> todos() {
        List<Evento> resp = this.jdbcTemplate.query("SELECT * from eventos",
                (rs, rowNum) -> new Evento(rs.getInt("id"), rs.getString("nome"), rs.getInt("dia"), rs.getInt("mes"),
                        rs.getInt("ano"), rs.getInt("distancia"), rs.getInt("horas"), rs.getInt("minutos"),
                        rs.getInt("segundos")));
        return resp;
    }

    public boolean cadastra(Evento evento){
        this.jdbcTemplate.update(
            "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES (?,?,?,?,?,?,?,?,?)",
            evento.getId(), evento.getNome(), evento.getDia(), evento.getMes(), evento.getAno(),
            evento.getDistancia(), evento.getHoras(), evento.getMinutos(), evento.getSegundos());
        return true;
    }

    @Override
    public List<Evento> getEventosByDistancia(int distancia) {
        List<Evento> response = this.jdbcTemplate.query("SELECT * FROM eventos where distancia="+distancia,
            (rs, rowNum) -> new Evento(rs.getInt("id"), rs.getString("nome"), rs.getInt("dia"), rs.getInt("mes"),
            rs.getInt("ano"), rs.getInt("distancia"), rs.getInt("horas"), rs.getInt("minutos"),
            rs.getInt("segundos"))
        );
        return response;
    }

    @Override
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
