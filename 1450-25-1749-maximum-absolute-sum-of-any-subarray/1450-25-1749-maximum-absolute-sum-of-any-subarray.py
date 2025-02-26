class Solution:
    def maxAbsoluteSum(self, nums):
        max_sum = min_sum = curr_max = curr_min = 0

        for num in nums:
            curr_max = max(0, curr_max + num)
            curr_min = min(0, curr_min + num)
            max_sum = max(max_sum, curr_max)
            min_sum = min(min_sum, curr_min)

        return max(abs(max_sum), abs(min_sum))

# Example usage:
solution = Solution()
print(solution.maxAbsoluteSum([1, -3, 2, 3, -4]))  # Output: 5
print(solution.maxAbsoluteSum([2, -5, 1, -4, 3, -2]))  # Output: 8
