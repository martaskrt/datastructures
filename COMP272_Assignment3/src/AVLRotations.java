import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Arrays;

/**
 * Created by Marta on 2017-08-15.
 */
public class AVLRotations {
    int n;
    Node root;
    Stack<Integer> moves = new Stack();

    Stack<Integer> makeLeftTree() { //convert any binary tree to left-leaning tree using single rotations
        int treeLean = 0; //keeps track of whether there are any right children of nodes; a value of 1 indicates there are no right children
        Node r = root; //start at root of tree
        while (treeLean == 0) {
            if (r.right != null) { //while there is a filled node to the right of the root
                moves.push(r.right.key); //add root.right.x to stack; we will find this value later to rotate left to get back to original tree
                rotateLeft(r); //rotate root left
                r = root;
            } else if (r.left != null){
                r = r.left;
            } else { treeLean = 1; } //the tree is left-leaning if treeLean = 1;
            
        }
        return moves;
    }
    
    void convertLeftTree(Stack<Integer> i){
        while(!i.isEmpty()){
            int s = i.pop(); //this is the last value we performed a left rotation on its parent to convert tree to left-leaning
            System.out.println(s);
            rotateRight(find(s)); //rotate the node containing value s right
            }
        }

    void rotateLeft(Node u){
        Node w = u.right;
        w.parent = u.parent;
        if (w.parent != null){
            if(u == w.parent.left){
                w.parent.left = w;
            } else { w.parent.right = w;}
        }
        u.right = w.left;
        if (u.right != null) {
            u.right.parent = u;
        }
        u.parent = w;
        w.left = u;
        if (u == root) { root = w; root.parent = null; }
    }
    void rotateRight(Node u){
        Node w = u.left;
        w.parent = u.parent;
        if(w.parent != null){
            if(u == w.parent.left){
                w.parent.left = w;
            } else { w.parent.right = w;}
        }
        u.left = w.right;
        if (u.left != null) {
            u.left.parent = u;
        }
        u.parent = w;
        w.right = u;
        if (u == root) { root = w; root.parent = null; }
    }

    void bfTraverse() { //used to confirm that two trees are the same
        Queue<Node> q = new LinkedList<Node>();
        if (root != null) q.add(root);
        while (!q.isEmpty()) {
            Node u = q.remove();
            System.out.print(u.key + " | ");
            if (u.left != null) q.add(u.left);
            if (u.right != null) q.add(u.right);
        }
        System.out.println();
    }

    boolean add(int x) { //add new node to tree containing value x

        if (n == 0) {
            root = new Node(x);
            n++;
            return true;
        }
        Node u = find(x);
        if (u.key == x) return false;
        if (x > u.key) {
            u.right = new Node(x);
            u.right.parent = u;
            n++;
            return true;
        }
        else {
            u.left = new Node(x);
            u.left.parent = u;
            n++;
            return true;
        }
    }
    Node find(int x){
        if (n == 0) return null;
        if(root.key == x) return root;

        Node u = root;
        Node s = root;

        while (s != null){
            if(s.key == x) return s; //x is already in tree
            u = s;
            if (x < s.key) s = s.left;
            else s = s.right;
        }
        return u;
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



