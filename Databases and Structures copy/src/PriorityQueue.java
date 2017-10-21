/**
 * Created by Marta on 2017-06-03.
 */
public class PriorityQueue {

    Node head;
    Node tail;
    int n; //keeps track of queue size

    void add(int x){
        Node u = new Node();
        u.x = x;
        if (n==0){
            head = u; tail = u; u.next = null; n++; //if there are no values in the queue and a new value is added, it becomes the head and the tail; n is incremented by 1
        }
        else {
            tail.next = u; //if the queue already contains values, a new value is added to the end of the list
            tail = u; //the new value becomes the queue tail
            n++; //n increases by 1
        }
    }

    int deleteMin() {
        if (n == 0) return 0;

        int minValue = head.x; //the variable minValue is set to contain the value of head and will be used to find the smallest value
        Node minValueRef = head; //the head node is stored in a new node, which will store minValue
        Node searchNode = head;//this node will be used to search through the entire queue
        for(int i = 1; i < n; i++) {
            if (searchNode.next.x < minValue) { //this compares minValue with the value proceeding the current node
                minValue = searchNode.next.x; //if the next node's value is smaller than the current minValue, minValue will be swapped to contained tne new value
                minValueRef = searchNode; //if the next node's value is smaller than the current minValue, minValueRef will be swapped to reference the new node
            }
            searchNode = searchNode.next; //move on to the next value
        }
        if (minValue == head.x) {
            head = head.next; //if the smallest value is the head value, we delete the head by making head.next the new head
            n--; //decrement queue size by 1
            return minValue;
        }
        else{
            minValueRef.next = minValueRef.next.next; //the node that points to the node contain minValue is set to point to the node following minValue, deleting minValue
            n--; //decrement queue size by 1
            return minValue;
        }
        }




    int size(){
        return n; //returns length of queue, which is updated with each add(x) or deleteMin() method
    }

    void print() {
        Node searchNode = head; // used to search through nodes to find swap nodes
        for (int i = 0; i < n; i++) {
            System.out.print(searchNode.x + " | ");
            searchNode = searchNode.next;
        }
        System.out.println();
    }

    class Node{
        int x;
        Node next;}



}
