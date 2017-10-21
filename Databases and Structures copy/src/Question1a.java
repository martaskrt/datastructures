/**
 * Created by Marta on 2017-06-03.
 */

/** Question 1a: In the priority queue interface, the add(x) method adds the value x to the queue. deleteMin() removes
 the smallest value from the queue, while size() returns the length of the queue. The running time for the add(x) method
 I implemented is O(1) because each new value is added onto the end of the list. The time required to do this is not
 dependent on the number of items already in the list; the value will be added in constant time. The running time of
 my deleteMin() method is O(n). The method works by storing the value of the head in a temporary node and comparing all
 other values in the list to the node. The node is replaced with a value if it is less than the current value that it
 holds. Because I am comparing all values in the queue with the value in the node, the running time is dependent on the
 number of values in the queue.

 Question 1a REFLECTION: My deleteMin() method worked perfectly when I added four integers to my queue and the min value
 was the second or third digit. However, my code did not work when my minimum value was the head. This is because I set
 the node value to the head and compared the rest of the nodes to the head node. My code involved comparing head to
 head.next, and if head.next was the smallest value, then I set head.next to head.next.next. This deleted the node
 head.next. However, if the head node was the minimum value, setting head.next to head.next.next would not delete
 the minimum value because I needed to point to the head, not head.next. I fixed this by adding an instance where if the
 head had the smallest value, then I would set head to head.next. This error was easy to catch. I drew out the instance
 of the head node containing the minimum value on paper and I quickly realized that it would be impossible to delete
 the head node because head.next can never point to the head. I simply added in an instance at the end of my deleteMin()
 method, after I had compared all the values in my queue, that deleted the head if it contained the minimum value by
 making the new head to be head.next.*/


public class Question1a {

    public static void main(String[] args) {

        System.out.println("Instancing a new SLList Priority queue...");

        PriorityQueue testQueue = new PriorityQueue();

        System.out.println("Adding 5 to priority queue...");
        testQueue.add(5);
        System.out.println("Adding 7 to priority queue...");
        testQueue.add(7);
        System.out.println("Adding 2 to priority queue...");
        testQueue.add(2);
        System.out.println("Adding 10 to priority queue...");
        testQueue.add(10);
        System.out.print("The priority queue is currently: ");
        testQueue.print();
        System.out.print("The size of the priority queue is currently: " + testQueue.size());
        System.out.println();
        System.out.println("Deleting minimum value from queue...");
        System.out.println("Minimum value deleted: " + testQueue.deleteMin());
        System.out.print("After deleting the minimum value, the priority queue is: ");
        testQueue.print();
        System.out.print("The size of the priority queue is currently: " + testQueue.size());
        System.out.println();
        System.out.println("Deleting minimum value from queue...");
        System.out.println("Minimum value deleted: " + testQueue.deleteMin());
        System.out.print("After deleting the minimum value, the priority queue is: ");
        testQueue.print();
        System.out.print("The size of the priority queue is currently: " + testQueue.size());
        System.out.println();
        System.out.println("Deleting minimum value from queue...");
        System.out.println("Minimum value deleted: " + testQueue.deleteMin());
        System.out.print("After deleting the minimum value, the priority queue is: ");
        testQueue.print();
        System.out.println("Deleting minimum value from queue...");
        System.out.println("Minimum value deleted: " + testQueue.deleteMin());
        System.out.print("After deleting the minimum value, the priority queue is: ");
        testQueue.print();
        System.out.println("Adding 5,6,7,8 to the priority queue!");
        testQueue.add(5);testQueue.add(6);testQueue.add(7);testQueue.add(8);
        testQueue.print();



    }
}
