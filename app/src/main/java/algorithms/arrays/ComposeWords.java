package algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

public class ComposeWords {

    public static void main(String[] args) {
        char[][] grid = {
                {'A', 'B', 'R'},
                {'C', 'Y', 'P'},
                {'H', 'U', 'L'},
        };
        List<String> words = List.of("ABU", "BRP", "ABR", "RPL", "HUY", "CYL");
        List<String> wordMatched = new ArrayList<>();

        for (String word : words) {
            if (canFindWord(grid, word)) {
                wordMatched.add(word);
            }
        }

        System.out.println(wordMatched);
    }

    private static boolean canFindWord(char[][] grid, String word) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        boolean[][] visited = new boolean[numRows][numCols];

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (dfs(grid, word, row, col, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] grid, String word, int row, int col, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= grid.length
                || col < 0 || col >= grid[0].length
                || visited[row][col] || grid[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;
        //DEFINE MOVEMENT RULES
        if (dfs(grid, word, row + 1, col, index + 1, visited) ||
                dfs(grid, word, row - 1, col, index + 1, visited) ||
                dfs(grid, word, row, col + 1, index + 1, visited) ||
                dfs(grid, word, row, col - 1, index + 1, visited)) {
            return true;
        }

        visited[row][col] = false;
        return false;
    }
}
