package com.example.demo.Repository;

import com.example.demo.domain.Listes;

import java.util.List;

public interface ListesDAO {

    //public List<Articles> getAllListesNames() ;

     List<Listes> getAllListesNames();

     Listes getListesById(int id);

   // public List<Articles> getAllArticlebyid(Integer id);

     int InsertListe(Listes listes);

     void deletById(int id);
}
