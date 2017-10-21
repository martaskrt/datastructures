/**
 * Created by Marta on 2017-06-03.
 */
/** Question 1b: The running time of the push method I implement is O(1). This is because each new value is added to the
 end of the queue. The time for adding to the end of the queue is constant; it is not dependent on the number of values
 already in the queue. The pop method, on the other hand, has a running time of n-1, or O(n). This is because I move all
 of the values from one queue into a second queue except for the first value. Thus, the running time is dependent on the
 number of values in the queue minus 1. As n gets larger, the difference between n and n minus 1 becomes less significant,
 and so the running time is largely dependent on n, giving O(n).

 Question 1b REFLECTION: To answer this question, I implemented the interface Queue using the class LinkedList. This is
 a FIFO queue. This means that if I push a value, it will add to the beginning of the queue, and if I pop the
 queue, it will remove the very first value that I pushed. To create a last-in-first-out (FIFO) queue (a stack),
 I need the help of a second queue. I move all of the values from the first queue into the second queue except for the
 last value in the first queue. I then empty the first queue, which deletes the first value in the queue. I then rename
 the second queue as the first queue. This returns the first queue as the original queue minus the first value,
 successfully implementing the stack concept. At first, I didn't understand what this question was asking for. However,
 I quickly realized that it would be hard to implement a LIFO queue with a FIFO queue so I went off the idea of using
 two queues. I played around with the values and used the print function I created, which is an implementation of the
 iterator interface, to check my stack. I finally achieved my answer after debugging the code by the method explained
 above.*/


public class Question1b {
    public static void main(String[] args) {

        System.out.println("Instancing a new stack...");
        TwoQueueStack<Integer> testCase = new TwoQueueStack<Integer>();
        System.out.println("Adding value: " + testCase.push(12) + " to the stack...");
        System.out.println("Adding value: " + testCase.push(2) + " to the stack...");
        System.out.println("Adding value: " + testCase.push(4) + " to the stack...");
        System.out.println("Adding value: " + testCase.push(16) + " to the stack...");
        System.out.print("Current Values in stack: ");
        testCase.print();
        System.out.println("Popping value: " + testCase.pop() + " from the stack...");
        System.out.print("Current Values in stack: ");
        testCase.print();
    }
}
