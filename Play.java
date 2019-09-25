import java.util.Random;

class Play {

    public static int getRandomIntegerBetweenRange(int min, int max){

        int x = (int)(Math.random()*((max-min)+1))+min;
    
        return x;
    
    }

    public static String distribution() {


}


  

    public static void main(String[] args) {

        int[] deckNumber = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        String[] deckName = {"club", "diamond", "heart", "spade"};
        int x = getRandomIntegerBetweenRange(deckNumber[0], deckNumber[11]);
        System.out.println(x);
        



    }
     











}