/**
 * Created by Marta on 2017-08-16.
 */

import java.awt.*;
import java.util.*;
import java.util.List;

public class GraphTraversal {

        int n;
        Dictionary adj; //interface dictionary

        GraphTraversal(int n) {
            this.n = n;
            adj = new Hashtable(); //implement hashtable data structure
        }

        void addEdge(char i, char j) {
            if (adj.get(i) == null) { //if there is no value for key
                adj.put(i, new ArrayList());
                ArrayList temp = (ArrayList) adj.get(i); //create a new list at key
                temp.add(j);
            }
            else {
                ArrayList temp = (ArrayList) adj.get(i);
                temp.add(j);
            }
        }

        ArrayList outEdges(char i) {
            return (ArrayList) adj.get(i);
        }

        void traverseEdges(char z) { //depth first search

            ArrayList<String> edgeList = new ArrayList<String>(); //keeps track of visited edges
            Stack<Character> visited = new Stack<Character>(); //keeps track of visited nodes in traversal

            visited.push(z);

            while (visited.isEmpty() != true) {
                char i = visited.pop();
                for (int j = 0; j < outEdges(i).size();j++) {
                    char to = (Character) outEdges(i).get(j);
                    String edgeVisited = Character.toString(i) + " --> " + to;
                    outEdges(i).get(j);
                    if (edgeList.contains(edgeVisited) != true) {
                        edgeList.add(edgeVisited); //if we haven't already visited the edge, add it to array
                        visited.push(to);
                    }
                }
            }

            Iterator graphTraverse = edgeList.iterator();
            int counter = 0;
            System.out.println("Our edge traversal list contains the following edges:");
            while (graphTraverse.hasNext()){
                System.out.println(graphTraverse.next());
                counter++;
            }
            System.out.println("We have traversed the entire graph through " + counter + " edges.");
        }
    }
