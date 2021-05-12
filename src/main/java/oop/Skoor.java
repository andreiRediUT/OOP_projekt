package oop;

public class Skoor {


    private int[] skoor;
    private final int lõpp_skoor;
    private int vooruskoor;
    private boolean esimese_kord;


    /**
     * @param lõpp_skoor konstruktortoriga saab määrata, mis skoorini täringumängu mängitakse.
     */
    public Skoor(int lõpp_skoor) {
        this.esimese_kord = true;
        this.skoor = new int[2];  // esimene element järjendis on Esimese mängija skoor, teine element on Teise
        this.lõpp_skoor = lõpp_skoor;
        this.vooruskoor = 0;
    }

    public void prindiSkoor() {
        System.out.println("\nEsimese skoor " + this.skoor[0] + "     ---------------    " + "  Teise skoor  "
                + this.skoor[1] + "\n");

    }

    /**
     *   kui esimese_kord on True, siis liidetakse esimese mängijale, kui False siis teisele
     */
    public void liidaSkoor() {
        this.skoor[esimese_kord ? 0 : 1] += vooruskoor;
        this.setVooruskoor(0);
    }

    public int getVooruskoor() {
        return vooruskoor;
    }

    public int[] getSkoor() {
        return this.skoor;
    }

    /**
     * @param vooruskoor lisatakse täringuveeretus vooruskoorile. Kui on 0, siis vooruskoor nullitakse.
     */
    public void setVooruskoor(int vooruskoor) {
        this.vooruskoor = vooruskoor == 0 ? 0 : this.vooruskoor + vooruskoor;

    }

    public boolean isEsimese_kord() {
        return esimese_kord;
    }

    public void setEsimese_kord(boolean esimese_kord) {
        this.esimese_kord = esimese_kord;
    }

    /**
     * @param täring Kui on True, siis kutsuti funktsioon täringuviskest "1". Üldskoorile ei liideta vooruskoor
     *               Voorukord läheb teisele mängijale üle.
     *               Kui on False, siis mängija loobus voorust vabatahtlikult, kirjutades "ff".
     *               Liidetake vooruskoor üldskoorile ja kord läheb teisele mängija üle.
     */

    public void poole_vahetus(boolean täring) {

        if (!täring) this.liidaSkoor();

        this.setVooruskoor(0);   // kui on null, siis nullib vooruskoori

        this.esimese_kord = !esimese_kord;

       // this.skoor.prindiSkoor();
        System.out.println("Nüüd on " + (esimese_kord ? " Esimese mängija" : "Teise mängija kord"));

    }

    /**
     * @return tagastakse indeks, kui keegi saanud üldskooriks 91 või rohkem. Kui ei, siis tagastatakse -1.
     */
    public int keegiVõitnud() {
        for (int i = 0; i < this.skoor.length; i++) {
            if (this.skoor[i]  >= this.lõpp_skoor) {
                return i;
            }
        }

        return -1;

    }

    public boolean kasOnVõitnud() {

        return this.skoor[esimese_kord ? 0: 1] + this.vooruskoor >= this.lõpp_skoor;

    }
}
