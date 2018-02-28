package shuuya.palkkavahti;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miisu on 9.7.2016.
 */
public class TiedotActivity extends AppCompatActivity {
    Spinner alue,ala,kokemus,palkkaluokka,tyosuhdemuoto;
    EditText vero;
    Button aseta;
    Palkka palkka = new Palkka();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiedot);
        alue = (Spinner)findViewById(R.id.spinner);
        ala = (Spinner)findViewById(R.id.spinner2);
        kokemus = (Spinner)findViewById(R.id.spinner4);
        palkkaluokka = (Spinner)findViewById(R.id.spinner3);
        tyosuhdemuoto = (Spinner)findViewById(R.id.spinner5);
        vero = (EditText)findViewById(R.id.editText);
        aseta = (Button)findViewById(R.id.button2);
        aseta.setOnClickListener(cliker);

        List<String> list_ala = new ArrayList<String>();
        list_ala.add("Kaupantyöntekijät");
        list_ala.add("Tukkumyyjät");
        List<String>list_alue = new ArrayList<String>();
        list_alue.add("Pääkaupunkiseutu");
        list_alue.add("Muu Suomi");
        final List<String>list_kokemus = new ArrayList<String>();
        final List<String>list_palkkaluokka = new ArrayList<String>();
        List<String>list_tyosuhdemuoto = new ArrayList<String>();
        list_tyosuhdemuoto.add("Osa-aikainen");
        list_tyosuhdemuoto.add("Vakituinen");



        ArrayAdapter<String> alueAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list_alue);
        alueAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        alue.setAdapter(alueAdapter);

        ArrayAdapter<String> alaAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list_ala);
        alaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ala.setAdapter(alaAdapter);

        ArrayAdapter<String> tyosuhdeAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list_tyosuhdemuoto);
        tyosuhdeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tyosuhdemuoto.setAdapter(tyosuhdeAdapter);
        ala.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position ==0){
                    list_palkkaluokka.clear();
                    list_palkkaluokka.add("A");
                    list_palkkaluokka.add("B1");
                    list_palkkaluokka.add("B2");
                    list_palkkaluokka.add("C1");
                    list_palkkaluokka.add("C2");
                    list_palkkaluokka.add("D");

                    ArrayAdapter<String>palkkaAdapter = new ArrayAdapter<String>(TiedotActivity.this,android.R.layout.simple_spinner_item,list_palkkaluokka);
                    palkkaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    palkkaluokka.setAdapter(palkkaAdapter);

                    list_kokemus.clear();
                    list_kokemus.add("Harjoittelija");
                    list_kokemus.add("1.vuotena");
                    list_kokemus.add("3.vuotena");
                    list_kokemus.add("5.vuotena");
                    list_kokemus.add("8.vuotena");

                    ArrayAdapter<String>kokemusAdapter = new ArrayAdapter<String>(TiedotActivity.this,android.R.layout.simple_spinner_item,list_kokemus);
                    kokemusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    kokemus.setAdapter(kokemusAdapter);
                }else{
                    list_palkkaluokka.clear();
                    list_palkkaluokka.add("Tukkumyyjä II");
                    list_palkkaluokka.add("Tukkumyyjä III");
                    ArrayAdapter<String>palkkaAdapter = new ArrayAdapter<String>(TiedotActivity.this,android.R.layout.simple_spinner_item,list_palkkaluokka);
                    palkkaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    palkkaluokka.setAdapter(palkkaAdapter);

                    list_kokemus.clear();
                    list_kokemus.add("Harjoittelija");
                    list_kokemus.add("1.vuotena");
                    list_kokemus.add("3.vuotena");
                    list_kokemus.add("5.vuotena");
                    list_kokemus.add("8.vuotena");

                    ArrayAdapter<String>kokemusAdapter = new ArrayAdapter<String>(TiedotActivity.this,android.R.layout.simple_spinner_item,list_kokemus);
                    kokemusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    kokemus.setAdapter(kokemusAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
    View.OnClickListener cliker = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String alue1 = String.valueOf(alue.getSelectedItem());
            String ala1 = String.valueOf(ala.getSelectedItem());
            String ryhma1 = String.valueOf(palkkaluokka.getSelectedItem());
            String kokemus1 = String.valueOf(kokemus.getSelectedItem());
            String luokka = String.valueOf(tyosuhdemuoto.getSelectedItem());
            double vero1;
            try {
                vero1 = Double.parseDouble(vero.getText().toString());
            } catch (NumberFormatException e) {
                vero1 = 0.0;
            }
            palkka.setVero(vero1);

            switch (ala1) {
                case "Kaupantyöntekijät":
                    switch (alue1) {
                        case "Pääkaupunkiseutu":
                            switch (ryhma1) {
                                case "A":
                                    switch (kokemus1) {
                                        case "Harjoittelija":
                                            if (luokka == "Osa-aikainen") {

                                                palkka.setPalkka(8.993);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1439.05);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "1.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(10.58);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1693.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "3.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(10.96);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1754.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "5.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(11.55);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1848.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "8.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(12.11);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1937.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                    }
                                    break;
                                case "B1":
                                    switch (kokemus1) {
                                        case "Harjoittelija":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(9.452);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1512.15);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "1.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(11.12);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1779.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "3.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(11.49);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1838.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "5.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(12.12);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1939.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "8.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(12.66);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(2026.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                    }
                                    break;
                                case "B2":
                                    switch (kokemus1) {
                                        case "Harjoittelija":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(9.537);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1525.75);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "1.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(11.22);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1795.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "3.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(11.64);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1863.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "5.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(12.29);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1968.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "8.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(12.84);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(2055.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                    }
                                    break;
                                case "C1":
                                    switch (kokemus1) {
                                        case "Harjoittelija":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(10.1065);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1617.55);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "1.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(11.89);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1903.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "3.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(12.31);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1969.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "5.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(13.08);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(2093.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "8.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(13.67);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(2187.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                    }
                                    break;
                                case "C2":
                                    switch (kokemus1) {
                                        case "Harjoittelija":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(0.183);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1629.45);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "1.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(11.98);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1917.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "3.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(12.42);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1987.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "5.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(13.25);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(2120.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "8.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(13.88);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(2221.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                    }
                                    break;
                                case "D":
                                    switch (kokemus1) {
                                        case "Harjoittelija":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(10.7185);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1715.3);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "1.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(12.61);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(2018.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "3.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(13.09);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(2094.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "5.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(13.97);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(2235.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "8.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(15.03);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(2405.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                    }
                                    break;
                            }
                            break;
                        case "Muu Suomi":
                            switch (ryhma1) {
                                case "A":
                                    switch (kokemus1) {
                                        case "Harjoittelija":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(8.636);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1382.1);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "1.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(10.16);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1626.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "3.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(12.52);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1683.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "5.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(11.05);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1768.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "8.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(11.56);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1850.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                    }
                                    break;
                                case "B1":
                                    switch (kokemus1) {
                                        case "Harjoittelija":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(9.0695);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1450.95);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "1.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(10.67);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1707.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "3.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(11.03);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1765.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "5.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(11.63);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1860.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "8.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(12.09);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1935.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                    }
                                    break;
                                case "B2":
                                    switch (kokemus1) {
                                        case "Harjoittelija":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(9.163);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1465.4);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "1.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(10.78);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1724.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "3.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(11.19);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1790.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "5.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(11.76);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1881.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "8.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(12.26);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1962.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                    }
                                    break;
                                case "C1":
                                    switch (kokemus1) {
                                        case "Harjoittelija":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(9.6815);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1549.55);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "1.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(11.39);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1823.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "3.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(11.80);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1888.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "5.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(12.49);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1998.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "8.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(13.03);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(2084.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                    }
                                    break;
                                case "C2":
                                    switch (kokemus1) {
                                        case "Harjoittelija":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(9.758);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1560.6);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "1.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(11.48);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1836.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "3.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(11.88);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1901.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "5.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(12.62);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(2019.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "8.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(13.20);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(2112.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                    }
                                    break;
                                case "D":
                                    switch (kokemus1) {
                                        case "Harjoittelija":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(10.2765);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1643.9);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "1.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(12.09);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(1934.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "3.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(12.66);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(2025.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "5.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(13.31);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(2129.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                        case "8.vuotena":
                                            if (luokka == "Osa-aikainen") {
                                                palkka.setPalkka(14.25);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            } else {
                                                palkka.setPalkka(2280.00);
                                                tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            }
                                            break;
                                    }
                                    break;
                            }
                            break;

                    }
                    break;
                case "Tukkumyyjät":
                    switch (alue1) {
                        case "Pääkaupunkiseutu":
                            switch (ryhma1) {
                                case "Tukkumyyjä II":
                                    switch (kokemus1) {
                                        case "Harjoittelija":
                                            palkka.setPalkka(1910.8);
                                            tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            break;
                                        case "1.vuotena":
                                            palkka.setPalkka(2248.00);
                                            tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            break;
                                        case "3.vuotena":
                                            palkka.setPalkka(2343.00);
                                            tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            break;
                                        case "5.vuotena":
                                            palkka.setPalkka(2454.00);
                                            tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            break;
                                        case "8.vuotena":
                                            palkka.setPalkka(2578.00);
                                            tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            break;
                                    }
                                    break;
                                case "Tukkumyyjä III":
                                    switch (kokemus1) {
                                        case "Harjoittelija":
                                            palkka.setPalkka(2217.65);
                                            tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            break;
                                        case "1.vuotena":
                                            palkka.setPalkka(2609.00);
                                            tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            break;
                                        case "3.vuotena":
                                            palkka.setPalkka(2710.00);
                                            tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            break;
                                        case "5.vuotena":
                                            palkka.setPalkka(2827.00);
                                            tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            break;
                                        case "8.vuotena":
                                            palkka.setPalkka(2961.00);
                                            tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            break;
                                    }
                                    break;
                            }
                        case "Muu Suomi":
                            switch (kokemus1) {
                                case "Tukkumyyjä II":
                                    switch (kokemus1) {
                                        case "Harjoittelija":
                                            palkka.setPalkka(1800.3);
                                            tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            break;
                                        case "1.vuotena":
                                            palkka.setPalkka(2118.00);
                                            tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            break;
                                        case "3.vuotena":
                                            palkka.setPalkka(2211.00);
                                            tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            break;
                                        case "5.vuotena":
                                            palkka.setPalkka(2314.00);
                                            tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            break;
                                        case "8.vuotena":
                                            palkka.setPalkka(2433.00);
                                            tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            break;
                                    }
                                    break;
                                case "Tukkumyyjä III":
                                    switch (kokemus1) {
                                        case "Harjoittelija":
                                            palkka.setPalkka(2077.4);
                                            tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            break;
                                        case "1.vuotena":
                                            palkka.setPalkka(2444.00);
                                            tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            break;
                                        case "3.vuotena":
                                            palkka.setPalkka(2542.00);
                                            tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            break;
                                        case "5.vuotena":
                                            palkka.setPalkka(2635.00);
                                            tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            break;
                                        case "8.vuotena":
                                            palkka.setPalkka(2761.00);
                                            tiedostoonTallennus(palkka.getPalkka(), palkka.getVero());
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }


            }
            if (palkka.getPalkka() > 50) {
                Intent intent = new Intent(TiedotActivity.this, KauppakkActivity.class);
                intent.putExtra("Object", palkka);
                startActivity(intent);
                finish();
            } else {
                Intent intent = new Intent(TiedotActivity.this, MainActivity.class);
                intent.putExtra("Object", palkka);
                startActivity(intent);
                finish();
            }

        }

    };
    private void tiedostoonTallennus(double palkka,double vero) {
        String tallenne = Double.toString(palkka);
        tallenne = tallenne+","+Double.toString(vero);

        try {
            FileOutputStream output = openFileOutput("palkka.txt", Context.MODE_PRIVATE);
            DataOutputStream dout = new DataOutputStream(output);
            dout.writeUTF(tallenne);
            dout.flush();
            dout.close();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
