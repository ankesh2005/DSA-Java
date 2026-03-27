package DivideAndConquer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtLeastKRepeatingCharacters {
  // lc-395. Longest Substring with At Least K Repeating Characters
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if (n == 0 || n < k)
            return 0;
        if (k <= 1)
            return n;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int l = 0;
        while (l < n && map.get(s.charAt(l)) >= k)
            l++;
        if (l == n)
            return l;
        int ls1 = longestSubstring(s.substring(0, l), k);
        while (l < n && map.get(s.charAt(l)) < k)
            l++;
        int ls2 = (l < n) ? longestSubstring(s.substring(l), k) : 0;
        return Math.max(ls1, ls2);
    }
}

