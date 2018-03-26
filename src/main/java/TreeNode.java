public class TreeNode<E> {
    TreeNode parent;
    TreeNode left;
    TreeNode right;
    E data;

    public TreeNode(){
        this.data = null;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public TreeNode(E value){
        this.data = value;
    }

    public TreeNode(E value, TreeNode<E> parent){
        this.data = value;
        this.parent = parent;

    }

    public void addLeftChild( TreeNode<E> leftchild){
        this.left = leftchild;
    }

    public void  addRightChild(TreeNode<E> rightChild){
        this.right = rightChild;
    }
}
