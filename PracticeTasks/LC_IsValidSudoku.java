package PracticeTasks;

public class LC_IsValidSudoku {
    public static void main(String[] args) {
        char[][] array = {
                {'.', '.', '4', '.', '7', '.', '.', '.', '.'},
                {'0', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'3', '.', '.', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'1', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '0'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(array));
    }

    public static boolean isValidSudoku(char[][] board) {
        StringBuilder totalRow = new StringBuilder();
        StringBuilder totalCol = new StringBuilder();
        StringBuilder matrix1 = new StringBuilder();
        StringBuilder matrix2 = new StringBuilder();
        StringBuilder matrix3 = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != '.') {
                    if (!matrix1.toString().contains(String.valueOf(board[i][j])) && !totalCol.toString().contains(String.valueOf(board[i][j]))) {
                        matrix1.append(board[i][j]);
                        totalCol.append(board[i][j]);
                    } else {
                        return false;
                    }
                }
                if (board[j][i] != '.') {
                    if (!totalRow.toString().contains(String.valueOf(board[j][i]))) {
                        totalRow.append(board[j][i]);
                    } else {
                        return false;
                    }
                }
            }
            for (int j = 3; j < 6; j++) {
                if (board[i][j] != '.') {
                    if (!matrix2.toString().contains(String.valueOf(board[i][j])) && !totalCol.toString().contains(String.valueOf(board[i][j]))) {
                        matrix2.append(board[i][j]);
                        totalCol.append(board[i][j]);
                    } else {
                        return false;
                    }
                }
                if (board[j][i] != '.') {
                    if (!totalRow.toString().contains(String.valueOf(board[j][i]))) {
                        totalRow.append(board[j][i]);
                    } else {
                        return false;
                    }
                }
            }
            for (int j = 6; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!matrix3.toString().contains(String.valueOf(board[i][j])) && !totalCol.toString().contains(String.valueOf(board[i][j]))) {
                        matrix3.append(board[i][j]);
                        totalCol.append(board[i][j]);
                    } else {
                        return false;
                    }
                }
                if (board[j][i] != '.') {
                    if (!totalRow.toString().contains(String.valueOf(board[j][i]))) {
                        totalRow.append(board[j][i]);
                    } else {
                        return false;
                    }
                }
            }
            totalCol = new StringBuilder();
            totalRow = new StringBuilder();
            if (i == 2 || i == 5) {
                matrix1 = new StringBuilder();
                matrix2 = new StringBuilder();
                matrix3 = new StringBuilder();
            }
        }
        return true;
    }
}
