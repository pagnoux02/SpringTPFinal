package com.example.demo.domain;



public class Articles {
    private Integer idArt;
    private String nomArt;
    private boolean coche;



    public Articles() {
    }

    public Articles(String nomArt) {
        this.nomArt = nomArt;
    }

    public Integer getIdArt() {
        return idArt;
    }

    public void setIdArt(Integer idArt) {
        this.idArt = idArt;
    }

    public String getNomArt() {
        return nomArt;
    }

    public void setNomArt(String nomArt) {
        this.nomArt = nomArt;
    }

    public boolean isCoche() {
        return coche;
    }

    public void setCoche(boolean coche) {
        this.coche = coche;
    }
}
