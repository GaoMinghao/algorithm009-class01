//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length -1);
    }

    private int majorityElementRec(int[] nums, int beginIndex, int endIndex) {
        // recurison terminator
        if (beginIndex == endIndex) return nums[beginIndex];

        // local process - prepare data
        int mid = (endIndex - beginIndex)/2 + beginIndex;

        // calculate left and right
        int left = majorityElementRec(nums, beginIndex, mid);
        int right = majorityElementRec(nums, mid+1, endIndex);

        // process and generate the final result
        if (left == right) return left;
        int leftCount = countInrange(nums, left, beginIndex, endIndex);
        int rightCount = countInrange(nums, right, beginIndex, endIndex);
        return leftCount > rightCount ? left:right;
    }

    private int countInrange(int[] nums, int num, int beginIndex, int endIndex) {
        int count = 0;
        for (int i= beginIndex; i<=endIndex;i++){
            if(nums[i] == num) count++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
