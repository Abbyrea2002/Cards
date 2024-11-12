import java.util.Random;

/**
 * Created by abbyr on 12/11/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public class Deck
{
   private static int NUMCARDS = 52;
   private final Card[] CARDS = new Card[NUMCARDS];
   private int cardIndex;

   public Deck(){
      for(int thisCard=0; thisCard < NUMCARDS; thisCard++){
         this.CARDS[thisCard] = new Card(thisCard % 13, thisCard/13);
      }
      this.cardIndex = NUMCARDS - 1;
      this.shuffle();
   }

   private void shuffle(){
      int index;
      Card temp;
      Random random = new Random();
      for(int i = this.CARDS.length - 1; i > 0; i--){
         index = random.nextInt(i + 1);
         temp = this.CARDS[index];
         this.CARDS[index] = this.CARDS[i];
         this.CARDS[i] = temp;

      }
   }

   public Card deal(){
      return this.CARDS[this.cardIndex--];
   }


}//class
