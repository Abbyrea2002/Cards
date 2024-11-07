import java.util.Arrays;
import java.util.Random;

/**
 * Created by abbyr on 07/11/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public class Sort
{
   public static int numComparisons = 0, numSwaps = 0;
   public static void bubbleSort(int[] arr){

      int firstPos = 0, lastPos = arr.length - 1;
      int temp, lastSwapPos;


      while(firstPos < lastPos){
         lastSwapPos = firstPos;
         for(int j = firstPos; j<lastPos; j++){
            numComparisons++;
            if(arr[j] > arr[j+1]){
               temp = arr[j];
               arr[j] =arr[j+1];
               arr[j+1] = temp;
               numSwaps++;
               lastSwapPos = j;
            }
         }
         lastPos = lastSwapPos;
         //System.out.println("Pass : " + Arrays.toString(arr));
      }
   }

   public static int[] randomArray(int n){
      Random rand = new Random();
      int[] arr = new int[n];

      for(int i = 0; i<n; i++){
         arr[i] = rand.nextInt(100);
      }
      return arr;
   }

   public static void main(String[] args){

      int[] arr;
      long startTime, endTime;
      int[] arraySizes = {100, 200, 400, 800, 1600, 3200, 6400};

      for(int arraySize : arraySizes){
         startTime = System.currentTimeMillis();
         for(int i=0; i<1000; i++){
            arr = randomArray(arraySize);
            bubbleSort(arr);

         }
         endTime = System.currentTimeMillis();

         System.out.println(arraySize + "\t " + (endTime - startTime));
      }

   }
}//class
