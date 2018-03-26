import sun.reflect.generics.tree.Tree;

import java.util.List;

public class BinarySearchTree<E extends Comparable> {

    TreeNode<E> root;
    int size;

    public BinarySearchTree(TreeNode<E> root) {
        this.root = root;
    }

    public boolean contains(E valueToFind) {

        TreeNode<E> currentNode = root;

        while (null != currentNode) {
            if (-1 == valueToFind.compareTo(currentNode.data)) {
                currentNode = currentNode.left;
            } else if (1 == valueToFind.compareTo(currentNode.data)) {
                currentNode = currentNode.right;
            } else
                return true;
        }
        return false;
    }

    public boolean search(E valuetoFind) {
        return search(valuetoFind, this.root);
    }


    private boolean search(E valuetoFind, TreeNode<E> node) {
        if (valuetoFind.equals(node.data)) {
            return true;
        }

        if (valuetoFind.compareTo(node.data) < 0 && null != node.left) {
            return search(valuetoFind, node.left);
        }

        return null != node.right && search(valuetoFind, node.right);
    }

    public void insert(E valueToInsert) {
        this.insert(valueToInsert, this.root);
    }

    private void insert(E valueToInsert, TreeNode<E> node) {

        if (valueToInsert.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.addLeftChild(new TreeNode<>(valueToInsert, node));
            } else {
                insert(valueToInsert, node.left);
            }
        } else {
            if (node.right == null) {
                node.addRightChild(new TreeNode<>(valueToInsert, node));
            } else {
                insert(valueToInsert, node.right);
            }
        }
    }

    public boolean delete(E valuetoFind){
        return delete(valuetoFind, this.root);
    }

    private boolean delete(E valuetoFind, TreeNode<E> node) {
        if (valuetoFind.equals(node.data)) {
            if (null != node.left && null != node.right) {
                node.right.parent = node.parent;
                node.parent.right = node.right;
                node.right.addLeftChild(node.left);
                return true;
            }
            if (null == node.left && null == node.right) {
                node.parent.right = node.right;
                node.parent.left = node.left;
                return true;
            }
            if ( null == node.left && null != node.right) {
                node.right.parent = node.parent;
                node.parent.right = node.right;
                node.right.addLeftChild(node.left);
                return true;
            }
            if ( null != node.left && null == node.right) {
                node.left.parent = node.parent;
                node.parent.right = node.right;
                node.right.addLeftChild(node.left);
                return true;
            }
        }

        if (valuetoFind.compareTo(node.data) < 0 && null != node.left) {
            return delete(valuetoFind, node.left);
        }

        return null != node.right && delete(valuetoFind, node.right);
    }
}
