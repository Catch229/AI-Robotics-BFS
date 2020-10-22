/**
* Kolton Sumner
* AI Robotics
* Description: This program demonstrates how 
* a BFS algorithm would be implemented.
 */
package airoboticslab;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Kolton
 */
public class AIRoboticsLab {

    //Node class to represent tree
    public static class Node {
        public String value;
        public Node left, right;
        public Node(String value){
            this.value = value; 
            left = right = null;
        }
    }

    public static void main(String[] args) {
        ArrayList<Node> open = new ArrayList<>();
        ArrayList<Node> closed = new ArrayList<>();
        
        Scanner in = new Scanner(System.in);
        
        //Create the tree structure
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");
        Node H = new Node("H");
        Node I = new Node("I");
        Node J = new Node("J");
        Node K = new Node("K");
        Node L = new Node("L");
        Node M = new Node("M");
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = F;
        E.right = G;
        G.left = H;
        G.right = I;
        H.left = J;
        H.right = K;
        J.left = L;
        J.right = M;

        
        //Take user input and find path
        System.out.print("Please input your destination node here: ");
        String nodeValue = in.next();
        ArrayList<Node> path = isPath(A, nodeValue);
        
        //Print out calculated path
        for(int i = 0; i < path.size()-1; i++)
            System.out.print(path.get(i).value + " -> ");
        System.out.print(path.get(path.size()-1).value + "\n");
        
    }
    //Utility function to find path using BFS
    public static ArrayList<Node> isPath(Node source,String dest){
        ArrayList<Node> open = new ArrayList<>();
        ArrayList<Node> closed = new ArrayList<>();
        Node current = null;
        Node prev = null;
        open.add(source);
        
        //BFS algo
        while(!open.isEmpty()){
            current = open.remove(0);
            if(current.value.equals(dest))
                break;
            
            if(current.left != null)
                open.add(current.left);
            if(current.right != null)
                open.add(current.right);
            if(current.left != current.right)
                closed.add(current);
        }
        //Path isolating
        if(closed.get(closed.size()-2).right == current)
            closed.remove(closed.get(closed.size()-2).left);
        closed.add(current);
        return closed;
    }
    
}
