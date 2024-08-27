package PracticeTasks;

public class LC1514_maxProbability {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] cost = {0.5, 0.5, 0.2};
        System.out.println(maxProbability(3, edges, cost, 0, 2));
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;

        for (int i = 0; i < n - 1; i++) {
            boolean isUpdated = false;
            for (int j = 0; j < edges.length; j++) {
                int fromNode = edges[j][0];
                int toNode = edges[j][1];
                double pathCost = succProb[j];

                if (maxProb[fromNode] * pathCost > maxProb[toNode]) {
                    maxProb[toNode] = maxProb[fromNode] * pathCost;
                    isUpdated = true;
                }

                if (maxProb[toNode] * pathCost > maxProb[fromNode]) {
                    maxProb[fromNode] = maxProb[toNode] * pathCost;
                    isUpdated = true;
                }
            }
            if (!isUpdated) break;
        }

        return maxProb[end_node];
    }

    
}
