class TreeNode {
    int txt6312_val;
    TreeNode txt6312_left, txt6312_right;

    TreeNode(int val) {
        this.txt6312_val = val;
        txt6312_left = txt6312_right = null;
    }
}

class BST {
    TreeNode root;

    BST() {
        root = null;
    }

    void txt6312_insert(int val) {
        root = txt6312_insertRecursive(root, val);
    }

    TreeNode txt6312_insertRecursive(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.txt6312_val) {
            root.txt6312_left = txt6312_insertRecursive(root.txt6312_left, val);
        } else if (val > root.txt6312_val) {
            root.txt6312_right = txt6312_insertRecursive(root.txt6312_right, val);
        }

        return root;
    }

    boolean txt6312_search(int val) {
        return txt6312_searchRecursive(root, val);
    }

    boolean txt6312_searchRecursive(TreeNode root, int val) {
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
        // Testing BST
        BST bst = new BST();
        bst.txt6312_insert(5);
        bst.txt6312_insert(3);
        bst.txt6312_insert(7);
        bst.txt6312_insert(1);
        bst.txt6312_insert(9);

        System.out.println(bst.txt6312_search(7));  
        System.out.println(bst.txt6312_search(10)); 
    }
}
