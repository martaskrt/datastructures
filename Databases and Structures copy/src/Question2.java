/**
 * Created by Marta on 2017-06-03.
 */

/** Question 2 REFLECTION: The most challenging part about this question was swapping nodes for the SLList
 * case because I realized that it was very easy to delete links when I changed where my nodes pointed to, and so I lost
 * a lot of data easily. As well, since there are head and tail nodes, they have to be taken into account as special
 * cases when performing a swap in order not to destroy the integrity of the SLList links. I debugged my code and
 * checked the links by creating a print method for the SLListSwap and DLListSwap classes; this ensured that I could
 * visualize my list in the console before and after a switch. After I wrote my initial code for the SLListSwap class,
 * I tested it extensively by adding element by element and performing the swap at multiple locations. I quickly found
 * that my code didn't work during special cases where the n value was really low and when trying to swap a value
 * contained in the head or the tail. By using the print() method I was able to write additional conditionals to
 * account for the special cases and then my code worked effectively.
 *
 * The DLListSwap was a lot easier to code than the SLListSwap since there are no head and tail nodes and the DLList has a
 * previous node linked to every node. I used a pencil and paper to draw out all the links needed for a swap and then proceeded
 * to code what I had written. After a little tweaking, I visualized what I had coded using the print() method in the
 * DLListSwap and I was able to create a method that works very well, as shown below.
 * */

public class Question2 {

    public static void main(String[] args) {
        System.out.println("Creating new SLList!");

        SLListSwap testSLL = new SLListSwap();

        System.out.println("Adding integers to SLL instance...");
        System.out.println("Adding 5 to the list..."); testSLL.add(5);
        System.out.print("Current list: ");
        testSLL.print();
        System.out.println();

        System.out.print("Adding 2 to the list...");
        testSLL.add(2); testSLL.print();

        System.out.print("Swapping values 5 and 2...");
        testSLL.swap(5,2);
        testSLL.print();System.out.println();

        System.out.print("Adding 7 to the list...");testSLL.add(7);
        testSLL.print();

        System.out.print("Swapping values 5 and 7...");
        testSLL.swap(5,7);
        testSLL.print();
        System.out.println();

        System.out.print("Adding 4 to the list...");testSLL.add(4);
        testSLL.print();
        System.out.print("Adding 3 to the list...");testSLL.add(3);
        testSLL.print();

        System.out.print("Swapping values 4 and 3...");
        testSLL.swap(4,3);
        testSLL.print();
        System.out.println();
        System.out.println();



        System.out.println("Creating new DLList!");

        DLListSwap testDLL = new DLListSwap();

        System.out.println("Adding integers to DLL instance...");
        System.out.println("Adding 5 to the list..."); testDLL.add(5);
        System.out.print("Current list: ");
        testDLL.print();
        System.out.println();

        System.out.print("Adding 2 to the list...");
        testDLL.add(2); testDLL.print();

        System.out.print("Swapping values 5 and 2...");
        testDLL.swap(5,2);
        testDLL.print();System.out.println();

        System.out.print("Adding 7 to the list...");testDLL.add(7);
        testDLL.print();

        System.out.print("Swapping values 5 and 7...");
        testDLL.swap(5,7);
        testDLL.print();
        System.out.println();

        System.out.print("Adding 4 to the list...");testDLL.add(4);
        testDLL.print();
        System.out.print("Adding 3 to the list...");testDLL.add(3);
        testDLL.print();

        System.out.print("Swapping values 4 and 3...");
        testDLL.swap(4,3);
        testDLL.print();
        System.out.println();

    }
}
