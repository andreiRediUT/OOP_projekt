package oop;

import java.util.Scanner;

public class Täringumäng {
    private boolean esimese_kord;
    private KuueNumbriTäring täring;

    private Skoor skoor;

    public Täringumäng() {
        this.esimese_kord = true;
        this.skoor = new Skoor(91);
        this.täring = new KuueNumbriTäring();
    }

    public void alusta() {


        this.reeglid();   //prindib reeglid

        // mängija skoor kuni ta ise lõpetab või saab 1

        Scanner scanner = new Scanner(System.in);

        while (true) {   // tsükkel jookseb koguaeg, kuni mängu lõppemiseni

            // küsin mängijalt, et äkki annab käigu edasi, kui korduvalt veeretanud ja ei ole 1 saanud.

            if (this.skoor.keegiVõitnud() != -1) break;   // Lõpetab programmi tööd kui keegi saanud skoori täis

            täring.täringuVeeretus();
            this.skoor.setVooruskoor(täring.getVeeretus());   // ajutine skoor, mida pärast lisatakse üldskoorile
            System.out.println(esimese_kord ? " ".repeat(40) + "Esimene mängija veeretas " + täring.getVeeretus() : " ".repeat(40) + "Teine Mängija veeretas " + täring.getVeeretus());


            if (täring.getVeeretus() == 1) poole_vahetus(true);

            System.out.println("Käigu üleandmiseks, kirjuta  - \"ff\" ");

            System.out.print(esimese_kord ? "\nⅠ.mängija vooruskoor - " : "\nⅡ.mängija vooruskoor -  ");
            System.out.print(skoor.getVooruskoor());   // kuvab hetkevooru mängija skoori

            System.out.println(" ".repeat(20) + "Üldskoor " + skoor.getSkoor()[0] + " | " + skoor.getSkoor()[1]);

            String input = scanner.nextLine();

            if (input.equals("ff")) {
                this.poole_vahetus(false);
                continue;
            }

        }

        // Mängu võitja kuulutamine.

        this.skoor.prindiSkoor();

        System.out.println("" +
                "\n 🥇🥇🥇🥇🥇 Mängu võitis "
                + (this.skoor.keegiVõitnud() == 0 ? "Esimene" : "Teine")
                + " mängija 🥇🥇🥇🥇🥇🥇\n");

        System.out.println("   Palju õnne!  ");

    }

    /**
     * @param täring Kui on True, siis kutsuti funktsioon täringuviskest "1". Üldskoorile ei liideta vooruskoor
     *               Voorukord läheb teisele mängijale üle.
     *               Kui on False, siis mängija loobus voorust vabatahtlikult, kirjutades "ff".
     *               Liidetake vooruskoor üldskoorile ja kord läheb teisele mängija üle.
     */
    protected void poole_vahetus(boolean täring) {

        if (!täring) this.skoor.liidaSkoor(esimese_kord);

        this.skoor.setVooruskoor(0);   // kui on null, siis nullib vooruskoori

        this.esimese_kord = !esimese_kord;

        this.skoor.prindiSkoor();
        System.out.println("Nüüd on " + (esimese_kord ? " Esimese mängija" : "Teise mängija kord"));

    }

//    public int random_number() {
//       return  (int) ((Math.random() * (6 - 1)) + 1);
//    }


    protected void reeglid() {
        System.out.println("Mängijad viskavad täringut korda mööda. ");
        System.out.println("Ühes viskevoorus võib mängija visata täringuid ükskõik mitu korda");
        System.out.println("aga kui tuleb 1, siis kogusumma nullitakse ja viskeõigus läheb teisele mängijale.");
        System.out.println("Viskel saadud tulemus liidetakse kogusummale. Võidab see, kes saab enne üle 91 punkti. ");
        System.out.println("Täringu viskamiseks vajuta ENTER");

        System.out.println("\nAlustab esimene mängija.");
    }

}
