package oop;

import java.util.HashMap;

public class KuueNumbriTäring {

    int veeretus;
    private HashMap<Integer, Integer> statistika = new HashMap<>();


    /**
     * Konstruktor genereerib täringuveeretusele esimese juhusliku numbri
     */
    public KuueNumbriTäring() {
        this.veeretus = (int) (Math.random() * 6 + 1);
        this.statistika.put(1,0);
        this.statistika.put(2,0);
        this.statistika.put(3,0);
        this.statistika.put(4,0);
        this.statistika.put(5,0);
        this.statistika.put(6,0);
    }

    /**
     * Meetod genereerib numbri 1-6ni.
     */
    public void täringuVeeretus() {

        this.veeretus = (int) (Math.random() * 6 + 1);
        int summa = statistika.get(veeretus);
        statistika.put(veeretus, summa+1);
        System.out.println(statistika);
    }

    public HashMap<Integer, Integer> getStatistika() {
        return statistika;
    }

    /**
     * @return nende get meetoditega tagastakse vastavad väärtused
     */

    public int getVeeretus() {
        return veeretus;
    }

}