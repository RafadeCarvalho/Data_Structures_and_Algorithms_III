package GraphAlgorithms;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        GraphList g1 = new GraphList(3);
        g1.addEdge(0, 1, 10);
        g1.addEdge(0, 2, 20);
        g1.addEdge(2, 0, 15);
        System.out.println(g1);

        GraphList g2 = new GraphList(3);


        /*Graph g1 = new Graph("graph2.txt");
        System.out.println(g1);
        g1.floyd_Warshal();

        /*GraphMatrix g2 = new GraphMatrix("graph3.txt");
        System.out.println(g2);
        g2.floyd_Warshal(0, 3);
        */


       /* Graph g1 = new Graph(9);
        g1.addUnorientedEdge(7, 5, 1);
        g1.addUnorientedEdge(7,1,1);
        g1.addUnorientedEdge(7, 2, 1);
        g1.addUnorientedEdge(1, 0, 1);
        g1.addUnorientedEdge(1, 4, 1);
        g1.addUnorientedEdge(2, 3, 1);
        g1.addUnorientedEdge(5, 6, 1);
        g1.addUnorientedEdge(6, 8, 1);
        System.out.println(g1.bfs(7));
        if (g1.isConnected())
            System.out.println("\nThis graph is connected\n");

        Graph g2 = new Graph("graph1.txt");
        System.out.println(g2);

        Graph g3 = new Graph(7);
        g3.addUnorientedEdge(6, 3, 1);
        g3.addUnorientedEdge(6,4,1);
        g3.addUnorientedEdge(6,5,1);
        g3.addUnorientedEdge(3,2,1);
        g3.addUnorientedEdge(4,0,1);
        g3.addUnorientedEdge(0,1,1);
        System.out.println(g3.dfs(6)); */
    }
}
        /*Graph g1 = new Graph(4);
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
*/