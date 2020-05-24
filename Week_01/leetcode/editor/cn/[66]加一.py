# 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
# 
#  最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
# 
#  你可以假设除了整数 0 之外，这个整数不会以零开头。 
# 
#  示例 1: 
# 
#  输入: [1,2,3]
# 输出: [1,2,4]
# 解释: 输入数组表示数字 123。
#  
# 
#  示例 2: 
# 
#  输入: [4,3,2,1]
# 输出: [4,3,2,2]
# 解释: 输入数组表示数字 4321。
#  
#  Related Topics 数组


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    #直接转化为数字加一再转化为数组
    # def plusOne(self, digits: List[int]) -> List[int]:
    #     num = 0
    #     result = []
    #     for index, digist in enumerate(digits):
    #         num = num + digist * 10 ** (len(digits) - index - 1)
    #     num = num + 1
    #     while num:
    #         result_index = num % 10
    #         num = int(num // int(10))
    #         result.append(result_index)
    #     result.reverse()
    #     return result
    def plusOne(self, digits: List[int]) -> List[int]:
        l = len(digits)
        if l == 0:
            return [1]
        for i in range (l-1, -1, -1):
            if digits[i] != 9:
                digits[i] = digits[i]+1
                return digits
            else:
                digits[i] = 0
        digits.insert(0, 1) #该方法是python内置方法，运行速度很快
        return digits

# leetcode submit region end(Prohibit modification and deletion)

if __name__ == '__main__':
    digist = [9]
    solution = Solution()
    print(solution.plusOne(digist))
