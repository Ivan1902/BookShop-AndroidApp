package com.example.androidapp.models;

import java.io.Serializable;

public class Korisnik implements Serializable
{
    public String ime;
    public String prezime;
    public String kor_ime;
    public String lozinka;
    public int telefon;
    public String adresa;
    public int tip;

    public Korisnik(String ime, String prezime, String kor_ime, String lozinka, int telefon, String adresa, int tip) {
        this.ime = ime;
        this.prezime = prezime;
        this.kor_ime = kor_ime;
        this.lozinka = lozinka;
        this.telefon = telefon;
        this.adresa = adresa;
        this.tip = tip;
    }
}
