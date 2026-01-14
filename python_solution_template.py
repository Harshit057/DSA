"""
PYTHON SOLUTION TEMPLATE
Following the 6 Mandatory Guidelines for Quiz Solutions

This template demonstrates how to structure your solution with:
1. Plan/Approach
2. Reasoning
3. Code Changes (iterations)
4. Testing & Edge Cases
5. Final Solution
6. Additional Constraints

EXAMPLE PROBLEM: Maximum Subarray Sum (Kadane's Algorithm)
Problem: Given an integer array nums, find the contiguous subarray with the largest sum.
"""

"""
===================================
1. PLAN / APPROACH (Mandatory)
===================================

Step 1: Understand the problem and constraints
    - Why: Need to know input format, output format, and edge cases
    - Example Input: nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    - Example Output: 6 (subarray [4, -1, 2, 1] has maximum sum)
    - Constraints: Array can be empty, contain negative numbers

Step 2: Identify the approach - Kadane's Algorithm
    - Why: Optimal O(n) solution for maximum subarray problem
    - Why not brute force: Would be O(n²) to check all subarrays
    - Why not divide & conquer: O(n log n) is slower than O(n)

Step 3: Initialize tracking variables
    - max_sum: Track the maximum sum found so far (global maximum)
    - current_sum: Track the sum of current subarray (local maximum)
    - Why: Need to distinguish between current subarray and best found

Step 4: Iterate through array once (O(n) time)
    - For each element, decide: start new subarray or extend current?
    - Decision rule: current_sum = max(num, current_sum + num)
    - Why: If current_sum + num < num, better to start fresh
    - Example: If current_sum = -5 and num = 3, choose 3 over -2

Step 5: Update global maximum at each step
    - max_sum = max(max_sum, current_sum)
    - Why: Need to track best subarray seen across all iterations

Step 6: Return the maximum sum
    - Return max_sum as final answer
    
If Plan Changes:
Plan #2: (Write here if you realize initial plan needs modification)
    - Explain what changed and why the new approach is better
"""

"""
===================================
2. REASONING (Explicit Thought Process)
===================================

Why Kadane's Algorithm?
- Time Complexity: O(n) - single pass through array
- Space Complexity: O(1) - only need two variables
- Optimal: Cannot do better than O(n) since we must look at each element

Why not Dynamic Programming with Array?
- Traditional DP: dp[i] = max(nums[i], dp[i-1] + nums[i])
- Requires O(n) extra space for dp array
- Kadane's optimizes this to O(1) by only tracking current state

Edge Case Reasoning:
1. Empty array: Return 0 (or raise error based on problem spec)
   - Why: No subarray exists in empty array
   
2. All negative numbers: Return the largest (least negative) number
   - Why: Single element subarray is valid
   - Example: [-3, -1, -4] → return -1
   
3. Single element: Return that element
   - Why: The only subarray is the element itself
   
4. All positive numbers: Return sum of entire array
   - Why: Extending subarray always increases sum

Bug Prevention:
- Initialize max_sum to float('-inf') not 0
  - Why: If all numbers are negative, 0 would be wrong answer
  - Example: [-5, -2, -3] should return -2, not 0
"""

"""
===================================
3. CODE CHANGES (Iteration Rules)
===================================

This section shows the evolution of the solution with explanations.
"""

from typing import List

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        """
        Find the contiguous subarray with the largest sum.
        
        Time Complexity: O(n)
        Space Complexity: O(1)
        
        Args:
            nums: List of integers (can include negative numbers)
            
        Returns:
            int: Maximum sum of any contiguous subarray
        """
        
        # ===== ITERATION 1: Initial Attempt (INCORRECT) =====
        # max_sum = 0
        # current_sum = 0
        # for num in nums:
        #     current_sum += num
        #     max_sum = max(max_sum, current_sum)
        # return max_sum
        #
        # Why this is WRONG:
        # 1. Initializing max_sum to 0 fails when all numbers are negative
        #    Example: [-1, -2, -3] would return 0 instead of -1
        # 2. Always adding to current_sum doesn't allow "starting fresh"
        #    Example: [-5, 3] would give -2 instead of 3
        # 3. Doesn't handle empty array edge case
        
        # ===== ITERATION 2: Fixed initialization (PARTIALLY CORRECT) =====
        # if not nums:
        #     return 0
        # max_sum = nums[0]
        # current_sum = 0
        # for num in nums:
        #     current_sum += num
        #     max_sum = max(max_sum, current_sum)
        # return max_sum
        #
        # Why this is STILL WRONG:
        # Still doesn't handle the "start fresh" decision correctly
        # Example: [1, -5, 3] would track: 1, -4, -1 → returns 1
        # But correct answer is 3 (we should start fresh at 3)
        
        # ===== ITERATION 3: Final Correct Solution =====
        # Added proper Kadane's algorithm logic
        
        # Edge case: empty array
        if not nums:
            return 0
        
        # Initialize to negative infinity to handle all-negative arrays
        max_sum = float('-inf')
        current_sum = 0
        
        for num in nums:
            # KEY DECISION: Either start new subarray or extend current
            # This is the core of Kadane's algorithm
            current_sum = max(num, current_sum + num)
            
            # Update global maximum
            max_sum = max(max_sum, current_sum)
        
        return max_sum


"""
===================================
4. TESTING & EDGE CASES
===================================

Test Case Strategy:
- Normal cases: Typical inputs with positive/negative/mixed numbers
- Edge cases: Empty, single element, all negative, all positive
- Boundary cases: Large numbers, maximum array size
"""

def test_solution():
    """
    Comprehensive test suite covering all cases.
    """
    sol = Solution()
    
    print("Running test cases...")
    
    # Test 1: Normal Case - Mixed positive and negative
    # Why: This is the classic example for Kadane's algorithm
    # Expected: Subarray [4, -1, 2, 1] = 6
    test1_input = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    test1_expected = 6
    test1_result = sol.maxSubArray(test1_input)
    assert test1_result == test1_expected, f"Test 1 Failed: Expected {test1_expected}, got {test1_result}"
    print(f"✓ Test 1 Passed: Mixed numbers {test1_input} → {test1_result}")
    
    # Test 2: Normal Case - All positive numbers
    # Why: Should return sum of entire array
    # Expected: 1 + 2 + 3 + 4 = 10
    test2_input = [1, 2, 3, 4]
    test2_expected = 10
    test2_result = sol.maxSubArray(test2_input)
    assert test2_result == test2_expected, f"Test 2 Failed: Expected {test2_expected}, got {test2_result}"
    print(f"✓ Test 2 Passed: All positive {test2_input} → {test2_result}")
    
    # Test 3: Edge Case - All negative numbers
    # Why: Must return the least negative number (single element subarray)
    # Expected: -1 (largest among negatives)
    test3_input = [-3, -1, -4, -2]
    test3_expected = -1
    test3_result = sol.maxSubArray(test3_input)
    assert test3_result == test3_expected, f"Test 3 Failed: Expected {test3_expected}, got {test3_result}"
    print(f"✓ Test 3 Passed: All negative {test3_input} → {test3_result}")
    
    # Test 4: Edge Case - Single element (positive)
    # Why: Subarray is just that element
    # Expected: 5
    test4_input = [5]
    test4_expected = 5
    test4_result = sol.maxSubArray(test4_input)
    assert test4_result == test4_expected, f"Test 4 Failed: Expected {test4_expected}, got {test4_result}"
    print(f"✓ Test 4 Passed: Single positive {test4_input} → {test4_result}")
    
    # Test 5: Edge Case - Single element (negative)
    # Why: Must handle negative single element
    # Expected: -10
    test5_input = [-10]
    test5_expected = -10
    test5_result = sol.maxSubArray(test5_input)
    assert test5_result == test5_expected, f"Test 5 Failed: Expected {test5_expected}, got {test5_result}"
    print(f"✓ Test 5 Passed: Single negative {test5_input} → {test5_result}")
    
    # Test 6: Edge Case - Empty array
    # Why: Must handle empty input gracefully
    # Expected: 0 (or could raise error based on requirements)
    test6_input = []
    test6_expected = 0
    test6_result = sol.maxSubArray(test6_input)
    assert test6_result == test6_expected, f"Test 6 Failed: Expected {test6_expected}, got {test6_result}"
    print(f"✓ Test 6 Passed: Empty array {test6_input} → {test6_result}")
    
    # Test 7: Boundary Case - Two elements (negative then positive)
    # Why: Tests "start fresh" decision
    # Expected: 5 (start fresh at positive number)
    test7_input = [-10, 5]
    test7_expected = 5
    test7_result = sol.maxSubArray(test7_input)
    assert test7_result == test7_expected, f"Test 7 Failed: Expected {test7_expected}, got {test7_result}"
    print(f"✓ Test 7 Passed: Start fresh case {test7_input} → {test7_result}")
    
    # Test 8: Boundary Case - Large numbers
    # Why: Test overflow handling and correctness with large values
    # Expected: 19999 (10000 - 1 + 10000)
    test8_input = [10000, -1, 10000]
    test8_expected = 19999
    test8_result = sol.maxSubArray(test8_input)
    assert test8_result == test8_expected, f"Test 8 Failed: Expected {test8_expected}, got {test8_result}"
    print(f"✓ Test 8 Passed: Large numbers {test8_input} → {test8_result}")
    
    # Test 9: Tricky Case - Alternating positive/negative
    # Why: Tests decision making at each step
    # Expected: 9 (subarray [5, -3, 5, -3, 5])
    test9_input = [5, -3, 5, -3, 5, -10]
    test9_expected = 9  # [5, -3, 5, -3, 5]
    test9_result = sol.maxSubArray(test9_input)
    assert test9_result == test9_expected, f"Test 9 Failed: Expected {test9_expected}, got {test9_result}"
    print(f"✓ Test 9 Passed: Alternating {test9_input} → {test9_result}")
    
    print("\n" + "="*50)
    print("ALL TESTS PASSED! ✓")
    print("="*50)


"""
===================================
5. FINAL SOLUTION (Clean Version)
===================================

Below is the clean, production-ready code without iterations or comments.
This is what you would submit as your final answer.
"""

class SolutionFinal:
    """Clean final solution following all guidelines."""
    
    def maxSubArray(self, nums: List[int]) -> int:
        """
        Find the contiguous subarray with the largest sum using Kadane's Algorithm.
        
        Time Complexity: O(n) - single pass through the array
        Space Complexity: O(1) - constant extra space
        
        Args:
            nums: List of integers
            
        Returns:
            Maximum sum of any contiguous subarray
            
        Example:
            >>> sol = SolutionFinal()
            >>> sol.maxSubArray([-2,1,-3,4,-1,2,1,-5,4])
            6
        """
        if not nums:
            return 0
        
        max_sum = float('-inf')
        current_sum = 0
        
        for num in nums:
            current_sum = max(num, current_sum + num)
            max_sum = max(max_sum, current_sum)
        
        return max_sum


"""
===================================
6. ADDITIONAL CONSTRAINTS
===================================

Checklist for Professional Code:
✓ Clear variable names (max_sum, current_sum, not m, c)
✓ Type hints (List[int], -> int)
✓ Docstrings with examples
✓ Proper indentation (4 spaces)
✓ No unnecessary prints in final solution
✓ Only code inside provided function
✓ Template code unchanged (class name, function signature)
✓ Comments explaining logic
✓ Professional formatting
✓ All edge cases handled
"""


# Main execution
if __name__ == "__main__":
    print("="*50)
    print("PYTHON SOLUTION TEMPLATE DEMONSTRATION")
    print("Following 6 Mandatory Guidelines")
    print("="*50)
    print()
    
    # Run all tests
    test_solution()
    
    print()
    print("This template demonstrates:")
    print("1. ✓ Plan/Approach with step-by-step explanation")
    print("2. ✓ Reasoning for decisions and edge cases")
    print("3. ✓ Code iterations showing improvement")
    print("4. ✓ Comprehensive test cases with explanations")
    print("5. ✓ Clean final solution")
    print("6. ✓ Professional constraints and formatting")
    print()
    print("Use this template as a reference for all quiz problems!")
