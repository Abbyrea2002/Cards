import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by abbyr on 21/11/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public class Challenge82 {

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

   public static void quickSort(int[] arr){
      quickSort_r(arr, 0, arr.length- 1);

   }

   public static void quickSort_r(int[] arr, int first, int last)
   {
      int middle = (first + last) / 2;
      orderThree(arr, first, middle, last);
      swap(arr, middle, last);
      int pivot = arr[last];
      int indexFromLeft = first, indexFromRight = last;

      while (indexFromLeft <= indexFromRight)
      {
         numComparisons++;
         while (arr[indexFromLeft] < pivot)
         {
            indexFromLeft++;
            numComparisons++;
         }
         numComparisons++;
         while (arr[indexFromRight] > pivot)
         {
            indexFromRight--;
            numComparisons++;
         }
         if (indexFromLeft <= indexFromRight) swap(arr, indexFromLeft++, indexFromRight--);


      }
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



   public static int[] randomArray(int n){
      Random rand = new Random();
      int[] arr = new int[n];
      for(int i = 0; i<n; i++){
         arr[i] = rand.nextInt(100);
      }
      return arr;
   }


   public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      int choice = 0;


         System.out.println("************************************************");
         System.out.println("***         Sort Performance Analyser        ***");
         System.out.println("************************************************");
         System.out.println("Measuring the execution time when sorting arrays");
         System.out.println("of 10, 100, 1k, 10k, 100k and 1 million elements");
         System.out.println("------------------------------------------------\n");
         System.out.println("Choose a sort algorithm");
         System.out.println("-----------------------");
         System.out.println("0. Exit");
         System.out.println("1. Bubble sort");
         System.out.println("2. Selection sort");
         System.out.println("3. Insertion sort");
         System.out.println("4. Shell sort");
         System.out.println("5. Merge sort");
         System.out.println("6. Quicksort");
         System.out.println("-----------------------");

         System.out.print("Your choice >>");
         choice = scanner.nextInt();

      System.out.println("User input: " + choice);

         int[] arraySizes = {10, 100, 1000, 10000, 1000000, 1000000};

         long previousSortTime = 0;
         for (int arraySize : arraySizes) {
            long totalTime = 0;

            for (int i = 0; i < 1000; i++) {
               int[] arr = randomArray(arraySize); // Generate random array

               long startTime = System.nanoTime();
               switch(choice){
                  case '1':
                     System.out.println("-----------------------");
                     System.out.println("Results for Bubble sort");
                     System.out.println("-----------------------");
                     System.out.printf("%-10s %-20s %-20s\n", "Size", "Sort Time (ns)", "Rate of Increase");
                     System.out.flush();
                     Sort.bubbleSort(arr);
                     break;
                  case '2':
                     System.out.println("-----------------------");
                     System.out.println("Results for Selection sort");
                     System.out.println("-----------------------");
                     System.out.printf("%-10s %-20s %-20s\n", "Size", "Sort Time (ns)", "Rate of Increase");

                     Sort.selectionSort(arr);
                  case '3':
                     System.out.println("-----------------------");
                     System.out.println("Results for Insertion sort");
                     System.out.println("-----------------------");
                     System.out.printf("%-10s %-20s %-20s\n", "Size", "Sort Time (ns)", "Rate of Increase");
                     Sort.insertionSort(arr);
                  case '4':
                     System.out.println("-----------------------");
                     System.out.println("Results for Shell sort");
                     System.out.println("-----------------------");
                     System.out.printf("%-10s %-20s %-20s\n", "Size", "Sort Time (ns)", "Rate of Increase");
                     Sort.shellSort(arr);
                  case '5':
                     System.out.println("-----------------------");
                     System.out.println("Results for Merge sort");
                     System.out.println("-----------------------");
                     System.out.printf("%-10s %-20s %-20s\n", "Size", "Sort Time (ns)", "Rate of Increase");
                     Sort.mergeSort(arr);
                  case '6':
                     System.out.println("-----------------------");
                     System.out.println("Results for  Quicksort");
                     System.out.println("-----------------------");
                     System.out.printf("%-10s %-20s %-20s\n", "Size", "Sort Time (ns)", "Rate of Increase");
                     Sort.quickSort(arr);

            }
            long endTime = System.nanoTime();
               totalTime += (endTime - startTime); // Sum total sort time for this size
         }
            // Calculate rate of increase
            double rateOfIncrease = (previousSortTime == 0) ? 0 : (double) totalTime / previousSortTime;

            // Display results for the current size
            System.out.printf("%-10d %-20d %-20.2f\n", arraySize, totalTime, (previousSortTime == 0) ? 0 : rateOfIncrease);

            // Update previousSortTime
            previousSortTime = totalTime;
         }
         scanner.close();
      }
}//class
