package shuuya.palkkavahti;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.TextView;



/**
 * Created by Miisu on 9.7.2016.
 */
public class YhteenvetoActivity extends AppCompatActivity{
    TextView ilta,lauantai,yo,sunnuntai,tunnit,tyel,tyottomyys,kuukausi,Brutto,Netto,ennakkopidatys,kausi;
    TextView maara1,maara2,maara3,maara4,maara5,maara6;
    double brutto,iltatunnit,lauantaitunnit,sunnuntaitunnit,yotunnit,perustunnit;
    double yopalkka = 6.16;
    double iltapalkka = 4.1;
    double lauantaipalkka = 5.35;
    double palkka = 0;
    double tyel_arvo = 0.057;
    double tyottomyys_arvo = 0.0115;
    double vero = 0;
    double vahennys = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yhteenveto);
        Intent i = getIntent();
        //muuttujat
        brutto = i.getExtras().getDouble("brutto");
        iltatunnit = i.getExtras().getDouble("ilta");
        lauantaitunnit = i.getExtras().getDouble("lauantai");
        sunnuntaitunnit = i.getExtras().getDouble("sunnuntai");
        yotunnit =i.getExtras().getDouble("yo") ;
        perustunnit = i.getExtras().getDouble("tunnit");
        palkka = i.getExtras().getDouble("palkka");
        vero = i.getExtras().getDouble("vero");
        vahennys = (vero/100)+tyel_arvo+tyottomyys_arvo;


        //pääkenttä
        kuukausi = (TextView)findViewById(R.id.Kuukausi);
        kuukausi.setText(i.getExtras().getString("kuukausi"));
        kausi = (TextView)findViewById(R.id.kausi);
        kausi.setText(i.getExtras().getString("kausi"));

        //keskialueen kentät
        maara1 = (TextView)findViewById(R.id.määrä1);
        maara2 = (TextView)findViewById(R.id.määrä2);
        maara3 = (TextView)findViewById(R.id.määrä3);
        maara4 = (TextView)findViewById(R.id.määrä4);
        maara5 = (TextView)findViewById(R.id.määrä5);
        maara6 = (TextView)findViewById(R.id.määrä6);
        //oikean puolen kentät
        tunnit = (TextView)findViewById(R.id.tunnit);
        ilta = (TextView)findViewById(R.id.ilta);
        lauantai = (TextView)findViewById(R.id.lauantai);
        yo = (TextView)findViewById(R.id.yo);
        sunnuntai = (TextView)findViewById(R.id.sunnuntai);
        tyel = (TextView)findViewById(R.id.tyel_m);
        tyottomyys = (TextView)findViewById(R.id.työttömyys);
        ennakkopidatys = (TextView)findViewById(R.id.Ennakkopidätys_määrä);

        //keskialueen arvot
        maara1.setText(""+(Math.round(perustunnit*100)/100.0d));
        maara2.setText(""+(Math.round(iltatunnit*100)/100.0d));
        maara3.setText(""+(Math.round(lauantaitunnit*100)/100.0d));
        maara4.setText(""+(Math.round(yotunnit*100)/100.0d));
        maara5.setText(""+(Math.round(sunnuntaitunnit*100)/100.0d));
        maara6.setText(""+(Math.round(vero*100/100.0d)));
        //oikean puolen arvo
        if(palkka>50){
            double tuntipalkka = Math.round((palkka/160)*100)/100.00d;

            tunnit.setText("" + (Math.round(palkka * 100) / 100.0d));
            ilta.setText("" + (Math.round(iltatunnit * iltapalkka * 100) / 100.0d));
            lauantai.setText("" + (Math.round(lauantaitunnit * lauantaipalkka * 100) / 100.0d));
            yo.setText("" + (Math.round(yotunnit * yopalkka * 100) / 100.0d));
            sunnuntai.setText("" + (Math.round(sunnuntaitunnit * (tuntipalkka) * 100) / 100.0d));
            tyel.setText("-" + (Math.round(brutto * tyel_arvo * 100) / 100.0d));
            tyottomyys.setText("-" + (Math.round(brutto * tyottomyys_arvo * 100) / 100.0d));
            ennakkopidatys.setText("-" + (Math.round(brutto * (vero / 100) * 100) / 100.0d));
        }else {
            tunnit.setText("" + (Math.round(perustunnit * palkka * 100) / 100.0d));
            ilta.setText("" + (Math.round(iltatunnit * iltapalkka * 100) / 100.0d));
            lauantai.setText("" + (Math.round(lauantaitunnit * lauantaipalkka * 100) / 100.0d));
            yo.setText("" + (Math.round(yotunnit * yopalkka * 100) / 100.0d));
            sunnuntai.setText("" + (Math.round(sunnuntaitunnit * palkka * 100) / 100.0d));
            tyel.setText("-" + (Math.round(brutto * tyel_arvo * 100) / 100.0d));
            tyottomyys.setText("-" + (Math.round(brutto * tyottomyys_arvo * 100) / 100.0d));
            ennakkopidatys.setText("-" + (Math.round(brutto * (vero / 100) * 100) / 100.0d));
        }

        //brutto ja netto palkat
        Brutto = (TextView)findViewById(R.id.Brutto);
        Brutto.setText(""+brutto+"€");
        Netto = (TextView)findViewById(R.id.Netto);
        Netto.setText(""+(Math.round(brutto*(1-vahennys)*100)/100.0d)+"€");
    }
}
