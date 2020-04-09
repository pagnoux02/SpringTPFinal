package com.example.demo.Repository;

import com.example.demo.domain.Articles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
@Repository
public class ArticlesRepositoryDAOImpl implements ArticlesDAO {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<Articles> getAllArticlebyid(Integer id) {
        String vSQL = "SELECT * FROM Articles\n" +
                "join POSSEDER on id = id_article\n" +
                "where id_liste = "+id+"";

        RowMapper<Articles> vRowMapper = (pRS, pRowNum) -> {
            Articles vArticles = new Articles();
            vArticles.setIdArt(pRS.getInt("id"));
            vArticles.setNomArt(pRS.getString("nom"));
            vArticles.setCoche(pRS.getBoolean("coche"));
            return vArticles;
        };
        List<Articles> ListArticleNames = jdbcTemplate.query(vSQL, vRowMapper);
        return ListArticleNames;
    }

    @Override
    public void deleteById(int id) {
        String deleteQuery = "delete from Articles where id = ?";
        jdbcTemplate.update(deleteQuery, id);
    }

    @Override
    public int insertArticle(Articles articles) {
        final String INSERT_SQL = "insert into articles (nom) values(?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
            ps.setString(1, articles.getNomArt());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }



}
