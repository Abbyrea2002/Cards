import java.util.Random;

/**
 * Created by abbyr on 14/11/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public class Challenege2
{

   public static int numComparisons = 0, numSwaps = 0, numUpdates = 0;
   private static void mergeSort_rWithTemp(int[] arr, int[] temp, int first, int last){
      if(first < last){
         int mid = (first + last) / 2;
         mergeSort_rWithTemp(arr, temp, first, mid);
         mergeSort_rWithTemp(arr, temp, mid + 1, last);
         mergeWithTemp(arr, temp, first, mid, last);
      }
   }

   public static void mergeSortWithTemp(int[] arr){
      int[] temp = new int[arr.length];
      mergeSort_rWithTemp(arr, temp, 0, arr.length-1);


   }

   private static void mergeWithTemp(int[] arr, int[] temp, int first, int mid, int last){
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

   private static void mergeSort_rWithout(int[] arr, int first, int last){
      if(first < last){
         int mid = (first + last) / 2;
         mergeSort_rWithout(arr, first, mid);
         mergeSort_rWithout(arr, mid + 1, last);
         mergeWithout(arr, first, mid, last);
      }
   }
   public static void mergeSortWithout(int[] arr){
      int[] temp = new int[arr.length];
      mergeSort_rWithout(arr, 0, arr.length-1);


   }

   private static void mergeWithout(int[] arr, int first, int mid, int last){
      int pos1 = first, pos2 = mid + 1, index = first;
      int[] temp = new int[arr.length];


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
      int[] arraySizes = {5000, 10000};
      long[] sortTimesWith = new long[arraySizes.length];
      long[] sortTimesWithout = new long[arraySizes.length];


      for(int a = 0; a< arraySizes.length; a++){
         startTime = System.currentTimeMillis();
         for (int i = 0; i < 1000; i++)
         {
            arr = randomArray(arraySizes[a]);
            mergeSortWithTemp(arr);

         }
         endTime = System.currentTimeMillis();
         sortTimesWith[a] = endTime - startTime;
      }
      for(int a = 0; a< arraySizes.length; a++){
         startTime = System.currentTimeMillis();
         for (int i = 0; i < 1000; i++)
         {
            arr = randomArray(arraySizes[a]);
            mergeSortWithout(arr);

         }
         endTime = System.currentTimeMillis();
         sortTimesWithout[a] = endTime - startTime;
      }
      for(int a = 0; a < arraySizes.length; a++){
         System.out.println("Array sizes: " + arraySizes[a]);
         System.out.println("Temporary array passed as parameter: " + sortTimesWith[a]);
         System.out.println("Temporary array generated in merge method: " + sortTimesWithout[a]);
         System.out.println();
      }
      
   }
}//class
