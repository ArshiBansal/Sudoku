public class SudokuValidator {
    public static boolean isValid(int[][] board, int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value && i != col) return false;
            if (board[i][col] == value && i != row) return false;
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++)
            for (int j = startCol; j < startCol + 3; j++)
                if (board[i][j] == value && (i != row || j != col))
                    return false;

        return true;
    }
}
