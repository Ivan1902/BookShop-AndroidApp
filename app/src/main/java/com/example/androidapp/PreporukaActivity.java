package com.example.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
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

public class PreporukaActivity extends AppCompatActivity {
    Korisnik korisnik;
    Knjiga knjiga;
    ArrayList<Korisnik> sviKorisnici;
    ArrayList<Knjiga> sveKnjige;
    ArrayList<KomentarOcena> komentariOcene;
    ArrayList<Preporuka> preporuke;
    ArrayList<Korisnik> korisniciZaPreporuku;
    ListView listView;
    TextView preporukaPoruka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preporuka);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        korisnik = (Korisnik) intent.getSerializableExtra("korisnik");
        knjiga = (Knjiga) intent.getSerializableExtra("knjiga");
        sviKorisnici = (ArrayList<Korisnik>) b.getSerializable("sviKorisnici");
        sveKnjige = (ArrayList<Knjiga>) b.getSerializable("sveKnjige");
        komentariOcene = (ArrayList<KomentarOcena>) b.getSerializable("komentariOcene");
        preporuke = (ArrayList<Preporuka>) b.getSerializable("preporuke");

        korisniciZaPreporuku = new ArrayList<Korisnik>();
        for(Korisnik kor : sviKorisnici){
            if(!kor.kor_ime.equals(korisnik.kor_ime) && kor.tip != 1){
                korisniciZaPreporuku.add(kor);
            }
        }

        preporukaPoruka = findViewById(R.id.preporukaPoruka);

        if(preporukaPoruka != null){
            preporukaPoruka.setText("");
        }

        KorisniciAdapter adapter = new KorisniciAdapter(getApplicationContext(), R.layout.activity_preporuka, korisniciZaPreporuku);
        listView = findViewById(R.id.preporukaListaKorisnika);

        listView.setAdapter(adapter);


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

    public void preporuciOdabranim(View view){
        ArrayList<String> odabraniKorisnici = new ArrayList<String>();
        for(int i = 0; i < listView.getCount(); i++){
            View v = listView.getChildAt(i);
            CheckBox cb = v.findViewById(R.id.odabrano);
            TextView tv = v.findViewById(R.id.korisnickoIme);
            if(cb.isChecked()){
                odabraniKorisnici.add(tv.getText().toString());
            }
        }
        if(odabraniKorisnici.size() == 0){
            preporukaPoruka.setText("Morate odabrati barem jednog korisnika!");
            return;
        }
        for (String korisnik: odabraniKorisnici){
            boolean found = false;
            for(Preporuka preporuka: preporuke){
                if(preporuka.kor_ime.equals(korisnik) && preporuka.idKnjige == knjiga.id){
                    found = true;
                }
            }
            if(!found){
                preporuke.add(new Preporuka(knjiga.id, korisnik));
            }
        }
        preporukaPoruka.setText("Uspesno preporuceno odabranim korisnicima!");
    }
}
