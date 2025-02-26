package csc223.ec;

public class BinaryTree implements Tree {

    TreeNode root;

    public BinaryTree(char data) {
        this.root = new TreeNode(data);
    }

    /** Get the level order traversal of the tree
    *
    * For example, the level order traversal of the following tree:
    *
    *    A
    *   / \
    *  B   C
    *
    * is "ABC"
    */
   public String levelorder() {
    String treeString = new String();

    // Create a queue and enqueue the root node.
    TreeNodeArrayQueue queue = new TreeNodeArrayQueue();
    queue.enqueue(this.root);

    // While the queue is not empty:

   TreeNode currNode = null;

    while (!queue.isEmpty()) {

        // 2.1. Dequeue a node from the queue.
        currNode = queue.dequeue();

        // 2.2. Process the node (e.g., print its value).
        treeString += currNode.data;

    // 2.3. Enqueue the left child of the node if it exists.
        if (currNode.left != null) {
            queue.enqueue(currNode.left);
        }

    // 2.4. Enqueue the right child of the node if it exists.
        if (currNode.right != null) {
            queue.enqueue(currNode.right);
        }
    }
        return treeString;
   }


   /** Get the preorder traversal of the tree: root -> left -> right
    *
    * For example, the preorder traversal of the following tree:
*
    *     A
    *    / \
    *  B   C
    * / \
    * D E
    *
    * is "ABDEC"
    */
    public String preorder() {
        TreeNode currNode = this.root;
        String valuesString = new String();

        return preorderHelper(currNode, valuesString);

    }

    private String preorderHelper(TreeNode currNode, String valuesString) {
        if (currNode == null) {
            return valuesString;
        }

        //add data to string
        valuesString += currNode.data;
        //visit left side
        valuesString = preorderHelper(currNode.left, valuesString);
        //visit right side
        valuesString = preorderHelper(currNode.right, valuesString);

        return valuesString;
        
    }


    /** Get the inorder traversal of the tree: left -> root -> right
     *
     * For example, the inorder traversal of the following tree:
     *
     *        A
     *       / \
     *      B   C
     *     / \
     *    D   E
     *
     * is "DBEAC"
     */
    public String inorder() {
        String valuesString = new String();
        return this.inorder(this.root, valuesString);
    }

    private String inorder(TreeNode currNode, String valuesString) {
        if (currNode == null) {
            return valuesString;
        }

        //recursive call in the order or left, currnode, then right
        valuesString = inorder(currNode.left, valuesString);

        valuesString += currNode.data;

        valuesString = inorder(currNode.right, valuesString);

        return valuesString;
    }
 
 
    /**
     * Get the postorder traversal of the tree:
     *  left -> right -> root
     *
     * For example, the postorder traversal of the following tree:
     *
     *      A
     *     / \
     *   B   C
     *  / \
     *  D E
     *
     * is "DEBCA"
     */
    public String postorder() {
        String valueString = new String();
        return postorder(this.root, valueString);
    }

    private String postorder(TreeNode currNode, String valuesString) {
        if (currNode == null) {
            return valuesString;
        }

        //recursive call in order of left, right, currNode
        valuesString = postorder(currNode.left, valuesString);

        valuesString = postorder(currNode.right, valuesString);

        valuesString += currNode.data;

        return valuesString;

    }
 
 
    /**
     * Insert an item into the tree,
     * using level order traversal to find the correct position
     * If the tree is empty, insert the item at the root node.
     */
    public void insert(char item) {
        // Create a new node with the given value.
        TreeNode newNode = new TreeNode(item);

        // If the root is null, set the new node as the root.
        if (this.root == null) {
            this.root = newNode;
        }
        // Else, perform a level order traversal to find the first node that has an empty left or right child.
        else {

            TreeNode currNode = null;

            TreeNodeArrayQueue queue = new TreeNodeArrayQueue();
            queue.enqueue(this.root);

            while (!queue.isEmpty()) {

                currNode = queue.dequeue();

            // 2.3. Enqueue the left child of the node if it exists.
                if (currNode.left != null) {
                    queue.enqueue(currNode.left);
                }

                else {
                    currNode.left = newNode;
                    return;
                }

            // 2.4. Enqueue the right child of the node if it exists.
                if (currNode.right != null) {
                    queue.enqueue(currNode.right);
                }
                
                else {
                    currNode.right = newNode;
                    return;
                }
            }
            
        }
    }
 
 
    // Check if the tree contains an item
    public boolean search(char item) {
        return this.search(item, this.root, false);
    }

    private boolean search(char item, TreeNode currNode, boolean found) {
        if (currNode == null) {
            return false;
        }
        else if (currNode.data == item) {
            return true;
        }

        return (this.search(item, currNode.left, found) || this.search(item, currNode.right, found) == true);
    }
 
 
    // Get the number of nodes in the tree
    public int size() {
        return size(this.root, 0);
    }

    private int size(TreeNode currNode, int count) {
        if (currNode == null) {
            return count;
        }

        count+= 1;
        count = size(currNode.left, count);
        count = size(currNode.right, count);
        return count;
    }
 
 
    // Check if the tree is empty
    public boolean isEmpty() {
        return this.root == null;
    }
 
 
    // Get the height of the tree (number of nodes along the longest path from the root node down to the farthest leaf node)
    public int height() {
        return this.height(this.root);
    }

    private int height(TreeNode currNode) {
        if (currNode == null) {
            return 0;
        }

        //recursive call for the left and right side of the tree
        int leftHeight = this.height(currNode.left);
        int rightHeight = this.height(currNode.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BinaryTree testTree2 = new BinaryTree('A');

        testTree2.insert('B');
        testTree2.insert('C');
        testTree2.insert('D');
        testTree2.insert('E');

        System.out.println(testTree2.search('C'));
    }
}
