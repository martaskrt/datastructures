/**
 * Created by Marta on 2017-08-16.
 * REFLECTION: To answer this question, I took the concept of the remove() method from the textbook where removing the
 * root would be followed by merging the left and right subtrees of the root. As soon as I saw the expected run time of the
 * method I knew it would be best to utilize the merge method. The only tricky part I found was how to incorporate the
 * merge method. I knew for calls to remove the node, I could just call the regular remove method. However, for other nodes
 * I would have to update their parents references and nodes around. So I meddled around with the references until I came
 * up with a workable solution. To test my removal method, I utilized a breadth-first traversal of the tree, to make sure
 * the node I specified was no longer in the tree.
 */
public class A3Q7 {

    public static void main(String[] args) {

        MeldableHeap binaryTree1 = new MeldableHeap(7);

        int[] treeNodes = {6, 4, 2, 10, 18, 5};

        //                  6
        //                /    \
        //               4      10
        //             /   \     \
        //            2     5     18
        //
        for (int node : treeNodes) {
            binaryTree1.add(node);
        }
        binaryTree1.bfTraverse();
        System.out.println(binaryTree1.remove(binaryTree1.r.left).key);
        binaryTree1.bfTraverse();
    }
}


