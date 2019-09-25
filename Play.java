import java.util.Random;
import java.util.Scanner;

class Play {

    public static int joueur1Carte1Chiffre;
    // public static String joueur1Carte1Nom;
    public static String carteJoueur1;

    public static int getRandomIntegerBetweenRange(int min, int max) {
        int x = (int) (Math.random() * ((max - min) + 1)) + min;

        return x;
    }

    // public static String distributionNomCarte() {

    // String[] deckName = { "club", "diamond", "heart", "spade" };
    // int nb = getRandomIntegerBetweenRange(0, 3);
    // joueur1Carte1Nom = deckName[nb];
    // return joueur1Carte1Nom;
    // }
    public static int distributionNumberCarte(String name) {
        joueur1Carte1Chiffre = getRandomIntegerBetweenRange(1, 13);

        if (joueur1Carte1Chiffre > 10) {
            joueur1Carte1Chiffre = 10;
        }
        if (name.equals("Joueur")) {

            if (joueur1Carte1Chiffre == 1) {
                Scanner myObj1 = new Scanner(System.in);
                System.out.println("vous avez piocher un as: quelle valeur vous voulez lui donner: 1 ou 11");
                String reponse1 = myObj1.nextLine();
                if (reponse1.equals("1")) {
                    joueur1Carte1Chiffre = 1;
                } else {
                    joueur1Carte1Chiffre = 11;
                }
            }
        } else {

        }
        return joueur1Carte1Chiffre;

    }
    // public static String carteJoueur1(){

    // return distributionNumberCarte() + " " + distributionNomCarte();
    // }

    public static String compare(int joueur, int croupier) {
        if (joueur > 21) {
            return "le joueur a perdu";
        }
        if (croupier > 21) {
            return "le croupier a perdu";
        }
        if (joueur > croupier) {
            return "le joueur a Gagner";
        }
        if (joueur == croupier) {
            return "Egalité";
        } else {
            return "le croupier a gagné";
        }

    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in); // Create a Scanner objectI played blackjack with me
        // System.out.println("I played blackjack with me");
        // System.out.println("Enter your name");
        // String userName = myObj.nextLine(); // Read user input
        // System.out.println("Welcome: " + userName); // Output user input

        int carte1Joueur = distributionNumberCarte("Joueur");
        int carte2Joueur = distributionNumberCarte("Joueur");

        System.out.println("Carte 1 joueur = " + carte1Joueur);
        System.out.println("Carte 2 joueur = " + carte2Joueur);

        int total = carte1Joueur + carte2Joueur;
        System.out.println("total Joueur = " + total);

        // CROUPIER

        int carte1Croupier = distributionNumberCarte("Croupier");
        int carte2Croupier = distributionNumberCarte("Croupier");

        System.out.println("Carte 1 croupier = " + carte1Croupier);
        System.out.println("Carte 2 croupier = " + "carte cachée");

        int totalCroupier = carte1Croupier + carte2Croupier;
        System.out.println("total visible Croupier = " + carte1Croupier);
        int carte;

        while (total < 21 && totalCroupier < 21) {

            System.out.println("Voulez-vous une autre carte ?");
            System.out.println("oui ou non");
            String reponse = myObj.nextLine();

            if (reponse.equals("oui")) {
                carte = distributionNumberCarte("Joueur");
                System.out.println("Votre carte:" + carte);
                total = total + carte;
                System.out.println("total Joueur = " + total);

            } else {
                System.out.println("Le croupier retourne sa deuxième carte : " + carte2Croupier);
                System.out.println("total Croupier = " + totalCroupier);
                System.out.println(compare(total, totalCroupier));
                return;
            }

        }
        System.out.println(compare(total, totalCroupier));

        // // Joueur 21

        // if (total == 21) {
        // System.out.println("Le croupier retourne sa deuxième carte : " +
        // carte2Croupier);
        // System.out.println("total Croupier = " + totalCroupier);
        // System.out.println(compare(total, totalCroupier));

        // } else {

        // // CARTE 3

        // System.out.println("Voulez-vous continuer ?");
        // System.out.println("oui ou non");
        // String reponse = myObj.nextLine();

        // if (reponse.equals("oui")) {
        // int carte3Joueur = distributionNumberCarte("Joueur");
        // System.out.println("Carte 3 joueur = " + carte3Joueur);
        // total = total + carte3Joueur;
        // System.out.println("total Joueur = " + total);
        // System.out.println(compare(total, totalCroupier));

        // }
        // if (reponse.equals("non")) {

        // System.out.println("Le croupier retourne sa deuxième carte : " +
        // carte2Croupier);
        // System.out.println("total Croupier = " + totalCroupier);
        // System.out.println(compare(total, totalCroupier));

        // }
        // }

    }

}