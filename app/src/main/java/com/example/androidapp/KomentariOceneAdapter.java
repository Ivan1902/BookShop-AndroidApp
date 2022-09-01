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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class KomentariOceneAdapter extends ArrayAdapter<KomentarOcena> {
    private ArrayList<KomentarOcena> komentarOcenaList;

    public KomentariOceneAdapter(@NonNull Context context, int resource, ArrayList<KomentarOcena> komentarOcenaList) {
        super(context, resource, komentarOcenaList);
        this.komentarOcenaList = komentarOcenaList;
    }

    public void setItems(ArrayList<KomentarOcena> list){
        komentarOcenaList.clear();
        komentarOcenaList.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int phraseIndex = position;
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.ocena_komentar, parent, false);
        }

        TextView kor_imeView = convertView.findViewById(R.id.OcenaKomentarKorIme);
        TextView ocenaView = convertView.findViewById(R.id.OcenaKomentarOcena);
        TextView komentarView = convertView.findViewById(R.id.OcenaKomentarKomentar);

        kor_imeView.setText(komentarOcenaList.get(position).kor_ime);
        if(komentarOcenaList.get(position).ocena == 0){
            ocenaView.setText("/");
        }
        else {
            ocenaView.setText(Integer.toString(komentarOcenaList.get(position).ocena));
        }
        if(komentarOcenaList.get(position).komentar.equals("") || komentarOcenaList.get(position).komentar == null){
            komentarView.setText("/");
        }
        else{
            komentarView.setText(komentarOcenaList.get(position).komentar);
        }
        return convertView;
    }

    @Override
    public int getCount(){
        return komentarOcenaList.size();
    }

}
