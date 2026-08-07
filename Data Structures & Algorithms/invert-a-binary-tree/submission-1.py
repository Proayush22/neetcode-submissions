# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        # if theres no root then return nothing
        if not root:
            return None

        #using a temp variable to swap the values
        temp = root.right
        root.right = root.left
        root.left = temp

        #recursive function which goes to both children then returns root when its done
        self.invertTree(root.left)
        self.invertTree(root.right)

        return root


        
        



