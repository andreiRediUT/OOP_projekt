//Täringumäng.
// Koostada klassid Täring ja Täringumäng jäljendamaks kahe mängija mängu.
// Mängijate viskevoorud kordamööda.
//Ühes viskevoorus võib mängija visata täringuid ükskõik mitu korda, aga kui tuleb 1, siis kogusumma nullitakse ja viskeõigus läheb teisele mängijale.
// Muidu viskel saadud tulemus liidetakse kogusummale. Võidab see, kes saab enne üle 91 punkti.


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
    public void Tulemus(int veeretus){

        tulemus +=veeretus;
    }

    public int getTulemus() { return tulemus; }
    public int getVeeretus() {return veeretus;}

    }
