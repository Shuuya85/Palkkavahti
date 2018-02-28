package shuuya.palkkavahti;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Miisu on 9.7.2016.
 */
public class MenuActivity extends AppCompatActivity {
    Button kalenteri,asetus;
    ImageView logo;
    double liksa = 0.0;
    double vero = 0.0;
    String luku;
    Palkka palkka = new Palkka();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        logo = (ImageView)findViewById(R.id.Logo);
        kalenteri = (Button)findViewById(R.id.kalenteriin);
        kalenteri.setOnClickListener(clicker);
        asetus = (Button)findViewById(R.id.tietojen_asetus);
        asetus.setOnClickListener(clicker);
        try {


            luku = tiedostostaLukeminen();
            String[] lista = luku.split(",");
            liksa = Double.parseDouble(lista[0]);
            vero = Double.parseDouble(lista[1]);
        }catch(ArrayIndexOutOfBoundsException r){

        }catch(NullPointerException e){
            vero = 0.0;
            liksa = 0.0;
        }


    }
    View.OnClickListener clicker = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case (R.id.kalenteriin):
                    palkka.setPalkka(liksa);
                    palkka.setVero(vero);
                    if(liksa>50){
                        Intent i = new Intent(MenuActivity.this,KauppakkActivity.class);
                        i.putExtra("Object", palkka);
                        startActivity(i);
                        finish();
                    }else {
                        Intent i = new Intent(MenuActivity.this, MainActivity.class);
                        i.putExtra("Object", palkka);
                        startActivity(i);
                        finish();
                    }
                    break;
                case (R.id.tietojen_asetus):

                    Intent j = new Intent(MenuActivity.this,TiedotActivity.class);
                    startActivity(j);
                    break;
            }
        }
    };
    private String tiedostostaLukeminen() {

        try {
            FileInputStream input = openFileInput("palkka.txt");
            DataInputStream din = new DataInputStream(input);
            String data = din.readUTF();
            luku = data;
            din.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

        return luku;
    }
}