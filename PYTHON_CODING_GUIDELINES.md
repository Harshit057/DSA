# Python Coding Guidelines for Quiz Solutions

This document outlines the mandatory guidelines for solving Python quiz problems. Following these principles ensures clarity, professional quality, and demonstrates strong problem-solving skills.

---

## 1. Plan / Approach (Mandatory)

**Always start with a clearly written Plan/Approach in comments.**

### Requirements:
- The plan must be **step-by-step**
- Explain **what** will be done and **why**
- Include **example inputs and outputs** for each step where useful
- If the initial plan changes, write a new **"Plan #2"** explaining the improvement

### Example:
```python
"""
Plan / Approach:
Step 1: Parse the input array and identify constraints
    - Why: Need to understand the data structure and bounds
    - Example: nums = [1, 2, 3, 4] -> len = 4, all positive integers

Step 2: Initialize variables for tracking (e.g., max_sum, current_sum)
    - Why: Dynamic programming requires state tracking
    - Example: max_sum = 0, current_sum = 0

Step 3: Iterate through the array once
    - Why: O(n) time complexity is optimal for this problem
    - Example: For each num in [1, 2, 3, 4], update current_sum

Step 4: Apply the core algorithm logic at each step
    - Why: This is where the main solution logic resides
    - Example: current_sum = max(num, current_sum + num)

Step 5: Return the final result
    - Why: This is the answer to the problem
    - Example: Return max_sum = 10
"""
```

---

## 2. Reasoning (Explicit Thought Process)

**Explain the reasoning behind important decisions, logic choices, and edge-case handling.**

### Requirements:
- Clearly explain **why** you chose a specific approach (e.g., why DP over recursion)
- When debugging or fixing an issue, explain:
  - What was **wrong**
  - How it is being **fixed**
  - Write this explanation **before** writing new code

### Example:
```python
"""
Reasoning:
- Using Dynamic Programming instead of Recursion:
  Why: DP with memoization avoids recalculating overlapping subproblems,
       reducing time complexity from O(2^n) to O(n).

- Choosing a hash map for frequency counting:
  Why: O(1) lookup time for checking if an element exists.
       Alternative (list): Would require O(n) search time.

- Edge case handling for empty array:
  Why: The problem states array can be empty, so we return 0 early
       to avoid index errors.
"""
```

---

## 3. Code Changes (Iteration Rules)

**NEVER modify code silently. Show your work and iterations.**

### Requirements:
- Do **NOT** modify code without explanation
- If changes are needed:
  1. **Comment out** the previous code
  2. Add a comment explaining **why it was incorrect**
  3. Write the **corrected version** below it
- This clearly shows iterations and improvement

### Example:
```python
def solution(nums):
    # Iteration 1: Initial approach (INCORRECT)
    # result = sum(nums) / len(nums)
    # Why incorrect: This gives average, not the maximum subarray sum
    
    # Iteration 2: Kadane's Algorithm (CORRECT)
    # Reasoning: We need maximum subarray sum, not average
    # Kadane's algorithm tracks current_sum and max_sum
    
    max_sum = float('-inf')
    current_sum = 0
    
    for num in nums:
        # Iteration 1: Had bug here
        # current_sum += num
        # Why incorrect: Didn't handle case where starting fresh is better
        
        # Iteration 2: Fixed version
        current_sum = max(num, current_sum + num)
        max_sum = max(max_sum, current_sum)
    
    return max_sum
```

---

## 4. Testing & Edge Cases

**Add explicit test cases for normal cases and edge cases.**

### Requirements:
- Include test cases for:
  - **Normal cases** (typical inputs)
  - **Edge cases** (empty input, boundary values, etc.)
- **Explain why** each test case exists
- **Double-check** logic to ensure it would pass hidden test cases

### Example:
```python
"""
Test Cases:

1. Normal Case - Positive Numbers:
   Input: nums = [1, 2, 3, 4]
   Expected Output: 10
   Why: Tests basic functionality with all positive numbers

2. Normal Case - Mixed Positive/Negative:
   Input: nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
   Expected Output: 6
   Why: Tests Kadane's algorithm with mixed numbers
   Subarray: [4, -1, 2, 1] = 6

3. Edge Case - All Negative Numbers:
   Input: nums = [-3, -1, -4, -2]
   Expected Output: -1
   Why: When all negative, return the least negative number

4. Edge Case - Single Element:
   Input: nums = [5]
   Expected Output: 5
   Why: Array with one element should return that element

5. Edge Case - Empty Array:
   Input: nums = []
   Expected Output: 0 (or handle based on problem requirements)
   Why: Must handle empty input gracefully

6. Boundary Case - Large Numbers:
   Input: nums = [10000, -1, 10000]
   Expected Output: 19999
   Why: Tests overflow handling and large value processing
"""

# Actual test execution
def test_solution():
    sol = Solution()
    
    # Test 1: Normal case - positive numbers
    assert sol.maxSubArray([1, 2, 3, 4]) == 10, "Test 1 Failed"
    
    # Test 2: Normal case - mixed
    assert sol.maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4]) == 6, "Test 2 Failed"
    
    # Test 3: Edge case - all negative
    assert sol.maxSubArray([-3, -1, -4, -2]) == -1, "Test 3 Failed"
    
    # Test 4: Edge case - single element
    assert sol.maxSubArray([5]) == 5, "Test 4 Failed"
    
    # Test 5: Edge case - empty array
    assert sol.maxSubArray([]) == 0, "Test 5 Failed"
    
    # Test 6: Boundary case - large numbers
    assert sol.maxSubArray([10000, -1, 10000]) == 19999, "Test 6 Failed"
    
    print("All tests passed!")
```

---

## 5. Final Solution

**The final answer must contain clean, executable Python code.**

### Requirements:
- Clean and **well-formatted** code
- **No unnecessary prints** (unless explicitly for testing)
- Code written **only inside the provided function**
- **Do not alter** template code (e.g., class name, function signature)
- Follow **Python conventions** (PEP 8 style guide)

### Example:
```python
class Solution:
    def maxSubArray(self, nums):
        """
        Find the contiguous subarray with the largest sum.
        
        Args:
            nums (List[int]): Array of integers
            
        Returns:
            int: Maximum subarray sum
        """
        # Handle edge case: empty array
        if not nums:
            return 0
        
        # Initialize tracking variables
        max_sum = float('-inf')
        current_sum = 0
        
        # Apply Kadane's Algorithm
        for num in nums:
            # Either start fresh from current num or continue subarray
            current_sum = max(num, current_sum + num)
            # Update global maximum
            max_sum = max(max_sum, current_sum)
        
        return max_sum
```

---

## 6. Additional Constraints

**Professional, evaluator-friendly code.**

### Requirements:
- **No skipping steps** - Follow all guidelines
- **Clear comments** before each logical section
- **No internet-style shortcuts** (e.g., avoid unclear variable names like `i`, `j` without context)
- **Careful handling** of corner cases
- **Professional formatting**:
  - Proper indentation (4 spaces)
  - Meaningful variable names
  - Type hints where appropriate
  - Docstrings for functions

### Example of Professional Code:
```python
from typing import List

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        """
        Calculate the maximum sum of a contiguous subarray using Kadane's Algorithm.
        
        Time Complexity: O(n) - single pass through array
        Space Complexity: O(1) - constant extra space
        
        Args:
            nums: List of integers (can be positive, negative, or zero)
            
        Returns:
            Maximum sum of any contiguous subarray
            
        Example:
            >>> solution = Solution()
            >>> solution.maxSubArray([-2,1,-3,4,-1,2,1,-5,4])
            6
        """
        # Edge case: empty array
        if not nums:
            return 0
        
        # Initialize maximum sum seen so far
        max_sum = float('-inf')
        
        # Track current running sum
        current_sum = 0
        
        # Iterate through array once
        for num in nums:
            # Decision: start new subarray or extend current one
            current_sum = max(num, current_sum + num)
            
            # Update global maximum if current sum is larger
            max_sum = max(max_sum, current_sum)
        
        return max_sum
```

---

## Summary Checklist

Before submitting your solution, ensure:

- [ ] **Plan/Approach** is written at the top in comments
- [ ] **Step-by-step** explanation with examples is included
- [ ] **Reasoning** for key decisions is documented
- [ ] **Edge cases** are identified and handled
- [ ] **Code iterations** are shown (if applicable) with explanations
- [ ] **Test cases** are written and explain their purpose
- [ ] **Final code** is clean, executable, and inside the function
- [ ] **No template code** is altered
- [ ] **Professional formatting** is applied
- [ ] All **corner cases** are handled

---

## Quick Reference Template

Use this template as a starting point for any problem:

```python
"""
PLAN / APPROACH:
Step 1: [Describe first step]
    - Why: [Reason]
    - Example: [Input/Output]

Step 2: [Describe second step]
    - Why: [Reason]
    - Example: [Input/Output]

[Continue for all steps...]

REASONING:
- [Key decision 1]: Why this approach?
- [Key decision 2]: Why not alternative?
- [Edge case handling]: How are we addressing this?

TEST CASES:
1. Normal: [Input] -> [Output] - [Why]
2. Edge: [Input] -> [Output] - [Why]
3. Boundary: [Input] -> [Output] - [Why]
"""

from typing import List

class Solution:
    def functionName(self, param: List[int]) -> int:
        """
        [Brief description of what function does]
        
        Time Complexity: O(?)
        Space Complexity: O(?)
        """
        # Edge case handling
        if not param:
            return 0
        
        # Initialize variables
        
        # Main algorithm logic
        
        # Return result
        return result

# Test cases
def test_solution():
    sol = Solution()
    # Test 1: [Description]
    assert sol.functionName([...]) == expected
    print("All tests passed!")

if __name__ == "__main__":
    test_solution()
```

---

## Remember

This is not just about solving the problem—it's about **demonstrating your thought process, professionalism, and attention to detail**. Follow these guidelines to show evaluators that you are a thorough, careful, and skilled problem solver.
