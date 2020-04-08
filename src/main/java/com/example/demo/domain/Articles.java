package com.example.demo.domain;



public class Articles {
    private Integer id;
    private String nomArt;
    private boolean coche;



    public Articles() {
    }

    public Articles(String nomArt) {
        this.nomArt = nomArt;
    }

    public boolean isCoche() {
        return coche;
    }

    public void setCoche(boolean coche) {
        this.coche = coche;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getNomArt() {
        return nomArt;
    }

    public void setNomArt(String nomArt) {
        this.nomArt = nomArt;
    }

}
