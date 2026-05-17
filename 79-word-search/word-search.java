class Solution {
    public boolean exist(char[][] board, String word) {
       int rows = board.length;
        int cols = board[0].length;

        // Try starting from every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board,
                        String word,
                        int row,
                        int col,
                        int index) {

        // All characters matched
        if (index == word.length()) {
            return true;
        }

        // Boundary checks
        if (row < 0 || col < 0 ||
            row >= board.length ||
            col >= board[0].length ||
            board[row][col] != word.charAt(index)) {

            return false;
        }

        // Store current character
        char temp = board[row][col];

        // Mark as visited
        board[row][col] = '#';

        // Explore all 4 directions
        boolean found =
                dfs(board, word, row + 1, col, index + 1) || // down
                dfs(board, word, row - 1, col, index + 1) || // up
                dfs(board, word, row, col + 1, index + 1) || // right
                dfs(board, word, row, col - 1, index + 1);   // left

        // Restore original character
        board[row][col] = temp;

        return found; 
    }
}