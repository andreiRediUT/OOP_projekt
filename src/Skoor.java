public class Skoor {


    private int[] skoor;
    private final int lõpp_skoor;
    private int vooruskoor;


    /**
     * @param lõpp_skoor konstruktortoriga saab määrata, mis skoorini täringumängu mängitakse.
     */
    public Skoor(int lõpp_skoor) {
        this.skoor = new int[2];  // esimene element järjendis on Esimese mängija skoor, teine element on Teise
        this.lõpp_skoor = lõpp_skoor;
        this.vooruskoor = 0;
    }

    public void prindiSkoor() {
        System.out.println("\nEsimese skoor " + this.skoor[0] + "     ---------------    " + "  Teise skoor  "
                + this.skoor[1] + "\n");

    }

    /**
     * @param liitaEsimesele kui on True, siis liidetakse esimese mängijale, kui False siis teisele
     */
    public void liidaSkoor(boolean liitaEsimesele) {
        this.skoor[liitaEsimesele ? 0 : 1] += vooruskoor;
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

    /**
     * @return tagastakse indeks, kui keegi saanud üldskooriks 91 või rohkem. Kui ei, siis tagastatakse -1.
     */
    public int keegiVõitnud() {
        for (int i = 0; i < this.skoor.length; i++) {
            if (this.skoor[i] >= this.lõpp_skoor) {
                return i;
            }
        }

        return -1;

    }
}
