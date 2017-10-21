/**
 * Created by Marta on 2017-06-03.
 */
/** Question 4 REFLECTION: To go about answering this question, I realized that I simply had to go from the front and
 back ends of the list and swap the values. For example, to reverse 1,2,3, I had to swap 1 and 3. To code this, I
 decided to create two placeholder nodes that would contain the values I wanted to swap. I then changed the original
 nodes using the placeholder nodes so that they would contain swapped values. I tried to write a method that would
 reverse a DLList using only links; however, this proved to be overly challenging for me because I could not change
 the link pointers without losing data. Although this method may require slightly more memory because more data had to
 be stored, it was much easier to implement. The hardest part of this method was to figure out how to go through the
 list from both ends simultaneously, but I tackled this by creating two variables, front and back, that pointed to
 nodes at the front and back of the list. These nodes were incremented using front.next and back.prev after each swap.*/

public class Question4 {

    public static void main(String[] args) {

        System.out.println("Instancing a new DLList...");
        DLListReverse testCase = new DLListReverse();

        System.out.println("Adding 6 to DLList...");
        testCase.add(6);
        System.out.println("Adding 54 to DLList...");
        testCase.add(54);
        System.out.println("Adding 1005 to DLList...");
        testCase.add(1005);
        System.out.println("Adding 3 to DLList...");
        testCase.add(3);
        System.out.println("Adding 97 to DLList...");
        testCase.add(97);
        System.out.print("The DLList is currently: ");
        testCase.print();
        System.out.println("The DLList is being reversed...");
        testCase.reverse();
        System.out.print("The reversed DLList is: ");
        testCase.print();


    }
}
