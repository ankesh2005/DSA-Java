package Greedy;

public class StampingTheSequence {
// lc-936. Stamping The Sequence
class Solution {
    boolean checkReplaceHoga(char[] t, char[] s, int idx) {
        for (int i = 0; i < s.length; i++) {
            if (t[idx + i] != '?' && t[idx + i] != s[i]) {
                return false;
            }
        }
        return true;
    }

    void replaceKaro(char[] t, char[] s, int idx) {
        for (int i = 0; i < s.length; i++) {
            t[idx + i] = '?';
        }
    }

    public int[] movesToStamp(String stamp, String target) {
        List<Integer> ans = new ArrayList<>();
        int n = target.length(), m = stamp.length();
        char[] t = target.toCharArray();
        char[] s = stamp.toCharArray();
        String tar = "?".repeat(n);
        //unwrapping
        while (!new String(t).equals(tar)) {
            boolean replaceHua = false;
            for (int i = 0; i <= n - m; i++) {
                if (checkReplaceHoga(t, s, i)) {
                    boolean changed = false;

                    for (int j = 0; j < m; j++) {
                        if (t[i + j] != '?') { // check if real change
                            changed = true;
                            break;
                        }
                    }

                    if (changed) {
                        replaceKaro(t, s, i);
                        replaceHua = true;
                        ans.add(i);
                    }
                }
            }
            if (!replaceHua)
                return new int[0];
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(ans.size() - 1 - i);
        }

        return res;
    }
}
  
}