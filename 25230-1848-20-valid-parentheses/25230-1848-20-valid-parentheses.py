class Solution:
    def isValid(self, s):
        # Dictionary to map closing brackets to opening brackets
        bracket_map = {')': '(', '}': '{', ']': '['}
        
        # Stack to keep track of opening brackets
        stack = []
        
        for char in s:
            # If it's a closing bracket, check for validity
            if char in bracket_map:
                # Pop from the stack if possible, else use a dummy value
                top_element = stack.pop() if stack else '#'
                
                # If the popped element doesn't match the expected opening bracket, return False
                if bracket_map[char] != top_element:
                    return False
            else:
                # If it's an opening bracket, push it onto the stack
                stack.append(char)
        
        # If the stack is empty, all brackets are matched
        return not stack
