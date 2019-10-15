/**
 * @author cvictory ON 2019-05-21
 */
public class WordSearch {
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    boolean[][] haveVisit = new boolean[board.length][board[0].length];
                    haveVisit[i][j] = true;
                    if (search(board, word.substring(1), i, j, haveVisit)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int i, int j, boolean[][] haveVisit) {

        for (int[] direction : directions) {
            int newR = i + direction[0];
            int newC = j + direction[1];
            if (newR >= board.length || newC >= board[0].length || newR < 0 || newC < 0) {
                continue;
            }
//            System.out.println(newR + ", " + newC + ", " + word);
            if (haveVisit[newR][newC]) {
                continue;
            }
            if (board[newR][newC] != word.charAt(0)) {
                continue;
            }
            haveVisit[newR][newC] = true;
            if (word.length() == 1) {
                return true;
            }
            if (search(board, word.substring(1), newR, newC, haveVisit)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] t = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(new WordSearch().exist(t, "ABCCED"));
        System.out.println(new WordSearch().exist(t, "SEE"));
        System.out.println(new WordSearch().exist(t, "ABCB"));
    }
}
