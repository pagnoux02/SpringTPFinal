package com.example.demo.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PossederRepositoryDAOImp {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public void insertPosseder(int idArt, int idList) {
        String INSERT_SQL = "insert into posseder( id_article,id_liste) values(?,?)";

         jdbcTemplate.update(INSERT_SQL,idArt,idList);
    }
}
