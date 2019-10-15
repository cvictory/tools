import java.util.Arrays;

/**
 * @author cvictory ON 2019-03-27
 */
public class RedundantConnection {

    public static void main(String[] args) {
//        int[][] param = {{1, 2}, {1, 3}, {2, 3}};
//        int[] r = new RedundantConnection().findRedundantConnection(param);
//        System.out.println(r[0] + ", " + r[1]);

        int[][] param2 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int[] r2 = new RedundantConnection().findRedundantConnection(param2);
        System.out.println(r2[0] + ", " + r2[1]);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        UF uf = new UF(N);
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (uf.connect(u, v)) {
                return e;
            }
            uf.union(u, v);
        }
        return new int[]{-1, -1};
    }

    private class UF {

        private int[] id;

        UF(int N) {
            id = new int[N + 1];
            for (int i = 0; i < id.length; i++) {
                id[i] = i;
            }
        }

        void union(int u, int v) {
            int uID = find(u);
            int vID = find(v);
            if (uID == vID) {
                return;
            }
            for (int i = 0; i < id.length; i++) {
                if (id[i] == uID) {
                    System.out.println(uID + ", " + vID + ", " + i);
                    id[i] = vID;
                }
            }
        }

        int find(int p) {
            return id[p];
        }

        boolean connect(int u, int v) {
            return find(u) == find(v);
        }
    }
}
