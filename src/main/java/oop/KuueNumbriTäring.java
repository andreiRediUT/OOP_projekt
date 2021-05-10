package oop;

public class KuueNumbriTäring {

    int veeretus;

    /**
     * Konstruktor genereerib täringuveeretusele esimese juhusliku numbri
     */
    public KuueNumbriTäring() {
        this.veeretus = (int) (Math.random() * 6 + 1);
    }

    /**
     * Meetod genereerib numbri 1-6ni.
     */
    public void täringuVeeretus() {

        this.veeretus = (int) (Math.random() * 6 + 1);
    }

    /**
     * @return nende get meetoditega tagastakse vastavad väärtused
     */

    public int getVeeretus() {
        return veeretus;
    }

}