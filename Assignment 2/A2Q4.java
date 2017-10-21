/**
 * Created by Marta Skreta on 2017-07-09.
 * /** Question 4 REFLECTION: To solve this problem, I simply created an array of size n.
 * I then created a hash function that took each input, i, and found i%13. I check in n to see if the space at index
 * i%13 was free. If it was, I placed i in that spot. If it wasn't, I incremented the index by 1 until I came across
 * a free spot and placed i there. While this is not the more efficient hash function as a lot of collisions took place,
 * it was quite simple to implement.
 */


public class A2Q4 {

    public static void main(String[] args) {

        Q4HT hashTable = new Q4HT(15);//I know I have 15 inputs and so I create an array of size 15
        int[] hash_list = {1,5,21,26,39,14,15,16,17,18,19,20,111,145,146}; //these are the integers I want to place in my array

        for(int number : hash_list){
            hashTable.add(number);
            hashTable.print();
        }
    }
}
