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


    }
}
