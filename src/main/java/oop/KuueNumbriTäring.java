package oop;

import java.util.HashMap;


//Täringumäng.
// Klass täringu veeretustulemuse saamiseks
//täringuVeeretus tuleb meetodiga Math.random ja saadakse kätte getVeeretus() ega

public class KuueNumbriTäring {
    int tulemus;
    int veeretus;
    private HashMap<Integer, Integer> statistika = new HashMap<>();


    public KuueNumbriTäring() {
        this.tulemus = 0;
        this.veeretus = (int) (Math.random() * 6 + 1);
        this.statistika.put(1,0);
        this.statistika.put(2,0);
        this.statistika.put(3,0);
        this.statistika.put(4,0);
        this.statistika.put(5,0);
        this.statistika.put(6,0);
    }

    public void täringuVeeretus() {

        this.veeretus = (int) (Math.random() * 6 + 1);
        int summa = statistika.get(veeretus);
        statistika.put(veeretus, summa+1);
        System.out.println(statistika);
    }

    public HashMap<Integer, Integer> getStatistika() {
        return statistika;
    }

    public int getVeeretus() {return veeretus;}

}