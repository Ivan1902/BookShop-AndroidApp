package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidapp.models.Knjiga;
import com.example.androidapp.models.KomentarOcena;
import com.example.androidapp.models.Korisnik;
import com.example.androidapp.models.Preporuka;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Korisnik> sviKorisniciInit = new ArrayList<Korisnik>() {{
        add(new Korisnik("Pera","Petrovic", "pera", "pera123", 123456789, "Bulevar Milutina Milankovica 10", 0));
        add(new Korisnik("Mika","Mikic", "mika", "mika123", 1111111, "Omladinskih brigada 3", 0));
        add(new Korisnik("Zika","Zikic", "zika", "zika123", 999999999, "Sarajevska 114", 0));
        add(new Korisnik("Marko","Markovic", "marko", "marko123", 5555555, "Tosin bunar 144", 1));
    }};
    public ArrayList<Knjiga> sveKnjigeInit = new ArrayList<Knjiga>(){{
        add(new Knjiga(1, R.drawable.ana_karenjina, "Ana Karenjina", "Lav Nikolajevič Tolstoj", 1878, "Roman koji je Fjodor Dostojevski smatrao besprekornim, a Vilijam Fokner nazvao najboljim romanom koji je ikada napisan, Ana Karenjina je monumentalno delo Lava Tolstoja koji daje sveobuhvatan prikaz ruskog društva devetnaestog veka, od aristokratskih salona do seoskih gazdinstava. Uvodeći dva narativna toka, prvi koji prati ljubavnu priču između Ane i Vronskog i drugi koji prati odnos između Kiti i Ljevina, Lav Tolstoj ispisuje svevremene stranice o porodici, gubitku, ljubavi, izdaji, veri i prijateljstvu.", 864, 0));
        add(new Knjiga(2, R.drawable.bela_griva, "Bela griva", "Rene Gijo", 1953, "Poznati roman za decu koji govori o velikom prijateljstvu između dečaka i ždrebeta. Pošto su mu naneli mnogo bola, ždrebe nije volelo ljude. Međutim, dečak Folko, veliki ljubitelj konja, pripitomljava Belu Grivu, pružajući mu veliku ljubav i pažnju, i doživljava sa njim brojne avanture. Siromašni dečak želi do tančina da upozna prirodu konja, a u tome mu pomaže stari prijatelj Antonio. Ova uzbudljiva i dirljiva priča pokazuje da prijateljstvo između čoveka i životinje zaista nema granice. ", 90, 1));
        add(new Knjiga(3, R.drawable.koreni, "Koreni", "Dobrica Ćosić", 1954, "„Koreni su biografija naroda i autobiografija pisca koji je postao sopstveni književni lik, manje Ćosić iz neznane Velike Drenove, a više znameniti Katić iz ovekovečenog Prerova. Koreni su zasađeni u noći istorije, a izdanci dovedeni do naših dana u možda najdužem rukopisu posle naše nepisane poezije.\n" + "Pesnik je nadživeo svoju ideologiju da bi ga nadživela poezija ispisana na stranicama koje nemaju strana.“ Matija Bećković", 376, 0));
        add(new Knjiga(4, R.drawable.na_drini_cuprija, "Na Drini ćuprija", "Ivo Andrić", 1945, "Kameni most iz XVI veka, zadużbina Mehmed paše Sokolovića, kao nemi svedok pamti prividno slaganje različitih kultura, vera i naroda. Most je, bio jedina postojana i nepromenljiva tačka o koju se odbijaju sve napetosti i komešanja koja rađaju sukobe među ljudima, kulturama, verama i tadašnjim carstvima. Upravo tu činjenicu Ivo Andrić koristi da napravi fantastičan pripovijedački luk dug četiri stotine godina od gotovo kristalno čistog literarnog stila, čineći da most postane deo naših sopstvenih żivota.", 366, 1));
    }};
    public ArrayList<Preporuka> preporukeInit = new ArrayList<Preporuka>(){{
        add(new Preporuka(1, "pera"));
        add(new Preporuka(1, "mika"));
        add(new Preporuka(3, "pera"));
        add(new Preporuka(3, "mika"));
        add(new Preporuka(3, "zika"));
    }};
    public ArrayList<KomentarOcena> komentariOceneInit = new ArrayList<KomentarOcena>(){{
        add(new KomentarOcena(1, "mika", 5, "Odlicna knjiga!"));
        add(new KomentarOcena(2, "mika", 5, "Sjajna knjiga!"));
        add(new KomentarOcena(1, "zika", 5, "Odlicno napisana knjiga!"));
    }};

    public ArrayList<Korisnik> sviKorisnici;
    public ArrayList<Knjiga> sveKnjige;
    public ArrayList<Preporuka> preporuke;
    public ArrayList<KomentarOcena> komentariOcene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        sviKorisnici = b != null ? (ArrayList<Korisnik>) b.getSerializable("sviKorisnici") : sviKorisniciInit;
        sveKnjige = b != null ? (ArrayList<Knjiga>) b.getSerializable("sveKnjige") : sveKnjigeInit;
        komentariOcene = b != null ? (ArrayList<KomentarOcena>) b.getSerializable("komentariOcene") : komentariOceneInit;
        preporuke = b != null ? (ArrayList<Preporuka>) b.getSerializable("preporuke") : preporukeInit;
    }

    public void prijavaNaSistem(View view){
        String korisnicko_ime = ((EditText)findViewById(R.id.kor_ime)).getText().toString();
        String lozinka = ((EditText)findViewById(R.id.lozinka)).getText().toString();
        TextView poruka = findViewById(R.id.poruka);
        boolean nadjenoKorisnickoIme = false;

        for (Korisnik korisnik: sviKorisnici) {
            if(korisnik.kor_ime.equals(korisnicko_ime)){
                nadjenoKorisnickoIme = true;
                if(korisnik.lozinka.equals(lozinka)){
                    Intent intent = new Intent(this, DostupneKnjigeActivity.class);
                    Bundle b = new Bundle();
                    intent.putExtra("korisnik", korisnik);
                    b.putSerializable("sviKorisnici", (Serializable) sviKorisnici);
                    b.putSerializable("sveKnjige", (Serializable) sveKnjige);
                    b.putSerializable("komentariOcene", (Serializable) komentariOcene);
                    b.putSerializable("preporuke", (Serializable) preporuke);
                    intent.putExtras(b);
                    startActivity(intent);
                }
                else {
                    poruka.setText("Neispravna lozinka!");
                }
            }
        }
        if(!nadjenoKorisnickoIme) poruka.setText("Ne postoji korisnik sa unetim korisnickim imenom!");
    }
}