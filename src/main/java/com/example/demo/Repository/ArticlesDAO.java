package com.example.demo.Repository;

import com.example.demo.domain.Articles;

import java.util.List;

public interface ArticlesDAO {

     List<Articles> getAllArticlebyid(Integer id);

     void deleteById(int id);

     int insertArticle(Articles articles);

}
