package com.example.androidapp.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Knjiga implements Serializable {
    public int id;
    public int slika;
    public String naziv;
    public String autor;
    public int godina;
    public String opis;
    public int strane;
    public int promocija;

    public Knjiga(int id, int slika, String naziv, String autor, int godina, String opis, int strane, int promocija) {
        this.id = id;
        this.slika = slika;
        this.naziv = naziv;
        this.autor = autor;
        this.godina = godina;
        this.opis = opis;
        this.strane = strane;
        this.promocija = promocija;
    }
}
