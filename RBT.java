class RedBlackTreeNode {
    int txt6312_val;
    String txt6312_color;
    RedBlackTreeNode txt6312_left, txt6312_right, txt6312_parent;

    RedBlackTreeNode(int val) {
        this.txt6312_val = val;
        this.txt6312_color = "RED";
        txt6312_left = txt6312_right = txt6312_parent = null;
    }
}

class RedBlackTree {
    RedBlackTreeNode root;

    RedBlackTree() {
        root = null;
    }

    void txt6312_insert(int val) {
        RedBlackTreeNode node = new RedBlackTreeNode(val);
        if (root == null) {
            root = node;
            root.txt6312_color = "BLACK";
        } else {
            root = txt6312_insertRecursive(root, node);
            txt6312_fixViolations(node);
        }
    }

    RedBlackTreeNode txt6312_insertRecursive(RedBlackTreeNode root, RedBlackTreeNode node) {
        if (root == null) {
            return node;
        }

        if (node.txt6312_val < root.txt6312_val) {
            root.txt6312_left = txt6312_insertRecursive(root.txt6312_left, node);
            root.txt6312_left.txt6312_parent = root;
        } else if (node.txt6312_val > root.txt6312_val) {
            root.txt6312_right = txt6312_insertRecursive(root.txt6312_right, node);
            root.txt6312_right.txt6312_parent = root;
        }

        return root;
    }

    void txt6312_fixViolations(RedBlackTreeNode node) {
        while (node != root && node.txt6312_parent.txt6312_color.equals("RED")) {
            if (node.txt6312_parent == node.txt6312_parent.txt6312_parent.txt6312_left) {
                RedBlackTreeNode uncle = node.txt6312_parent.txt6312_parent.txt6312_right;
                if (uncle != null && uncle.txt6312_color.equals("RED")) {
                    node.txt6312_parent.txt6312_color = "BLACK";
                    uncle.txt6312_color = "BLACK";
                    node.txt6312_parent.txt6312_parent.txt6312_color = "RED";
                    node = node.txt6312_parent.txt6312_parent;
                } else {
                    if (node == node.txt6312_parent.txt6312_right) {
                        node = node.txt6312_parent;
                        txt6312_leftRotate(node);
                    }
                    node.txt6312_parent.txt6312_color = "BLACK";
                    node.txt6312_parent.txt6312_parent.txt6312_color = "RED";
                    txt6312_rightRotate(node.txt6312_parent.txt6312_parent);
                }
            } else {
                RedBlackTreeNode uncle = node.txt6312_parent.txt6312_parent.txt6312_left;
                if (uncle != null && uncle.txt6312_color.equals("RED")) {
                    node.txt6312_parent.txt6312_color = "BLACK";
                    uncle.txt6312_color = "BLACK";
                    node.txt6312_parent.txt6312_parent.txt6312_color = "RED";
                    node = node.txt6312_parent.txt6312_parent;
                } else {
                    if (node == node.txt6312_parent.txt6312_left) {
                        node = node.txt6312_parent;
                        txt6312_rightRotate(node);
                    }
                    node.txt6312_parent.txt6312_color = "BLACK";
                    node.txt6312_parent.txt6312_parent.txt6312_color = "RED";
                    txt6312_leftRotate(node.txt6312_parent.txt6312_parent);
                }
            }
        }
        root.txt6312_color = "BLACK";
    }

    void txt6312_leftRotate(RedBlackTreeNode x) {
        RedBlackTreeNode y = x.txt6312_right;
        x.txt6312_right = y.txt6312_left;
        if (y.txt6312_left != null) {
            y.txt6312_left.txt6312_parent = x;
        }
        y.txt6312_parent = x.txt6312_parent;
        if (x.txt6312_parent == null) {
            root = y;
        } else if (x == x.txt6312_parent.txt6312_left) {
            x.txt6312_parent.txt6312_left = y;
        } else {
            x.txt6312_parent.txt6312_right = y;
        }
        y.txt6312_left = x;
        x.txt6312_parent = y;
    }

    void txt6312_rightRotate(RedBlackTreeNode y) {
        RedBlackTreeNode x = y.txt6312_left;
        y.txt6312_left = x.txt6312_right;
        if (x.txt6312_right != null) {
            x.txt6312_right.txt6312_parent = y;
        }
        x.txt6312_parent = y.txt6312_parent;
        if (y.txt6312_parent == null) {
            root = x;
        } else if (y == y.txt6312_parent.txt6312_right) {
            y.txt6312_parent.txt6312_right = x;
        } else {
            y.txt6312_parent.txt6312_left = x;
        }
        x.txt6312_right = y;
        y.txt6312_parent = x;
    }

    boolean txt6312_search(int val) {
        return txt6312_searchRecursive(root, val);
    }

    boolean txt6312_searchRecursive(RedBlackTreeNode root, int val) {
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
        // Testing Red-Black Tree
        RedBlackTree rbt = new RedBlackTree();
        rbt.txt6312_insert(5);
        rbt.txt6312_insert(3);
        rbt.txt6312_insert(7);
        rbt.txt6312_insert(1);
        rbt.txt6312_insert(9);

        System.out.println(rbt.txt6312_search(7));  
        System.out.println(rbt.txt6312_search(10)); 
    }
}
