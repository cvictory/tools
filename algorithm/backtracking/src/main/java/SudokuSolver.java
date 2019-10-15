import java.util.Arrays;

/**
 * @author cvictory ON 2019-05-22
 */
public class SudokuSolver {
    private char[] nums = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private int[][] directions = {{0, 1}, {-1, 0}, {-1, 0}, {1, 0}};

    private boolean[][] rowsUsed = new boolean[9][10];
    private boolean[][] colsUsed = new boolean[9][10];
    private boolean[][] cubesUsed = new boolean[9][10];
    private char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };

    public void solveSudoku() {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                rowsUsed[i][num] = true;
                colsUsed[j][num] = true;
                cubesUsed[cubeNum(i, j)][num] = true;
            }
        backtracking(0, 0);
    }

    private boolean backtracking(int row, int col) {

        while (row < 9 && board[row][col] != '.') {
            row = col == 8 ? row + 1 : row;
            col = col == 8 ? 0 : col + 1;
        }

        if (row == 9) {
            return true;
        }

        for (char num : nums) {
            int nunInt = num - '0';
            if (rowsUsed[row][nunInt] || colsUsed[col][nunInt] || cubesUsed[cubeNum(row, col)][nunInt]) {
                continue;
            }
            rowsUsed[row][nunInt] = colsUsed[col][nunInt] = cubesUsed[cubeNum(row, col)][nunInt] = true;
            System.out.println(row + " --> " + col + " : " + num);
            board[row][col] = num;
            if (backtracking(row, col)) {
                return true;
            }
            System.out.println(row + " <-- " + col + " : " + num);
            rowsUsed[row][nunInt] = colsUsed[col][nunInt] = cubesUsed[cubeNum(row, col)][nunInt] = false;
            board[row][col] = '.';
        }
        return false;
    }


    private int cubeNum(int i, int j) {
        int r = i / 3;
        int c = j / 3;
        return r * 3 + c;
    }

    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.solveSudoku();
        sudokuSolver.print();
    }

    private void print(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
                System.out.print(", ");
            }
            System.out.println("");
        }
    }

}
