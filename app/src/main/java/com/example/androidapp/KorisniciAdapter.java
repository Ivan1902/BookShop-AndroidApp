package com.example.androidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.androidapp.models.Knjiga;
import com.example.androidapp.models.KomentarOcena;
import com.example.androidapp.models.Korisnik;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class KorisniciAdapter extends ArrayAdapter<Korisnik> {
    private ArrayList<Korisnik> korisniciList;

    public KorisniciAdapter(@NonNull Context context, int resource, ArrayList<Korisnik> korisniciList) {
        super(context, resource, korisniciList);
        this.korisniciList = korisniciList;
    }

    public void setItems(ArrayList<Korisnik> list){
        korisniciList.clear();
        korisniciList.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int phraseIndex = position;
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.korisnik_preporuka, parent, false);
        }

        TextView imePrezimeView = convertView.findViewById(R.id.imePrezime);
        TextView korisnickoImeView = convertView.findViewById(R.id.korisnickoIme);

        imePrezimeView.setText(korisniciList.get(position).ime + " " + korisniciList.get(position).prezime);
        korisnickoImeView.setText(korisniciList.get(position).kor_ime);

        return convertView;
    }

    @Override
    public int getCount(){
        return korisniciList.size();
    }

}