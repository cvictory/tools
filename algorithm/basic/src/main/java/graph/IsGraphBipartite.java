package graph;

import java.util.Arrays;

/**
 * @author cvictory ON 2019-06-05
 */
public class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < graph.length; i++) {
//            if()
        }
        return true;
    }

    private boolean isBipartite(int[][] graph, int node, int[] colors, int color) {
        if (colors[node] != -1) {
            return colors[node] == color;
        }
        colors[node] = color;
        for (int num : graph[node]) {
            if (!isBipartite(graph, num, colors, 1 - color)) {
                return false;
            }
        }
        return true;
    }
}
