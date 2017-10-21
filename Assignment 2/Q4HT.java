/**
 * Created by Marta Skreta on 2017-07-09.
 */


public class Q4HT {

    int[] HT;
    int counter;

    Q4HT(int N){
        HT = new int[N]; //create array of size n
        counter = N; //keeps track of array size for printing
    }

    int add(int x){
        int y = x%13; //this is my hash function, which calculates the index I want to place x
        while(HT[y] != 0 ){ //index y is already full
            y++; //increment y by 1 until I find a spot that is not full
        }
        HT[y] = x; //place the input at index y
        return y;
    }

    void print() {
        for (int i = 0; i < counter; i++) {
            System.out.print(" | " + HT[i]);
        }
        System.out.println();
    }

}
