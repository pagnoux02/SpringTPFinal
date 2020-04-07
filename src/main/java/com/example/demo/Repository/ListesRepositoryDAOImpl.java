package com.example.demo.Repository;

import com.example.demo.domain.Articles;
import com.example.demo.domain.Listes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class ListesRepositoryDAOImpl implements ListesDAO {

    @Autowired
    public JdbcTemplate jdbcTemplate;


    @Override
    public List<Listes> getAllListesNames() {
        String vSQL = "SELECT id,nom FROM Listes";

        RowMapper<Listes> vRowMapper = new RowMapper<Listes>() {
            public Listes mapRow(ResultSet pRS, int pRowNum) throws SQLException {
                Listes vListes = new Listes();
                vListes.setId(pRS.getInt("id"));
                vListes.setNom(pRS.getString("nom"));
                return vListes;
            }
        };
        return jdbcTemplate.query(vSQL, vRowMapper);
    }

    @Override
    public Listes getListesById(int id) {

        String sql = "SELECT * FROM Listes where id = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Listes(rs.getInt("id"), rs.getString("nom")
                ));

    }

    @Override
    public int InsertListe(Listes listes) {
        final String INSERT_SQL = "insert into listes (nom) values(?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
                ps.setString(1, listes.getNom());
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public void deletById(int id) {
        String deleteQuery = "delete from listes where id = ?";
        jdbcTemplate.update(deleteQuery, id);
    }
}
