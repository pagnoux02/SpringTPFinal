package com.example.demo.Repository;

import com.example.demo.domain.Articles;
import com.example.demo.domain.Listes;
import com.example.demo.domain.Posseder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CourseRepository {
    //  @Autowired
    ///public JdbcTemplate jdbcTemplate;
    //private Posseder Posseder;

//    public List<Listes> getAllListesNames() {
//        String vSQL = "SELECT id,nom FROM Listes";
//
//        RowMapper<Listes> vRowMapper = new RowMapper<Listes>() {
//            public Listes mapRow(ResultSet pRS, int pRowNum) throws SQLException {
//                Listes vListes = new Listes();
//                vListes.setId(pRS.getInt("id"));
//                vListes.setNom(pRS.getString("nom"));
//                return vListes;
//            }
//        };
//        List<Listes> ListListesNames = jdbcTemplate.query(vSQL, vRowMapper);
//        return ListListesNames;
//    }
//
//    public Listes getListesById(int id) {
//
//        String sql = "SELECT * FROM Listes where id = ?";
//
//        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
//                new Listes(rs.getInt("id"), rs.getString("nom")
//                ));
//
//    }
//
//    public List<Articles> getAllArticlebyid(Integer id) {
//        String vSQL = "SELECT * FROM Articles\n" +
//                "join POSSEDER on id = id_article\n" +
//                "where id_liste = "+id+"";
//
//        RowMapper<Articles> vRowMapper = (pRS, pRowNum) -> {
//            Articles vArticles = new Articles();
//            vArticles.setId(pRS.getInt("id"));
//            vArticles.setNom(pRS.getString("nom"));
//            vArticles.setCoche(pRS.getBoolean("coche"));
//            return vArticles;
//        };
//        List<Articles> ListArticleNames = jdbcTemplate.query(vSQL, vRowMapper);
//        return ListArticleNames;
//    }
//
//
//    public int InsertListe(Listes listes) {
//        final String INSERT_SQL = "insert into listes (nom) values(?)";
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        jdbcTemplate.update(new PreparedStatementCreator() {
//            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
//                PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
//                ps.setString(1, listes.getNom());
//                return ps;
//            }
//        }, keyHolder);
//
//        return keyHolder.getKey().intValue();
//    }
//}
//    public void InsertListeAndArticles(Articles articles,Listes listes) {
//        String vSQL = "INSERT INTO Listes (nom) VALUES (:nom)";
//        String vSQLarticle = "INSERT INTO Articles (nom,coche) VALUES (:nom,coche)";
//        String vSQLPosseder = "insert into posseder values((SELECT MAX(id) FROM ARTICLES),(SELECT MAX(id) FROM listes))";
//        //  String vSQL = "INSERT INTO Listes (nom) VALUES (:nom)";
//
//        BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(listes);
//        vParams.registerSqlType("nom", Types.VARCHAR);
//        jdbcTemplate.update(vSQL, vParams);
//
//        BeanPropertySqlParameterSource vParamsA = new BeanPropertySqlParameterSource(articles);
//        vParams.registerSqlType("nom", Types.VARCHAR);
//        vParams.registerSqlType("coche", Types.BOOLEAN);
//        jdbcTemplate.update(vSQLarticle, vParamsA);
//
//        BeanPropertySqlParameterSource vParamsP = new BeanPropertySqlParameterSource(Posseder);
//        vParams.registerSqlType("id_articles", Types.INTEGER);
//        vParams.registerSqlType("id_listes", Types.INTEGER);
//        jdbcTemplate.update(vSQLPosseder, vParamsP);
//
//    }}
}