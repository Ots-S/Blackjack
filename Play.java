import java.util.Random;

class Play {


    public static String Distribution() {

        

        return 0;
    }

 
    public static void main(String[] args) {

        int[] deckNumber = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        String[] deckName = {"club", "diamond", "heart","spade"};
        System.out.println(myRandomInteger(1,10));
    }

      public static  myRandomInteger(int min, int max)
        {
            return (int) (min + Math.random() * (max - min + 1));
        }
     











}