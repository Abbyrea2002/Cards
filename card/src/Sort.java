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
         System.out.println("Pass : " + Arrays.toString(arr));
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

   public static void selectionSort(int[] arr){
      int firstPos = 0, lastPos = arr.length - 1;
      int temp, smallestPos;

      for(int i = firstPos; i<lastPos; i++){
         smallestPos = i;
         for(int j=i+1; j<=lastPos; j++){
            numComparisons++;
            if(arr[j] < arr[smallestPos]){
               smallestPos = j;
            }
         }
         temp = arr[smallestPos];
         arr[smallestPos] = arr[i];
         arr[i] = temp;
         numSwaps++;
         System.out.println("Pass" + (i+1) + ": " + Arrays.toString(arr));
      }
   }

   public static void selectionSort_r(int[] arr, int firstPos, int lastPos){

      int temp, smallestPos;

      numComparisons++;

      if(firstPos<lastPos){
         smallestPos = firstPos;
         for(int j=firstPos+1; j<=lastPos; j++){
            numComparisons++;
            if(arr[j] < arr[smallestPos]){
               smallestPos = j;
            }
         }
         temp = arr[smallestPos];
         arr[smallestPos] = arr[firstPos];
         arr[firstPos] = temp;
         numSwaps++;
         System.out.println("Pass" +  ": " + Arrays.toString(arr));
         selectionSort_r(arr, firstPos+1, lastPos);
      }
   }
   public static void main(String[] args){

      int[] arr = {5, 9, 1, 10, 3, 8, 2, 4, 7, 6};
      System.out.println("Before:" + Arrays.toString(arr));
      selectionSort_r(arr, 0, arr.length-1);
      System.out.println("After:" + Arrays.toString(arr));
      System.out.println("There were " + numComparisons + " comparisons and " + numSwaps + " swaps.");

      //int[] arr;
      //long startTime, endTime;
      //int[] arraySizes = {100, 200, 400, 800, 1600, 3200, 6400};

//         for(int arraySize : arraySizes){
//            startTime = System.currentTimeMillis();
//            for(int i=0; i<1000; i++){
//               arr = randomArray(arraySize);
//               bubbleSort(arr);
//
//            }
//            endTime = System.currentTimeMillis();
//
//            System.out.println(arraySize + "\t " + (endTime - startTime));


   }
}//class
