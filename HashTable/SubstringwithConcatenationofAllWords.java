package HashTable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {
  // lc-30. Substring with Concatenation of All Words
  class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
      Map<String, Integer> map1 = new HashMap<>();
      for (var word : words)
        map1.put(word, map1.getOrDefault(word, 0) + 1);
      int len = words[0].length();
      int totallen = len * words.length;
      int n = s.length();
      List<Integer> ans = new LinkedList<>();
      for (int i = 0; i < len; i++) {
        Map<String, Integer> seen = new HashMap<>();
        int count = 0;
        int l = i, r = i;
        while (r + len <= n) {
          String word = s.substring(r, r + len);
          r += len;
          if (map1.containsKey(word)) {
            seen.put(word, seen.getOrDefault(word, 0) + 1);
            count++;
            while (seen.get(word) > map1.get(word)) {
              String leftWord = s.substring(l, l + len);
              seen.put(leftWord, seen.get(leftWord) - 1);
              l += len;
              count--;
            }
            if (count == words.length) {
              ans.add(l);
            }
          } else {
            seen.clear();
            count = 0;
            l = r;
          }

        }
      }
      return ans;
    }
  }
}
