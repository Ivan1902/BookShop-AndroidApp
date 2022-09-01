package com.example.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidapp.models.Knjiga;
import com.example.androidapp.models.KomentarOcena;
import com.example.androidapp.models.Korisnik;
import com.example.androidapp.models.Preporuka;

import java.io.Serializable;
import java.util.ArrayList;

public class KnjigeNaPromocijiActivity extends AppCompatActivity {
    Korisnik korisnik;
    ArrayList<Korisnik> sviKorisnici;
    ArrayList<Knjiga> sveKnjige;
    ArrayList<KomentarOcena> komentariOcene;
    ArrayList<Knjiga> knjigeNaPromociji;
    ArrayList<Preporuka> preporuke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knjige_na_promociji);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        korisnik = (Korisnik) intent.getSerializableExtra("korisnik");
        sviKorisnici = (ArrayList<Korisnik>) b.getSerializable("sviKorisnici");
        sveKnjige = (ArrayList<Knjiga>) b.getSerializable("sveKnjige");
        komentariOcene = (ArrayList<KomentarOcena>) b.getSerializable("komentariOcene");
        preporuke = (ArrayList<Preporuka>) b.getSerializable("preporuke");

        knjigeNaPromociji = new ArrayList<>();

        for (Knjiga knjiga: sveKnjige) {
            if(knjiga.promocija == 1){
                knjigeNaPromociji.add(knjiga);
            }
        }

        BookAdapter adapter = new BookAdapter(getApplicationContext(), R.layout.knjiga, knjigeNaPromociji);
        ListView listView = findViewById(R.id.listaKnjigaNaPromociji);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Knjiga knjiga = knjigeNaPromociji.get(position);
                Intent intent = new Intent(view.getContext(), DetaljiKnjigeActivity.class);
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
        });
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
}
