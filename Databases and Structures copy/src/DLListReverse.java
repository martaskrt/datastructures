/**
 * Created by Marta on 2017-05-26.
 */
public class DLListReverse {

    int n;
    DLNode dummy;

    DLListReverse() {
        dummy = new DLNode();
        dummy.next = dummy;
        dummy.prev = dummy;
        n = 0;
    }

    void print() {
        DLNode searchNode = dummy.next;
        System.out.println();
        for (int i = 1; i <= n; i++) {
            System.out.print(searchNode.x + " | ");
            searchNode = searchNode.next;

        }
        System.out.println();
    }

    void add(int x) {
        DLNode last = dummy.prev;
        DLNode u = new DLNode();
        u.x = x;
        u.next = dummy;
        u.prev = last;
        dummy.prev = u;
        last.next = u;
        n++;
    }

    void reverse(){
        DLNode front = dummy.next; //creates a variable, front, that points to dummy.next (front of the list)
        DLNode back = dummy.prev; //creates a variable, back, that points to dummy.prev (back of the list)

        for(int i = 0; i < n/2; i++) { //only n/2 steps are necessary because we swap n/2 values
            DLNode u = new DLNode(); //creates a new variable that will act as a placeholder node to hold the value I want to switch at list front
            u.x = front.x; //u contains the same value as front
            DLNode z = new DLNode(); //creates a new variable that will act as a placeholder node to hold the value I want to switch at list back
            z.x = back.x; //z contains the same value as back
            front.x = z.x; //the front value becomes z value
            back.x = u.x; //the back value becomes u value; swap is complete
            front = dummy.next.next; //front is moved one node forward
            back = dummy.prev.prev; //back is moved one node backward

        }}



    class DLNode {
        int x;
        DLNode prev, next;
    }


}






