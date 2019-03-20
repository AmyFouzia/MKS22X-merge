import java.util.*;

public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
  /*mergesort(data,lo,hi):
  if lo >= hi :
    return
  mergesort left side
  mergesort right side
  merge
  */
    msHelp(data, 0, data.length-1);
  }

   private static void msHelp(int[]data, int lo, int hi){

   }

   public static void merge(int[] data,int lo,int midpoint,int hi){

   }

   public static void insertionSort(int[] ary, int start, int end){

   }

   public static void main(String[] args){
      //testing insertion insertionSort
      //int[] array = new int[]{2,3,1,0,3,4,1,8,7,9};
      //insertionSort(array, 8, 6);
      //System.out.println(Arrays.toString(array)); //should print {2,3,0,1,1,3,4,8,7,9}

      System.out.println("Size\t\tMax Value\tmerge /builtin ratio ");
      int[]MAX_LIST = {1000000000,500,10};
      for(int MAX : MAX_LIST){
        for(int size = 31250; size < 2000001; size*=2){
          long qtime=0;
          long btime=0;
          //average of 5 sorts.
          for(int trial = 0 ; trial <=5; trial++){
            int []data1 = new int[size];
            int []data2 = new int[size];
            for(int i = 0; i < data1.length; i++){
              data1[i] = (int)(Math.random()*MAX);
              data2[i] = data1[i];
            }
            long t1,t2;
            t1 = System.currentTimeMillis();
            Merge.mergesort(data2);
            t2 = System.currentTimeMillis();
            qtime += t2 - t1;
            t1 = System.currentTimeMillis();
            Arrays.sort(data1);
            t2 = System.currentTimeMillis();
            btime+= t2 - t1;
            if(!Arrays.equals(data1,data2)){
              System.out.println("FAIL TO SORT!");
              System.exit(0);
            }
          }
          System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
        }
        System.out.println();
      }
    }

   }
}
