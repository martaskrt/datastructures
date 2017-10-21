/**
 * Created by Marta on 2017-05-28.
 */
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;
public class TwoQueueStack<T> {

    Queue<T> queueOne = new LinkedList<T>(); //FIFO queue that will contain all values added
    Queue<T> queueTwo = new LinkedList<T>(); //FIFO queue that will be used to hold all queueOne values except for first

    T push(T x) {
        queueOne.add(x); //add value x to queueOne
        return x;
    }

    T pop() {
        while(queueOne.size() > 1) {
            queueTwo.add(queueOne.remove()); //add all values from queueOne to queueTwo and remove those values from queueOne; stop when queueOne has only one value in it
        }
        T pop = queueOne.remove(); //empty queueOne (deletes first value)
        Queue<T> newQueue = queueOne;
        queueOne = queueTwo; //rename queueTwo as queueOne--now queueOne contains all original values except for first value
        queueTwo = newQueue;
        return pop;
    }

    void print() {
        Iterator cycle = queueOne.iterator(); // used to search through nodes to find swap nodes
        while(cycle.hasNext()) {
            System.out.print(cycle.next() + " | ");
        }
        System.out.println();
    }

}
