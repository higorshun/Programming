class TreeNode {
    int item;        // The data in this node.
    TreeNode left;   // Pointer to the left subtree.
    TreeNode right;  // Pointer to the right subtree.

    public TreeNode(int item, TreeNode left, TreeNode right) {
        this.item = item;
        this.left = left;
        this.right = right;
    }


    /**
     * Count the nodes in the binary tree to which root points, and
     * return the answer.  If root is null, the answer is zero.
     */
    static int countNodes(TreeNode root) {
        if (root == null)
            return 0;  // The tree is empty.  It contains no nodes.
        else {
            int count = 1;   // Start by counting the root.
            count += countNodes(root.left);  // Add the number of nodes
            //     in the left subtree.
            count += countNodes(root.right); // Add the number of nodes
            //    in the right subtree.
            return count;  // Return the total.
        }
    } // end countNodes()

    /**
     * Print all the items in the tree to which root points.
     * The item in the root is printed first, followed by the
     * items in the left subtree and then the items in the
     * right subtree.
     */
    static void preorderPrint(TreeNode root) {
        if (root != null) {  // (Otherwise, there's nothing to print.)
            System.out.print(root.item + " ");  // Print the root item.
            preorderPrint(root.left);   // Print items in left subtree.
            preorderPrint(root.right);  // Print items in right subtree.
        }
    } // end preorderPrint()

    /**
     * Print all the items in the tree to which root points.
     * The items in the left subtree are printed first, followed
     * by the items in the right subtree and then the item
     * in the root node.
     */
    static void postorderPrint(TreeNode root) {
        if (root != null) {  // (Otherwise, there's nothing to print.)
            postorderPrint(root.left);   // Print items in left subtree.
            postorderPrint(root.right);  // Print items in right subtree.
            System.out.print(root.item + " ");  // Print the root item.
        }
    } // end postorderPrint()

    /**
     * Print all the items in the tree to which root points.
     * The items in the left subtree are printed first, followed
     * by the item in the root node and then the items
     * in the right subtree.
     */


    static void inorderPrint(TreeNode root) {
        if (root != null) {  // (Otherwise, there's nothing to print.)
            inorderPrint(root.left);   // Print items in left subtree.
            System.out.print(root.item + " ");  // Print the root item.
            inorderPrint(root.right);  // Print items in right subtree.
        }
    } // end inorderPrint()

}



