//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
//
// 示例 1:
//
//
//输入: "abc"
//输出: 3
//解释: 三个回文子串: "a", "b", "c".
//
//
// 示例 2:
//
//
//输入: "aaa"
//输出: 6
//说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
//
//
// 注意:
//
//
// 输入的字符串长度不会超过1000。
//
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        if ( s== null || s.equals("")) return 0;
        int length = s.length();
        int result = length;
        Boolean[][] dp =  new Boolean[length][length];
        for(int i=0;i<length;i++) dp[i][i] = Boolean.TRUE;
        //为什么从右下角遍历：因为在填dp表时，(i, j) 位置的值依赖于（i+1,j-1），也就是当前位置的左下方。显然如果从上往下遍历，左下方的值就完全没有初始化，当然当前位置也会是错误的。但是从右下角遍历就保证了左下方的所有值都已经计算好了。
        for (int i= length-1; i>=0; i--) {
            for (int j=i+1;j<length;j++) {
                if(s.charAt(j) == s.charAt(i)) {
                    if(j-i == 1){
                        dp[i][j] = Boolean.TRUE;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                else {
                    dp[i][j]=Boolean.FALSE;
                }
                if(dp[i][j]) result++;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
