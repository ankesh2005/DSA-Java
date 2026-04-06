package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupsAnagrams {
  // lc-49. Groups Anagrams
  class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>map=new HashMap<>();
        for(String str:strs){
            int[] arr=new int[26];
            for(char ch:str.toCharArray()){
                arr[ch-'a']++;
            }
            String key=Arrays.toString(arr);
            if(map.containsKey(key)){
                map.get(key).add(str);
            }else{
                map.put(key,new ArrayList<>());
                map.get(key).add(str);
            }
        }
        List<List<String>> ans=new ArrayList<>();
        for(String key:map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }
}
}
