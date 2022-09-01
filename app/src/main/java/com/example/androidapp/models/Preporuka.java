package com.example.androidapp.models;

import java.io.Serializable;

public class Preporuka implements Serializable {
    public int idKnjige;
    public String kor_ime;

    public Preporuka(int idKnjige, String kor_ime) {
        this.idKnjige = idKnjige;
        this.kor_ime = kor_ime;
    }
}
