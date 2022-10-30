package trees.dfs;

import java.util.ArrayList;
import java.util.List;

public class FindingKeys {
    public static void main(String[] args) {

        char[][] grid = {
                {'A', 'B', 'R'},
                {'C', 'Y', 'P'},
                {'H', 'U', 'L'}
        };

        List<String> words = List.of("ABU", "BRP", "ABR", "RPL", "HUY", "CYL");
        System.out.println(findKeyWords(grid, words));

    }

    private static List<String> findKeyWords(char[][] grid, List<String> words) {
        List<String> findings = new ArrayList<>();
        words.forEach(word -> {

        });
        return findings;
    }
}

