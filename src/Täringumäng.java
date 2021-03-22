import java.util.Scanner;

public class Täringumäng {
    private boolean esimese_kord;
    private int[] skoor;
    private final int lõpp_skoor;
    private int vooruskoor;

    public Täringumäng() {
        this.esimese_kord = true;
        this.lõpp_skoor = 91;
        this.skoor = new int[2];
    }

    public void alusta() {

        this. reeglid();   // prindib reeglid

          // mängija skoor kuni ta ise lõpetab või saab 1

        Scanner scanner = new Scanner(System.in);

        while (true) {   // tsükkel jookseb koguaeg, kuni mängu lõppemiseni

            // küsin mängijalt, et äkki annab käigu edasi, kui korduvalt veeretanud ja ei ole 1 saanud.

            int täring = random_number();
            this.vooruskoor += täring;
            System.out.println(esimese_kord ? " ".repeat(40) +  "Esimene mängija veeretas " + täring : " ".repeat(40) +"Teine Mängija veeretas " + täring);


            if (täring == 1) poole_vahetus(true);

            System.out.println("Kui soovid anda käigu üle, siis kirjuta  - \"ff\" ");
            String input = scanner.nextLine();

            if (input.equals("ff") ) {

                this.poole_vahetus(false);
                continue;
            }

        }

    }

    protected void poole_vahetus(boolean täring) {
        if (!täring) skoor[esimese_kord ? 0: 1] += vooruskoor;

        this.vooruskoor = 0;

        this.esimese_kord = !esimese_kord;
        System.out.println("\nEsimese skoor " + this.skoor[0] + "     ---------------    " + "  Teise skoor  " + this.skoor[1] + "\n");
        System.out.println("Nüüd on " + (esimese_kord ? " Esimese mängija" : "Teise mängija kord"));

    }

    public int random_number() {
       return  (int) ((Math.random() * (6 - 1)) + 1);
    }

    public void skoor () {
        System.out.println("\nEsimese skoor " + this.skoor[0] + "     ---------------    " + "  Teise skoor  " + this.skoor[1]);

    }

    protected void reeglid() {
        System.out.println( "Mängijad viskavad täringut korda mööda. ");
        System.out.println("Ühes viskevoorus võib mängija visata täringuid ükskõik mitu korda");
        System.out.println("aga kui tuleb 1, siis kogusumma nullitakse ja viskeõigus läheb teisele mängijale.");
        System.out.println("Viskel saadud tulemus liidetakse kogusummale. Võidab see, kes saab enne üle 91 punkti. ");

        System.out.println("\nAlustab esimene mängija.");
    }

}
