/**
 * Created by Marta Skreta on 2017-07-14.
 *
 * REFLECTION: When I sat down to answer this question the first time, it was deceivingly easy: I simply had to compare
 * each node to its children; u.left was less than u and u.right was greater than u for all nodes u in the binary tree,
 * then I could return true. However, what I did not immediately realize, was that I had to compare each node u to all
 * the nodes before it, not just its parent. u had to be less than all the nodes from the root to u.parent in the left
 * subtree and u had to be greater than all the nodes from the root to u.parent in the right subtree. I implemented the following
 * logical solution: in the case of the root, it cannot be less than the minimum value in the entire binary tree (which
 * should be the leftmost node) or greater than the maximum value in the entire binary tree (which should be the rightmost
 * node). Moving to root.left, the value still cannot be less than the minimum value in the binary tree. As well, it cannot
 * be greater than the root, because otherwise it would belong to the right subtree. Moving to root.right,
 * the value still cannot be greater than the maximum value in the tree. It also cannot be less than the root, because
 * it would belong to the left subtree. By decrementing the root value by 1 for each iteration of the binary
 * search tree algorithm, we keep track of the maximum value allowed in each left subtree, and by incrementing the root value
 * by 1 for each iteration, we keep track of the minimum value allowed in each right subtree. These values are updated
 * in min and max variables.
 */

public class A2Q2 {
    public static void main(String[] args) {

        Q2SearchTree searchTree = new Q2SearchTree(6);
        searchTree.root.parent = null;

        searchTree.root.left = new Q2SearchTree.Node(4);
        searchTree.root.left.parent = searchTree.root;

        searchTree.root.right = new Q2SearchTree.Node(7);
        searchTree.root.right.parent = searchTree.root;

        searchTree.root.left.left = new Q2SearchTree.Node(2);
        searchTree.root.left.left.parent = searchTree.root.left;

        searchTree.root.left.right = new Q2SearchTree.Node(5);
        searchTree.root.left.right.parent = searchTree.root.left;

        searchTree.root.right.right = new Q2SearchTree.Node(8);
        searchTree.root.right.right.parent = searchTree.root.right;


        //                  6
        //                /    \
        //               4      7
        //             /   \     \
        //            2     5     8


        System.out.println("Binary tree called searchTree is: " + searchTree.search()); //this output returns true because all the nodes follow the binary search tree property


        Q2SearchTree searchTree2 = new Q2SearchTree(6);
        searchTree2.root.parent = null;

        searchTree2.root.left = new Q2SearchTree.Node(4);
        searchTree2.root.left.parent = searchTree2.root;

        searchTree2.root.right = new Q2SearchTree.Node(7);
        searchTree2.root.right.parent = searchTree2.root;

        searchTree2.root.left.left = new Q2SearchTree.Node(2);
        searchTree2.root.left.left.parent = searchTree2.root.left;

        searchTree2.root.left.right = new Q2SearchTree.Node(9);
        searchTree2.root.left.right.parent = searchTree.root.left;

        searchTree2.root.right.right = new Q2SearchTree.Node(8);
        searchTree2.root.right.right.parent = searchTree2.root.right;


        //                  6
        //                /    \
        //               4      7
        //             /   \     \
        //            2     9     8


        System.out.println("Binary tree called searchTree2 is: " + searchTree2.search()); //this output returns false because the node 9 validates the binary search tree property;
        //although 9 is larger than 4, it is smaller than 6, and so it should be in the subtree to the right of 6;

    }
}
