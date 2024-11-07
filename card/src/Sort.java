import java.util.Arrays;

/**
 * Created by abbyr on 07/11/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public class Sort
{
   public static void bubbleSort(int[] arr){
      int lastPos = arr.length - 1;
      int innerLastPos = lastPos;
      int temp;
      for(int i = 0; i<lastPos; i++){
         for(int j = 0; j<innerLastPos; j++){
            if(arr[j] > arr[j+1]){
               temp = arr[i];
               arr[j] =arr[j+1];
               arr[j+1] = temp;
            }
         }
         innerLastPos--;
      }
   }

   public static void main(String[] args){
      int[] arr = {9, 6, 3, 2, 5, 3, 10, 8, 1, 7, 4};
      bubbleSort(arr);
      System.out.println(Arrays.toString(arr));
   }
}//class
