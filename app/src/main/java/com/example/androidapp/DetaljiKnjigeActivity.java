package com.example.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidapp.models.Knjiga;
import com.example.androidapp.models.KomentarOcena;
import com.example.androidapp.models.Korisnik;
import com.example.androidapp.models.Preporuka;

import java.io.Serializable;
import java.util.ArrayList;

public class DetaljiKnjigeActivity extends AppCompatActivity {
    Korisnik korisnik;
    Knjiga knjiga;
    ArrayList<Korisnik> sviKorisnici;
    ArrayList<Knjiga> sveKnjige;
    ArrayList<KomentarOcena> komentariOcene;
    ArrayList<Preporuka> preporuke;
    ImageView detaljiKnjigeSlika;
    TextView detaljiKnjigeOpis;
    TextView detaljiKnjigeNaziv;
    TextView detaljiKnjigeAutor;
    TextView detaljiKnjigeGodina;
    TextView detaljiKnjigeStrane;
    TextView detaljiKnjigeOcena;
    TextView detaljiKnjigeKomentar;
    KomentarOcena mojKomentarOcena;
    ArrayList<KomentarOcena> komentariOceneZaKnjigu;
    TextView detaljiKnjigeOcenaPoruka;
    TextView detaljiKnjigeKomentarPoruka;
    KomentariOceneAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalji_knjige);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        korisnik = (Korisnik) intent.getSerializableExtra("korisnik");
        knjiga = (Knjiga) intent.getSerializableExtra("knjiga");
        sviKorisnici = (ArrayList<Korisnik>) b.getSerializable("sviKorisnici");
        sveKnjige = (ArrayList<Knjiga>) b.getSerializable("sveKnjige");
        komentariOcene = (ArrayList<KomentarOcena>) b.getSerializable("komentariOcene");
        preporuke = (ArrayList<Preporuka>) b.getSerializable("preporuke");

        for(KomentarOcena tmp : komentariOcene){
            if(tmp.kor_ime.equals(korisnik.kor_ime) && tmp.idKnjige == knjiga.id){
                mojKomentarOcena = tmp;
            }
        }

        komentariOceneZaKnjigu = new ArrayList<KomentarOcena>();
        for(KomentarOcena tmp: komentariOcene){
            if(tmp.idKnjige == knjiga.id){
                komentariOceneZaKnjigu.add(tmp);
            }
        }

        detaljiKnjigeSlika = findViewById(R.id.DetaljiKnjigeSlika);
        detaljiKnjigeOpis = findViewById(R.id.DetaljiKnjigeOpis);
        detaljiKnjigeNaziv = findViewById(R.id.detaljiKnjigeNaziv);
        detaljiKnjigeAutor = findViewById(R.id.detaljiKnjigeAutor);
        detaljiKnjigeGodina = findViewById(R.id.detaljiKnjigeGodina);
        detaljiKnjigeStrane = findViewById(R.id.detaljiKnjigeStrane);
        detaljiKnjigeOcena = findViewById(R.id.detaljiKnjigeOcena);
        detaljiKnjigeKomentar = findViewById(R.id.detaljiKnjigeKomentar);
        detaljiKnjigeOcenaPoruka = findViewById(R.id.detaljiKnjigeOcenaPoruka);
        detaljiKnjigeKomentarPoruka = findViewById(R.id.detaljiKnjigeKomentarPoruka);

        if(detaljiKnjigeSlika != null){
            detaljiKnjigeSlika.setImageResource(knjiga.slika);
        }
        if(detaljiKnjigeOpis != null){
            detaljiKnjigeOpis.setText(knjiga.opis);
        }
        if(detaljiKnjigeNaziv != null){
            detaljiKnjigeNaziv.setText(knjiga.naziv);
        }
        if(detaljiKnjigeAutor != null){
            detaljiKnjigeAutor.setText(knjiga.autor);
        }
        if(detaljiKnjigeGodina != null){
            detaljiKnjigeGodina.setText(Integer.toString(knjiga.godina));
        }
        if(detaljiKnjigeStrane != null){
            detaljiKnjigeStrane.setText(Integer.toString(knjiga.strane));
        }
        if(detaljiKnjigeOcena != null){
            if(mojKomentarOcena != null && mojKomentarOcena.ocena != 0){
                detaljiKnjigeOcena.setText(Integer.toString(mojKomentarOcena.ocena));
            }
        }
        if(detaljiKnjigeKomentar != null){
            if(mojKomentarOcena != null && mojKomentarOcena.komentar != null){
                detaljiKnjigeKomentar.setText(mojKomentarOcena.komentar);
            }
        }
        adapter = new KomentariOceneAdapter(getApplicationContext(), R.layout.ocena_komentar, komentariOceneZaKnjigu);
        listView = findViewById(R.id.detaljiKnjigeListaKomentaraIOcena);

        listView.setAdapter(adapter);
        Utility.setListViewHeightBasedOnChildren(listView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.dostupneKnjigeItem: {
                Intent intent = new Intent(this, DostupneKnjigeActivity.class);
                Bundle b = new Bundle();
                intent.putExtra("korisnik", korisnik);
                b.putSerializable("sviKorisnici", (Serializable) sviKorisnici);
                b.putSerializable("sveKnjige", (Serializable) sveKnjige);
                b.putSerializable("komentariOcene", (Serializable) komentariOcene);
                b.putSerializable("preporuke", (Serializable) preporuke);
                intent.putExtras(b);
                startActivity(intent);
                break;
            }
            case R.id.knjigeNaPromocijiItem:{
                Intent intent = new Intent(this, KnjigeNaPromocijiActivity.class);
                Bundle b = new Bundle();
                intent.putExtra("korisnik", korisnik);
                b.putSerializable("sviKorisnici", (Serializable) sviKorisnici);
                b.putSerializable("sveKnjige", (Serializable) sveKnjige);
                b.putSerializable("komentariOcene", (Serializable) komentariOcene);
                b.putSerializable("preporuke", (Serializable) preporuke);
                intent.putExtras(b);
                startActivity(intent);
                break;
            }
            case R.id.preporuceneKnjigeItem:{
                Intent intent = new Intent(this, PreporuceneKnjigeActivity.class);
                Bundle b = new Bundle();
                intent.putExtra("korisnik", korisnik);
                b.putSerializable("sviKorisnici", (Serializable) sviKorisnici);
                b.putSerializable("sveKnjige", (Serializable) sveKnjige);
                b.putSerializable("komentariOcene", (Serializable) komentariOcene);
                b.putSerializable("preporuke", (Serializable) preporuke);
                intent.putExtras(b);
                startActivity(intent);
                break;
            }
            case R.id.izmenaLicnihPodatakaItem:{
                Intent intent = new Intent(this, IzmenaLicnihPodatakaActivity.class);
                Bundle b = new Bundle();
                intent.putExtra("korisnik", korisnik);
                b.putSerializable("sviKorisnici", (Serializable) sviKorisnici);
                b.putSerializable("sveKnjige", (Serializable) sveKnjige);
                b.putSerializable("komentariOcene", (Serializable) komentariOcene);
                b.putSerializable("preporuke", (Serializable) preporuke);
                intent.putExtras(b);
                startActivity(intent);
                break;
            }
            case R.id.izmenaLozinkeItem:{
                Intent intent = new Intent(this, IzmenaLozinkeActivity.class);
                Bundle b = new Bundle();
                intent.putExtra("korisnik", korisnik);
                b.putSerializable("sviKorisnici", (Serializable) sviKorisnici);
                b.putSerializable("sveKnjige", (Serializable) sveKnjige);
                b.putSerializable("komentariOcene", (Serializable) komentariOcene);
                b.putSerializable("preporuke", (Serializable) preporuke);
                intent.putExtras(b);
                startActivity(intent);
                break;
            }
            case R.id.odjavaItem:{
                Intent intent = new Intent(this, MainActivity.class);
                Bundle b = new Bundle();
                intent.putExtra("korisnik", korisnik);
                b.putSerializable("sviKorisnici", (Serializable) sviKorisnici);
                b.putSerializable("sveKnjige", (Serializable) sveKnjige);
                b.putSerializable("komentariOcene", (Serializable) komentariOcene);
                b.putSerializable("preporuke", (Serializable) preporuke);
                intent.putExtras(b);
                startActivity(intent);
                break;
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }
        return true;
    }

    public void unesiOcenu(View view){
        try{
            int ocena = Integer.parseInt(detaljiKnjigeOcena.getText().toString());
            if(ocena < 1 || ocena > 5){
                detaljiKnjigeOcenaPoruka.setText("Ocena mora biti broj u intervalu od 1 do 5!");
                return;
            }
            if(mojKomentarOcena != null){
                mojKomentarOcena.ocena = ocena;
                for(KomentarOcena tmp : komentariOcene){
                    if(tmp.idKnjige == knjiga.id && tmp.kor_ime.equals(korisnik.kor_ime)){
                        tmp.ocena = ocena;
                    }
                }
                for(KomentarOcena tmp : komentariOceneZaKnjigu){
                    if(tmp.idKnjige == knjiga.id && tmp.kor_ime.equals(korisnik.kor_ime)){
                        tmp.ocena = ocena;
                    }
                }
                KomentariOceneAdapter adapter1 = new KomentariOceneAdapter(getApplicationContext(), R.layout.ocena_komentar, komentariOceneZaKnjigu);

                listView.setAdapter(adapter1);
                Utility.setListViewHeightBasedOnChildren(listView);
            }
            else {
                mojKomentarOcena = new KomentarOcena(knjiga.id, korisnik.kor_ime, ocena, "");
                komentariOcene.add(mojKomentarOcena);
                komentariOceneZaKnjigu.add(mojKomentarOcena);

                KomentariOceneAdapter adapter1 = new KomentariOceneAdapter(getApplicationContext(), R.layout.ocena_komentar, komentariOceneZaKnjigu);

                listView.setAdapter(adapter1);
                Utility.setListViewHeightBasedOnChildren(listView);

            }
            detaljiKnjigeOcenaPoruka.setText("");
        }catch(Exception e){
            detaljiKnjigeOcenaPoruka.setText("Ocena mora biti broj u intervalu od 1 do 5!");
            return;
        }
    }
    public void unesiKomentar(View view){
        if(detaljiKnjigeKomentar.getText().toString().equals("")){
            detaljiKnjigeKomentarPoruka.setText("Popunite polje!");
            return;
        }
        if(mojKomentarOcena != null){
            mojKomentarOcena.komentar = detaljiKnjigeKomentar.getText().toString();
            for(KomentarOcena tmp : komentariOcene){
                if(tmp.kor_ime.equals(korisnik.kor_ime) && tmp.idKnjige == knjiga.id){
                    tmp.komentar = mojKomentarOcena.komentar;
                }
            }
            for(KomentarOcena tmp : komentariOceneZaKnjigu){
                if(tmp.kor_ime.equals(korisnik.kor_ime) && tmp.idKnjige == knjiga.id){
                    tmp.komentar = mojKomentarOcena.komentar;
                }
            }
            KomentariOceneAdapter adapter1 = new KomentariOceneAdapter(getApplicationContext(), R.layout.ocena_komentar, komentariOceneZaKnjigu);

            listView.setAdapter(adapter1);
            Utility.setListViewHeightBasedOnChildren(listView);
        }
        else {
            mojKomentarOcena = new KomentarOcena(knjiga.id, korisnik.kor_ime, 0, detaljiKnjigeKomentar.getText().toString());
            komentariOcene.add(mojKomentarOcena);
            komentariOceneZaKnjigu.add(mojKomentarOcena);
            KomentariOceneAdapter adapter1 = new KomentariOceneAdapter(getApplicationContext(), R.layout.ocena_komentar, komentariOceneZaKnjigu);

            listView.setAdapter(adapter1);
            Utility.setListViewHeightBasedOnChildren(listView);
        }
        detaljiKnjigeKomentarPoruka.setText("");
    }
    public void preporuci(View view){
        Intent intent = new Intent(this, PreporukaActivity.class);
        Bundle b = new Bundle();
        intent.putExtra("korisnik", korisnik);
        intent.putExtra("knjiga", knjiga);
        b.putSerializable("sviKorisnici", (Serializable) sviKorisnici);
        b.putSerializable("sveKnjige", (Serializable) sveKnjige);
        b.putSerializable("komentariOcene", (Serializable) komentariOcene);
        b.putSerializable("preporuke", (Serializable) preporuke);
        intent.putExtras(b);
        startActivity(intent);
    }
}
