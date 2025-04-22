package csc223.ec;

//https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/description/

public class MediumLeetcode {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val; 
        }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        private int sum;

        public int sumEvenGrandparent(TreeNode root) {
            //initialize DFS
            sum = 0;
            if (root != null) {
                depthFirst(root.left, root, null);
                depthFirst(root.right, root, null);
            }
           
            return sum; 
        }
    
        public void depthFirst(TreeNode current, TreeNode parent, TreeNode grandParent){
            //base case
            if (current == null) return;
    
            // if grandparent node is even, add curr nodes value to the sum
            if (grandParent != null && grandParent.val % 2 == 0){
                this.sum += current.val;
            }
            //recursive call to left and right children
            depthFirst(current.left, current, parent);
            depthFirst(current.right, current, parent);
        }
    }
}
