/**
 * Created by Marta on 2017-05-27.
 */
public class MinStack {
    Stack allValues = new Stack(); //creates stack that contains all values added
    Stack minValues = new Stack(); //creates stack that tracks the smallest value in the stack at a given time
    int n; //keeps track of the stack size

    void push(int x){
        allValues.push(x); //add x to stack
        n++;
        if(n==1 || x <= minValues.head.x){ //if there is only one value in stack or added value is less than or equal to the last value that was added, add current value to minValue stack
            minValues.push(x);
            return; //exit
        }
        minValues.push(minValues.head.x); //if added value is greater than last value added, add last value added again to list (this signifies the min value is still last value added)

    }


    int pop(){
        allValues.pop();
        n--;
        return minValues.pop();
    }

    int min() {
        return minValues.head.x;
    } //return top of minValues list, because that is updated to contain the min value in the list at the time

    int size() {
        return n;
    }

    void print(){
        allValues.print();
    }

    class Stack {
        Node head;
        Node tail;
        int n;

        void push(int x) {
            n++;
            Node u = new Node();
            u.x = x;
            if (n == 0) {
                tail = u;
                head = u;
                u.next = null;
            } else {
                u.next = head;
                head = u;
            }
        }

        int pop() {
            if (n==0) return 0;
            int x = head.x;
            head = head.next;
            n--;
            if (n == 0) {
                tail = null;
            }

            return x;
        }

        void print() {
            Node searchNode = head; // used to search through nodes to find swap nodes
            for (int i = 0; i < n; i++) {
                System.out.print(searchNode.x + " | ");
                searchNode = searchNode.next;
            }
            System.out.println();
        }

        class Node {

            int x;
            Node next;
        }
    }


}


