import java.util.Random;

/**
 * Created by abbyr on 07/11/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public class Card implements Comparable<Card>
{
   private final int RANK, SUIT;




   private static final Random GENERATOR = new Random();
   private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
   private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
   //private static final String[] COLOURS = {"Red", "Black"};

   public Card(){
      RANK = GENERATOR.nextInt(RANKS.length);
      SUIT = GENERATOR.nextInt(SUITS.length);
      //COLOUR = (SUIT == 1 || SUIT == 2) ? 0 : 1;


   }
   public Card(int r, int s){
      RANK = r;
      SUIT = s;
   }

   public String getRank(){
      return RANKS[RANK];

   }

   public String getSuit(){
      return SUITS[SUIT];

   }

   //public String getColour(){
     // return COLOURS[COLOUR];
   //}

   public int getRankValue(){
      return RANK;
   }





   @Override
   public String toString(){
      return getRank() + " of " + getSuit();

   }

   @Override
   public int compareTo(Card otherCard){
      if(this.getRankValue() > otherCard.getRankValue()) return 1;
      else if(this.getRankValue() < otherCard.getRankValue()) return -1;
      else return 0;
   }
}//class
