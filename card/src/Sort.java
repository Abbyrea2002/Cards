import java.util.ArrayList;
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
        // System.out.println("\nGap is " + gap);
         for(int i = gap; i<arr.length; i++){
            temp = arr[i];
            numComparisons++;
            for(index = i; index >= gap && arr[index - gap] > temp;index -= gap){
               arr[index] = arr[index - gap];
               numUpdates++;
               numComparisons++;
            }
            arr[index] = temp;
            numUpdates++;
            //System.out.println("Pass:" + Arrays.toString(arr));
         }
      }

   }

   private static void shellShort2(int[] arr, int[]gaps){
      for (int gap : gaps) {
         for (int i = gap; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j >= gap && arr[j - gap] > temp) {
               arr[j] = arr[j - gap];
               j -= gap;
            }
            arr[j] = temp;
         }
      }
   }

   private static void mergeSort_r(int[] arr,int[] temp, int first, int last){
      if(first < last){
         int mid = (first + last) / 2;
         mergeSort_r(arr, temp, first, mid);
         mergeSort_r(arr, temp, mid + 1, last);
         merge(arr, temp, first, mid, last);
      }
   }

   public static void mergeSort(int[] arr){
      int[] temp = new int[arr.length];
      mergeSort_r(arr, temp, 0, arr.length-1);


   }

   private static void merge(int[] arr, int[] temp, int first, int mid, int last){
      int pos1 = first, pos2 = mid + 1, index = first;


      while(pos1 <= mid && pos2 <= last){
         numComparisons++;
         if(arr[pos1] <= arr[pos2]) temp[index++] = arr[pos1++];
         else temp[index++] = arr[pos2++];
         numUpdates++;
      }
      numUpdates++;
      while(pos1 <= mid) temp[index++] = arr[pos1++];
      numUpdates++;
      while(pos2 <= last) temp[index++] = arr[pos2++];

      for(int i = first; i <= last; i++) arr[i] = temp[i];
      numUpdates += last - first +1;
   }

   public static void swap(int[] arr, int first, int second){
      int temp = arr[first];
      arr[first] = arr[second];
      arr[second] = temp;
      numUpdates+=2;
   }

   public static void orderThree(int[] arr, int first, int second, int third){
      if (arr[first] > arr[second]) swap(arr, first, second);
      if(arr[first] > arr[third]) swap(arr, first, third);
      if(arr[second] > arr[third]) swap(arr, second, third);
      numComparisons+=3;

   }

   public static void quickSort(int[] arr){
      quickSort_r(arr, 0, arr.length- 1);

   }

   public static void quickSort_r(int[] arr, int first, int last){
      int middle = (first + last) / 2;
      orderThree(arr, first, middle, last);
      swap(arr, middle, last);
      int pivot = arr[last];
      int indexFromLeft = first, indexFromRight = last;

      while(indexFromLeft <= indexFromRight){
         numComparisons++;
         while(arr[indexFromLeft] < pivot){ indexFromLeft++; numComparisons++;}
         numComparisons++;
         while (arr[indexFromRight] > pivot){ indexFromRight--; numComparisons++;}
         if(indexFromLeft <= indexFromRight) swap(arr, indexFromLeft++, indexFromRight--);


      }

      if(first < indexFromRight) quickSort_r(arr, first, indexFromRight);
      if(indexFromLeft < last) quickSort_r(arr, indexFromLeft, last);
   }



   private static int[][] generateRandomArrays(int arraySize, int numArrays){
      int[][] arrays = new int[numArrays][arraySize];
      Random random = new Random();

      for (int i = 0; i < numArrays; i++) {
         for (int j = 0; j < arraySize; j++) {
            arrays[i][j] = random.nextInt(); // Fill with random integers
         }
      }
      return arrays;
   }

   private static long measureTime(int[][] arrays, int[] gaps){
      long startTime = System.currentTimeMillis();
      for(int[] array : arrays){
         int[] arrayCopy = Arrays.copyOf(array, array.length);
         shellShort2(arrayCopy, gaps);
      }
      long endTime = System.currentTimeMillis();
      return endTime - startTime;
   }

   public static void main(String[] args){
      //int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
      int[] arr = {5, 9, 1, 10, 3, 8, 2, 4, 7, 6};
      System.out.println("Before:" + Arrays.toString(arr));
      quickSort(arr);
      System.out.println("After:" + Arrays.toString(arr));
      System.out.println("There were " + numComparisons + " comparisons and " + numUpdates + " updates.");

//      int[][] arrays = generateRandomArrays(10000, 1000);
//      int[] gapSeq1 = {5000, 2500, 1250, 625, 312, 156, 78, 39, 19, 9, 4, 1}; // n/2, n/4, n/8, ..., 1
//      int[] gapSeq2 = {3333, 1111, 370, 123, 41, 13, 4, 1}; // n/3, n/6, n/9, ..., 1
//      int[] gapSeq3 = {2500, 625, 156, 39, 9, 1}; // n/4, n/16, n/64, ..., 1
//      int[] gapSeq4 = {3785, 1695, 749, 326, 138, 57, 23, 9, 4, 1}; // Mean of prime numbers sequence
//
//      long time1 = measureTime(arrays, gapSeq1);
//      System.out.println("Gap list is " + Arrays.toString(gapSeq1));
//      System.out.println("Execution time is: " + time1 + "\n");
//
//      long time2 = measureTime(arrays, gapSeq2);
//      System.out.println("Gap list is " + Arrays.toString(gapSeq2));
//      System.out.println("Execution time is: " + time2 + "\n");
//
//      long time3 = measureTime(arrays, gapSeq3);
//      System.out.println("Gap list is " + Arrays.toString(gapSeq3));
//      System.out.println("Execution time is: " + time3 + "\n");
//
//      long time4 = measureTime(arrays, gapSeq4);
//      System.out.println("Gap list is " + Arrays.toString(gapSeq4));
//      System.out.println("Execution time is: " + time4 + "\n");

//      int[] arr;
//      long startTime, endTime;
//      int[] arraySizes = {5000, 10000};
//      long[] sortTimes = new long[arraySizes.length];
//     // long[] r_sortTimes = new long[arraySizes.length];
//
//
//            for(int a = 0; a< arraySizes.length; a++){
//               startTime = System.currentTimeMillis();
//               for (int i = 0; i < 1000; i++)
//               {
//                  arr = randomArray(arraySizes[a]);
//                  mergeSort(arr);
//
//               }
//               endTime = System.currentTimeMillis();
//               sortTimes[a] = endTime - startTime;
//            }
//
////            for(int a = 0; a< arraySizes.length; a++){
////               startTime = System.currentTimeMillis();
////               for (int i = 0; i < 1000; i++)
////               {
////                  arr = randomArray(arraySizes[a]);
////                  insertionSort_r(arr, 0, arr.length - 1);
////
////               }
////               endTime = System.currentTimeMillis();
////
////               r_sortTimes[a] = endTime - startTime;
////            }
//
//            for(int a = 0; a < arraySizes.length; a++){
//               System.out.println(arraySizes[a] + "\t" + sortTimes[a]);
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
