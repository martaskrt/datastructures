import java.util.Comparator;

import java.util.*;
import java.lang.*;
/**
 * Created by Marta on 2017-08-15.
 */
public class MeldableHeap {

    MeldableHeap(int x){
        r = new Node(x);
    }

    Node r; int n;

    Node merge(Node h1, Node h2){
        if (h1 == null) return h2;
        if (h2 == null) return h1;
        if (h2.key < h1.key) return(merge(h2, h1));
        Random rn = new Random();
        if (rn.nextBoolean()){
            h1.left = merge(h1.left, h2);
            h1.left.parent = h1;
        }
        else{
            h1.right = merge(h1.right, h2);
            h1.right.parent = h1;
        }
        return h1;

    }


    Node remove(Node u){
        if (u == r){
            r = merge (r.left, r.right); //merge left and right subtrees of root
        }
        if (u.parent.left  == u){//If node is left child, make reference to it null
            u.parent.left = null;
        }
        else {
            u.parent.right = null;//If node is right child, make reference to it null
        }
        u.parent = null; //make reference to parent null for merge
        r = merge(r, u.left); r = merge(r, u.right); //merge left and right children to root
        r.parent = null; n--; // make root parent null and decrease the value of n; the value of n is the number of elements
        // currently stored in the tree
        return u;
    }

    void bfTraverse() {
        Queue<Node> q = new LinkedList<Node>();
        if (r != null) q.add(r);
        while (!q.isEmpty()) {
            Node u = q.remove();
            System.out.print(u.key + " | ");
            if (u.left != null) q.add(u.left);
            if (u.right != null) q.add(u.right);
        }
        System.out.println();
    }

    void add(int x){
        //Method for adding new elements; merges element with root
        Node newAddition = new Node(x);
        r = merge(newAddition,r);
        r.parent = null;
        n++;
    }

    public static class Node {
        Node left;
        Node right;
        Node parent;
        int key;

        Node(int key) {
            this.right = this.left = null;
            this.key = key;
        }
    }

}
