package com.example.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidapp.models.Knjiga;
import com.example.androidapp.models.KomentarOcena;
import com.example.androidapp.models.Korisnik;
import com.example.androidapp.models.Preporuka;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;

public class IzmenaLicnihPodatakaActivity extends AppCompatActivity {
    Korisnik korisnik;
    ArrayList<Korisnik> sviKorisnici;
    ArrayList<Knjiga> sveKnjige;
    ArrayList<KomentarOcena> komentariOcene;
    ArrayList<Preporuka> preporuke;
    EditText izmenaLicnihPodatakaIme;
    EditText izmenaLicnihPodatakaPrezime;
    EditText izmenaLicnihPodatakaTelefon;
    EditText izmenaLicnihPodatakaAdresa;
    TextView izmenaLicnihPodatakaPoruka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izmena_licnih_podataka);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        korisnik = (Korisnik) intent.getSerializableExtra("korisnik");
        sviKorisnici = (ArrayList<Korisnik>) b.getSerializable("sviKorisnici");
        sveKnjige = (ArrayList<Knjiga>) b.getSerializable("sveKnjige");
        komentariOcene = (ArrayList<KomentarOcena>) b.getSerializable("komentariOcene");
        preporuke = (ArrayList<Preporuka>) b.getSerializable("preporuke");


        izmenaLicnihPodatakaIme = ((EditText)findViewById(R.id.izmenaLicnihPodatakaIme));
        izmenaLicnihPodatakaPrezime = ((EditText)findViewById(R.id.izmenaLicnihPodatakaPrezime));
        izmenaLicnihPodatakaTelefon = ((EditText)findViewById(R.id.izmenaLicnihPodatakaKontaktTelefon));
        izmenaLicnihPodatakaAdresa = ((EditText)findViewById(R.id.izmenaLicnihPodatakaAdresa));
        izmenaLicnihPodatakaPoruka = (TextView)findViewById(R.id.izmenaLicnihPodatakaPoruka);

        if(izmenaLicnihPodatakaIme != null){
            izmenaLicnihPodatakaIme.setText(korisnik.ime);
        }
        if(izmenaLicnihPodatakaPrezime != null){
            izmenaLicnihPodatakaPrezime.setText(korisnik.prezime);
        }
        if(izmenaLicnihPodatakaTelefon != null){
            izmenaLicnihPodatakaTelefon.setText(Integer.toString(korisnik.telefon));
        }
        if(izmenaLicnihPodatakaAdresa != null){
            izmenaLicnihPodatakaAdresa.setText(korisnik.adresa);
        }
        if(izmenaLicnihPodatakaPoruka != null){
            izmenaLicnihPodatakaPoruka.setText("");
        }

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

    public void unesiIzmene(View view){
        if(izmenaLicnihPodatakaIme.getText().toString().equals("") || izmenaLicnihPodatakaPrezime.getText().toString().equals("") ||
            izmenaLicnihPodatakaTelefon.getText().toString().equals("") || izmenaLicnihPodatakaAdresa.getText().toString().equals("")){
            izmenaLicnihPodatakaPoruka.setText("Sva polja moraju biti popunjena!");
            return;
        }
        if(izmenaLicnihPodatakaIme.getText().toString().charAt(0) != izmenaLicnihPodatakaIme.getText().toString().toUpperCase().charAt(0)){
            izmenaLicnihPodatakaPoruka.setText("Prvo slovo imena mora biti velik slovo!");
            return;
        }
        if(izmenaLicnihPodatakaPrezime.getText().toString().charAt(0) != izmenaLicnihPodatakaPrezime.getText().toString().toUpperCase().charAt(0)){
            izmenaLicnihPodatakaPoruka.setText("Prvo slovo prezimena mora biti velik slovo!");
            return;
        }
        for(char slovo: izmenaLicnihPodatakaIme.getText().toString().toCharArray()){
            if(Character.isDigit(slovo)){
                izmenaLicnihPodatakaPoruka.setText("Ime ne sme da sadrzi broj!");
                return;
            }
        }
        for(char slovo: izmenaLicnihPodatakaPrezime.getText().toString().toCharArray()){
            if(Character.isDigit(slovo)){
                izmenaLicnihPodatakaPoruka.setText("Prezime ne sme da sadrzi broj!");
                return;
            }
        }
        for(char slovo: izmenaLicnihPodatakaTelefon.getText().toString().toCharArray()){
            if(!Character.isDigit(slovo)){
                izmenaLicnihPodatakaPoruka.setText("Kontakt telefon nije broj!");
                return;
            }
        }
        this.korisnik.ime = izmenaLicnihPodatakaIme.getText().toString();
        this.korisnik.prezime = izmenaLicnihPodatakaPrezime.getText().toString();
        this.korisnik.telefon = Integer.parseInt(izmenaLicnihPodatakaTelefon.getText().toString());
        this.korisnik.adresa = izmenaLicnihPodatakaAdresa.getText().toString();

        for(Korisnik user: sviKorisnici){
            if(user.kor_ime.equals(korisnik.kor_ime)){
                user.ime = korisnik.ime;
                user.prezime = korisnik.prezime;
                user.telefon = korisnik.telefon;
                user.adresa = korisnik.adresa;
            }
        }
        izmenaLicnihPodatakaPoruka.setText("Uspesno azurirano!");
    }
}
