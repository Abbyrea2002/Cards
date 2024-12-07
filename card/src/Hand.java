/**
 * Created by abbyr on 06/12/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
import java.util.ArrayList;
public class Hand extends Card{
   private static ArrayList<Card> cards;

   public Hand(){
      cards = new ArrayList<>();
   }

   public void addCard(Card card){
      cards.add(card);
   }

   private static boolean inHand(Card card, Card[] hand){
      for (Card cardInHand : hand) {
         if (card.getSuit().equals(cardInHand.getSuit()) &&
               card.getRank().equals(cardInHand.getRank())) {
            return true;
         }
      }
      return false;
   }

   public static void main(String[] args){

      Card[] hand = new Card[10];
      System.out.println("My hand is.....");
      for(int i = 0; i < hand.length; i++){
         hand[i] = new Card();
         System.out.println(hand[i]);
      }

      System.out.println("---------------------");

      Card card1 = new Card();
      Card card2 = new Card();
      Card card3 = new Card();
      Card card4 = new Card();
      Card card5 = new Card();
      Card card6 = new Card();
      Card card7 = new Card();
      Card card8 = new Card();
      Card card9 = new Card();
      Card card10 = new Card();

      System.out.println("Checking card No.1: " + card1 + "..." + inHand(card1, hand));
      System.out.println("Checking card No.2: " + card2 + "..." + inHand(card2, hand));
      System.out.println("Checking card No.3: " + card3 + "..." + inHand(card3, hand));
      System.out.println("Checking card No.4: " + card4 + "..." + inHand(card4, hand));
      System.out.println("Checking card No.5: " + card5 + "..." + inHand(card5, hand));
      System.out.println("Checking card No.6: " + card6 + "..." + inHand(card6, hand));
      System.out.println("Checking card No.7: " + card7 + "..." + inHand(card7, hand));
      System.out.println("Checking card No.8: " + card8 + "..." + inHand(card8, hand));
      System.out.println("Checking card No.9: " + card9 + "..." + inHand(card9, hand));
      System.out.println("Checking card No.10: " + card10 + "..." + inHand(card10, hand));




   }



}//class
