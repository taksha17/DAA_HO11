class AVLTreeNode {
    int txt6312_val;
    AVLTreeNode txt6312_left, txt6312_right;
    int txt6312_height;

    AVLTreeNode(int val) {
        this.txt6312_val = val;
        txt6312_left = txt6312_right = null;
        txt6312_height = 1;
    }
}

class AVLTree {
    AVLTreeNode root;

    AVLTree() {
        root = null;
    }

    void txt6312_insert(int val) {
        root = txt6312_insertRecursive(root, val);
    }

    AVLTreeNode txt6312_insertRecursive(AVLTreeNode root, int val) {
        if (root == null) {
            return new AVLTreeNode(val);
        }

        if (val < root.txt6312_val) {
            root.txt6312_left = txt6312_insertRecursive(root.txt6312_left, val);
        } else if (val > root.txt6312_val) {
            root.txt6312_right = txt6312_insertRecursive(root.txt6312_right, val);
        }

        root.txt6312_height = 1 + Math.max(txt6312_getHeight(root.txt6312_left), txt6312_getHeight(root.txt6312_right));

        int balance = txt6312_getBalance(root);

        // Left Left Case
        if (balance > 1 && val < root.txt6312_left.txt6312_val) {
            return txt6312_rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && val > root.txt6312_right.txt6312_val) {
            return txt6312_leftRotate(root);
        }

        // Left Right Case
        if (balance > 1 && val > root.txt6312_left.txt6312_val) {
            root.txt6312_left = txt6312_leftRotate(root.txt6312_left);
            return txt6312_rightRotate(root);
        }

        // Right Left Case
        if (balance < -1 && val < root.txt6312_right.txt6312_val) {
            root.txt6312_right = txt6312_rightRotate(root.txt6312_right);
            return txt6312_leftRotate(root);
        }

        return root;
    }

    int txt6312_getHeight(AVLTreeNode root) {
        if (root == null) {
            return 0;
        }

        return root.txt6312_height;
    }

    int txt6312_getBalance(AVLTreeNode root) {
        if (root == null) {
            return 0;
        }

        return txt6312_getHeight(root.txt6312_left) - txt6312_getHeight(root.txt6312_right);
    }

    AVLTreeNode txt6312_leftRotate(AVLTreeNode x) {
        AVLTreeNode y = x.txt6312_right;
        AVLTreeNode T2 = y.txt6312_left;

        y.txt6312_left = x;
        x.txt6312_right = T2;

        x.txt6312_height = Math.max(txt6312_getHeight(x.txt6312_left), txt6312_getHeight(x.txt6312_right)) + 1;
        y.txt6312_height = Math.max(txt6312_getHeight(y.txt6312_left), txt6312_getHeight(y.txt6312_right)) + 1;

        return y;
    }

    AVLTreeNode txt6312_rightRotate(AVLTreeNode y) {
        AVLTreeNode x = y.txt6312_left;
        AVLTreeNode T2 = x.txt6312_right;

        x.txt6312_right = y;
        y.txt6312_left = T2;

        y.txt6312_height = Math.max(txt6312_getHeight(y.txt6312_left), txt6312_getHeight(y.txt6312_right)) + 1;
        x.txt6312_height = Math.max(txt6312_getHeight(x.txt6312_left), txt6312_getHeight(x.txt6312_right)) + 1;

        return x;
    }

    boolean txt6312_search(int val) {
        return txt6312_searchRecursive(root, val);
    }

    boolean txt6312_searchRecursive(AVLTreeNode root, int val) {
        if (root == null) {
            return false;
        }

        if (root.txt6312_val == val) {
            return true;
        } else if (val < root.txt6312_val) {
            return txt6312_searchRecursive(root.txt6312_left, val);
        } else {
            return txt6312_searchRecursive(root.txt6312_right, val);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Testing AVL Tree
        AVLTree avlTree = new AVLTree();
        avlTree.txt6312_insert(5);
        avlTree.txt6312_insert(3);
        avlTree.txt6312_insert(7);
        avlTree.txt6312_insert(1);
        avlTree.txt6312_insert(9);

        System.out.println(avlTree.txt6312_search(7));  // Output: true
        System.out.println(avlTree.txt6312_search(10)); // Output: false
    }
}
