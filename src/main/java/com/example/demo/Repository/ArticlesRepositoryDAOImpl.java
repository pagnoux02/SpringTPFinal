package com.example.demo.Repository;

import com.example.demo.domain.Articles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
            vArticles.setId(pRS.getInt("id"));
            vArticles.setNom(pRS.getString("nom"));
            vArticles.setCoche(pRS.getBoolean("coche"));
            return vArticles;
        };
        List<Articles> ListArticleNames = jdbcTemplate.query(vSQL, vRowMapper);
        return ListArticleNames;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public int insertArticle(Articles articles) {
        return 0;
    }
}
