//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    方法一：使用HashMap，整个算法的时间复杂度为NKLogK，其中N为strs中字段的数量
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List> stringHashMap = new HashMap<String, List>();
        for(String string:strs){
            char[] chars = string.toCharArray();
            //sort这一步所需要花费的时间复杂度为KLogK，其中K为字符串的最大长度
            Arrays.sort(chars);
            String keyString = String.valueOf(chars);
            if(stringHashMap.containsKey(keyString)) {
                stringHashMap.get(keyString).add(string);
            }else {
                List<String> list = new ArrayList<>();
                list.add(string);
                stringHashMap.put(keyString,list);
            }
        }
        return new ArrayList(stringHashMap.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
