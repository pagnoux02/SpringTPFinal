package com.example.demo.domain;

public class Posseder {
    private Integer id_Articles;
    private Integer id_listes;

    public Posseder(Integer id_Articles, Integer id_listes) {
        this.id_Articles = id_Articles;
        this.id_listes = id_listes;
    }

    public Integer getId_Articles() { return id_Articles;
    }

    public void setId_Articles(Integer id_Articles) {
        this.id_Articles = id_Articles;
    }

    public Integer getId_listes() {
        return id_listes;
    }

    public void setId_listes(Integer id_listes) {
        this.id_listes = id_listes;
    }
}
