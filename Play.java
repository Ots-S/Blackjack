import java.util.Random;
import java.util.Scanner;

class Play {

    public static int joueur1Carte1Chiffre;
    public static String joueur1Carte1Nom;
    public static String carteJoueur1;

    public static int getRandomIntegerBetweenRange(int min, int max) {
        int x = (int) (Math.random() * ((max - min) + 1)) + min;
        return x;
    }

    public static String distributionNomCarte() {
   
        String[] deckName = { "club", "diamond", "heart", "spade" };
        int nb = getRandomIntegerBetweenRange(0, 3);
        joueur1Carte1Nom = deckName[nb];
        return joueur1Carte1Nom;
    }
    public static int distributionNumberCarte(){
        joueur1Carte1Chiffre = getRandomIntegerBetweenRange(1, 12);
        return joueur1Carte1Chiffre;
    }
    public static String carteJoueur1(){

        return distributionNumberCarte() + " " + distributionNomCarte();
    }


    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in); // Create a Scanner objectI played blackjack with me
        System.out.println("I played blackjack with me");
        System.out.println("Enter your name");
        String userName = myObj.nextLine(); // Read user input
        System.out.println("Welcome: " + userName); // Output user input

        carteJoueur1=carteJoueur1();
        
        System.out.println(carteJoueur1);

    }

}