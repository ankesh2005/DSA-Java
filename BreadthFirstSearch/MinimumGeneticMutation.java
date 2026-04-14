package BreadthFirstSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {
  // lc-433. Minimum Genetic Mutation
  class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
      Queue<String> q = new ArrayDeque<>();
      Set<String> words = new HashSet<>();
      if (startGene.equals(endGene))
        return 0;
      for (var word : bank)
        words.add(word);
      List<Character> choices = new ArrayList<>();
      choices.add('A');
      choices.add('C');
      choices.add('G');
      choices.add('T');
      int level = 0;
      q.offer(startGene);
      while (!q.isEmpty()) {
        int size = q.size();
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < size; i++) {
          String word = q.poll();
          StringBuilder sb = new StringBuilder(word);
          visited.add(word);
          for (char ch : choices) {
            for (int j = 0; j < 8; j++) {
              sb = new StringBuilder(word);
              if (word.charAt(j) == ch)
                continue;
              sb.setCharAt(j, ch);
              if (words.contains(sb.toString())) {
                if (endGene.equals(sb.toString()))
                  return level + 1;
                visited.add(sb.toString());
                q.add(sb.toString());
              }
            }
          }
        }
        for (String word : visited)
          words.remove(word);
        level++;
      }
      return -1;
    }

  }
}
