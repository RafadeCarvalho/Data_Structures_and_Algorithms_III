package GraphAlgorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GraphMatrix {
    private int countNodes;
    private int countEdges;
    private int[][] adjMatrix;
    public static final int INF = 9999;

    public GraphMatrix(int countNodes) {
        this.countNodes = countNodes;
        this.adjMatrix = new int[countNodes][countNodes];
    }

    public GraphMatrix(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);

        // Read header
        String[] line = bufferedReader.readLine().split(" ");
        this.countNodes = (Integer.parseInt(line[0]));
        int fileLines = (Integer.parseInt(line[1]));

        // Create and fill adjMatrix with read edges
        this.adjMatrix = new int[this.countNodes][this.countNodes];
        for (int i = 0; i < fileLines; ++i) {
            String[] edgeInfo = bufferedReader.readLine().split(" ");
            int source = Integer.parseInt(edgeInfo[0]);
            int sink = Integer.parseInt(edgeInfo[1]);
            int weight = Integer.parseInt(edgeInfo[2]);
            addEdge(source, sink, weight);
        }
        bufferedReader.close();
        reader.close();
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


    //d = |E| / |V|*|V| - 1  = Fórmula densidade do grafo
    public float density() {
        return (float) this.countEdges / (this.countNodes * this.countNodes - 1);
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

    // source = origem, sink = destino e weight = peso.
    public void addEdge(int source, int sink, int weight) {
        if (source < 0 || source > this.countNodes - 1 || sink < 0
                || sink > this.countNodes - 1 || weight <= 0) {
            System.err.println("Invalid Edge: " + source + " " + sink + " " + source);
            return;
        }
        this.adjMatrix[source][sink] = weight;
        this.countEdges++;
    }

    /*public void addUnorientedEdge(int u, int v, int w) {
        if (u < 0 || u > this.countNodes - 1 || v < 0
                || v > this.countNodes - 1 || w <= 0) {
            System.err.println("Invalid Edge: " + u + " " + v + " " + w);
            return;
        }
        this.adjMatrix[u][v] = w;
        this.adjMatrix[v][u] = w;
        this.countEdges += 2;
    }*/

    public void addUnorientedEdge(int source, int sink, int weight) {
        addEdge(source, sink, weight);
        addEdge(sink, source, weight);
    }

    public int highestDegree() {
        // Returns the highest degree in the graph
        int highest = 0;
        for (int i = 0; i < this.adjMatrix.length; ++i) {
            int degreeNodeI = this.degree(i);
            if (degreeNodeI > highest)
                highest = degreeNodeI;
        }
        return highest;
    }

    public int lowestDegree() {
        int lowest = this.adjMatrix.length;
        for (int i = 0; i < this.adjMatrix.length; ++i) {
            int degreeNodeI = this.degree(i);
            if (degreeNodeI < lowest)
                lowest = degreeNodeI;
        }
        return lowest;
    }

    // Breadth-first Search(Busca em largura) ; (s) = Origem; Arraylist = Lista de inteiros
    public ArrayList<Integer> bfs(int source) {
        int[] desc = new int[this.countNodes];
        ArrayList<Integer> Q = new ArrayList<>();
        Q.add(source);
        ArrayList<Integer> R = new ArrayList<>();
        R.add(source);
        desc[source] = 1;
        while (Q.size() > 0) {
            int u = Q.remove(0);
            for (int v = 0; v < this.adjMatrix[u].length; ++v) {
                if (this.adjMatrix[u][v] != 0 && desc[v] == 0) {
                    Q.add(v);
                    R.add(v);
                    desc[v] = 1;
                }
            }
        }
        return R;
    }

    // Depth-first search(dfs) = Busca em profundidade
    public ArrayList<Integer> dfs(int source) {
        int desc[] = new int[countNodes];
        ArrayList<Integer> S = new ArrayList<>(); // Stack (Pilha)
        S.add(source);
        ArrayList<Integer> R = new ArrayList<>();
        R.add(source);
        desc[source] = 1;
        while (S.size() > 0) {
            int u = S.get(S.size() - 1);
            boolean unstack = true;
            for (int v = 0; v < adjMatrix[u].length; ++v) {
                if (adjMatrix[u][v] != 0 && desc[v] == 0) { // v é adjacente a u
                    S.add(v);
                    R.add(v);
                    desc[v] = 1;
                    unstack = false;
                    break;
                }
            }
            if (unstack) {
                S.remove(S.size() - 1);
            }
        }
        return R;
    }

    public boolean isConnected() {
        return this.bfs(0).size() == this.countNodes;
    }

    public ArrayList<Integer> dfsRec(int s) {
        int[] desc = new int[this.countNodes];
        ArrayList<Integer> R = new ArrayList<>();
        dfsRecAux(s, desc, R);
        return R;
    }

    public void dfsRecAux(int u, int[] desc, ArrayList<Integer> R) {
        desc[u] = 1;
        R.add(u);
        for (int v = 0; v < this.adjMatrix[u].length; ++v) {
            if (this.adjMatrix[u][v] != 0 && desc[v] == 0) {
                dfsRecAux(v, desc, R);
            }
        }
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < this.adjMatrix.length; ++i) {
            for (int j = 0; j < this.adjMatrix[i].length; ++j) {
                str += this.adjMatrix[i][j] + "\t";
            }
            str += "\n";
        }
        return str;
    }

    public GraphMatrix complement() {
        //Returns the complement of the current graph
        GraphMatrix g2 = new GraphMatrix(this.countNodes);
        for (int i = 0; i < this.adjMatrix.length; ++i) {
            for (int j = 0; j < this.adjMatrix[i].length; j++) {
                if (this.adjMatrix[i][j] == 0 && i != j)
                    //g2.adjMatrix[i][j] = 1;
                    g2.addEdge(i, j, 1); // essa opção é melhor que a de cima pela atualização do contador.
            }
        }
        return g2;
    }

    // Retorna true se g2 é subgrafo de this; false caso contrário.
    public boolean subGraph(GraphMatrix g2) {
        if (g2.countNodes > this.countNodes || g2.countEdges > this.countEdges)
            return false;
        for (int i = 0; i < g2.adjMatrix.length; ++i) {
            for (int j = 0; j < g2.adjMatrix[i].length; ++j) {
                if (g2.adjMatrix[i][j] != 0 && this.adjMatrix[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    public boolean isOriented() { // se for orientado retorna false, se for não orientado retorna true
        for (int i = 1; i < this.adjMatrix.length; i++) {
            for (int j = i + 1; j < this.adjMatrix[i].length; j++) {
                if (this.adjMatrix[i][j] != this.adjMatrix[j][i])
                    return false;
            }
        }
        return true;
    }

    public void floyd_Warshal(int s, int t) {
        GraphMatrix g1 = new GraphMatrix(countNodes);
        int dist[][] = new int[this.countNodes][this.countNodes];
        int pred[][] = new int[this.countNodes][this.countNodes];
        for (int i = 0; i < this.adjMatrix.length; ++i) {
            for (int j = 0; j < this.adjMatrix[i].length; ++j) {
                if (i == j) {
                    dist[i][j] = 0;
                } else if (this.adjMatrix[i][j] != 0) { // ha aresta (i, j)
                    dist[i][j] = this.adjMatrix[i][j];
                    pred[i][j] = i;
                } else {
                    dist[i][j] = INF;
                    pred[i][j] = -1;
                }
            }
        }
        for(int k = 0; k < this.countNodes; ++k){
            for(int i = 0; i < this.countNodes; ++i){
                for(int j = 0; j < this.countNodes; ++j){
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                        pred[i][j] = pred[k][j];
                    }
                }
            }
        }
        // Recuperando os caminhos
        System.out.printf("Distance from %d to %d is: %d", s, t, dist[s][t]);
        ArrayList<Integer> C = new ArrayList<>();
        int aux = t;
        while(aux != s){
            aux = pred[s][aux];
            C.add(0, aux);
        }
        System.out.println("\n=== Dist ===");
        for(int i = 0; i < dist.length; ++i){
            for(int j = 0; j < dist[i].length; ++j){
                System.out.print(dist[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\n=== Pred ===");
        for(int i = 0; i < pred.length; ++i){
            for(int j = 0; j < pred[i].length; ++j){
                System.out.print(pred[i][j] + "\t");
            }
            System.out.println();
        }
    }

}


