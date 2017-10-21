
/**
 * Created by Marta on 2017-08-15.
 * REFLECTION: The hardest part about this question was figuring out that every single binary tree can be turned into
 * a left-leaning tree using AVL single left rotations to any node that contains a right child. Once I figured this out,
 * I realized that if I track the rotations I do to one tree to turn it into a left-leaning tree and save the right child
 * of each node that I rotated, I can find that child in the left-leaning tree and perform a right rotation to get it
 * back to the original tree. I decided to create a stack that kept track of each node u.right whenever I did a rotation on
 * u. Then, when I wanted to transform a left-leaning tree, I could pop the stack, find the node containing the value
 * stored in u.right and do a right rotation on it. This would give me my original tree. To confirm my findings,
 * I did a breadth-search traversal of a tree, T1, and on T2--a different binary search tree that I converted to T1 through
 * a left-leaning tree intermediate. If the breadth-search traversals were the same, I could say that my function works.
 */

import java.util.Stack;
public class A3Q2 {

    public static void main(String[] args) {

        AVLRotations testTree1 = new AVLRotations();

        int[] treeNodes = {6, 4, 2, 10, 18, 5};

        //                  6
        //                /    \
        //               4      10
        //             /   \     \
        //            2     5     18
        //

        for (int i = 0; i < treeNodes.length; i++) {
            testTree1.add(treeNodes[i]);
        }
        AVLRotations testTree1copy = new AVLRotations();
        int[] treeNodesCopy = {6, 4, 2, 10, 18, 5};
        for (int i = 0; i < treeNodesCopy.length; i++) {
            testTree1copy.add(treeNodesCopy[i]);
        }

        AVLRotations testTree2 = new AVLRotations();

        int[] treeNodes2 = {4, 2, 6, 5, 10, 18};

        //                  4
        //                /    \
        //               2      6
        //                     /  \
        //                    5   10
        //                          \
        //                          18

        for (int i = 0; i < treeNodes2.length; i++) {
            testTree2.add(treeNodes2[i]);
        }

        //Stack<Integer> tree1convert = testTree1copy.makeLeftTree();
        System.out.println("Rotations were done for nodes containing the following keys for T2 to convert it to a left-leaning tree.");
        testTree2.makeLeftTree();
        testTree1copy.makeLeftTree();
        testTree2.convertLeftTree(testTree1copy.makeLeftTree());
        System.out.println("The tree T2 was converted to the tree T1 using AVL single rotations.");
        System.out.println("The breadth-first traversal of T1 is: ");
        testTree1.bfTraverse();
        System.out.println("The breadth-first traversal of T2 converted to T1 is: ");
        testTree2.bfTraverse();
        System.out.println("Since the breadth-first traversal of T1 equals the breadth-first traversal of T2, T2 was successfuly converted to T1 using AVL single rotations.");

    }

}
