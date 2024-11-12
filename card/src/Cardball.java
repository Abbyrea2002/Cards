/**
 * Created by abbyr on 12/11/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public class Cardball
{
   private static final int NUMCARDS = 5;
   private Card[] player1 = new Card[NUMCARDS];
   private Card[] player2 = new Card[NUMCARDS];
   private int score1 = 0, score2 = 0;

   public Cardball(){
      Deck deck = new Deck();

      for(int i = 0; i<NUMCARDS; i++){
         this.player1[i] = deck.deal();
         this.player2[i] = deck.deal();
      }
      sort(player1);
      sort(player2);
   }

   private static <T extends Comparable <T>>void sort(T[] arr){
      T nextToInsert;
      int index;


      for(int i = 1; i< arr.length; i++){
         nextToInsert = arr[i];
         index = i - 1;

         while(index >= 0 && arr[index].compareTo(nextToInsert) > 0){
            arr[index + 1] = arr[index];
            index--;
         }
         arr[index + 1] = nextToInsert;
      }
   }

   public static void main(String[] args)
   {
      Cardball game = new Cardball();

      for (int i = NUMCARDS - 1; i >= 0; i--)
      {
         System.out.println("Player 1: " + game.player1[i]);
         System.out.println("Player 2: " + game.player2[i]);

         if (game.player1[i].compareTo(game.player2[i]) > 0)
         {
            System.out.println("Goal to player 1");
            game.score1++;
         } else
         {
            if (game.player1[i].compareTo(game.player2[i]) < 0)
            {
               System.out.println("Goal to player 2\n");
               game.score2++;

            } else System.out.println("No score\n");

         }

      }
      System.out.println("FINAL SCORE");
      System.out.println("-----------");
      System.out.println("Player1 " + game.score1 + " Player2 " + game.score2);
   }
}//class
