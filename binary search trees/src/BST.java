// BST.java
// This class defines a generic Binary Search Tree (BST) data structure.
// It uses a nested TreeNode class to represent each node in the tree.
// The tree stores elements of any type E that implements Comparable<E>.
public class BST<E extends Comparable<E>> {
    protected TreeNode<E> root; // The root node of the BST
    protected int size = 0;     // Keeps track of the number of nodes in the tree

    // Default constructor for an empty tree
    public BST() {}

    // Public method to get the height of the tree
    public int height() {
        return height(root);
    }

    // Private helper method to compute the height recursively
    private int height(TreeNode<E> node) {
        if (node == null) return 0; // Base case: empty subtree
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // Public method to perform inorder traversal
    public void inorder() {
        inorder(root);
        System.out.println(); // Print a newline after traversal output
    }

    // Recursive helper for inorder traversal
    private void inorder(TreeNode<E> root) {
        if (root != null) {
            inorder(root.left);             // Visit left subtree
            System.out.print(root.element + " "); // Visit current node
            inorder(root.right);            // Visit right subtree
        }
    }

    // Nested TreeNode class to represent each node in the tree
    public static class TreeNode<E> {
        protected E element;        // The data stored at this node
        protected TreeNode<E> left; // Reference to the left child
        protected TreeNode<E> right;// Reference to the right child

        // Constructor initializes the node with data
        public TreeNode(E e) {
            element = e;
        }
    }

    // Method to get the number of nodes in the BST
    public int size() {
        return size;
    }

    public boolean search(E e) {
        TreeNode<E> curr = root;

        int comparison = 0;

        while (curr != null && (comparison = curr.element.compareTo(e)) != 0) {
            if (comparison > 0) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return curr != null;

    }

    // public void delete(E e) {
    //     TreeNode<E> curr = root;
    //     TreeNode<E> prev = null;
    //
    //     int comparison = 0;
    //     boolean left = false;
    //
    //     while (curr != null && (comparison = curr.element.compareTo(e)) != 0) {
    //         prev = curr;
    //         if (comparison > 0) {
    //             curr = curr.left;
    //             left = true;
    //         } else {
    //             curr = curr.right;
    //             left = false;
    //         }
    //     }
    // }


    /* adapted from a previous BST i wrote */
    public void delete(E e) {
        /* handle removing root */
        if (root.element.compareTo(e) == 0) {
            if (this.root.left != null && this.root.right != null) {
                /* minimum value to the right of the node */
                TreeNode<E> min = this.root.right;
                TreeNode<E> prev = this.root.right;
                while (min.left != null) {
                    prev = min;
                    min = min.left;
                }
                /* remove the old node */
                prev.left = null;
                /* copy the important bits */
                this.root.element = min.element;

            } else if (this.root.right != null) {
                /* copy the important bits */
                this.root.left = this.root.right.left;
                this.root.element = this.root.right.element;
                this.root.right = this.root.right.right;
                return;
            } else if (this.root.left != null) {
                /* copy the important bits */
                this.root.right = this.root.left.right;
                this.root.element = this.root.left.element;
                this.root.left = this.root.left.left;
                return;
            } else {
                /* no children, ez */
                this.root = null;
                return;
            }
        }
        TreeNode<E> curr = this.root;
        boolean left = false;
        TreeNode<E> parent = curr;
        while (curr != null) {
            /* find it first */
            if (curr.element.compareTo(e) < 0) {
                parent = curr;
                curr = curr.right;
                left = false;
            } else if (curr.element.compareTo(e) > 0) {
                parent = curr;
                curr = curr.left;
                left = true;
            } else if (curr.element.compareTo(e) == 0) {
                /* once found, do removal logic just like we did above */
                if (curr.left != null && curr.right != null) {
                    TreeNode<E> min = curr.right;
                    TreeNode<E> prev = curr.right;
                    while (min.left != null) {
                        prev = min;
                        min = min.left;
                    }
                    prev.left = null;
                    curr.element = min.element;

                } else if (curr.left != null) {
                    if (left) {
                        parent.left = curr.left;
                    } else {
                        parent.right = curr.left;
                    }
                } else if (curr.right != null) {
                    if (left) {
                        parent.left = curr.right;
                    } else {
                        parent.right = curr.right;
                    }
                } else {
                    if (left) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
                return;
            }
        }
        /* wasn't found */
        throw new IllegalArgumentException();
    }
}
