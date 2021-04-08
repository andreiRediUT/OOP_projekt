//Täringumäng.
// Klass täringu veeretustulemuse saamiseks
//täringuVeeretus tuleb meetodiga Math.random ja saadakse kätte getVeeretus() ega
public class KuueNumbriTäring {
    int tulemus;
    int veeretus;

    public KuueNumbriTäring() {
        this.tulemus = 0;
        this.veeretus = (int) (Math.random() * 6 + 1);
    }

    public void täringuVeeretus() {

        this.veeretus = (int) (Math.random() * 6 + 1);
    }

    public int getVeeretus() {return veeretus;}

}