"""
QUICK REFERENCE: Python Quiz Solution Template
================================================

Copy this template and fill in the sections for your specific problem.
This ensures you follow all 6 mandatory guidelines.
"""

"""
===================================
1. PLAN / APPROACH
===================================

Step 1: [Describe what you'll do first]
    - Why: [Explain reasoning]
    - Example: [Show input/output for this step]

Step 2: [Next step]
    - Why: [Reasoning]
    - Example: [Input/output]

Step 3: [Continue...]
    - Why: [Reasoning]
    - Example: [Input/output]

[Add more steps as needed]

Step N: Return result
    - Why: [Final reasoning]
    - Example: [Expected output]

If Plan Changes:
Plan #2: [Explain what changed and why]
"""

"""
===================================
2. REASONING
===================================

Why this approach?
- [Explain your algorithm choice]
- [Compare with alternatives]
- Time Complexity: O(?)
- Space Complexity: O(?)

Why not [Alternative Approach]?
- [Explain why you rejected it]

Edge Case Handling:
1. [Edge case 1]: [How you handle it and why]
2. [Edge case 2]: [How you handle it and why]
3. [Edge case 3]: [How you handle it and why]

Key Decisions:
- [Decision 1]: [Why this choice?]
- [Decision 2]: [Why this choice?]
"""

"""
===================================
3. CODE CHANGES (Show iterations if applicable)
===================================

If this is your first attempt, write it clean.
If you need to fix bugs, show iterations:

# Iteration 1: [INCORRECT/INCOMPLETE]
# [old code here]
# Why this was wrong: [Explanation]

# Iteration 2: [CORRECT]
# [new code here]
# Why this is better: [Explanation]
"""

from typing import List, Optional  # Import types as needed

class Solution:
    def problemFunction(self, param1: List[int], param2: int) -> int:
        """
        [Brief description of what this function does]
        
        Time Complexity: O(?)
        Space Complexity: O(?)
        
        Args:
            param1: [Description of first parameter]
            param2: [Description of second parameter]
            
        Returns:
            [Description of return value]
            
        Example:
            >>> sol = Solution()
            >>> sol.problemFunction([1, 2, 3], 5)
            [expected output]
        """
        
        # Edge case: [Handle edge case 1]
        if not param1:
            return 0  # or appropriate default
        
        # Edge case: [Handle edge case 2]
        if param2 < 0:
            return -1  # or appropriate handling
        
        # Initialize variables
        # [Explain what each variable tracks]
        result = 0
        
        # Main algorithm logic
        # [Add comments explaining each section]
        for item in param1:
            # [Explain what happens in this iteration]
            pass
        
        # Return final result
        return result


"""
===================================
4. TESTING & EDGE CASES
===================================

Test Cases:
"""

def test_solution():
    """
    Comprehensive test suite.
    """
    sol = Solution()
    
    # Test 1: Normal Case - [Description]
    # Why: [Explain purpose of this test]
    # Expected: [What should happen]
    input1 = [...]
    expected1 = ...
    result1 = sol.problemFunction(input1, ...)
    assert result1 == expected1, f"Test 1 Failed: got {result1}, expected {expected1}"
    print(f"✓ Test 1 Passed: {input1} → {result1}")
    
    # Test 2: Edge Case - Empty input
    # Why: Must handle empty gracefully
    # Expected: [Default value]
    input2 = []
    expected2 = 0
    result2 = sol.problemFunction(input2, ...)
    assert result2 == expected2, f"Test 2 Failed: got {result2}, expected {expected2}"
    print(f"✓ Test 2 Passed: Empty input → {result2}")
    
    # Test 3: Edge Case - Single element
    # Why: Minimum valid input
    # Expected: [Result]
    input3 = [1]
    expected3 = ...
    result3 = sol.problemFunction(input3, ...)
    assert result3 == expected3, f"Test 3 Failed: got {result3}, expected {expected3}"
    print(f"✓ Test 3 Passed: Single element → {result3}")
    
    # Test 4: Boundary Case - [Description]
    # Why: [Explain]
    # Expected: [Result]
    input4 = ...
    expected4 = ...
    result4 = sol.problemFunction(input4, ...)
    assert result4 == expected4, f"Test 4 Failed: got {result4}, expected {expected4}"
    print(f"✓ Test 4 Passed: {input4} → {result4}")
    
    # Add more tests as needed...
    
    print("\n✓ All tests passed!")


"""
===================================
5. FINAL SOLUTION (Clean Version)
===================================

Copy your final, clean solution here without iteration comments.
"""

class SolutionFinal:
    def problemFunction(self, param1: List[int], param2: int) -> int:
        """Clean final solution with minimal comments."""
        
        # Edge cases
        if not param1:
            return 0
        
        # Initialize
        result = 0
        
        # Main logic
        for item in param1:
            # Core algorithm
            pass
        
        return result


"""
===================================
6. CHECKLIST (Before Submission)
===================================

Professional Code Checklist:
□ Meaningful variable names (not x, y, i without context)
□ Type hints for function parameters and return
□ Docstring with description and example
□ Proper indentation (4 spaces)
□ Comments explaining key logic sections
□ No unnecessary print statements in final code
□ Code only inside provided function
□ Template code (class name, function name) unchanged
□ All edge cases handled
□ Test cases written and passing
"""

# Main execution
if __name__ == "__main__":
    print("="*60)
    print("QUICK REFERENCE TEMPLATE")
    print("="*60)
    print()
    print("This is a TEMPLATE file - not meant to be run directly!")
    print()
    print("To use this template:")
    print("1. Copy this file: cp QUICK_REFERENCE_TEMPLATE.py my_problem.py")
    print("2. Replace all [...] placeholders with your actual code")
    print("3. Fill in the Plan, Reasoning, and Test sections")
    print("4. Implement your solution in the Solution class")
    print("5. Run your customized file")
    print()
    print("For a working example, run: python3 python_solution_template.py")
    print("="*60)
    
    # Uncomment the line below after filling in your solution
    # test_solution()
