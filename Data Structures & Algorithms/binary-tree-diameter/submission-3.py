# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        #this is a variable that is available inside the diameter class, so dfs sees
        self.res = 0
        
        def dfs(curr):
            if not curr:
                return 0

            #the diameter means you want to find which path is greatest which is what this is doing and saves it in the global variable
            right = dfs(curr.right)
            left = dfs(curr.left)
            self.res = max(self.res, right + left)

            #this 
            return (1 + max(right, left))
            
        dfs(root)
        return self.res

        