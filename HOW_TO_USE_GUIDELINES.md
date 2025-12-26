# How to Use the Python Coding Guidelines

## Overview

This repository now includes comprehensive guidelines and templates for solving Python quiz problems following 6 mandatory principles that demonstrate professional coding practices and clear thinking.

## Files Included

### 1. `PYTHON_CODING_GUIDELINES.md`
**Purpose:** Complete reference guide explaining all 6 principles in detail.

**When to use:** 
- Read this first to understand the philosophy behind each guideline
- Reference when you need detailed examples of each principle
- Review before important coding assessments

**What's inside:**
- Detailed explanation of each of the 6 guidelines
- Multiple examples for each principle
- Common pitfalls to avoid
- Best practices for professional code

---

### 2. `python_solution_template.py`
**Purpose:** Fully worked example demonstrating ALL 6 principles in action.

**When to use:**
- Study this to see how a complete solution should look
- Run it to see the test suite in action (`python3 python_solution_template.py`)
- Use as inspiration when structuring your own solutions

**What's inside:**
- Complete solution to "Maximum Subarray Sum" problem
- All 6 principles demonstrated with extensive comments
- Code iteration examples showing bug fixes
- Comprehensive test suite with 9 test cases
- Both development version (with iterations) and clean final version

**Features:**
- ✅ Executable - runs and passes all tests
- ✅ Well-commented - explains every decision
- ✅ Shows iteration - demonstrates fixing bugs
- ✅ Comprehensive tests - covers all edge cases

---

### 3. `QUICK_REFERENCE_TEMPLATE.py`
**Purpose:** Copy-paste template you can fill in for your specific problem.

**When to use:**
- Copy this file when starting a new problem
- Fill in the bracketed sections `[...]` with your specific solution
- Use as a checklist to ensure you haven't missed any guidelines

**What's inside:**
- Skeleton structure with all 6 sections
- Placeholders for you to fill in
- Comments guiding what to write in each section
- Pre-submission checklist

**How to use:**
```bash
# Copy the template for your new problem
cp QUICK_REFERENCE_TEMPLATE.py my_new_problem.py

# Edit and fill in your solution
# Follow the comments and replace [...] with your code
```

---

## The 6 Mandatory Guidelines

### Quick Summary

1. **Plan/Approach** - Always start with step-by-step plan in comments
2. **Reasoning** - Explain why you made key decisions
3. **Code Changes** - Show iterations; comment out old code and explain fixes
4. **Testing & Edge Cases** - Write explicit test cases with explanations
5. **Final Solution** - Clean, executable code inside provided function
6. **Additional Constraints** - Professional formatting, no shortcuts

---

## Workflow: How to Solve a Problem

### Step 1: Read the Problem
- Understand input/output format
- Identify constraints
- Note edge cases

### Step 2: Plan Your Approach
- Write out steps in comments (Guideline #1)
- Think through the algorithm before coding
- Include example inputs/outputs for each step

### Step 3: Explain Your Reasoning
- Document why you chose this approach (Guideline #2)
- Compare with alternatives
- Note time/space complexity

### Step 4: Write Initial Code
- Implement your planned solution
- Add comments explaining logic

### Step 5: Test & Debug
- Write test cases for normal and edge cases (Guideline #4)
- If bugs found, comment out old code and explain fix (Guideline #3)
- Show your iteration process

### Step 6: Create Final Clean Version
- Write production-ready code (Guideline #5)
- Follow professional standards (Guideline #6)
- Verify all edge cases handled

---

## Example Usage

### Scenario: You're given a new problem

1. **Start with the Quick Reference Template:**
```bash
cp QUICK_REFERENCE_TEMPLATE.py problem_name.py
```

2. **Fill in the Plan section:**
```python
"""
Step 1: Parse input and identify pattern
    - Why: Need to understand structure
    - Example: input [1,2,3] -> all positive
    
Step 2: Choose algorithm (e.g., sliding window)
    - Why: O(n) time complexity is optimal
    - Example: window [1,2], [2,3]
"""
```

3. **Add Reasoning:**
```python
"""
Why sliding window?
- Linear time O(n) vs brute force O(n²)
- Space efficient O(1)

Edge cases:
- Empty array -> return 0
- Single element -> return element
"""
```

4. **Implement and Test:**
```python
# Write code, then test cases
def test_solution():
    sol = Solution()
    assert sol.function([1,2,3]) == 6
    # ... more tests
```

5. **If you find a bug, show iteration:**
```python
# Iteration 1: WRONG
# result = sum(nums)  
# Why wrong: Doesn't handle negatives

# Iteration 2: CORRECT
result = max(sum(nums), 0)
```

---

## Running the Examples

### Test the complete example:
```bash
python3 python_solution_template.py
```

**Expected output:**
```
==================================================
PYTHON SOLUTION TEMPLATE DEMONSTRATION
Following 6 Mandatory Guidelines
==================================================

Running test cases...
✓ Test 1 Passed: Mixed numbers [-2, 1, -3, 4, -1, 2, 1, -5, 4] → 6
✓ Test 2 Passed: All positive [1, 2, 3, 4] → 10
...
✓ All tests passed!
```

---

## Tips for Success

### DO:
✅ Start every solution with a plan  
✅ Explain your reasoning clearly  
✅ Show your work when debugging  
✅ Write comprehensive test cases  
✅ Use meaningful variable names  
✅ Add type hints  
✅ Handle all edge cases  
✅ Write clean, professional code  

### DON'T:
❌ Skip the planning phase  
❌ Change code without explanation  
❌ Ignore edge cases  
❌ Use unclear variable names (i, j without context)  
❌ Submit without testing  
❌ Leave unnecessary print statements  
❌ Modify template code (class/function names)  

---

## Checklist Before Submission

Use this checklist for every problem:

- [ ] **Plan written** at the top in comments
- [ ] **Steps explained** with why and examples
- [ ] **Reasoning documented** for key decisions
- [ ] **Edge cases identified** and handled
- [ ] **Iterations shown** if code was fixed
- [ ] **Test cases written** with explanations
- [ ] **All tests passing**
- [ ] **Code is clean** and in provided function
- [ ] **Template unchanged** (class/function names)
- [ ] **Professional formatting** applied
- [ ] **Type hints added**
- [ ] **Docstring included**
- [ ] **No unnecessary prints**

---

## Common Patterns

### Pattern 1: Array Problems
- Plan: Identify if sliding window, two pointers, or DP
- Edge cases: Empty, single element, all same values
- Test: Positive, negative, mixed, boundaries

### Pattern 2: String Problems  
- Plan: Hash map, two pointers, or sliding window
- Edge cases: Empty string, single char, all same chars
- Test: Normal cases, special characters, case sensitivity

### Pattern 3: Dynamic Programming
- Plan: Define state, transition, base cases
- Edge cases: Minimum input, maximum input
- Test: Simple cases first, then complex

### Pattern 4: Tree/Graph Problems
- Plan: BFS vs DFS, recursive vs iterative
- Edge cases: Empty tree, single node, unbalanced
- Test: Balanced, unbalanced, edge cases

---

## Additional Resources

### In this repository:
- `PYTHON_CODING_GUIDELINES.md` - Full detailed guide
- `python_solution_template.py` - Complete worked example
- `QUICK_REFERENCE_TEMPLATE.py` - Copy-paste template

### Recommended reading:
- PEP 8 - Python Style Guide
- PEP 257 - Docstring Conventions
- Algorithm design patterns
- Time/Space complexity analysis

---

## Questions?

If you're unsure about any guideline:
1. Read the detailed section in `PYTHON_CODING_GUIDELINES.md`
2. Study the example in `python_solution_template.py`
3. Use the template in `QUICK_REFERENCE_TEMPLATE.py`

Remember: These guidelines show evaluators that you're a **thorough, professional, and thoughtful problem solver**. Follow them consistently!

---

## Summary

**Goal:** Write solutions that demonstrate clear thinking, professionalism, and attention to detail.

**Method:** Follow the 6 guidelines systematically using the provided templates.

**Result:** High-quality, well-tested, professional code that stands out in evaluations.

Good luck with your coding quizzes! 🚀
