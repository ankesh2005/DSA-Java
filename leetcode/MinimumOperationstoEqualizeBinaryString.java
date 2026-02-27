import java.util.NavigableSet;
public class MinimumOperationstoEqualizeBinaryString {
class Solution {
  // lc-3666
    public int minOperations(String s, int k) {
        // int n=s.length();
        // int startZero=0;
        // for (char c : s.toCharArray()){ 
        //     if (c == '0') { 
        //         startZero++;
        //     }
        // }
        // if(startZero==0)return 0;
        // int[] ops=new int[n+1];
        // Arrays.fill(ops,-1);
        // ops[startZero]=0;
        // Queue<Integer> que=new ArrayDeque<>();
        // que.offer(startZero);//add
        // while(!que.isEmpty()){
        //     int z=que.poll();
        //     int minf=Math.max(0,k-n+z);
        //     int maxf=Math.min(k,z);
        //     for(int f=minf;f<=maxf;f++){
        //         int newz=z+k-2*f;
        //         if(ops[newz]==-1){
        //             ops[newz]=ops[z]+1;
        //             if(newz==0){
        //                 return ops[newz];
        //             }
        //             que.add(newz);
        //         }
        //     }
        // }
        // return -1;

        int n = s.length();
        int startZero = 0;
        for (char c : s.toCharArray()) {
            if (c == '0')
                startZero++;
        }
        if (startZero == 0)
            return 0;
        int[] ops = new int[n + 1];
        Arrays.fill(ops, -1);
        ops[startZero] = 0;
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(startZero);
        TreeSet<Integer> evenSet = new TreeSet<>();
        TreeSet<Integer> oddSet = new TreeSet<>();
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0)
                evenSet.add(i);
            else
                oddSet.add(i);
        }
        if (startZero % 2 == 0)
            evenSet.remove(startZero);
        else
            oddSet.remove(startZero);
        while (!que.isEmpty()) {
            int z = que.poll();
            int step = ops[z];
            int min_new_z = z + k - 2 * Math.min(k, z);
            int max_new_z = z + k - 2 * Math.max(0, k - n + z);
            int newParity = (z + k) % 2;
TreeSet<Integer> currSet = (newParity == 0) ? evenSet : oddSet;
            NavigableSet<Integer> candidates = currSet.subSet(min_new_z, true, max_new_z, true);
            List<Integer> toRemove = new ArrayList<>();
            for (int newZ : candidates) {
                if (ops[newZ] == -1) {
                    ops[newZ] = step + 1;
                    if (newZ == 0)
                        return ops[newZ];
                    que.offer(newZ);
                    toRemove.add(newZ);
                }
            }
            for (int val : toRemove)
                currSet.remove(val);
        }
        return -1;

    }
}
}