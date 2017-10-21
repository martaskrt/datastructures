/**
 * Created by Marta Skreta on 2017-07-09.*/

public class Q2SearchTree {

    Node root;
    int n;

    Q2SearchTree(int rootKey) {root = new Node(rootKey);}

    boolean search() {
        int min = Integer.MIN_VALUE; //this sets the variable min to the smallest value in the the binary tree
        int max = Integer.MAX_VALUE; //this sets the variable max to the largest value in the the binary tree
        return search(root, min, max);
    }

    boolean search(Node u, int smallestVal, int largestVal) {

        if (u == null) { //if the tree is empty, we do not violate the binary search tree property; return true
            return true;
        }

        if ((u.x < smallestVal) || (u.x > largestVal)) { //if u is less than the minimum value in the subtree or greater than the maximum value in the subtree, the tree violates the binary tree search property
            return false;
        }

        return (search(u.left, smallestVal, u.x) && search(u.right, u.x, largestVal));
        //moving into the left subtree, we keep the min value the same because that is the smallest value in the tree;
        //the max value is u.x; u.left cannot be greater than u.x because then it should belong in the right subtree
        //moving into the right subtree, we keep the max value the same because that is the largest value in the tree;
        //the max value is u.x; u.left cannot be less than u.x because then it should belong in the left subtree
    }

    static class Node {
        int x;
        Node left;
        Node right;
        Node parent;

        Node(int x) {
            this.x = x;
            right = null;
            left = null;
        }
    }


}




