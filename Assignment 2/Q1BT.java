/**
 *Created by Marta Skreta on 2017-08-11.
 *
 * Question 1: All of the traversal functions run in O(n) time. This is because each traversal visits each node exactly
 * once through recursion. Once the node has been visited, it is never visited again.
 *
 REFLECTION: When I began to answer this question, I had to think of whether it would be better to traverse the tree
 recursively or use iterations (i.e. depending on what node I am on, I go to the next node using node.left or node.right).
 Ultimately, I decided to use a recursive approach because this way, I only visit each node once. If I used iterations,
 I could potentially visit nodes more than once, which would make analyzing the running time much harder. It would also
 make the running time longer as I could go through nodes multiple times. Implementing the recursive algorithms was simple;
 I went through each left subtree and right subtree recursively, but depending on the type of traversal, I changed the
 order in which I visited the nodes. The hardest part about this question was to figure out how to return the next node
 if I was present at the target Node, x. I decided to use a boolean indicator to tell me if I was at the target node (true)
 or not (false). If the indicator was set to true, a placeholder variable would be set to the proceeding node in the next recursion.
 The indicator variable would then be reset to false, so the rest of the tree could be traversed and the indicator would
 never be set to true again.
 */

import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;
import java.util.*;

public class Q1BT {


    public static void main(String[] args) {

        Traversal testTree = new Traversal();

        int[] treeNodes = {6, 4, 2, 10, 12, 17, 23, 5, 3, 1, 14};

        //                  6
        //                /    \
        //               4      10
        //             /   \     \
        //            2     5     12
        //          /   \           \
        //         1     3           17
        //                          /  \
        //                         14   23

        for (int i = 0; i < treeNodes.length; i++) {
            testTree.add(treeNodes[i]);
        }

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a number that you see in the above tree as a single integer (e.g. 1). If you can't see the tree, input one of the following numbers: 6, 4, 2, 10, 12, 17, 23, 5, 3, 1, 14 ");
        int n = reader.nextInt();
        if (testTree.preorderNext(n) == null) {
            System.out.println("You are at the last node for pre-order traversal.");
        } else {
            System.out.println("The next node in a preorderTraversal is: " + testTree.preorderNext(n).key);  // Reading from System.in
        }
        if (testTree.postorderNext(n) == null) {
            System.out.println("You are at the last node for post-order traversal.");
        } else {
            System.out.println("The next node in a postorderTraversal is: " + testTree.postorderNext(n).key);
        }
        if (testTree.inorderNext(n) == null) {
            System.out.println("You are at the last node for in-order traversal.");
        } else {
            System.out.println("The next node in an inorderTraversal is: " + testTree.inorderNext(n).key);
        }
        //If my input is 3, the output will be:
        //preorderTraversal = 5; postorderTraversal = 2; inorderTraversal = 4;
        //If my input is 4, the output will be:
        //preorderTraversal = 2; postorderTraversal = 14; inorderTraversal = 5;
        //If my input is 23, the output will be:
        //preorderTraversal = null; postorderTraversal = null; inorderTraversal = null;
    }
}
    class Traversal {

        int n;
        Node root;
        Node nextNode;
        boolean target;

        boolean add(int x) {
            if (n == 0) {
                root = new Node(x);
                n++;
                return true;
            }
            Node searchNode = this.root;
            Node finalNode = searchNode;
            while (searchNode != null) {
                finalNode = searchNode;
                if (searchNode.key > x) searchNode = searchNode.left;
                else if (searchNode.key < x) searchNode = searchNode.right;
                else return false;
            }
            if (x < finalNode.key) {
                finalNode.left = new Node(x);
                finalNode.left.parent = finalNode;
                n++;
                return true;
            } else {
                finalNode.right = new Node(x);
                finalNode.right.parent = finalNode;
                n++;
                return true;
            }
        }


        Node inorderNext(int x) {
            return inorderNext(x, this.root); //start traversal at root of tree
        }

        Node inorderNext(int x, Node u) {

            if (u == null) {
                return null; //the tree is empty; exit function
            }

            if (u == this.root) {
                nextNode = null; //reset nextNode to empty; it is an instance variable and so it might contain another node from another traversal
                target = false; //reset target to false
            }

            inorderNext(x, u.left); //recurse left subtree

            if (target == true) { //if we have found Node, x
                nextNode = u; //set nextNode to the node following x; this happens after target has been set to true below
                target = false; //reset target to false so we never change nextNode
            }

            if (u.key == x) {
                target = true; //we have found the node of interest; set boolean to true; go to the
                // following node by recursion and set nextNode to that node
            }

            inorderNext(x, u.right); //recurse right subtree

            return nextNode; //this node has been set to the node following x
        }

        Node postorderNext(int x) {
            return postorderNext(x, this.root); //start traversal at root of tree
        }

        Node postorderNext(int x, Node u) {

            if (u == null) {
                return null; //the tree is empty; exit function
            }

            if (u == this.root) {
                nextNode = null;//reset nextNode to empty; it is an instance variable and so it might contain another node from another traversal
                target = false; //reset target to false
            }

            postorderNext(x, u.left); //recurse left subtree

            postorderNext(x, u.right); //recurse right subtree

            if (target == true) {
                nextNode = u;//set nextNode to the node following x; this happens after target has been set to true below
                target = false; //reset target to false
            }

            if (u.key == x) {
                target = true; //we have found the node of interest; set boolean to true; go to the
                // following node by recursion and set nextNode to that node
            }

            return nextNode; //this node has been set to the node following x
        }

        Node preorderNext(int x) {
            return preorderNext(x, this.root); //start traversal at root of tree
        }

        Node preorderNext(int x, Node u) {

            if (u == null) {
                return null; //the tree is empty; exit function
            }

            if (u == this.root) {
                nextNode = null;//reset nextNode to empty; it is an instance variable and so it might contain another node from another traversal
                target = false; //reset target to false
            }

            if (target == true) {
                nextNode = u;//reset nextNode to empty; it is an instance variable and so it might contain another node from another traversal
                target = false; //reset target to false
            }

            if (u.key == x) {
                target = true; //we have found the node of interest; set boolean to true; go to the
                // following node by recursion and set nextNode to that node
            }
            preorderNext(x, u.left);//recurse left subtree

            preorderNext(x, u.right); //recurse right subtree

            return nextNode; //this node has been set to the node following x
        }

        public static class Node {

            Node left;
            Node right;
            Node parent;
            int key;

            Node(int key) {
                right = left = null;
                this.key = key;
            }
        }
    }








