public class AVLTree<E extends Comparable<E>> {


    private AVLNode<E> root;

    public void insert(E element) {
        root = insert(root, element);
    }

    private AVLNode<E> insert(AVLNode<E> node, E element) {
        if (node == null) {
            return new AVLNode<>(element);
        }

        int cmp = element.compareTo(node.element);
        if (cmp < 0) {
            node.left = insert(node.left, element);
        } else if (cmp > 0) {
            node.right = insert(node.right, element);
        } else {
            return node; // Duplicate keys not allowed
        }

        updateHeight(node);
        return balance(node);
    }

    public void delete(E element) {
        root = delete(root, element);
    }

    private AVLNode<E> delete(AVLNode<E> node, E element) {
        if (node == null) return null;

        int cmp = element.compareTo(node.element);
        if (cmp < 0) {
            node.left = delete(node.left, element);
        } else if (cmp > 0) {
            node.right = delete(node.right, element);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left != null) ? node.left : node.right;
            } else {
                AVLNode<E> minNode = findMin(node.right);
                node.element = minNode.element;
                node.right = delete(node.right, minNode.element);
            }
        }

        if (node == null) return null;

        updateHeight(node);
        return balance(node);
    }

    private AVLNode<E> findMin(AVLNode<E> node) {
        while (node.left != null) node = node.left;
        return node;
    }

    private int height(AVLNode<E> node) {
        return node == null ? -1 : node.height;
    }

    private void updateHeight(AVLNode<E> node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private int balanceFactor(AVLNode<E> node) {
        return height(node.right) - height(node.left);
    }

    private AVLNode<E> balance(AVLNode<E> node) {
        int bf = balanceFactor(node);

        if (bf == -2) {
            if (balanceFactor(node.left) <= 0) {
                return rotateRight(node); // LL
            } else {
                node.left = rotateLeft(node.left); // LR
                return rotateRight(node);
            }
        } else if (bf == 2) {
            if (balanceFactor(node.right) >= 0) {
                return rotateLeft(node); // RR
            } else {
                node.right = rotateRight(node.right); // RL
                return rotateLeft(node);
            }
        }

        return node; // already balanced
    }

    private AVLNode<E> rotateLeft(AVLNode<E> a) {
        AVLNode<E> b = a.right;
        a.right = b.left;
        b.left = a;
        updateHeight(a);
        updateHeight(b);
        return b;
    }

    private AVLNode<E> rotateRight(AVLNode<E> a) {
        AVLNode<E> b = a.left;
        a.left = b.right;
        b.right = a;
        updateHeight(a);
        updateHeight(b);
        return b;
    }

    public void printAsciiTree() {
        printAsciiTree(root, " ",false);
    }

    private void printAsciiTree(AVLNode<E> node, String prefix, boolean isTail) {
        if (node == null) return;

        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.element);

        if (node.left != null || node.right != null) {
            if (node.right != null) {
                printAsciiTree(node.right, prefix + (isTail ? "    " : "│   "), false);
            }
            if (node.left != null) {
                printAsciiTree(node.left, prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }


    
    public E traceSearch(E key) {
        System.err.println("Searching for " + key.toString() + "...");
        /* starting point */
        AVLNode<E> curr = root;
        System.err.print("Visited: " + curr.element.toString());
        while (true) {
            /* check which direction to go */
            if (curr.element.compareTo(key) > 0) {
                curr = curr.left;
            } else if (curr.element.compareTo(key) < 0) {
                curr = curr.right;
            } else {
                /* we found it */
                System.err.print(" -> " + curr.element.toString() + " (found)\n");
                return curr.element;
            }
            /* it isn't in the tree */
            if (curr == null) {
                System.err.print(" -> (not found)\n");
                return null;
            }

            /* print in between chars ("trace" part of trace search) */
            System.err.print(" -> " + curr.element.toString());
        }
    }

    public void printNodeBalances() {
        /* call helper */
        printNodeBalances(root);
        System.err.println("Tree height = " + height(root));
    }

    private void printNodeBalances(AVLNode<E> node) {
        /* in order, call only if it exists */
        if (node.left != null) printNodeBalances(node.left);
        /* print data */
        System.err.println("Node " + node.element.toString() + ": balance = " + balanceFactor(node));
        if (node.right != null) printNodeBalances(node.right);
    }

    public static boolean isAVL(AVLNode root) {
        int factor = balanceFactor2(root);
        boolean isAVL = factor >= -1 && factor <= 1;
        /* recursively check each node and & it all together */
        if (root.left != null) {
            isAVL &= isAVL(root.left);
        }
        if (root.right != null) {
            isAVL &= isAVL(root.right);
        }
        return isAVL;
    }

    private static int balanceFactor2(AVLNode node) {
        return (node.left == null ? 0 : node.left.height) - (node.right == null ? 0 : node.right.height);
    }

    public AVLNode<E> getnodes() {
        return root;
    }
}

