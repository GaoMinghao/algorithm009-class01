# 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
# 
#  你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
# 
#  
# 
#  示例: 
# 
#  给定 nums = [2, 7, 11, 15], target = 9
# 
# 因为 nums[0] + nums[1] = 2 + 7 = 9
# 所以返回 [0, 1]
#  
#  Related Topics 数组 哈希表


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution(object):
    # 自己想的方法：直接循环相加
    # def twoSum(self, nums, target):
    #     """
    #     :type nums: List[int]
    #     :type target: int
    #     :rtype: List[int]
    #     """
    #     result_num = []
    #     index_of_i = 0
    #     index_of_j = 1
    #     for i in nums:
    #         index_of_j = index_of_i+1
    #         for j in nums[index_of_i+1:]:
    #             if i+j == target:
    #                     result_num.append(index_of_i)
    #                     result_num.append(index_of_j)
    #                     return result_num
    #             index_of_j = index_of_j + 1
    #         index_of_i = index_of_i + 1

    # 优化一：
    # def twoSum(self, nums: List[int], target: int) -> List[int]:
    #     """
    #     :type nums: List[int]
    #     :type target: int
    #     :rtype: List[int]
    #     """
    #     dict = {}
    #     result_list = []
    #     for num_index, num in enumerate(nums):
    #         dict[num] = num_index  # 需要注意的是如果nums中有两个相同的元素，则存入dict中时后存的会覆盖之前的，但是由于题目要求，只能又一个结果，所以选到相同元素时必两个都选中，恰巧规避了报错
    #     for num_index in range(len(nums)):
    #         match_index = dict.get(target - nums[num_index])  # 如果直接用dict[get]访问值，由于键可能不存在，所以会导致报错
    #         if match_index is not None and num_index != match_index:
    #             result_list.append(num_index)
    #             result_list.append(match_index)
    #             return result_list

    #优化二：
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dict = {}
        for index, num in enumerate(nums):
            diff = target - num
            if diff in dict:
                return [dict.get(diff), index]
            dict[num] = index

# leetcode submit region end(Prohibit modification and deletion)

if __name__ == "__main__":
    solution = Solution()
    nums = [1, 3, 3, 15]
    target = 6
    result_list = solution.twoSum(nums, target)
    print(result_list)
