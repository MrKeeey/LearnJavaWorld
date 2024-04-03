package PracticeTasks;

public class LC_exist {
    public static void main(String[] args) {
        char[][] array = {{'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}};
        String word = "AAB";
        System.out.println(exist(array, word));
    }

    public static boolean exist(char[][] board, String word) {
        boolean result;
        int m = board.length;
        int n = board[0].length;
        boolean[][] isUsed = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //System.out.println(board[i][j] + "|" + i + " " + j + " <--");
                if (board[i][j] == word.charAt(0)) {
                    result = checkNext(isUsed, board, i, j, word, 0);
                    if (result) return true;
                }
            }
        }
        return false;
    }

    public static boolean checkNext(boolean[][] isUsed, char[][] board, int i, int j, String word, int k) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[i].length && !isUsed[i][j]) {
            if (board[i][j] == word.charAt(k)) {
                //System.out.println(board[i][j] + "|" + i + " " + j);
                if (k == word.length() - 1) {
                    return true;
                }
                if (k < word.length() - 1) {
                    isUsed[i][j] = true;
                    if (checkNext(isUsed, board, i, j + 1, word, k + 1) || checkNext(isUsed, board, i, j - 1, word, k + 1) ||
                            checkNext(isUsed, board, i + 1, j, word, k + 1) || checkNext(isUsed, board, i - 1, j, word, k + 1)) {
                        return true;
                    }
                    isUsed[i][j] = false;
                }
            }
        }
        return false;
    }
}
