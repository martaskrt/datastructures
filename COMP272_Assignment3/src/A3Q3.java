import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Marta on 2017-08-15.
 * REFLECTION: To solve this problem, I wanted to implement a quicksort algorithm to sort each set. This is an efficient
 * algorithm that is space efficient and running time efficient if a good pivot is chosen (O(logn)) time. Deleting the
 * duplicates and comparing two sets was not hard to implement; I simply created an array for each set of numbers that
 * only stored a new number if it wasn't already in the array. I compared the elements at each index of two arrays;
 * if the method return true, that means every element at each index was the same and so the sets were identical.
 */
public class A3Q3 {
    public static void main(String[] args) {

        int[] s1 = {6, 4, 2, 10, 18, 5};
        int[] s2 = {4, 10, 18, 6, 2, 5};
        QuickSort sort1 = new QuickSort(); //use quickSort to sort elements in increasing order
        QuickSort sort2 = new QuickSort();
        sort1.quickSort(s1, 0, 6);
        sort2.quickSort(s2, 0, 6);
        if (Compare.compareArray(Compare.deleteDup(s1),Compare.deleteDup(s2))){ //delete the duplicates and compare two sets
            System.out.println("Set s1 and s2 contain the same elements!"); //should return true
        }
        else{ System.out.println("Set s1 and s2 do not contain the same elements!");}

        int[] s3 = {6, 4, 2, 10, 18, 5, 10, 2, 6};
        int[] s4 = {4, 10, 18, 6, 2, 5, 6, 18};
        QuickSort sort3 = new QuickSort();
        QuickSort sort4 = new QuickSort();
        sort3.quickSort(s3, 0, 9);
        sort4.quickSort(s4, 0, 8);
        if (Compare.compareArray(Compare.deleteDup(s4),Compare.deleteDup(s3))){
            System.out.println("Set s3 and s4 contain the same elements!"); //should return true
        }
        else{ System.out.println("Set s3 and s4 do not contain the same elements!");}

        int[] s5 = {6, 4, 2, 10, 19, 5, 10, 2, 6};
        int[] s6 = {4, 10, 18, 6, 2, 5, 6, 18};
        QuickSort sort5 = new QuickSort();
        QuickSort sort6 = new QuickSort();
        sort5.quickSort(s5, 0, 9);
        sort6.quickSort(s6, 0, 8);
        if (Compare.compareArray(Compare.deleteDup(s5),Compare.deleteDup(s6))){
            System.out.println("Set s5 and s6 contain the same elements!");
        }
        else{ System.out.println("Set s5 and s6 do not contain the same elements!");} //should return false

    }
}
class Compare {
    static int[] deleteDup(int[] x){ //delete duplicate elements in set
        int[] y = new int[x.length];
        if (x.length == 0) return null;
        int currentValue = x[0]; //keeps track of last value inserted in array; each new element is compared to this value to determine if there are replicates
        int n = 1; //keeps track of size
        int offset = 0; //keeps track of where to place next value in array; if there is a duplicate, it increases by 1
        y[0] = x[0]; //the first value cannot be a duplicate
        for (int i = 1; i < x.length; i++){
            if(x[i] != currentValue){
                y[i-offset] = x[i];
                currentValue = x[i];
                n++;
            } else { offset ++; }
        }
        x = new int[n];
        for (int i = 0; i < x.length; i++){
            x[i] = y[i];
        }
        return x;
    }

    static boolean compareArray(int[] a, int[] b){
        if(a.length!=b.length){ return false;} //if the arrays are not they same length, they cannot be identical
        for (int i = 0; i < a.length; i++){
            if(a[i] != b[i]) { //compares elements at each index for a and b, which are now sorted & have duplicates deleted
                return false;
            }
        }
        return true;
    }
}





