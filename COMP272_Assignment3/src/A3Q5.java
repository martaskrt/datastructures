/**
 * Created by Marta on 2017-08-15.
 * REFLECTION: To answer this question, I used a depth-search traversal and a stack to keep track of the edges I traversed.
 * Once I added an edge to the stack, I cannot add it again. If I go back to a parent node from the child and the edge
 * was not yet in my stack, I add it to my stack. The best way to implement this was using a stack because the element
 * that was popped off would be the next input for the depth-search traversal; I did not have to use recursion, which
 * could overload my system if my graph was huge. I decided to implement the graph using an hashtable. I did this using
 * a dictionary (each key node would have a value consisting of a list of nodes that were linked to the key node),
 * because get(i) functions run very efficiently.
 */
public class A3Q5 {

    public static void main(String[] args){
        //Create new 16 node graph
        GraphTraversal Graph = new GraphTraversal(16);
        System.out.println("We will traverse the entire graph exactly once in both directions starting at 'l'.");
        Graph.addEdge('a','b');
        Graph.addEdge('a','e');
        Graph.addEdge('a','f');
        Graph.addEdge('b','a');
        Graph.addEdge('b','c');
        Graph.addEdge('c','b');
        Graph.addEdge('c','d');
        Graph.addEdge('c','f');
        Graph.addEdge('d','c');
        Graph.addEdge('d','g');
        Graph.addEdge('e','a');
        Graph.addEdge('e','i');
        Graph.addEdge('f','a');
        Graph.addEdge('f','c');
        Graph.addEdge('f','j');
        Graph.addEdge('g','d');
        Graph.addEdge('g','h');
        Graph.addEdge('g','j');
        Graph.addEdge('g','k');
        Graph.addEdge('h','g');
        Graph.addEdge('h','o');
        Graph.addEdge('i','e');
        Graph.addEdge('i','j');
        Graph.addEdge('i','m');
        Graph.addEdge('i','n');
        Graph.addEdge('j','f');
        Graph.addEdge('j','g');
        Graph.addEdge('j','i');
        Graph.addEdge('k','g');
        Graph.addEdge('k','o');
        Graph.addEdge('l','p');
        Graph.addEdge('m','i');
        Graph.addEdge('n','o');
        Graph.addEdge('n','i');
        Graph.addEdge('o','h');
        Graph.addEdge('o','k');
        Graph.addEdge('o','n');
        Graph.addEdge('o','p');
        Graph.addEdge('p','o');
        Graph.addEdge('p','l');

        Graph.traverseEdges('l');
    }
}


