package shuuya.palkkavahti;

import android.support.v7.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;


import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;




import java.io.BufferedReader;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.InputStreamReader;


import java.io.OutputStreamWriter;
import java.io.Writer;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 * Created by Miisu on 9.7.2016.
 */
public class KauppakkActivity extends AppCompatActivity{
        CalendarView calendar;
Calendar selected = Calendar.getInstance();
        String weekday = "";
        String alku = "";
        String loppu = "";
        double palkka = 0;
        double tulos = 0;
        double iltalisa = 4.10;
        double yolisa = 6.16;
        double lauantailisa = 5.35;
        double sunnuntailisa=0.0;
        double vero;
        int paiva = 0;
        int isLastday = 0;
        boolean on = false;
        String paeva = "";
        //brutto tulon tallenteet
        HashMap<String,String> jan = new HashMap<>();
        HashMap<String,String> feb = new HashMap<>();
        HashMap<String,String> mar = new HashMap<>();
        HashMap<String,String> apr = new HashMap<>();
        HashMap<String,String> may = new HashMap<>();
        HashMap<String,String> jun = new HashMap<>();
        HashMap<String,String> jul = new HashMap<>();
        HashMap<String,String> aug = new HashMap<>();
        HashMap<String,String> sep = new HashMap<>();
        HashMap<String,String> oct = new HashMap<>();
        HashMap<String,String> nov = new HashMap<>();
        HashMap<String,String> dec = new HashMap<>();
        //tuntien tallenteet
        HashMap<String,String> tammi_perus = new HashMap<>();
        HashMap<String,String> tammi_ilta = new HashMap<>();
        HashMap<String,String> tammi_lauantai = new HashMap<>();
        HashMap<String,String> tammi_yo = new HashMap<>();
        HashMap<String,String> tammi_sunnuntai = new HashMap<>();
        HashMap<String,String> helmi_perus = new HashMap<>();
        HashMap<String,String> helmi_ilta = new HashMap<>();
        HashMap<String,String> helmi_lauantai = new HashMap<>();
        HashMap<String,String> helmi_yo= new HashMap<>();
        HashMap<String,String> helmi_sunnuntai = new HashMap<>();
        HashMap<String,String> maalis_perus = new HashMap<>();
        HashMap<String,String> maalis_ilta = new HashMap<>();
        HashMap<String,String> maalis_lauantai = new HashMap<>();
        HashMap<String,String> maalis_yo = new HashMap<>();
        HashMap<String,String> maalis_sunnuntai = new HashMap<>();
        HashMap<String,String> huhti_perus = new HashMap<>();
        HashMap<String,String> huhti_ilta = new HashMap<>();
        HashMap<String,String> huhti_lauantai = new HashMap<>();
        HashMap<String,String> huhti_yo = new HashMap<>();
        HashMap<String,String> huhti_sunnuntai = new HashMap<>();
        HashMap<String,String> touko_perus = new HashMap<>();
        HashMap<String,String> touko_ilta = new HashMap<>();
        HashMap<String,String> touko_lauantai = new HashMap<>();
        HashMap<String,String> touko_yo = new HashMap<>();
        HashMap<String,String> touko_sunnuntai = new HashMap<>();
        HashMap<String,String> kesa_perus = new HashMap<>();
        HashMap<String,String> kesa_ilta = new HashMap<>();
        HashMap<String,String> kesa_lauantai = new HashMap<>();
        HashMap<String,String> kesa_yo = new HashMap<>();
        HashMap<String,String> kesa_sunnuntai = new HashMap<>();
        HashMap<String,String> heina_perus = new HashMap<>();
        HashMap<String,String> heina_ilta = new HashMap<>();
        HashMap<String,String> heina_lauantai = new HashMap<>();
        HashMap<String,String> heina_yo = new HashMap<>();
        HashMap<String,String> heina_sunnuntai = new HashMap<>();
        HashMap<String,String> elo_perus = new HashMap<>();
        HashMap<String,String> elo_ilta = new HashMap<>();
        HashMap<String,String> elo_lauantai = new HashMap<>();
        HashMap<String,String> elo_yo = new HashMap<>();
        HashMap<String,String> elo_sunnuntai = new HashMap<>();
        HashMap<String,String> syys_perus = new HashMap<>();
        HashMap<String,String> syys_ilta = new HashMap<>();
        HashMap<String,String> syys_lauantai = new HashMap<>();
        HashMap<String,String> syys_yo = new HashMap<>();
        HashMap<String,String> syys_sunnuntai = new HashMap<>();
        HashMap<String,String> loka_perus = new HashMap<>();
        HashMap<String,String> loka_ilta = new HashMap<>();
        HashMap<String,String> loka_lauantai = new HashMap<>();
        HashMap<String,String> loka_yo = new HashMap<>();
        HashMap<String,String> loka_sunnuntai = new HashMap<>();
        HashMap<String,String> marras_perus = new HashMap<>();
        HashMap<String,String> marras_ilta = new HashMap<>();
        HashMap<String,String> marras_lauantai = new HashMap<>();
        HashMap<String,String> marras_yo = new HashMap<>();
        HashMap<String,String> marras_sunnuntai = new HashMap<>();
        HashMap<String,String> joulu_perus = new HashMap<>();
        HashMap<String,String> joulu_ilta = new HashMap<>();
        HashMap<String,String> joulu_lauantai = new HashMap<>();
        HashMap<String,String> joulu_yo = new HashMap<>();
        HashMap<String,String> joulu_sunnuntai = new HashMap<>();


        double tammikuu_perus,tammikuu_ilta,tammikuu_lauantai,tammikuu_yo,tammikuu_sunnuntai;
        double helmikuu_perus,helmikuu_ilta,helmikuu_lauantai,helmikuu_yo,helmikuu_sunnuntai;
        double maaliskuu_perus,maaliskuu_ilta,maaliskuu_lauantai,maaliskuu_yo,maaliskuu_sunnuntai;
        double huhtikuu_perus,huhtikuu_ilta,huhtikuu_lauantai,huhtikuu_yo,huhtikuu_sunnuntai;
        double toukokuu_perus,toukokuu_ilta,toukokuu_lauantai,toukokuu_yo,toukokuu_sunnuntai;
        double kesakuu_perus,kesakuu_ilta,kesakuu_lauantai,kesakuu_yo,kesakuu_sunnuntai;
        double heinakuu_perus,heinakuu_ilta,heinakuu_lauantai,heinakuu_yo,heinakuu_sunnuntai;
        double elokuu_perus,elokuu_ilta,elokuu_lauantai,elokuu_yo,elokuu_sunnuntai;
        double syyskuu_perus,syyskuu_ilta,syyskuu_lauantai,syyskuu_yo,syyskuu_sunnuntai;
        double lokakuu_perus,lokakuu_ilta,lokakuu_lauantai,lokakuu_yo,lokakuu_sunnuntai;
        double marraskuu_perus,marraskuu_ilta,marraskuu_lauantai,marraskuu_yo,marraskuu_sunnuntai;
        double joulukuu_perus,joulukuu_ilta,joulukuu_lauantai,joulukuu_yo,joulukuu_sunnuntai;





        TextView tammi, helmi, maalis, huhti, touko, kesa, heina, elo, syys, loka, marras, joulu;
        TextView tammik,helmik,maalisk,huhtik,toukok,kesak,heinak,elok,syysk,lokak,marrask,jouluk;
        Button poisto;
final Context context = this;


@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        Palkka liksa = (Palkka) i.getSerializableExtra("Object");
        palkka = liksa.getPalkka();
        vero = liksa.getVero();
        sunnuntailisa = (palkka/160);
        setContentView(R.layout.activity_main);
        tammi = (TextView) findViewById(R.id.p_tammi);
        tammik = (TextView)findViewById(R.id.tammi);
        tammik.setOnClickListener(clicker);
        helmi = (TextView) findViewById(R.id.p_helmi);
        helmik = (TextView)findViewById(R.id.helmi);
        helmik.setOnClickListener(clicker);
        maalis = (TextView) findViewById(R.id.p_maalis);
        maalisk = (TextView)findViewById(R.id.maalis);
        maalisk.setOnClickListener(clicker);
        huhti = (TextView) findViewById(R.id.p_huhti);
        huhtik = (TextView)findViewById(R.id.huhti);
        huhtik.setOnClickListener(clicker);
        touko = (TextView) findViewById(R.id.p_touko);
        toukok = (TextView)findViewById(R.id.touko);
        toukok.setOnClickListener(clicker);
        kesa = (TextView) findViewById(R.id.p_kesa);
        kesak = (TextView)findViewById(R.id.kesa);
        kesak.setOnClickListener(clicker);
        heina = (TextView) findViewById(R.id.p_heina);
        heinak = (TextView)findViewById(R.id.heina);
        heinak.setOnClickListener(clicker);
        elo = (TextView) findViewById(R.id.p_elo);
        elok = (TextView)findViewById(R.id.elo);
        elok.setOnClickListener(clicker);
        syys = (TextView) findViewById(R.id.p_syys);
        syysk = (TextView)findViewById(R.id.syys);
        syysk.setOnClickListener(clicker);
        loka = (TextView) findViewById(R.id.p_loka);
        lokak = (TextView)findViewById(R.id.loka);
        lokak.setOnClickListener(clicker);
        marras = (TextView) findViewById(R.id.p_marras);
        marrask = (TextView)findViewById(R.id.marras);
        marrask.setOnClickListener(clicker);
        joulu = (TextView) findViewById(R.id.p_joulu);
        jouluk = (TextView)findViewById(R.id.joulu);
        jouluk.setOnClickListener(clicker);
        poisto = (Button)findViewById(R.id.Poisto);
        poisto.setOnClickListener(remove);
        alustus();
        initializeCalendar();
        }

public void initializeCalendar() {

        calendar = (CalendarView) findViewById(R.id.calendar);

        calendar.setShowWeekNumber(false);

        calendar.setFirstDayOfWeek(2);


        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
@Override
public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
        selected.setFirstDayOfWeek(Calendar.MONDAY);


        selected.set(year, month, day);
        paeva = day + "." + (month + 1);

        int dayOfWeek = selected.get(Calendar.DAY_OF_WEEK);

        if (day == selected.getActualMaximum(Calendar.DATE)) {
        isLastday = 1;

        } else {
        isLastday = 0;

        }


        switch (dayOfWeek) {
        case 1:
        weekday = "Sunday";
        tunnit(weekday, month,day);
        break;
        case 2:
        weekday = "Monday";
        tunnit(weekday, month,day);
        break;
        case 3:
        weekday = "Tuesday";
        tunnit(weekday, month,day);
        break;
        case 4:
        weekday = "Wednesday";
        tunnit(weekday, month,day);
        break;
        case 5:
        weekday = "Thursday";
        tunnit(weekday, month,day);
        break;
        case 6:
        weekday = "Friday";
        tunnit(weekday, month,day);
        break;
        case 7:
        weekday = "Saturday";
        tunnit(weekday, month,day);
        break;


        }

        }
        });
        }



private void tunnit(String valinta, int month,int day) {
final int kuukausi = month;
final String choose = valinta;
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.promts, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        alertDialogBuilder.setView(promptsView);
final TextView date = (TextView) promptsView.findViewById(R.id.päivämäärä);
        date.setText(""+day+"."+(month+1));
final EditText alkutunnit = (EditText) promptsView.findViewById(R.id.alkutunnit);


final EditText lopputunnit = (EditText) promptsView.findViewById(R.id.lopputunnit);


        alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int id) {
        if ("".equals(alkutunnit.getText().toString())) {
        alkutunnit.setError("Alkutunnit vaadittu");
        return;
        } else {
        alku = alkutunnit.getText().toString();

        }
        if ("".equals(lopputunnit.getText().toString())) {
        lopputunnit.setError("Lopputunnit vaadittu");
        return;
        } else
        loppu = lopputunnit.getText().toString();


        switch (choose)

        {
        case "Monday":
        arki(alku, loppu, kuukausi);
        break;
        case "Tuesday":
        arki(alku, loppu, kuukausi);
        break;
        case "Wednesday":
        arki(alku, loppu, kuukausi);
        break;
        case "Thursday":
        arki(alku, loppu, kuukausi);
        break;
        case "Friday":
        arki(alku, loppu, kuukausi);
        break;
        case "Saturday":
        lauantai(alku, loppu, kuukausi);
        break;
        case "Sunday":
        sunnuntai(alku, loppu, kuukausi);
        break;
        }
        //tulostus(alku, loppu, kuukausi);

        }
        }

        ).

        setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int id) {
        dialog.cancel();
        }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();


        }

private void tulostus(double lh, double lDouble, double ah, double aDouble, Double lisat, double yo, int yovuoro, int kuu, int paiva) {
        double tunnit = 0;
        on = false;

        if (paiva == 1) {
        if (((lh + lDouble) - (ah + aDouble)) > 7 && yovuoro == 0) {
        tunnit =   lisat * iltalisa;

        } else if (((lh + lDouble) - (ah + aDouble)) <= 7 && yovuoro == 0) {
        tunnit =  lisat * iltalisa;

        } else if ((24 - (ah + aDouble) + (lDouble + lh) > 7 && yovuoro == 1 && isLastday == 0)) {
        tunnit =  lisat * iltalisa + yo * yolisa;
        } else if ((24 - (ah + aDouble) + (lDouble + lh) <= 7 && yovuoro == 1 && isLastday == 0)) {
        tunnit = lisat * iltalisa + yo * yolisa;
        } else if ((24 - (ah + aDouble) + (lDouble + lh) > 7 && yovuoro == 1 && isLastday == 1)) {
        tunnit = lisat * iltalisa + yo * yolisa;
        on = true;
        } else if ((24 - (ah + aDouble) + (lDouble + lh) <= 7 && yovuoro == 1 && isLastday == 1)) {
        tunnit =  lisat * iltalisa + yo * yolisa;
        on = true;

        }
        } else if (paiva == 2) {
        if (((lh + lDouble) - (ah + aDouble)) > 7 && yovuoro == 0) {
        tunnit =  lisat * lauantailisa;
        } else if (((lh + lDouble) - (ah + aDouble)) <= 7 && yovuoro == 0) {
        tunnit =  lisat * lauantailisa;
        } else if ((24 - (ah + aDouble) + (lDouble + lh) > 7 && yovuoro == 1 && isLastday == 0)) {
        tunnit = lisat * lauantailisa + yo * sunnuntailisa;
        } else if ((24 - (ah + aDouble) + (lDouble + lh) <= 7 && yovuoro == 1 && isLastday == 0)) {
        tunnit =  lisat * lauantailisa + yo * sunnuntailisa;
        } else if ((24 - (ah + aDouble) + (lDouble + lh) > 7 && yovuoro == 1 && isLastday == 1)) {
        on = true;
        tunnit =  + lisat * lauantailisa + yo * sunnuntailisa;
        } else if ((24 - (ah + aDouble) + (lDouble + lh) <= 7 && yovuoro == 1 && isLastday == 1)) {
        on = true;
        tunnit = ((24 - (aDouble + ah) + (lh + lDouble)) * palkka) + lisat * lauantailisa + yo * sunnuntailisa;
        }
        } else {
        if (((lh + lDouble) - (ah + aDouble)) > 7 && yovuoro == 0) {
        tunnit = (((lh + lDouble) - (ah + aDouble)) * (sunnuntailisa)) + lisat * iltalisa;

        } else if (((lh + lDouble) - (ah + aDouble)) <= 7 && yovuoro == 0) {
        tunnit = (((lh + lDouble) - (ah + aDouble)) * ( sunnuntailisa)) + lisat * iltalisa;

        } else if ((24 - (ah + aDouble) + (lDouble + lh) > 7 && yovuoro == 1 && isLastday == 0)) {
        tunnit =  lisat * (iltalisa + sunnuntailisa) + yo * yolisa;
        } else if ((24 - (ah + aDouble) + (lDouble + lh) <= 7 && yovuoro == 1 && isLastday == 0)) {
        tunnit =  lisat * (iltalisa + sunnuntailisa) + yo * yolisa;
        } else if ((24 - (ah + aDouble) + (lDouble + lh) > 7 && yovuoro == 1 && isLastday == 1)) {
        tunnit =  lisat * (iltalisa + sunnuntailisa) + yo * yolisa;
        on = true;

        } else if ((24 - (ah + aDouble) + (lDouble + lh) <= 7 && yovuoro == 1 && isLastday == 1)) {
        on = true;
        tunnit =  lisat * (iltalisa + sunnuntailisa) + yo * yolisa;
        }

        }



        switch (kuu) {
        case 0:
        if (on && paiva == 1) {
        jan.remove(paeva);
        //double luku = tunnit - ((24 - (ah + aDouble)) * palkka + lisat * iltalisa);
        //kuunVaihde(luku, 1);
        //jan.put(paeva, "" + (tunnit - luku));
        jan.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = jan.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("tammikuu.txt", kakka);
        }
        iteraatio(jan, tammi);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        } else if (on && paiva == 2) {
        jan.remove(paeva);

        jan.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = jan.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("tammikuu.txt", kakka);
        }
        iteraatio(jan, tammi);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");

        } else if (on && paiva == 3) {
        jan.remove(paeva);
        //double luku = tunnit - ((24 - (ah + aDouble)) * palkka + lisat * (iltalisa + sunnuntailisa));

        //kuunVaihde(luku, 1);
        //jan.put(paeva, "" + (tunnit - luku));
        jan.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}

        Set set = jan.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("tammikuu.txt", kakka);
        }
        iteraatio(jan, tammi);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        } else {
        jan.remove(paeva);
        jan.put(paeva, "" +(tunnit));

        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = jan.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("tammikuu.txt", kakka);
        }
        iteraatio(jan, tammi);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        }


        break;
        case 1:
        if (on && paiva == 1) {
        feb.remove(paeva);
        feb.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = feb.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("helmikuu.txt", kakka);
        }
        iteraatio(feb, helmi);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        } else if (on && paiva == 2) {
        feb.remove(paeva);;
        feb.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = feb.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("helmikuu.txt", kakka);
        }
        iteraatio(feb, helmi);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");

        } else if (on && paiva == 3) {
        feb.remove(paeva);
        feb.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = feb.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("helmikuu.txt", kakka);
        }
        iteraatio(feb, helmi);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        } else {
        feb.remove(paeva);
        feb.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = feb.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("helmikuu.txt", kakka);
        }
        iteraatio(feb, helmi);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        }


        break;
        case 2:
        if (on && paiva == 1) {
        mar.remove(paeva);
        mar.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = mar.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("maaliskuu.txt", kakka);
        }
        iteraatio(mar, maalis);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        } else if (on && paiva == 2) {
        mar.remove(paeva);
        mar.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = mar.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("maaliskuu.txt", kakka);
        }
        iteraatio(mar, maalis);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");

        } else if (on && paiva == 3) {
        mar.remove(paeva);
        mar.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = mar.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("maaliskuu.txt", kakka);
        }
        iteraatio(mar, maalis);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        } else {
        mar.remove(paeva);
        mar.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = mar.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("maaliskuu.txt", kakka);
        }
        iteraatio(mar, maalis);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        }


        break;
        case 3:
        if (on && paiva == 1) {
        apr.remove(paeva);
        apr.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = apr.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("huhtikuu.txt", kakka);
        }
        iteraatio(apr, huhti);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        } else if (on && paiva == 2) {
        apr.remove(paeva);
        apr.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = apr.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("huhtikuu.txt", kakka);
        }
        iteraatio(apr, huhti);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");

        } else if (on && paiva == 3) {
        apr.remove(paeva);
        apr.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = apr.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("huhtikuu.txt", kakka);
        }
        iteraatio(apr, huhti);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        } else {
        apr.remove(paeva);
        apr.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = apr.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("huhtikuu.txt", kakka);
        }
        iteraatio(apr, huhti);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        }


        break;
        case 4:
        if (on && paiva == 1) {
        may.remove(paeva);
        may.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = may.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("toukokuu.txt", kakka);
        }
        iteraatio(may, touko);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        } else if (on && paiva == 2) {
        may.remove(paeva);
        may.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = may.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("toukokuu.txt", kakka);
        }
        iteraatio(may, touko);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");

        } else if (on && paiva == 3) {
        may.remove(paeva);
        may.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = may.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("toukokuu.txt", kakka);
        }
        iteraatio(may, touko);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        } else {
        may.remove(paeva);
        //may.add(tunnit);
        //for (int i = 0; i < may.size(); i++) {
        // tulos = may.get(i);
        may.put(paeva,""+tunnit);


        //}

        Set set = may.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("toukokuu.txt", kakka);
        }

        iteraatio(may,touko);
        //tiedostoonTallennus("Toukokuu.txt", tulos);
        //touko.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        }


        break;
        case 5:
        if (on && paiva == 1) {
        jun.remove(paeva);
        jun.put(paeva,""+(tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = jun.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("kesäkuu.txt", kakka);
        }
        iteraatio(jun,kesa);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        } else if (on && paiva == 2) {
        jun.remove(paeva);
        jun.put(paeva,""+(tunnit));
                    /*for (int i = 0; i < jun.size(); i++) {
                        tulos += jun.get(i);
                    }*/
        Set set = jun.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("kesäkuu.txt", kakka);
        }
        iteraatio(jun, kesa);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");

        } else if (on && paiva == 3) {
        jun.remove(paeva);
        jun.put(paeva, "" + (tunnit));
                    /*for (int i = 0; i < jun.size(); i++) {
                        tulos += jun.get(i);
                    }*/

        Set set = jun.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("kesäkuu.txt", kakka);
        }
        iteraatio(jun, kesa);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        } else {
        jun.remove(paeva);
        jun.put(paeva,""+tunnit);
        Set set = jun.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("kesäkuu.txt", kakka);
        }
        iteraatio(jun, kesa);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        }


        break;
        case 6:
        if (on && paiva == 1) {
        jul.remove(paeva);
        jul.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = jul.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("heinäkuu.txt", kakka);
        }
        iteraatio(jul, heina);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        } else if (on && paiva == 2) {
        jul.remove(paeva);
        jul.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = jul.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("heinäkuu.txt", kakka);
        }
        iteraatio(jul, heina);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");

        } else if (on && paiva == 3) {
        jul.remove(paeva);
        jul.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = jul.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("heinäkuu.txt", kakka);
        }
        iteraatio(jul, heina);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        } else {
        jul.remove(paeva);
        jul.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = jul.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("heinäkuu.txt", kakka);
        }
        iteraatio(jul, heina);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        }


        break;
        case 7:
        //Tästä mallia
        if (on && paiva == 1) {
        aug.remove(paeva);
        aug.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = aug.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("elokuu.txt", kakka);
        }
        iteraatio(aug, elo);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        } else if (on && paiva == 2) {
        aug.remove(paeva);
        aug.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = aug.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("elokuu.txt", kakka);
        }
        iteraatio(aug, elo);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");

        } else if (on && paiva == 3) {
        aug.remove(paeva);
        aug.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = aug.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("elokuu.txt", kakka);
        }
        iteraatio(aug, elo);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        } else {
        aug.remove(paeva);
        aug.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = aug.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("elokuu.txt", kakka);
        }
        iteraatio(aug, elo);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        }


        break;
        case 8:
        if (on && paiva == 1) {
        sep.remove(paeva);
        sep.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = sep.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("syyskuu.txt", kakka);
        }
        iteraatio(sep, syys);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        } else if (on && paiva == 2) {
        sep.remove(paeva);
        sep.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = sep.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("syyskuu.txt", kakka);
        }
        iteraatio(sep, syys);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");

        } else if (on && paiva == 3) {
        sep.remove(paeva);
        sep.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = sep.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("syyskuu.txt", kakka);
        }
        iteraatio(sep, syys);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        } else {
        sep.remove(paeva);
        sep.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = sep.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("syyskuu.txt", kakka);
        }
        iteraatio(sep, syys);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        }


        break;
        case 9:
        if (on && paiva == 1) {
        oct.remove(paeva);
        oct.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = oct.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("lokakuu.txt", kakka);
        }
        iteraatio(oct, loka);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        } else if (on && paiva == 2) {
        oct.remove(paeva);
        oct.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = oct.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("lokakuu.txt", kakka);
        }
        iteraatio(oct, loka);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");

        } else if (on && paiva == 3) {
        oct.remove(paeva);
        oct.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = oct.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("lokakuu.txt", kakka);
        }
        iteraatio(oct, loka);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        } else {
        oct.remove(paeva);
        oct.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = oct.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("lokakuu.txt", kakka);
        }
        iteraatio(oct, loka);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        }


        break;
        case 10:
        if (on && paiva == 1) {
        nov.remove(paeva);
        nov.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = nov.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("marraskuu.txt", kakka);
        }
        iteraatio(nov, marras);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        } else if (on && paiva == 2) {
        nov.remove(paeva);
        nov.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = nov.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("marraskuu.txt", kakka);
        }
        iteraatio(nov, marras);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");

        } else if (on && paiva == 3) {
        nov.remove(paeva);
        nov.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = nov.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("marraskuu.txt", kakka);
        }
        iteraatio(nov, marras);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        } else {
        nov.remove(paeva);
        nov.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = nov.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("marraskuu.txt", kakka);
        }
        iteraatio(nov, marras);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        }


        break;
        case 11:
        if (on && paiva == 1) {
        dec.remove(paeva);
        dec.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = dec.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("joulukuu.txt", kakka);
        }
        iteraatio(dec, joulu);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        } else if (on && paiva == 2) {
        dec.remove(paeva);
        dec.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = dec.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("joulukuu.txt", kakka);
        }
        iteraatio(dec, joulu);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");

        } else if (on && paiva == 3) {
        dec.remove(paeva);
        dec.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = dec.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("joulukuu.txt", kakka);
        }
        iteraatio(dec, joulu);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        } else {
        dec.remove(paeva);
        dec.put(paeva, "" + (tunnit));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = dec.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();
        testitallennus("jouluu.txt", kakka);
        }
        iteraatio(dec, joulu);
        //tiedostoonTallennus("Kesäkuu.txt", tulos);
        //kesa.setText("" + (Math.floor(tulos * 100) / 100) + "€");
        }


        break;

        }

        tulos = 0;


        }

private void arki(String alku, String loppu, int fuk) {
        double lisatunnit = 0;
        double perus = 0;
        double yo = 0;

        double ilta = 0;
        int yovuoro;
        paiva = 1;
        String[] alkuh = alku.split("\\.");
        String[] loppuh = loppu.split("\\.");

        String alkumin = alkuh[1];
        String loppumin = loppuh[1];
        double aDouble = (Double.parseDouble(alkumin)) / 60;
        double lDouble = (Double.parseDouble(loppumin)) / 60;
        double ah = Double.parseDouble(alkuh[0]);
        double lh = Double.parseDouble(loppuh[0]);
        if ((lh + lDouble) >= 18 && (lh + lDouble) <= 24) {
        lisatunnit = (lh + lDouble) - 18;
        yovuoro = 0;
        ilta = lisatunnit;
        perus = (lh+lDouble)-(aDouble+ah);
        if(perus>7){
        perus=perus-0.5;
        }else{
        perus=(lh+lDouble)-(aDouble+ah);
        }

        } else if (ah + aDouble >= 18 && ah + aDouble <= 24 && lh + lDouble <= 6) {
        lisatunnit = 24 - (ah + aDouble);
        yovuoro = 1;

        yo = lh + lDouble;
        if((lisatunnit+yo)>7){
        perus = (lisatunnit+yo)-0.5;
        ilta = lisatunnit;

        }else {


        perus = lisatunnit + yo;
        ilta = lisatunnit;

        }
        } else if (ah + aDouble >= 18 && ah + aDouble <= 24 && lh + lDouble >= 6) {
        lisatunnit = 24 - (ah + aDouble);
        yo = 6;
        yovuoro = 1;
        if((lisatunnit+yo)>7){
        perus = (lisatunnit+yo)-0.5;
        ilta = lisatunnit;
        }else {

        perus = lisatunnit+yo;
        ilta = lisatunnit;
        }
        } else {

        lisatunnit = 0;
        yovuoro = 0;
        perus = (lh+lDouble)-(aDouble+ah);
        if(perus>7){
        perus=perus-0.5;
        }else{
        perus = (lh+lDouble)-(aDouble+ah);
        }


        }
        switch(fuk){
        case 0:
        erittelyTallennus(tammi_perus,"tammikuu_tunnit.txt",perus);
        erittelyTallennus(tammi_ilta,"tammikuu_ilta.txt",ilta);
        erittelyTallennus(tammi_yo,"tammikuu_yo.txt",yo);
        break;
        case 1:
        erittelyTallennus(helmi_perus,"helmikuu_tunnit.txt",perus);
        erittelyTallennus(helmi_ilta,"helmikuu_ilta.txt",ilta);
        erittelyTallennus(helmi_yo,"helmikuu_yo.txt",yo);
        break;
        case 2:
        erittelyTallennus(maalis_perus,"maaliskuu_tunnit.txt",perus);
        erittelyTallennus(maalis_ilta,"maaliskuu_ilta.txt",ilta);
        erittelyTallennus(maalis_yo,"maaliskuu_yo.txt",yo);
        break;
        case 3:
        erittelyTallennus(huhti_perus,"huhtikuu_tunnit.txt",perus);
        erittelyTallennus(huhti_ilta,"huhtikuu_ilta.txt",ilta);
        erittelyTallennus(huhti_yo,"huhtikuu_yo.txt",yo);
        break;
        case 4:
        erittelyTallennus(touko_perus,"toukokuu_tunnit.txt",perus);
        erittelyTallennus(touko_ilta,"toukokuu_ilta.txt",ilta);
        erittelyTallennus(touko_yo,"toukokuu_yo.txt",yo);
        break;
        case 5:
        erittelyTallennus(kesa_perus,"kesakuu_tunnit.txt",perus);
        erittelyTallennus(kesa_ilta,"kesakuu_ilta.txt",ilta);
        erittelyTallennus(kesa_yo,"kesakuu_yo.txt",yo);
        break;
        case 6:
        erittelyTallennus(heina_perus,"heinakuu_tunnit.txt",perus);
        erittelyTallennus(heina_ilta,"heinakuu_ilta.txt",ilta);
        erittelyTallennus(heina_yo,"heinakuu_yo.txt",yo);
        break;
        case 7:
        erittelyTallennus(elo_perus,"elokuu_tunnit.txt",perus);
        erittelyTallennus(elo_ilta,"elokuu_ilta.txt",ilta);
        erittelyTallennus(elo_yo,"elokuu_yo.txt",yo);
        break;
        case 8:
        erittelyTallennus(syys_perus,"syyskuu_tunnit.txt",perus);
        erittelyTallennus(syys_ilta,"syyskuu_ilta.txt",ilta);
        erittelyTallennus(syys_yo,"syyskuu_yo.txt",yo);
        break;
        case 9:
        erittelyTallennus(loka_perus,"lokakuu_tunnit.txt",perus);
        erittelyTallennus(loka_ilta,"lokakuu_ilta.txt",ilta);
        erittelyTallennus(loka_yo,"lokakuu_yo.txt",yo);
        break;
        case 10:
        erittelyTallennus(marras_perus,"marraskuu_tunnit.txt",perus);
        erittelyTallennus(marras_ilta,"marraskuu_ilta.txt",ilta);
        erittelyTallennus(marras_yo,"marraskuu_yo.txt",yo);
        break;
        case 11:
        erittelyTallennus(joulu_perus,"joulukuu_tunnit.txt",perus);
        erittelyTallennus(joulu_ilta,"joulukuu_ilta.txt",ilta);
        erittelyTallennus(joulu_yo,"joulukuu_yo.txt",yo);
        break;

        }

        tulostus(lh, lDouble, ah, aDouble, lisatunnit, yo, yovuoro, fuk, paiva);
        }

private void lauantai(String alku, String loppu, int fuk) {
        paiva = 2;
        double lisatunnit = 0;
        double yo = 0;
        double perus = 0;
        double lauantai = 0;
        double sunnuntai = 0;
        int yovuoro = 0;
        String[] alkuh = alku.split("\\.");
        String[] loppuh = loppu.split("\\.");

        String alkumin = alkuh[1];
        String loppumin = loppuh[1];
        double aDouble = (Double.parseDouble(alkumin)) / 60;
        double lDouble = (Double.parseDouble(loppumin)) / 60;
        double ah = Double.parseDouble(alkuh[0]);
        double lh = Double.parseDouble(loppuh[0]);
        if ((lh + lDouble) >= 13 && (lh + lDouble) <= 24 && (ah + aDouble) <= 13) {
        lisatunnit = (lh + lDouble) - 13;
        lauantai = lisatunnit;
        if(((lh+lDouble)-(ah+aDouble))>7){
        perus = ((lh+lDouble)-(ah+aDouble))-0.5;

        }else{
        perus = (lh+lDouble)-(ah+aDouble);


        }


        } else if ((ah + aDouble) >= 13 && (lh + lDouble) >= 13 && (lDouble + lh) <= 24) {
        lisatunnit = ((lh + lDouble) - (ah + aDouble));
        lauantai = lisatunnit;
        if(((lh+lDouble)-(ah+aDouble))>7){
        perus = (lh+lDouble)-(ah+aDouble)-0.5;
        }else{
        perus = (lh+lDouble)-(ah+aDouble);


        }

        } else if (ah + aDouble >= 18 && ah + aDouble <= 24 && lh + lDouble <= 6) {
        lisatunnit = 24 - (ah + aDouble);

        yovuoro = 1;
        lauantai = lisatunnit;
        sunnuntai = (lh+lDouble);
        if((lisatunnit+sunnuntai)>7){
        perus = lisatunnit+sunnuntai-0.5;

        }else{
        perus = lisatunnit+sunnuntai;

        }


        } else if (ah + aDouble >= 18 && ah + aDouble <= 24 && lh + lDouble >= 6) {
        lisatunnit = 24 - (ah + aDouble);

        yovuoro = 1;
        lauantai = lisatunnit;
        sunnuntai = (lh+lDouble);
        if((lisatunnit+sunnuntai)>7){
        perus = lisatunnit+(lh+lDouble)-0.5;

        }else{
        perus = lisatunnit+(lh+lDouble);

        }

        } else {

        lisatunnit = 0;
        yovuoro = 0;
        if(((lh+lDouble)-(ah+aDouble))>7) {
        perus = (lh + lDouble) - (ah + aDouble) - 0.5;

        }else{
        perus = (lh+lDouble)-(ah+aDouble);

        }

        }
        switch(fuk){

        case 0:
        erittelyTallennus(tammi_perus,"tammikuu_tunnit.txt",perus);
        erittelyTallennus(tammi_lauantai,"tammikuu_lauantai.txt",lauantai);
        erittelyTallennus(tammi_sunnuntai,"tammikuu_sunnuntai.txt",sunnuntai);
        break;
        case 1:
        erittelyTallennus(helmi_perus,"helmikuu_tunnit.txt",perus);
        erittelyTallennus(helmi_lauantai,"helmikuu_lauantai.txt",lauantai);
        erittelyTallennus(helmi_sunnuntai,"vkuu_sunnuntai.txt",sunnuntai);
        break;
        case 2:
        erittelyTallennus(maalis_perus,"maaliskuu_tunnit.txt",perus);
        erittelyTallennus(maalis_lauantai,"maaliskuu_lauantai.txt",lauantai);
        erittelyTallennus(maalis_sunnuntai,"maaliskuu_sunnuntai.txt",sunnuntai);
        break;
        case 3:
        erittelyTallennus(huhti_perus,"huhtikuu_tunnit.txt",perus);
        erittelyTallennus(huhti_lauantai,"huhtikuu_lauantai.txt",lauantai);
        erittelyTallennus(huhti_sunnuntai,"huhtikuu_sunnuntai.txt",sunnuntai);
        break;
        case 4:
        erittelyTallennus(touko_perus,"toukokuu_tunnit.txt",perus);
        erittelyTallennus(touko_lauantai,"toukokuu_lauantai.txt",lauantai);
        erittelyTallennus(touko_sunnuntai,"toukokuu_sunnuntai.txt",sunnuntai);
        break;
        case 5:
        erittelyTallennus(kesa_perus,"kesakuu_tunnit.txt",perus);
        erittelyTallennus(kesa_lauantai,"kesakuu_lauantai.txt",lauantai);
        erittelyTallennus(kesa_sunnuntai,"kesakuu_sunnuntai.txt",sunnuntai);
        break;
        case 6:
        erittelyTallennus(heina_perus,"heinakuu_tunnit.txt",perus);
        erittelyTallennus(heina_lauantai,"heinakuu_lauantai.txt",lauantai);
        erittelyTallennus(heina_sunnuntai,"heinakuu_sunnuntai.txt",sunnuntai);
        break;
        case 7:
        erittelyTallennus(elo_perus,"elokuu_tunnit.txt",perus);
        erittelyTallennus(elo_lauantai,"elokuu_lauantai.txt",lauantai);
        erittelyTallennus(elo_sunnuntai,"elokuu_sunnuntai.txt",sunnuntai);
        break;
        case 8:
        erittelyTallennus(syys_perus,"syyskuu_tunnit.txt",perus);
        erittelyTallennus(syys_lauantai,"syyskuu_lauantai.txt",lauantai);
        erittelyTallennus(syys_sunnuntai,"syyskuu_sunnuntai.txt",sunnuntai);
        break;
        case 9:
        erittelyTallennus(loka_perus,"lokakuu_tunnit.txt",perus);
        erittelyTallennus(loka_lauantai,"lokakuu_lauantai.txt",lauantai);
        erittelyTallennus(loka_sunnuntai,"lokakuu_sunnuntai.txt",sunnuntai);
        break;
        case 10:
        erittelyTallennus(marras_perus,"marraskuu_tunnit.txt",perus);
        erittelyTallennus(marras_lauantai,"marraskuu_lauantai.txt",lauantai);
        erittelyTallennus(marras_sunnuntai,"marraskuu_sunnuntai.txt",sunnuntai);
        break;
        case 11:
        erittelyTallennus(joulu_perus,"joulukuu_tunnit.txt",perus);
        erittelyTallennus(joulu_lauantai,"joulukuu_lauantai.txt",lauantai);
        erittelyTallennus(joulu_sunnuntai,"joulukuu_sunnuntai.txt",sunnuntai);
        break;

        }
        tulostus(lh, lDouble, ah, aDouble, lisatunnit, yo, yovuoro, fuk, paiva);
        }

private void sunnuntai(String alku, String loppu, int fuk) {
        double lisatunnit = 0;
        double yo = 0;
        double perus = 0;
        double ilta = 0;
        double sunnuntai = 0;
        int yovuoro = 0;
        paiva = 3;
        String[] alkuh = alku.split("\\.");
        String[] loppuh = loppu.split("\\.");

        String alkumin = alkuh[1];
        String loppumin = loppuh[1];
        double aDouble = (Double.parseDouble(alkumin)) / 60;
        double lDouble = (Double.parseDouble(loppumin)) / 60;
        double ah = Double.parseDouble(alkuh[0]);
        double lh = Double.parseDouble(loppuh[0]);
        if ((lh + lDouble) >= 18 && (lh + lDouble) <= 24) {
        lisatunnit = (lh + lDouble) - 18;
        yovuoro = 0;

        ilta = lisatunnit;
        sunnuntai = (lh+lDouble)-(aDouble+ah);
        if(((lh+lDouble)-(aDouble+ah))>7){
        perus = (lh+lDouble)-(aDouble+ah)-0.5;
        }else{
        perus = (lh+lDouble)-(aDouble+ah);
        }
        } else if (ah + aDouble >= 18 && ah + aDouble <= 24 && lh + lDouble <= 6) {
        lisatunnit = 24 - (ah + aDouble);
        yo = lh + lDouble;
        yovuoro = 1;
        ilta = lisatunnit;
        sunnuntai = lisatunnit;
        if((lisatunnit+yo)>7){
        perus = (lisatunnit+yo)-0.5;
        }else{
        perus = lisatunnit+yo;
        }

        } else if (ah + aDouble >= 18 && ah + aDouble <= 24 && lh + lDouble >= 6) {
        lisatunnit = 24 - (ah + aDouble);
        yo = 6;
        yovuoro = 1;
        ilta = lisatunnit;
        sunnuntai = lisatunnit;
        if((lisatunnit+yo)>7){
        perus = (lisatunnit+(lh+lDouble))-0.5;
        }else{
        perus = lisatunnit+(lh+lDouble);
        }
        } else {

        lisatunnit = 0;
        yovuoro = 0;

        if(((lh+lDouble)-(aDouble+ah))>7){
        perus = (lh+lDouble)-(aDouble+ah)-0.5;
        sunnuntai = (lh+lDouble)-(aDouble+ah);
        }else{
        perus = (lh+lDouble)-(aDouble+ah);
        sunnuntai = (lh+lDouble)-(aDouble+ah);
        }

        }
        switch(fuk) {
        case 0:
        erittelyTallennus(tammi_perus,"tammikuu_tunnit.txt",perus);
        erittelyTallennus(tammi_ilta,"tammikuu_ilta.txt",ilta);
        erittelyTallennus(tammi_sunnuntai,"tammikuu_sunnuntai.txt",sunnuntai);
        erittelyTallennus(tammi_yo,"tammikuu_yo.txt",yo);
        break;
        case 1:
        erittelyTallennus(helmi_perus,"helmikuu_tunnit.txt",perus);
        erittelyTallennus(helmi_ilta,"helmikuu_ilta.txt",ilta);
        erittelyTallennus(helmi_sunnuntai,"vkuu_sunnuntai.txt",sunnuntai);
        erittelyTallennus(helmi_yo,"helmikuu_yo.txt",yo);
        break;
        case 2:
        erittelyTallennus(maalis_perus,"maaliskuu_tunnit.txt",perus);
        erittelyTallennus(maalis_ilta,"maaliskuu_ilta.txt",ilta);
        erittelyTallennus(maalis_sunnuntai,"maaliskuu_sunnuntai.txt",sunnuntai);
        erittelyTallennus(maalis_yo,"maaliskuu_yo.txt",yo);
        break;
        case 3:
        erittelyTallennus(huhti_perus,"huhtikuu_tunnit.txt",perus);
        erittelyTallennus(huhti_ilta,"huhtikuu_ilta.txt",ilta);
        erittelyTallennus(huhti_sunnuntai,"huhtikuu_sunnuntai.txt",sunnuntai);
        erittelyTallennus(huhti_yo,"huhtikuu_yo.txt",yo);
        break;
        case 4:
        erittelyTallennus(touko_perus,"toukokuu_tunnit.txt",perus);
        erittelyTallennus(touko_ilta,"toukokuu_ilta.txt",ilta);
        erittelyTallennus(touko_sunnuntai,"toukokuu_sunnuntai.txt",sunnuntai);
        erittelyTallennus(touko_yo,"toukokuu_yo.txt",yo);
        break;
        case 5:
        erittelyTallennus(kesa_perus,"kesakuu_tunnit.txt",perus);
        erittelyTallennus(kesa_ilta,"kesakuu_ilta.txt",ilta);
        erittelyTallennus(kesa_sunnuntai,"kesakuu_sunnuntai.txt",sunnuntai);
        erittelyTallennus(kesa_yo,"kesakuu_yo.txt",yo);
        break;
        case 6:
        erittelyTallennus(heina_perus,"heinakuu_tunnit.txt",perus);
        erittelyTallennus(heina_ilta,"heinakuu_ilta.txt",ilta);
        erittelyTallennus(heina_sunnuntai,"heinakuu_sunnuntai.txt",sunnuntai);
        erittelyTallennus(heina_yo,"heinakuu_yo.txt",yo);
        break;
        case 7:
        erittelyTallennus(elo_perus,"elokuu_tunnit.txt",perus);
        erittelyTallennus(elo_ilta,"elokuu_ilta.txt",ilta);
        erittelyTallennus(elo_sunnuntai,"elokuu_sunnuntai.txt",sunnuntai);
        erittelyTallennus(elo_yo,"elokuu_yo.txt",yo);
        break;
        case 8:
        erittelyTallennus(syys_perus,"syyskuu_tunnit.txt",perus);
        erittelyTallennus(syys_ilta,"syyskuu_ilta.txt",ilta);
        erittelyTallennus(syys_sunnuntai,"syyskuu_sunnuntai.txt",sunnuntai);
        erittelyTallennus(syys_yo,"syyskuu_yo.txt",yo);
        break;
        case 9:
        erittelyTallennus(loka_perus,"lokakuu_tunnit.txt",perus);
        erittelyTallennus(loka_ilta,"lokakuu_ilta.txt",ilta);
        erittelyTallennus(loka_sunnuntai,"lokakuu_sunnuntai.txt",sunnuntai);
        erittelyTallennus(loka_yo,"lokakuu_yo.txt",yo);
        break;
        case 10:
        erittelyTallennus(marras_perus,"marraskuu_tunnit.txt",perus);
        erittelyTallennus(marras_ilta,"marraskuu_ilta.txt",ilta);
        erittelyTallennus(marras_sunnuntai,"marraskuu_sunnuntai.txt",sunnuntai);
        erittelyTallennus(marras_yo,"marraskuu_yo.txt",yo);
        break;
        case 11:
        erittelyTallennus(joulu_perus,"joulukuu_tunnit.txt",perus);
        erittelyTallennus(joulu_ilta,"joulukuu_ilta.txt",ilta);
        erittelyTallennus(joulu_sunnuntai,"joulukuu_sunnuntai.txt",sunnuntai);
        erittelyTallennus(joulu_yo,"joulukuu_yo.txt",yo);
        break;

        }
        tulostus(lh, lDouble, ah, aDouble, lisatunnit, yo, yovuoro, fuk, paiva);
        }
private void erittelyTallennus(HashMap<String,String> osa,String tiedosto, double summa){
        osa.remove(paeva);
        osa.put(paeva, "" + (summa));
        //for (int i = 0; i < jun.size(); i++) {
        //  tulos += jun.get(i);
        //}
        Set set = osa.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getKey()+"="+me.getValue();

        testitallennus(tiedosto, kakka);
        }
        }
private void tiedostoonTallennus(String tiedosto, double palkka) {
        String tallenne = Double.toString(palkka);

        try {
        FileOutputStream output = openFileOutput(tiedosto, Context.MODE_PRIVATE);
        DataOutputStream dout = new DataOutputStream(output);
        dout.writeUTF(tallenne);
        dout.flush();
        dout.close();
        } catch (IOException exc) {
        exc.printStackTrace();
        }
        }

private double tiedostostaLukeminen(String tiedosto) {
        double raha = 0.0;
        try {
        FileInputStream input = openFileInput(tiedosto);
        DataInputStream din = new DataInputStream(input);
        String data = din.readUTF();
        raha = Double.parseDouble(data);
        din.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

        return raha;
        }


private void testitallennus(String tiedosto, String merkinta) {


        try {
        FileOutputStream output = openFileOutput(tiedosto, Context.MODE_APPEND);
        //DataOutputStream dout = new DataOutputStream(output,"utf-8");
        Writer dout = new OutputStreamWriter(output,"UTF-8");
        dout.write(merkinta+"\t");

        dout.close();
        } catch (IOException exc) {
        exc.printStackTrace();
        }

        }

private void testiluku(HashMap<String,String> kausi,String tiedosto) {
        String merkki="";
        try {
        FileInputStream input = openFileInput(tiedosto);
        InputStreamReader din = new InputStreamReader(input,"utf-8");
        BufferedReader buff = new BufferedReader(din);
        String data;
        while((data = buff.readLine())!=null) {

        merkki = data;
        merkki.length();

        }

        buff.close();
        String[] juttu = merkki.split("\t");
        for(int i=0;i<juttu.length;i++){
        String kakka = juttu[i];
        String []dinn = kakka.split("=");

        kausi.put(dinn[0],dinn[1]);

        }

        } catch (FileNotFoundException e) {

        } catch (IOException e) {
        }





        }
private void iteraatio(HashMap<String,String> douh,TextView kuu){
        double ulos=0.0;
        Set set = douh.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getValue().toString();
        ulos += Double.parseDouble(kakka);



        }

        ulos = (Math.round(ulos * 100) / 100.0d);
        kuu.setText(""+(ulos+palkka)+ "€");
        }
private double erittelyIteraatio(HashMap<String,String> osa){
        double sum=0.0;
        Set set = osa.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
        Map.Entry me =(Map.Entry)i.next();
        String kakka = me.getValue().toString();
        sum+=Double.parseDouble(kakka);

        }
        return sum;

        }
private void alustus(){
        testiluku(jan,"tammikuu.txt");
        iteraatio(jan,tammi);
        testiluku(feb,"helmikuu.txt");
        iteraatio(feb,helmi);
        testiluku(mar,"maaliskuu.txt");
        iteraatio(mar,maalis);
        testiluku(apr,"huhtikuu.txt");
        iteraatio(apr,huhti);
        testiluku(may,"toukokuu.txt");
        iteraatio(may,touko);
        testiluku(jun,"kesäkuu.txt");
        iteraatio(jun,kesa);
        testiluku(jul,"heinäkuu.txt");
        iteraatio(jul,heina);
        testiluku(aug,"elokuu.txt");
        iteraatio(aug,elo);
        testiluku(sep,"syyskuu.txt");
        iteraatio(sep,syys);
        testiluku(oct,"lokakuu.txt");
        iteraatio(oct,loka);
        testiluku(nov,"marraskuu.txt");
        iteraatio(nov,marras);
        testiluku(dec,"joulukuu.txt");
        iteraatio(dec,joulu);
        testiluku(tammi_perus,"tammikuu_tunnit.txt");
        testiluku(tammi_ilta,"tammikuu_ilta.txt");
        testiluku(tammi_lauantai,"tammikuu_lauantai.txt");
        testiluku(tammi_yo,"tammikuu_yo.txt");
        testiluku(tammi_sunnuntai,"tammikuu_sunnuntai.txt");
        testiluku(helmi_perus,"helmikuu_tunnit.txt");
        testiluku(helmi_ilta,"helmikuu_ilta.txt");
        testiluku(helmi_lauantai,"helmikuu_lauantai.txt");
        testiluku(helmi_yo,"helmikuu_yo.txt");
        testiluku(helmi_sunnuntai,"helmikuu_sunnuntai.txt");
        testiluku(maalis_perus,"maaliskuu_tunnit.txt");
        testiluku(maalis_ilta,"maaliskuu_ilta.txt");
        testiluku(maalis_lauantai,"maaliskuu_lauantai.txt");
        testiluku(maalis_yo,"maaliskuu_yo.txt");
        testiluku(maalis_sunnuntai,"maaliskuu_sunnuntai.txt");
        testiluku(huhti_perus,"huhtikuu_tunnit.txt");
        testiluku(huhti_ilta,"huhtikuu_ilta.txt");
        testiluku(huhti_lauantai,"huhtikuu_lauantai.txt");
        testiluku(huhti_yo,"huhtikuu_yo.txt");
        testiluku(huhti_sunnuntai,"huhtikuu_sunnuntai.txt");
        testiluku(touko_perus,"toukokuu_tunnit.txt");
        testiluku(touko_ilta,"toukokuu_ilta.txt");
        testiluku(touko_lauantai,"toukokuu_lauantai.txt");
        testiluku(touko_yo,"toukokuu_yo.txt");
        testiluku(touko_sunnuntai,"toukokuu_sunnuntai.txt");
        testiluku(kesa_perus,"kesakuu_tunnit.txt");
        testiluku(kesa_ilta,"kesakuu_ilta.txt");
        testiluku(kesa_lauantai,"kesakuu_lauantai.txt");
        testiluku(kesa_yo,"kesakuu_yo.txt");
        testiluku(kesa_sunnuntai,"kesakuu_sunnuntai.txt");
        testiluku(heina_perus,"heinakuu_tunnit.txt");
        testiluku(heina_ilta,"heinakuu_ilta.txt");
        testiluku(heina_lauantai,"heinakuu_lauantai.txt");
        testiluku(heina_yo,"heinakuu_yo.txt");
        testiluku(heina_sunnuntai,"heinakuu_sunnuntai.txt");
        testiluku(elo_perus,"elokuu_tunnit.txt");
        testiluku(elo_ilta,"elokuu_ilta.txt");
        testiluku(elo_lauantai,"elokuu_lauantai.txt");
        testiluku(elo_yo,"elokuu_yo.txt");
        testiluku(elo_sunnuntai,"elokuu_sunnuntai.txt");
        testiluku(syys_perus,"syyskuu_tunnit.txt");
        testiluku(syys_ilta,"syyskuu_ilta.txt");
        testiluku(syys_lauantai,"vkuu_lauantai.txt");
        testiluku(syys_yo,"syyskuu_yo.txt");
        testiluku(syys_sunnuntai,"syyskuu_sunnuntai.txt");
        testiluku(loka_perus,"lokakuu_tunnit.txt");
        testiluku(loka_ilta,"lokakuu_ilta.txt");
        testiluku(loka_lauantai,"lokakuu_lauantai.txt");
        testiluku(loka_yo,"lokakuu_yo.txt");
        testiluku(loka_sunnuntai,"lokakuu_sunnuntai.txt");
        testiluku(marras_perus,"marraskuu_tunnit.txt");
        testiluku(marras_ilta,"marraskuu_ilta.txt");
        testiluku(marras_lauantai,"marraskuu_lauantai.txt");
        testiluku(marras_yo,"marraskuu_yo.txt");
        testiluku(marras_sunnuntai,"marraskuu_sunnuntai.txt");
        testiluku(joulu_perus,"joulukuu_tunnit.txt");
        testiluku(joulu_ilta,"joulukuu_ilta.txt");
        testiluku(joulu_lauantai,"joulukuu_lauantai.txt");
        testiluku(joulu_yo,"joulukuu_yo.txt");
        testiluku(joulu_sunnuntai,"joulukuu_sunnuntai.txt");
        }


        View.OnClickListener clicker = new View.OnClickListener() {
@Override
public void onClick(View v) {
        Intent i = new Intent(KauppakkActivity.this,YhteenvetoActivity.class);
        String palkkakausi="";
        switch(v.getId()){
        case (R.id.tammi):
        selected.set(selected.get(Calendar.YEAR),0,1);
        palkkakausi = ""+selected.getActualMinimum(Calendar.DATE)+".-"+selected.getActualMaximum(Calendar.DATE);
        i.putExtra("brutto",Double.parseDouble(tammi.getText().toString().substring(0,tammi.length()-1)));
        i.putExtra("kuukausi","Tammikuu");
        i.putExtra("tunnit",erittelyIteraatio(tammi_perus));
        i.putExtra("ilta",erittelyIteraatio(tammi_ilta));
        i.putExtra("lauantai",erittelyIteraatio(tammi_lauantai));
        i.putExtra("yo",erittelyIteraatio(tammi_yo));
        i.putExtra("sunnuntai",erittelyIteraatio(tammi_sunnuntai));
        i.putExtra("palkka",palkka);
        i.putExtra("vero",vero);
        i.putExtra("kausi",palkkakausi);
        startActivity(i);
        break;
        case (R.id.helmi):
        selected.set(selected.get(Calendar.YEAR),1,1);
        palkkakausi = ""+selected.getActualMinimum(Calendar.DATE)+".-"+selected.getActualMaximum(Calendar.DATE);
        i.putExtra("brutto",Double.parseDouble(helmi.getText().toString().substring(0,helmi.length()-1)));
        i.putExtra("kuukausi","Helmikuu");
        i.putExtra("tunnit",erittelyIteraatio(helmi_perus));
        i.putExtra("ilta",erittelyIteraatio(helmi_ilta));
        i.putExtra("lauantai",erittelyIteraatio(helmi_lauantai));
        i.putExtra("yo",erittelyIteraatio(helmi_yo));
        i.putExtra("sunnuntai",erittelyIteraatio(helmi_sunnuntai));
        i.putExtra("palkka",palkka);
        i.putExtra("vero",vero);
        i.putExtra("kausi",palkkakausi);
        startActivity(i);
        break;
        case (R.id.maalis):
        selected.set(selected.get(Calendar.YEAR),2,1);
        palkkakausi = ""+selected.getActualMinimum(Calendar.DATE)+".-"+selected.getActualMaximum(Calendar.DATE);
        i.putExtra("brutto",Double.parseDouble(maalis.getText().toString().substring(0,maalis.length()-1)));
        i.putExtra("kuukausi","Maaliskuu");
        i.putExtra("tunnit",erittelyIteraatio(maalis_perus));
        i.putExtra("ilta",erittelyIteraatio(maalis_ilta));
        i.putExtra("lauantai",erittelyIteraatio(maalis_lauantai));
        i.putExtra("yo",erittelyIteraatio(maalis_yo));
        i.putExtra("sunnuntai",erittelyIteraatio(maalis_sunnuntai));
        i.putExtra("palkka",palkka);
        i.putExtra("vero",vero);
        i.putExtra("kausi",palkkakausi);
        startActivity(i);
        break;
        case (R.id.huhti):
        selected.set(selected.get(Calendar.YEAR),3,1);
        palkkakausi = ""+selected.getActualMinimum(Calendar.DATE)+".-"+selected.getActualMaximum(Calendar.DATE);
        i.putExtra("brutto",Double.parseDouble(huhti.getText().toString().substring(0,huhti.length()-1)));
        i.putExtra("kuukausi","Huhtikuu");
        i.putExtra("tunnit",erittelyIteraatio(huhti_perus));
        i.putExtra("ilta",erittelyIteraatio(huhti_ilta));
        i.putExtra("lauantai",erittelyIteraatio(huhti_lauantai));
        i.putExtra("yo",erittelyIteraatio(huhti_yo));
        i.putExtra("sunnuntai",erittelyIteraatio(huhti_sunnuntai));
        i.putExtra("palkka",palkka);
        i.putExtra("vero",vero);
        i.putExtra("kausi",palkkakausi);
        startActivity(i);
        break;
        case (R.id.touko):
        selected.set(selected.get(Calendar.YEAR),4,1);
        palkkakausi = ""+selected.getActualMinimum(Calendar.DATE)+".-"+selected.getActualMaximum(Calendar.DATE);
        i.putExtra("brutto",Double.parseDouble(touko.getText().toString().substring(0,touko.length()-1)));
        i.putExtra("kuukausi","Toukokuu");
        i.putExtra("tunnit",erittelyIteraatio(touko_perus));
        i.putExtra("ilta",erittelyIteraatio(touko_ilta));
        i.putExtra("lauantai",erittelyIteraatio(touko_lauantai));
        i.putExtra("yo",erittelyIteraatio(touko_yo));
        i.putExtra("sunnuntai",erittelyIteraatio(touko_sunnuntai));
        i.putExtra("palkka",palkka);
        i.putExtra("vero",vero);
        i.putExtra("kausi",palkkakausi);
        startActivity(i);
        break;
        case (R.id.kesa):
        selected.set(selected.get(Calendar.YEAR),5,1);
        palkkakausi = ""+selected.getActualMinimum(Calendar.DATE)+".-"+selected.getActualMaximum(Calendar.DATE);
        i.putExtra("brutto",Double.parseDouble(kesa.getText().toString().substring(0,kesa.length()-1)));
        i.putExtra("kuukausi","Kesäkuu");
        i.putExtra("tunnit",erittelyIteraatio(kesa_perus));
        i.putExtra("ilta",erittelyIteraatio(kesa_ilta));
        i.putExtra("lauantai",erittelyIteraatio(kesa_lauantai));
        i.putExtra("yo",erittelyIteraatio(kesa_yo));
        i.putExtra("sunnuntai",erittelyIteraatio(kesa_sunnuntai));
        i.putExtra("palkka",palkka);
        i.putExtra("vero",vero);
        i.putExtra("kausi",palkkakausi);
        startActivity(i);
        break;
        case (R.id.heina):
        selected.set(selected.get(Calendar.YEAR),6,1);
        palkkakausi = ""+selected.getActualMinimum(Calendar.DATE)+".-"+selected.getActualMaximum(Calendar.DATE);
        i.putExtra("brutto",Double.parseDouble(heina.getText().toString().substring(0,heina.length()-1)));
        i.putExtra("kuukausi","Heinäkuu");
        i.putExtra("tunnit",erittelyIteraatio(heina_perus));
        i.putExtra("ilta",erittelyIteraatio(heina_ilta));
        i.putExtra("lauantai",erittelyIteraatio(heina_lauantai));
        i.putExtra("yo",erittelyIteraatio(heina_yo));
        i.putExtra("sunnuntai",erittelyIteraatio(heina_sunnuntai));
        i.putExtra("palkka",palkka);
        i.putExtra("vero",vero);
        i.putExtra("kausi",palkkakausi);
        startActivity(i);
        break;
        case (R.id.elo):
        selected.set(selected.get(Calendar.YEAR),7,1);
        palkkakausi = ""+selected.getActualMinimum(Calendar.DATE)+".-"+selected.getActualMaximum(Calendar.DATE);
        i.putExtra("brutto",Double.parseDouble(elo.getText().toString().substring(0,elo.length()-1)));
        i.putExtra("kuukausi","Elokuu");
        i.putExtra("tunnit",erittelyIteraatio(elo_perus));
        i.putExtra("ilta",erittelyIteraatio(elo_ilta));
        i.putExtra("lauantai",erittelyIteraatio(elo_lauantai));
        i.putExtra("yo",erittelyIteraatio(elo_yo));
        i.putExtra("sunnuntai",erittelyIteraatio(elo_sunnuntai));
        i.putExtra("palkka",palkka);
        i.putExtra("vero",vero);
        i.putExtra("kausi",palkkakausi);
        startActivity(i);
        break;
        case (R.id.syys):
        selected.set(selected.get(Calendar.YEAR),8,1);
        palkkakausi = ""+selected.getActualMinimum(Calendar.DATE)+".-"+selected.getActualMaximum(Calendar.DATE);
        i.putExtra("brutto",Double.parseDouble(syys.getText().toString().substring(0,syys.length()-1)));
        i.putExtra("kuukausi","Syyskuu");
        i.putExtra("tunnit",erittelyIteraatio(syys_perus));
        i.putExtra("ilta",erittelyIteraatio(syys_ilta));
        i.putExtra("lauantai",erittelyIteraatio(syys_lauantai));
        i.putExtra("yo",erittelyIteraatio(syys_yo));
        i.putExtra("sunnuntai",erittelyIteraatio(syys_sunnuntai));
        i.putExtra("palkka",palkka);
        i.putExtra("vero",vero);
        i.putExtra("kausi",palkkakausi);
        startActivity(i);
        break;
        case (R.id.loka):
        selected.set(selected.get(Calendar.YEAR),9,1);
        palkkakausi = ""+selected.getActualMinimum(Calendar.DATE)+".-"+selected.getActualMaximum(Calendar.DATE);
        i.putExtra("brutto",Double.parseDouble(loka.getText().toString().substring(0,loka.length()-1)));
        i.putExtra("kuukausi","Lokakuu");
        i.putExtra("tunnit",erittelyIteraatio(loka_perus));
        i.putExtra("ilta",erittelyIteraatio(loka_ilta));
        i.putExtra("lauantai",erittelyIteraatio(loka_lauantai));
        i.putExtra("yo",erittelyIteraatio(loka_yo));
        i.putExtra("sunnuntai",erittelyIteraatio(loka_sunnuntai));
        i.putExtra("palkka",palkka);
        i.putExtra("vero",vero);
        i.putExtra("kausi",palkkakausi);
        startActivity(i);
        break;
        case (R.id.marras):
        selected.set(selected.get(Calendar.YEAR),10,1);
        palkkakausi = ""+selected.getActualMinimum(Calendar.DATE)+".-"+selected.getActualMaximum(Calendar.DATE);
        i.putExtra("brutto",Double.parseDouble(marras.getText().toString().substring(0,marras.length()-1)));
        i.putExtra("kuukausi","Marraskuu");
        i.putExtra("tunnit",erittelyIteraatio(marras_perus));
        i.putExtra("ilta",erittelyIteraatio(marras_ilta));
        i.putExtra("lauantai",erittelyIteraatio(marras_lauantai));
        i.putExtra("yo",erittelyIteraatio(marras_yo));
        i.putExtra("sunnuntai",erittelyIteraatio(marras_sunnuntai));
        i.putExtra("palkka",palkka);
        i.putExtra("vero",vero);
        i.putExtra("kausi",palkkakausi);
        startActivity(i);
        break;
        case (R.id.joulu):
        selected.set(selected.get(Calendar.YEAR),11,1);
        palkkakausi = ""+selected.getActualMinimum(Calendar.DATE)+".-"+selected.getActualMaximum(Calendar.DATE);
        i.putExtra("brutto",Double.parseDouble(joulu.getText().toString().substring(0,joulu.length()-1)));
        i.putExtra("kuukausi","Joulukuu");
        i.putExtra("tunnit",erittelyIteraatio(joulu_perus));
        i.putExtra("ilta",erittelyIteraatio(joulu_ilta));
        i.putExtra("lauantai",erittelyIteraatio(joulu_lauantai));
        i.putExtra("yo",erittelyIteraatio(joulu_yo));
        i.putExtra("sunnuntai",erittelyIteraatio(joulu_sunnuntai));
        i.putExtra("palkka",palkka);
        i.putExtra("vero",vero);
        i.putExtra("kausi",palkkakausi);
        startActivity(i);
        break;

        }
        }
        };
        View.OnClickListener remove = new View.OnClickListener() {
@Override
public void onClick(View v) {
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.poisto_prompt, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        alertDialogBuilder.setView(promptsView);
final EditText poistopvm = (EditText) promptsView.findViewById(R.id.pvm);





        alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int id) {
        String poistatus ="";

        poistatus = poistopvm.getText().toString();
        String piu [] = poistatus.split("\\.");

        //("".equals(alkutunnit.getText().toString())); {
        // alkutunnit.setError("Alkutunnit vaadittu");
        //return;
        //} else {
        //alku = alkutunnit.getText().toString();

        //}
        switch (piu[1]) {
        //toimiva poisto
        case "1":
        paeva = poistatus;
        jan.remove(poistatus);

        jan.put(poistatus, "0.0");
        Set set = jan.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
        Map.Entry me = (Map.Entry) i.next();
        String kakka = me.getKey() + "=" + me.getValue();
        testitallennus("tammikuu.txt", kakka);
        }
        erittelyTallennus(tammi_perus,"tammikuu_tunnit.txt",0.0);
        erittelyTallennus(tammi_ilta,"tammikuu_ilta.txt",0.0);
        erittelyTallennus(tammi_sunnuntai,"tammikuu_sunnuntai.txt",0.0);
        erittelyTallennus(tammi_yo,"tammikuu_yo.txt",0.0);
        erittelyTallennus(tammi_lauantai,"tammikuu_lauantai.txt",0.0);
        break;
        case "2":
        paeva = poistatus;
        feb.remove(poistatus);

        feb.put(poistatus, "0.0");
        set = feb.entrySet();
        i = set.iterator();
        while (i.hasNext()) {
        Map.Entry me = (Map.Entry) i.next();
        String kakka = me.getKey() + "=" + me.getValue();
        testitallennus("helmikuu.txt", kakka);
        }
        erittelyTallennus(helmi_perus,"helmikuu_tunnit.txt",0.0);
        erittelyTallennus(helmi_ilta,"helmikuu_ilta.txt",0.0);
        erittelyTallennus(helmi_sunnuntai,"vkuu_sunnuntai.txt",0.0);
        erittelyTallennus(helmi_yo,"helmikuu_yo.txt",0.0);
        erittelyTallennus(helmi_lauantai,"helmikuu_lauantai.txt",0.0);
        break;
        case "3":
        paeva = poistatus;
        mar.remove(poistatus);

        mar.put(poistatus, "0.0");
        set = mar.entrySet();
        i = set.iterator();
        while (i.hasNext()) {
        Map.Entry me = (Map.Entry) i.next();
        String kakka = me.getKey() + "=" + me.getValue();
        testitallennus("maaliskuu.txt", kakka);
        }
        erittelyTallennus(maalis_perus,"maaliskuu_tunnit.txt",0.0);
        erittelyTallennus(maalis_ilta,"maaliskuu_ilta.txt",0.0);
        erittelyTallennus(maalis_sunnuntai,"maaliskuu_sunnuntai.txt",0.0);
        erittelyTallennus(maalis_yo,"maaliskuu_yo.txt",0.0);
        erittelyTallennus(maalis_lauantai,"maaliskuu_lauantai.txt",0.0);
        break;
        case "4":
        paeva = poistatus;
        apr.remove(poistatus);

        apr.put(poistatus, "0.0");
        set = apr.entrySet();
        i = set.iterator();
        while (i.hasNext()) {
        Map.Entry me = (Map.Entry) i.next();
        String kakka = me.getKey() + "=" + me.getValue();
        testitallennus("huhtikuu.txt", kakka);
        }
        erittelyTallennus(huhti_perus,"huhtikuu_tunnit.txt",0.0);
        erittelyTallennus(huhti_ilta,"huhtikuu_ilta.txt",0.0);
        erittelyTallennus(huhti_sunnuntai,"huhtikuu_sunnuntai.txt",0.0);
        erittelyTallennus(huhti_yo,"huhtikuu_yo.txt",0.0);
        erittelyTallennus(huhti_lauantai,"huhtikuu_lauantai.txt",0.0);
        break;
        case "5":
        paeva = poistatus;
        may.remove(poistatus);

        may.put(poistatus, "0.0");
        set = may.entrySet();
        i = set.iterator();
        while (i.hasNext()) {
        Map.Entry me = (Map.Entry) i.next();
        String kakka = me.getKey() + "=" + me.getValue();
        testitallennus("toukokuu.txt", kakka);
        }
        erittelyTallennus(touko_perus,"toukokuu_tunnit.txt",0.0);
        erittelyTallennus(touko_ilta,"toukokuu_ilta.txt",0.0);
        erittelyTallennus(touko_sunnuntai,"toukokuu_sunnuntai.txt",0.0);
        erittelyTallennus(touko_yo,"toukokuu_yo.txt",0.0);
        erittelyTallennus(touko_lauantai,"toukokuu_lauantai.txt",0.0);
        break;
        case "6":
        paeva = poistatus;
        jun.remove(poistatus);

        jun.put(poistatus, "0.0");
        set = jun.entrySet();
        i = set.iterator();
        while (i.hasNext()) {
        Map.Entry me = (Map.Entry) i.next();
        String kakka = me.getKey() + "=" + me.getValue();
        testitallennus("kesäkuu.txt", kakka);
        }
        kesa_perus.remove(poistatus);
        kesa_ilta.remove(poistatus);
        kesa_lauantai.remove(poistatus);
        kesa_sunnuntai.remove(poistatus);
        kesa_yo.remove(poistatus);
        erittelyTallennus(kesa_perus,"kesakuu_tunnit.txt",0.0);
        erittelyTallennus(kesa_ilta,"kesakuu_ilta.txt",0.0);
        erittelyTallennus(kesa_sunnuntai,"kesakuu_sunnuntai.txt",0.0);
        erittelyTallennus(kesa_yo,"kesakuu_yo.txt",0.0);
        erittelyTallennus(kesa_lauantai,"kesakuu_lauantai.txt",0.0);
        break;
        case "7":
        paeva = poistatus;
        jul.remove(poistatus);

        jul.put(poistatus, "0.0");
        set = jul.entrySet();
        i = set.iterator();
        while (i.hasNext()) {
        Map.Entry me = (Map.Entry) i.next();
        String kakka = me.getKey() + "=" + me.getValue();
        testitallennus("heinäkuu.txt", kakka);
        }
        erittelyTallennus(heina_perus,"heinakuu_tunnit.txt",0.0);
        erittelyTallennus(heina_ilta,"heinakuu_ilta.txt",0.0);
        erittelyTallennus(heina_sunnuntai,"heinakuu_sunnuntai.txt",0.0);
        erittelyTallennus(heina_yo,"heinakuu_yo.txt",0.0);
        erittelyTallennus(heina_lauantai,"heinakuu_lauantai.txt",0.0);
        break;
        case "8":
        paeva = poistatus;
        aug.remove(poistatus);

        aug.put(poistatus, "0.0");
        set = aug.entrySet();
        i = set.iterator();
        while (i.hasNext()) {
        Map.Entry me = (Map.Entry) i.next();
        String kakka = me.getKey() + "=" + me.getValue();
        testitallennus("elokuu.txt", kakka);
        }
        erittelyTallennus(elo_perus,"elokuu_tunnit.txt",0.0);
        erittelyTallennus(elo_ilta,"elokuu_ilta.txt",0.0);
        erittelyTallennus(elo_sunnuntai,"elokuu_sunnuntai.txt",0.0);
        erittelyTallennus(elo_yo,"elokuu_yo.txt",0.0);
        erittelyTallennus(elo_lauantai,"elokuu_lauantai.txt",0.0);
        break;
        case "9":
        paeva = poistatus;
        sep.remove(poistatus);

        sep.put(poistatus, "0.0");
        set = sep.entrySet();
        i = set.iterator();
        while (i.hasNext()) {
        Map.Entry me = (Map.Entry) i.next();
        String kakka = me.getKey() + "=" + me.getValue();
        testitallennus("syyskuu.txt", kakka);
        }
        erittelyTallennus(syys_perus,"syyskuu_tunnit.txt",0.0);
        erittelyTallennus(syys_ilta,"syyskuu_ilta.txt",0.0);
        erittelyTallennus(syys_sunnuntai,"syyskuu_sunnuntai.txt",0.0);
        erittelyTallennus(syys_yo,"syyskuu_yo.txt",0.0);
        erittelyTallennus(syys_lauantai,"syyskuu_lauantai.txt",0.0);
        break;
        case "10":
        paeva = poistatus;
        oct.remove(poistatus);

        oct.put(poistatus, "0.0");
        set = oct.entrySet();
        i = set.iterator();
        while (i.hasNext()) {
        Map.Entry me = (Map.Entry) i.next();
        String kakka = me.getKey() + "=" + me.getValue();
        testitallennus("lokakuu.txt", kakka);
        }
        erittelyTallennus(loka_perus,"lokakuu_tunnit.txt",0.0);
        erittelyTallennus(loka_ilta,"lokakuu_ilta.txt",0.0);
        erittelyTallennus(loka_sunnuntai,"lokakuu_sunnuntai.txt",0.0);
        erittelyTallennus(loka_yo,"lokakuu_yo.txt",0.0);
        erittelyTallennus(loka_lauantai,"lokakuu_lauantai.txt",0.0);
        break;
        case "11":
        paeva = poistatus;
        nov.remove(poistatus);

        nov.put(poistatus, "0.0");
        set = nov.entrySet();
        i = set.iterator();
        while (i.hasNext()) {
        Map.Entry me = (Map.Entry) i.next();
        String kakka = me.getKey() + "=" + me.getValue();
        testitallennus("marraskuu.txt", kakka);
        }
        erittelyTallennus(marras_perus,"marraskuu_tunnit.txt",0.0);
        erittelyTallennus(marras_ilta,"marraskuu_ilta.txt",0.0);
        erittelyTallennus(marras_sunnuntai,"marraskuu_sunnuntai.txt",0.0);
        erittelyTallennus(marras_yo,"marraskuu_yo.txt",0.0);
        erittelyTallennus(marras_lauantai,"marraskuu_lauantai.txt",0.0);
        break;
        case "12":
        paeva = poistatus;
        dec.remove(poistatus);

        dec.put(poistatus, "0.0");
        set = dec.entrySet();
        i = set.iterator();
        while (i.hasNext()) {
        Map.Entry me = (Map.Entry) i.next();
        String kakka = me.getKey() + "=" + me.getValue();
        testitallennus("joulukuu.txt", kakka);
        }
        erittelyTallennus(joulu_perus,"joulukuu_tunnit.txt",0.0);
        erittelyTallennus(joulu_lauantai,"joulukuu_lauantai.txt",0.0);
        erittelyTallennus(joulu_sunnuntai,"joulukuu_sunnuntai.txt",0.0);
        erittelyTallennus(joulu_ilta,"joulukuu_ilta.txt",0.0);
        erittelyTallennus(joulu_yo,"joulukuu_yo.txt",0.0);
        break;

        }
        alustus();



        }
        }

        ).

        setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int id) {
        dialog.cancel();
        }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

        }

        };



        }