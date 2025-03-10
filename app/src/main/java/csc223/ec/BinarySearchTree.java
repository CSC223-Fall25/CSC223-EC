package csc223.ec;

public class BinarySearchTree {

    IntTreeNode root;

    class IntTreeNode {
        IntTreeNode left;
        IntTreeNode right;
        int data;

        public IntTreeNode(int data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }
    
    public BinarySearchTree(int data) {
        this.root = new IntTreeNode(data);
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public String inorder() {
        String valuesString = new String();
        return this.inorder(this.root, valuesString).trim();
    }

    private String inorder(IntTreeNode currNode, String valuesString) {
        if (currNode == null) {
            return valuesString;
        }

        //recursive call in the order or left, currnode, then right
        valuesString = inorder(currNode.left, valuesString);

        valuesString += currNode.data + " ";

        valuesString = inorder(currNode.right, valuesString);

        return valuesString;
    }

    public void insert(int item) {
        if (this.isEmpty()) {
            IntTreeNode newNode = new IntTreeNode(item);
            this.root = newNode;
        }
        insert(item, this.root);
    }

    private void insert(int item, IntTreeNode currNode) {
        IntTreeNode newNode = new IntTreeNode(item);
        //go leftif greater
        if (currNode.data >= item) {
            if (currNode.left == null) {
                currNode.left = newNode;
                return;
            }
            insert(item, currNode.left);
        }
        //go right if smaller
        else {
            if (currNode.right == null) {
                currNode.right = newNode;
                return;
            }
            insert(item, currNode.right);
        }

    }

    public IntTreeNode findmax(IntTreeNode currNode) {
        if (currNode.right == null) {
            return currNode;
        }
        return findmax(currNode.right);
    }

    public IntTreeNode findmin(IntTreeNode currNode) {
        if (currNode.left == null) {
            return currNode;
        }
        return findmin(currNode.left);
    }

    public void delete(int value) {
    // If the tree is empty, return the tree.
    if (this.isEmpty()) {
        return;
    }
    this.root = deleteHelper(value, this.root);
    }

    private IntTreeNode deleteHelper(int value, IntTreeNode currNode) {
        if (currNode == null) {
            return null;
        }
    // If the value of the node to be deleted is less than the value of the current node, move to the left subtree.
        if (value < currNode.data) {
            currNode.left = deleteHelper(value, currNode.left);
        }
    // If the value of the node to be deleted is greater than the value of the current node, move to the right subtree.
        else  if (value > currNode.data) {
            currNode.right = deleteHelper(value, currNode.right);
        }
    // If the value of the node to be deleted is equal to the value of the current node, delete the node.
        else {
            // If the node has no children, simply delete the node.
            if (currNode.left == null && currNode.right == null) {
                return null;
            }
            // If the node has one child, replace the node with its child.
            else if (currNode.left == null && currNode.right != null) {
                return currNode.right;
            }
            else if (currNode.right == null && currNode.left != null) {
                return currNode.left;
            }
            // If the node has two children, find the inorder successor of the node, 
            // replace the node with the inorder successor, and delete the inorder successor.
            // The inorder successor is the smallest node in the right subtree of the node to be deleted.
            else {
                IntTreeNode successorNode = findmin(currNode.right);
                currNode.data = successorNode.data;
                currNode.right = deleteHelper(successorNode.data, currNode.right);
            }
        }
        return currNode;
    }

    public void update(int oldData, int newData) {
        delete(oldData);
        insert(newData);
    }

    public boolean search(int data) {
        return searchHelper(data, this.root);
    }

    private boolean searchHelper(int data, IntTreeNode currNode) {
        //binary search
        if (currNode == null) {
            return false;
        }
        else if (currNode.data == data) {
            return true;
        }
        else if (data > currNode.data) {
            return searchHelper(data, currNode.right);
        }
        else {
            return searchHelper(data, currNode.left);
        }
    }

    public IntTreeNode sortedArrayToBST(int[] values) {
        for (int i=0;i<values.length;i++) {
            insert(values[i]);
        }
        return this.root;
    }

    public int lowestCommonAncestor(int p, int q) {
        return lowestCommonAncestorHelper(p, q, this.root);
    }

    private int lowestCommonAncestorHelper(int p, int q, IntTreeNode currNode) {
        if (currNode == null) {
            return -1;
        }
        //go left
        else if (currNode.data > p && currNode.data > q) {
            return lowestCommonAncestorHelper(p, q, currNode.left);
        }
        //go right
        else if (currNode.data < p && currNode.data < q) {
            return lowestCommonAncestorHelper(p, q, currNode.right);
        }
        //found it
        else {
            return currNode.data;
     }

    }
}
