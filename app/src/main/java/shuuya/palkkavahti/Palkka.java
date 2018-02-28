package shuuya.palkkavahti;

import java.io.Serializable;

/**
 * Created by Miisu on 9.7.2016.
 */
public class Palkka implements Serializable {
    private double palkka;
    private double vero;

    public Palkka(){


    }
    public void setPalkka(double palkka){
        this.palkka = palkka;
    }
    public void setVero(double vero){
        this.vero = vero;
    }

    public Double getPalkka() {
        return palkka;
    }



    public Double getVero() {
        return vero;
    }
}