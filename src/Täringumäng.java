import java.util.Scanner;

public class Täringumäng {
    private boolean esimese_kord;

    Skoor skoor;

    public Täringumäng() {
        this.esimese_kord = true;
        this.skoor = new Skoor(91);
    }

    public void alusta() {

        this. reeglid();   // prindib reeglid

          // mängija skoor kuni ta ise lõpetab või saab 1

        Scanner scanner = new Scanner(System.in);

        while (true) {   // tsükkel jookseb koguaeg, kuni mängu lõppemiseni

            // küsin mängijalt, et äkki annab käigu edasi, kui korduvalt veeretanud ja ei ole 1 saanud.

            if (this.skoor.keegiVõitnud() != -1) break;   // Lõpetab programmi tööd kui keegi saanud skoori täis

            int täring = random_number();
            this.skoor.setVooruskoor(täring);
            System.out.println(esimese_kord ? " ".repeat(40) +  "Esimene mängija veeretas " + täring : " ".repeat(40) +"Teine Mängija veeretas " + täring);


            if (täring == 1) poole_vahetus(true);

            System.out.println("Kui soovid anda käigu üle, siis kirjuta  - \"ff\" ");
            String input = scanner.nextLine();

            if (input.equals("ff") ) {
                this.poole_vahetus(false);
                continue;
            }

        }

        // Mängu võitja kuulutamine.

        this.skoor.prindiSkoor();

        System.out.println("" +
                "\n 🥇🥇🥇🥇🥇 Mängu võitis "
                + (this.skoor.keegiVõitnud() == 0 ?  "Esimene": "Teine")
                + " mängija 🥇🥇🥇🥇🥇🥇\n" );

        System.out.println("   Palju õnne!  ");

    }

    protected void poole_vahetus(boolean täring) {

        if (!täring) this.skoor.liidaSkoor(esimese_kord);

        this.skoor.setVooruskoor(0);   // kui on null, siis nullib vooruskoori

        this.esimese_kord = !esimese_kord;

        this.skoor.prindiSkoor();
        System.out.println("Nüüd on " + (esimese_kord ? " Esimese mängija" : "Teise mängija kord"));

    }

    public int random_number() {
       return  (int) ((Math.random() * (6 - 1)) + 1);
    }


    protected void reeglid() {
        System.out.println( "Mängijad viskavad täringut korda mööda. ");
        System.out.println("Ühes viskevoorus võib mängija visata täringuid ükskõik mitu korda");
        System.out.println("aga kui tuleb 1, siis kogusumma nullitakse ja viskeõigus läheb teisele mängijale.");
        System.out.println("Viskel saadud tulemus liidetakse kogusummale. Võidab see, kes saab enne üle 91 punkti. ");

        System.out.println("\nAlustab esimene mängija.");
    }

}
