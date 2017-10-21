/**
 * Created by Marta on 2017-05-25.
 */
public class SLListSwap {

    Node head;
    Node tail;
    int n;

    boolean add(int x) {
        Node u = new Node();
        u.x = x;
        if (n == 0) {
            head = u;
        } else {
            tail.next = u;
        }
        tail = u;
        n++;
        return true;
    }

    void swap(int x, int y) {
        if (x == y) return; //this checks if the two inputs are the same, in which case, we exit the method because we do not have a valid input
        if(n<2) return; //this checks that the list size has at least two items in it; otherwise, we leave because there is nothing to swap
        Node store1 = null;  //this creates a dummy Node, which we will use as a pointer Node
        Node initial = head; //this sets the head of the list to the Node initial, which we will use to search through the list
        if (initial.x == x || initial.x == y) { //this is a check to see if the inputs are the head
            if (initial.next.x != y && initial.next.x != x)
                return; //this checks that the adjacent link to x or y is y or x; otherwise, we leave the method
            store1 = initial; //creates new node, store1, that points to initial
            initial = initial.next; //initial points to data found at initial.next
            store1.next = initial.next; //store1.next points to initial.next
            initial.next = store1; //initial.next poitns to store1
            head = initial; //initial is new head, swap is complete
            if (n ==2 ) tail = head.next;
            return;
        }
        for (int i = 1; i < n; i++) {
            if (initial.next.next == tail) { //if swap is being done close to tail
                tail.next = initial.next;
                initial.next = tail;
                tail = initial.next.next; //initial.next.next is new tail, swap is complete
                return;
            }
            if (initial.next.x == x || initial.next.x == y) {
                store1 = initial.next; //store1 points to initial.next
                initial.next = initial.next.next;
                store1.next = initial.next.next;
                initial.next.next = store1; //swap is complete
                return;
            }
            initial = initial.next; //cycle through list to find link
            }

        }
    void print() {
        Node searchNode = head; // used to search through nodes to find swap nodes
        for (int i = 0; i < n; i++) {
            System.out.print(" | " + searchNode.x );
            searchNode = searchNode.next;

        }
        System.out.println();
    }


class Node {
    int x;
    Node next;
    }
}



