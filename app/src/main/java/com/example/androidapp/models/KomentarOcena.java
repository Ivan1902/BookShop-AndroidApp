package com.example.androidapp.models;

import java.io.Serializable;

public class KomentarOcena implements Serializable {
    public int idKnjige;
    public String kor_ime;
    public int ocena;
    public String komentar;

    public KomentarOcena(int idKnjige, String kor_ime, int ocena, String komentar) {
        this.idKnjige = idKnjige;
        this.kor_ime = kor_ime;
        this.ocena = ocena;
        this.komentar = komentar;
    }
}
