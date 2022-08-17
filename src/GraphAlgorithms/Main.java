package GraphAlgorithms;

public class Main {
    public static void main(String[] args){
        Graph g1 = new Graph(4);
        g1.addEdge(0,1 , 3);
        g1.addEdge(1, 0, 3);
        g1.addEdge(0, 3, 4);
        g1.addEdge(3,0,4);
        g1.addEdge(3, 4, 2);
        System.out.println(g1);

        System.out.println("Number of non-zero degrees: " + g1.degree(0));
        System.out.println("Number of non-zero degrees: " + g1.degree(1));
        System.out.println("Number of non-zero degrees: " + g1.degree(2));
        System.out.println("Number of non-zero degrees: " + g1.degree(3));

        System.out.println("\nHighest Degree: " + g1.highestDegree());
        System.out.println("Lowest Degree: " + g1.lowestDegree());
        System.out.println("\nComplement of the current graph: \n" + g1.complement());

        Graph g2 = new Graph(3);
        g2.addEdge(0, 1, 1);
        g2.addEdge(1, 0, 1);
        System.out.println("g2 is subGraph? " + g1.subGraph(g2)); // true
        Graph g3 = new Graph(4);
        g3.addEdge(1, 3, 1);
        g3.addEdge(3, 1, 1);
        System.out.println("g3 is subGraph? " + g1.subGraph(g3)); // false
    }
}
