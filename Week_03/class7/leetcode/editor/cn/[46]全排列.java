// 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
// 输出:
// [
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
// ]
// Related Topics 回溯算法

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  private ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

  public List<List<Integer>> permute(int[] nums) {
    LinkedList<Integer> track = new LinkedList<>();
    backTrack(nums, track);
    return result;
  }

  private void backTrack(int[] nums, LinkedList<Integer> track) {
    // terminator
    if (track.size() == nums.length) {
      result.add(new LinkedList(track));
      return;
    }
    // process current logic
    // drill down
    for (int i :nums) {
      if (track.contains(i)) {
        continue;
      }
      track.add(i);
      backTrack(nums, track);
      track.removeLast();
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
