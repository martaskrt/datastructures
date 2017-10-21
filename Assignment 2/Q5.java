/**
 * Created by Marta Skreta on 2017-08-11.
 *
 *REFLECTION: This question was very similar to question one. However, instead of having a node that kept track of current
 * node I was visiting, I implemented a counter. When I visited a node in each traversal, I increased the counter by 1,
 * depending on the type of traversal I was implementing. For example, in the post order traversal, when I visited the left
 * most node in the tree, I incremented the counter by one. I incremented the counter by one again when I visited the
 * nodes sibling. The easiest way to implement this was using recursion because I visited each node exactly once. My
 * code recursively visits each left subtree and right subtree. The hardest part was figuring out where in the code I had
 * to increase the counter to indicate my position in the tree. This was the only thing that varied in between the traversals.
 * For post order, I incremented the counter first when I visited the left subtree, then when I visited its parent, then
 * when I visited its right subtree. For in order, first I incremented then counter when I visited the left subtree, then
 * the right subtree, then the parent. For preorder, I incremented the counter first when I saw the parent, then the
 * left subtree, and lastly the right. Ultimately, I think my function runs very smoothly and efficiently; it runs
 * in O(n) time, like my function in Question 1.
 */
public class Q5 {

    public static void main(String[] args){

        ExtendedBT testTree = new ExtendedBT();

        int[] treeNodes = {6,4,2,7,8,16,23,3,1,9};

        //                  6
        //                /    \
        //               5      7
        //             /         \
        //            2           8
        //          /   \           \
        //         1     3           16
        //                          /  \
        //                         9   23

        for (int i = 0; i < treeNodes.length; i++){
            testTree.add(treeNodes[i]);
        }

        testTree.preorderNumber();
        testTree.postorderNumber();
        testTree.inorderNumber();
        System.out.println("The pre-order numbers are:");
        System.out.println("Node 6: " + testTree.root.preordernumber);
        System.out.println("Node 4: " + testTree.root.left.preordernumber);
        System.out.println("Node 2: " + testTree.root.left.left.preordernumber);
        System.out.println("Node 1: " + testTree.root.left.left.left.preordernumber);
        System.out.println("Node 3: " + testTree.root.left.left.right.preordernumber);
        System.out.println("Node 7: " + testTree.root.right.preordernumber);
        System.out.println("Node 8: " + testTree.root.right.right.preordernumber);
        System.out.println("Node 16: " + testTree.root.right.right.right.preordernumber);
        System.out.println("Node 9: " + testTree.root.right.right.right.left.preordernumber);
        System.out.println("Node 23: " + testTree.root.right.right.right.right.preordernumber);

        System.out.println("The post-order numbers are:");
        System.out.println("Node 6: " + testTree.root.postordernumber);
        System.out.println("Node 4: " + testTree.root.left.postordernumber);
        System.out.println("Node 2: " + testTree.root.left.left.postordernumber);
        System.out.println("Node 1: " + testTree.root.left.left.left.postordernumber);
        System.out.println("Node 3: " + testTree.root.left.left.right.postordernumber);
        System.out.println("Node 7: " + testTree.root.right.postordernumber);
        System.out.println("Node 8: " + testTree.root.right.right.postordernumber);
        System.out.println("Node 16: " + testTree.root.right.right.right.postordernumber);
        System.out.println("Node 9: " + testTree.root.right.right.right.left.postordernumber);
        System.out.println("Node 23: " + testTree.root.right.right.right.right.postordernumber);

        System.out.println("The in-order numbers are:");
        System.out.println("Node 6: " + testTree.root.inordernumber);
        System.out.println("Node 4: " + testTree.root.left.inordernumber);
        System.out.println("Node 2: " + testTree.root.left.left.inordernumber);
        System.out.println("Node 1: " + testTree.root.left.left.left.inordernumber);
        System.out.println("Node 3: " + testTree.root.left.left.right.inordernumber);
        System.out.println("Node 7: " + testTree.root.right.inordernumber);
        System.out.println("Node 8: " + testTree.root.right.right.inordernumber);
        System.out.println("Node 16: " + testTree.root.right.right.right.inordernumber);
        System.out.println("Node 9: " + testTree.root.right.right.right.left.inordernumber);
        System.out.println("Node 23: " + testTree.root.right.right.right.right.inordernumber);

    }
}
class ExtendedBT extends Q1BT{

    int n;
    Node root;
    int nodeCounter; //keeps track of the position of visited nodes


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
    } //adds nodes into the tree according to the binary search tree theorem


    void inorderNumber(){
        inorderNumber(this.root);
    }
    void inorderNumber(Node u){
        if(u == null){
            return; //the tree is empty; exit function
        }

        if(u == this.root){
            this.nodeCounter = 1; //start the counter at 1 to account for visiting the first position
        }
        inorderNumber(u.left); //recurse through left subtree
        u.inordernumber = this.nodeCounter++; //increment counter by 1
        inorderNumber(u.right); //recurse through right subtree
    }

    void postorderNumber(){
        postorderNumber(this.root);
    }
    void postorderNumber(Node u){
        if(u == null){
            return; //the tree is empty; exit function
        }

        if(u == this.root){
            this.nodeCounter = 1; //start the counter at 1 to account for visiting the first position
        }
        postorderNumber(u.left); //recurse through left subtree
        postorderNumber(u.right); //recurse through right subtree
        u.postordernumber = this.nodeCounter++; //increment counter by 1
    }

    void preorderNumber(){
        preorderNumber(this.root);
    }
    void preorderNumber(Node u){
        if(u == null){
            return; //the tree is empty; exit function
        }

        if(u == this.root){
            this.nodeCounter = 1; //start the counter at 1 to account for visiting the first position
        }

        u.preordernumber = this.nodeCounter++; //increment counter by 1
        preorderNumber(u.left); //recurse through left subtree
        preorderNumber(u.right); //recurse through right subtree
    }

    public static class Node {

        Node left;
        Node right;
        Node parent;
        int key;
        Node(int key){
            right = left = null;
            this.key = key;
        }
        int preordernumber;
        int postordernumber;
        int inordernumber;
    }

}
