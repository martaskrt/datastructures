/**
 * Created by Marta on 2017-05-26.
 */
public class DLListSwap {

    int n;
    DLNode dummy;

    DLListSwap() {
        dummy = new DLNode();
        dummy.next = dummy;
        dummy.prev = dummy;
        n = 0;
    }

    void print() {
        DLNode searchNode = dummy.next; // used to search through nodes
        for (int i = 0; i < n; i++) {
            System.out.print(" | " + searchNode.x );
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

    void swap(int x, int y){ //input two adjacent values that are to be swapped
        DLNode search = dummy;
        for(int i = 0; i < n; i++){
            if(search.next.x == x || search.next.x == y){ //checks that next value is x or y
                DLNode u = search.next; //u points to search.next
                DLNode z = search.next.next; //z points to search.next.next
                u.next = z.next; //switch links so that z comes before u
                z.next.prev = u;
                z.prev = search;
                search.next = z;
                u.prev = z;
                z.next = u; //swap is complete
                return;
            }
            search = search.next;
        }
    }

    class DLNode {
        int x;
        DLNode prev, next;
    }
}


