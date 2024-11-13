import java.util.Arrays;
import java.util.Random;

/**
 * Created by abbyr on 07/11/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public class Sort
{
   public static int numComparisons = 0, numSwaps = 0, numUpdates = 0;
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
         //System.out.println("Pass" + (i+1) + ": " + Arrays.toString(arr));
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
         //System.out.println("Pass" +  ": " + Arrays.toString(arr));
         selectionSort_r(arr, firstPos+1, lastPos);
      }
   }

   public static void insertionSort(int[] arr){
      int nextToInsert, index;

      for(int i = 1; i< arr.length; i++){
         nextToInsert = arr[i];

         index = i - 1;
         numComparisons++;
         while(index >= 0 && arr[index] > nextToInsert){
            arr[index + 1] = arr[index];
            numUpdates++;
            index--;
            numComparisons++;
         }
         arr[index + 1] = nextToInsert;
         numUpdates++;
         //System.out.println("Pass " + i + " : " + Arrays.toString(arr));
      }

   }

   public static void insertionSort_r(int[] arr, int firstPos, int lastPos){
      int nextToInsert, index;

     numComparisons++;
     if(firstPos < lastPos){
        insertionSort_r(arr, firstPos, lastPos - 1);
         nextToInsert = arr[lastPos];

         index = lastPos - 1;
         numComparisons++;
         while(index >= 0 && arr[index] > nextToInsert){
            arr[index + 1] = arr[index];
            numUpdates++;
            index--;
            numComparisons++;
         }
         arr[index + 1] = nextToInsert;
         numUpdates++;
        // System.out.println("Pass " + lastPos + " : " + Arrays.toString(arr));
      }

   }

   private static void shellSort(int[] arr){
      int temp, index;

      for(int gap = arr.length / 2; gap>0; gap/=2){
         System.out.println("\nGap is " + gap);
         for(int i = gap; i<arr.length; i++){
            temp = arr[i];
            numComparisons++;
            for(index = i; index >+ gap && arr[index - gap] > temp;index -= gap){
               arr[index] = arr[index - gap];
               numUpdates++;
               numComparisons++;
            }
            arr[index] = temp;
            numUpdates++;
            System.out.println("Pass:" + Arrays.toString(arr));
         }
      }

   }
   public static void main(String[] args){
      //int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
      int[] arr = {5, 9, 1, 10, 3, 8, 2, 4, 7, 6};
      System.out.println("Before:" + Arrays.toString(arr));
      //selectionSort_r(arr, 0, arr.length-1);
      //insertionSort_r(arr, 0, arr.length - 1);
      shellSort(arr);
      System.out.println("After:" + Arrays.toString(arr));
      System.out.println("There were " + numComparisons + " comparisons and " + numUpdates + " updates.");
//
//      int[] arr;
//      long startTime, endTime;
//      int[] arraySizes = {100, 200, 400, 800, 1600, 3200, 6400};
//      long[] sortTimes = new long[arraySizes.length];
//      long[] r_sortTimes = new long[arraySizes.length];
//
//
//            for(int a = 0; a< arraySizes.length; a++){
//               startTime = System.currentTimeMillis();
//               for (int i = 0; i < 1000; i++)
//               {
//                  arr = randomArray(arraySizes[a]);
//                  insertionSort(arr);
//
//               }
//               endTime = System.currentTimeMillis();
//               sortTimes[a] = endTime - startTime;
//            }
//
//            for(int a = 0; a< arraySizes.length; a++){
//               startTime = System.currentTimeMillis();
//               for (int i = 0; i < 1000; i++)
//               {
//                  arr = randomArray(arraySizes[a]);
//                  insertionSort_r(arr, 0, arr.length - 1);
//
//               }
//               endTime = System.currentTimeMillis();
//
//               r_sortTimes[a] = endTime - startTime;
//            }
//
//            for(int a = 0; a < arraySizes.length; a++){
//               System.out.println(arraySizes[a] + "\t" + sortTimes[a] + "\t" + r_sortTimes[a]);
//            }





//      int[] arraySizes = {100, 200, 400, 800, 1600, 3200, 6400};
//
//
//
//      for (int arraySize : arraySizes)
//      {
//         long iterativeTime = 0;
//         long recursiveTime = 0;
//
//         for (int i = 0; i < 1000; i++)
//         {
            //int[] arr = randomArray(arraySize);
//            int[] arrCopy = Arrays.copyOf(arr, arr.length);

            // Measure iterative selection sort time
//            long startTime = System.currentTimeMillis();
//            selectionSort(arr);
//            long endTime = System.currentTimeMillis();
//            iterativeTime += (endTime - startTime);
//
//            // Measure recursive selection sort time
//            startTime = System.currentTimeMillis();
//            selectionSort_r(arrCopy, 0, arrCopy.length - 1);
//            endTime = System.currentTimeMillis();
//            recursiveTime += (endTime - startTime);
//         }
//         System.out.printf("%d\t\t%d\t\t\t%d\n", arraySize, iterativeTime, recursiveTime);
     // }
   }
}//class
