import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cvictory ON 2019-04-22
 */
public class ReconstructQueue {

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));

        print(people);

        List<int[]> r = new ArrayList<int[]>();
        for (int[] p : people){
            r.add(p[1], p);
        }
        return r.toArray(new int[r.size()][]);
    }

    public static void main(String[] args) {
        int[][] p = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};

        int[][] r = reconstructQueue(p);

        print(r);
    }

    private static void print(int[][] r){
        for (int i=0; i<r.length; i++){
            for (int j=0; j<r[i].length; j++){
                System.out.print(r[i][j]);
                System.out.print(",");
            }
            System.out.println();
        }
    }
}
