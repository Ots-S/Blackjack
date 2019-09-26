import java.util.Random;
import java.util.Scanner;

class Play {

    public static int joueur1Carte1Chiffre;
    // public static String joueur1Carte1Nom;
    public static String carteJoueur1;
    public static int totalCroupier;
    public static String userName;

    public static int getRandomIntegerBetweenRange(int min, int max) {
        int x = (int) (Math.random() * ((max - min) + 1)) + min;

        return x;
    }

    public static int distributionNumberCarte(String name) {
        joueur1Carte1Chiffre = getRandomIntegerBetweenRange(1, 13);

        if (joueur1Carte1Chiffre > 10) {
            joueur1Carte1Chiffre = 10;
        }
        if (name.equals("Joueur")) {

            if (joueur1Carte1Chiffre == 1) {
                Scanner myObj1 = new Scanner(System.in);
                System.out.println(userName + ", you draw a ace, choose his value : 1 or 11");
                String reponse1 = myObj1.nextLine();
                if (reponse1.equals("1")) {
                    joueur1Carte1Chiffre = 1;
                } else {
                    joueur1Carte1Chiffre = 11;
                }
            }
        } else {
            if (joueur1Carte1Chiffre == 1) {
                if (totalCroupier + 11 >= 17 && totalCroupier + 11 <= 21) {
                    joueur1Carte1Chiffre = 11;
                } else {
                    joueur1Carte1Chiffre = 1;
                }
            }
        }
        return joueur1Carte1Chiffre;

    }

    public static String compare(int joueur, int croupier) {
        if (joueur > 21) {
            return userName + ", you lose !";
        }
        if (croupier > 21) {
            return "The dealer's total is " + totalCroupier + ", You win !";
        }
        if (joueur > croupier) {
            return userName + ", you Win !";
        }
        if (joueur == croupier) {
            return "Deuce !";
        } else {
            return "The dealer's total is " + totalCroupier + ", the dealer wins !";
        }

    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in); // Create a Scanner objectI played blackjack with me
        System.out.println("Hi, Welcome to Wild Code School CASINO !");
        System.out.println("Please enter your name :");
        userName = myObj.nextLine(); // Read user input
        System.out.println("Welcome " + userName + ", nice to see you !"); // Output user input
        String rejouer = "yes";
        do {
            System.out.println("");
            jouer();

            System.out.println("Do you want play again ?");
            rejouer = myObj.nextLine(); // Read user input

        } while (rejouer.equals("yes"));

    }

    public static void jouer() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner objectI played blackjack with me

        int carte1Joueur = distributionNumberCarte("Joueur");
        System.out.println(userName + ", your first card is " + carte1Joueur + ".");

        int carte2Joueur = distributionNumberCarte("Joueur");
        System.out.println(userName + ", your second card is " + carte2Joueur + ".");

        int total = carte1Joueur + carte2Joueur;
        System.out.println(userName + ", your total is " + total + ".");

        // CROUPIER

        int carte1Croupier = distributionNumberCarte("Croupier");
        int carte2Croupier = distributionNumberCarte("Croupier");

        System.out.println("The dealer's first card is " + carte1Croupier + ".");
        System.out.println("The dealer's second card is face down.");

        totalCroupier = carte1Croupier + carte2Croupier;
        System.out.println("The dealer's visible total is " + carte1Croupier + ".");

        int carte;

        while (total <= 21 && totalCroupier <= 21) {
            // joueur
            System.out.println(userName + ", do you want to draw another card ?");
            System.out.println("yes or no");
            String reponse = myObj.nextLine();

            if (reponse.equals("yes")) {
                carte = distributionNumberCarte("Joueur");
                System.out.println(userName + ", your card is " + carte + ".");
                total = total + carte;
                System.out.println(userName + ", your total is " + total + ".");

            } else {
                int carteCroupier;
                System.out.println("The dealer's face-down card is turned up, it's " + carte2Croupier + ".");
                System.out.println("The dealer's total is " + totalCroupier + ".");
                while (totalCroupier <= 16) {
                    carteCroupier = distributionNumberCarte("Croupier");
                    System.out.println("The dealer's new card is " + carteCroupier + ".");
                    totalCroupier = totalCroupier + carteCroupier;
                    System.out.println("The dealer's total is " + totalCroupier + ".");

                }

                System.out.println(compare(total, totalCroupier));
                return;
            }
            // croupier

        }
        System.out.println(compare(total, totalCroupier));

    }

}
