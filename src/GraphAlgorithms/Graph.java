package GraphAlgorithms;

public class Graph {
    private int countNodes;
    private int countEdges;
    private int[][] adjMatrix;

    public Graph(int countNodes){
        this.countNodes = countNodes;
        this.adjMatrix = new int[countNodes][countNodes];
    }


    public void setCountNodes(int countNodes) {
        this.countNodes = countNodes;
    }

    public void setCountEdges(int countEdges) {
        this.countEdges = countEdges;
    }

    public void setAdjMatrix(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }

    public int getCountNodes() {
        return countNodes;
    }

    public int getCountEdges() {
        return countEdges;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public String toString(){
        String str = "";
        for (int i = 0; i < this.adjMatrix.length; ++i){
            for (int j = 0; j < this.adjMatrix[i].length; ++j){
                str  += this.adjMatrix[i][j] + "\t";
            }
            str += "\n";
        }
        return str;
    }

    // source = origem, sink = destino e weight = peso.
    public void addEdge(int source, int sink, int weight){
        if (source < 0 || source > this.countNodes - 1 || sink < 0
                || sink > this.countNodes - 1 || weight <= 0){
            System.err.println("Invalid Edge: " + source + " " + sink + " " + source);
            return;
        }
        this.adjMatrix[source][sink] = weight;
        this.countEdges++;
    }

    // Returns the degree(grau) of a node.
    public int degree(int node) {
        //
        int degree = 0;
        if (node < 0 || node > this.countNodes - 1)
            System.err.println("Invalid Node: " + node);
        for (int i = 0; i < this.adjMatrix[node].length; ++i) {
            if (this.adjMatrix[node][i] != 0)
                ++degree;
            }
        return degree;
    }

    public int highestDegree(){
        // Returns the highest degree in the graph
        int highest = 0;
        for (int i =0; i < this.adjMatrix.length; ++i){
            int degreeNodeI = this.degree(i);
            if (degreeNodeI > highest)
                highest = degreeNodeI;
        }
        return highest;
    }

    public int lowestDegree(){
        int lowest = this.adjMatrix.length;
        for(int i = 0; i < this.adjMatrix.length; ++i){
            int degreeNodeI = this.degree(i);
            if(degreeNodeI < lowest)
                lowest = degreeNodeI;
        }
        return lowest;
    }

    public Graph complement(){
        //Returns the complement of the current graph
        Graph g2 = new Graph(this.countNodes);
        for (int i = 0; i < this.adjMatrix.length; ++i){
            for(int j = 0; j < this.adjMatrix[i].length; j++){
                if(this.adjMatrix[i][j] == 0 && i!=j)
                    //g2.adjMatrix[i][j] = 1;
                    g2.addEdge(i, j, 1); // essa opção é melhor que a de cima pela atualização do contador.
            }
        }
        return g2;
    }

    //d = |E| / |V|*|V| - 1  = Fórmula densidade do grafo
    public float density(){
        return (float) this.countEdges/ (this.countNodes * this.countNodes - 1);
    }

    // Retorna true se g2 é subgrafo de this; false caso contrário.
    public boolean subGraph(Graph g2){
        if (g2.countNodes > this.countNodes || g2.countEdges > this.countEdges)
            return false;
        for(int i = 0; i < g2.adjMatrix.length; ++i) {
            for(int j = 0; j < g2.adjMatrix[i].length; ++j) {
                if(g2.adjMatrix[i][j] != 0 && this.adjMatrix[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
}
