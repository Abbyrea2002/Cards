import java.util.Objects;

/**
 * Created by ${USER} on ${DATE}
 * COMMENTS ABOUT PROGRAM HERE
 */
public class CardTest
{
   public static void main(String[] args){
      Card myCards[] = new Card [100];
      int numSnaps = 0;
      int numSuperSnaps = 0;
      for(int i = 0; i<100; i++){
         myCards[i] = new Card();
         System.out.println(myCards[i]);

         if(i > 0 && Objects.equals(myCards[i].getRankValue(), myCards[i-1].getRankValue())){
            System.out.println("SNAP!!");
            numSnaps++;
            if(i > 0 && Objects.equals(myCards[i].getColour(), myCards[i-1].getColour())){
               System.out.println("SUPERSNAP!!");
               numSuperSnaps++;
            }
         }



      }
      System.out.println("There were " + numSnaps + " snaps & " + numSuperSnaps + " supersnaps");
   }






//      Card card1 = new Card();
//      Card card2 = new Card();
//
//      System.out.println("Card 1 is the " + card1);
//      System.out.println("Card 2 is the " + card2);
//
//      if(card1.compareTo(card2) > 0){
//         System.out.println("Card 1 is bigger");
//      }else if (card1.compareTo(card2) < 0){
//         System.out.println("Card 2 is bigger");
//      }
//      else{
//         System.out.println("Card 1 and Card 2 are equal");
//      }

   }
