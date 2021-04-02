package com.bcopstein.CtrlCorredorV1.view.repositories;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.view.models.Corredor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CorredorRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CorredorRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;

        this.jdbcTemplate.execute("DROP TABLE corredores IF EXISTS");
        this.jdbcTemplate.execute("CREATE TABLE corredores("
                + "cpf VARCHAR(255), nome VARCHAR(255), genero VARCHAR(255), diaDn int, mesDn int, anoDn int, PRIMARY KEY(cpf))");

        cadastrarCorredor(new Corredor("123", "Tetste", 24, 01, 2000, "masculino"));
    }

    public boolean cadastrarCorredor(Corredor corredor){
        this.jdbcTemplate.update("INSERT INTO corredores(cpf,nome,genero,diaDn,mesDn,anoDn) VALUES (?,?,?,?,?,?)", 
            corredor.getCpf(),
            corredor.getNome(),
            corredor.getGenero(),
            corredor.getDiaDn(),
            corredor.getMesDn(),
            corredor.getAnoDn()
        );

        return true;
    }

    public List<Corredor> listarCorredores() {
        List<Corredor> response = this.jdbcTemplate.query("SELECT * FROM corredores",
            (rs, rowNum) -> new Corredor(rs.getString("cpf"), rs.getString("nome"), rs.getInt("diaDn"),
            rs.getInt("mesDn"), rs.getInt("anoDn"), rs.getString("genero"))
        );

        return response;
    }

    public void apagarCorredores(){
        this.jdbcTemplate.batchUpdate("DELETE FROM corredores");
    }
}
