import java.util.Comparator;
import java.util.Random;

/**
 * Created by Marta on 2017-08-15.
 */
public class QuickSort {

    static void quickSort(int[] array, int i, int arrayLength){
        if(arrayLength <= 1) return;
        Random rn = new Random();
        int pivot = array[i + rn.nextInt(arrayLength)];
        int p = i-1, j = i, q = i + arrayLength;
        while (j < q){
            if(array[j] < pivot){
                //Value less than pivot
                swap(array,j++,++p);
            } else if(array[j] > pivot){
                //Value greater than pivot
                swap(array,j,--q);
            } else {
                //Skips the pivot
                j++;
            }

        }
        quickSort(array,i,p-i+1);
        quickSort(array,q,arrayLength-(q-i));
    }
    static void swap(int[] a, int b, int c){
        int d = a[b];
        a[b] = a[c];
        a[c] = d;
    }

}
