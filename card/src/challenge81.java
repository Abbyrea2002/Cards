public class challenge81 {
    public static void main(String[] args){
              int[] arr;
      long startTime, endTime;
      int[] arraySizes = {10000, 50000, 100000};
      long[] sortTimes = new long[arraySizes.length];
      long[] r_sortTimes = new long[arraySizes.length];


            for(int a = 0; a< arraySizes.length; a++){
               startTime = System.currentTimeMillis();
               for (int i = 0; i < 1000; i++)
               {
                  arr = Sort.randomArray(arraySizes[a]);
                  Sort.quickSort(arr);

               }
               endTime = System.currentTimeMillis();
               sortTimes[a] = endTime - startTime;
            }

            for(int a = 0; a< arraySizes.length; a++){
               startTime = System.currentTimeMillis();
               for (int i = 0; i < 1000; i++)
               {
                  arr = Sort.randomArray(arraySizes[a]);
                  Sort.quickSortWithInsertion(arr, 0, arr.length - 1);

               }
               endTime = System.currentTimeMillis();

               r_sortTimes[a] = endTime - startTime;
            }

            for(int a = 0; a < arraySizes.length; a++){
               System.out.println("Array size: " + arraySizes[a]);
               System.out.println("Pure Quicksort: " + sortTimes[a]);
               System.out.println("Using Insertion Sort for sub-arrays <= 100: " + r_sortTimes[a] + "\n");
            }





    }

}
