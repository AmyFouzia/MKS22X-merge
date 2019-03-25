import java.util.*;

public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
  /*mergesort(data,low,hi):
  if lo >= hi :
    return
  mergesort left side
  mergesort right side
  merge
  */
    msHelp(data, 0, data.length-1);
  }

   private static void msHelp(int[]data, int low, int high){
     int mid = (low + high)/2;

     if(high-low < 100){
       insertionSort(data, low, high);
     }

     else{
     msHelp(data, low, mid); //left sort
     msHelp(data, mid+1, high); //right sort
     }

     merge(data, low, mid, high); //both sort
   }

   public static void merge(int[]data, int low, int mid, int high){
     int[] track = new int[(high-low)+1];
     int trackInt = 0;
     int right = mid + 1; //right ind
     int left = low; //left ind

     while((left <= mid || right <= high) && trackInt < track.length){
       if((right >= data.length || (right> high || data[left] < data[right])) && left <= mid){
         left++;
         trackInt++;
       }

       //put right in track data
       else{
         track[trackInt] = data[right];
         right++;
         trackInt++;
       }
     }
     //track vals-->original data
     for(int i = 0; i < track.length; i++){
       data[low+i] = track[i];
     }
   }

   public static void insertionSort(int[]data, int start, int end){
     int len = end - start + 1;
     for (int i = 1; i < len; i++){
       int track = data[start + i];
       int ob = 0;
          for (ob = i; ob > 0 && track < data[start + ob - 1]; ob--){
            data[start + ob] = data[start + ob - 1];
          }
       data[start + ob] = track;
     }
   }

   public static void main(String[] args){
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
