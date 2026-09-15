# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        #if both the tree nodes are empty
        if not p and not q:
            return True
        #if only one of them are empty, then they aren't the same
        if not p or not q:
            return False
        #if they are not the same value
        if p.val != q.val:
            return False
        #this will recursively check the children, if the children are good then it will return true otherwise false
        left = self.isSameTree(p.left, q.left)
        right = self.isSameTree(p.right, q.right)
        if left and right:
            return True
        else:
            return False