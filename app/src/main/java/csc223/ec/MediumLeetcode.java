package csc223.ec;

//https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/description/

public class MediumLeetcode {
    class Solution {
   

        public int sumEvenGrandparent(TreeNode root) {
            //initialize DFS
            int sum = 0;
            depthFirst(root, null, null);
            return sum; 
        }
    
        public void depthFirst(TreeNode root, Integer parent, Integer grandParent){
            //base case
            if(root == null) return 0;
    
            // if grandparent node is even, add curr nodes value to the sum
            if(grandParent != null){
                if(grandParent % 2 == 0){
                    sum += root.val;
                }
            }
            //recursive call to left and right children
            depthFirst(root.left, root.val, parent);
            depthFirst(root.right, root.val, parent);
        }
    }
}
