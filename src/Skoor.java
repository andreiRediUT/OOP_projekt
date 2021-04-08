public class Skoor {
    private int[] skoor;
    private final int lõpp_skoor;
    private int vooruskoor;

    public Skoor( int lõpp_skoor) {
        this.skoor = new int[2];
        this.lõpp_skoor = lõpp_skoor;
        this.vooruskoor = 0;
    }

    public void prindiSkoor() {
        System.out.println("\nEsimese skoor " + this.skoor[0] + "     ---------------    " + "  Teise skoor  "
                + this.skoor[1] + "\n");

    }


    public void liidaSkoor(boolean liitaEsimesele) {
        this.skoor[liitaEsimesele ? 0: 1] += vooruskoor;
    }

    public int getVooruskoor() {
        return vooruskoor;
    }

    public int[] getSkoor() {return this.skoor;}

    public void setVooruskoor(int vooruskoor) {   // jälgib ühe mängija skoori koguaeg, saab ka nullida.
        this.vooruskoor = vooruskoor==0 ? 0 : this.vooruskoor + vooruskoor;

    }

    public int keegiVõitnud() {
        for (int i = 0; i < this.skoor.length; i++) {
            if (this.skoor[i] >= this.lõpp_skoor) {
                return i;
            }
        }

        return -1;

    }
}
