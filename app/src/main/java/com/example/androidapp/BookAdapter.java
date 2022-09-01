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

import java.util.ArrayList;

public class BookAdapter extends ArrayAdapter<Knjiga> {
    private ArrayList<Knjiga> bookList;

    public BookAdapter(@NonNull Context context, int resource, ArrayList<Knjiga> bookList) {
        super(context, resource, bookList);
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int phraseIndex = position;
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.knjiga, parent, false);
        }

        ImageView bookImage = convertView.findViewById(R.id.knjigaView);
        TextView titleTextView = convertView.findViewById(R.id.nazivKnjige);
        TextView authorTextView = convertView.findViewById(R.id.autorKnjige);

        bookImage.setImageResource(bookList.get(position).slika);
        titleTextView.setText(bookList.get(position).naziv);
        authorTextView.setText(bookList.get(position).autor);

        return convertView;
    }

}