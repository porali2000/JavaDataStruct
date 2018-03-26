package datastructures;

public class CEntry<T> {

    private T value;
    private CEntry<T> left;
    private CEntry<T> right;

    public CEntry(T value, CEntry<T> left, CEntry<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public CEntry<T> getLeft() {
        return left;
    }

    public CEntry<T> getRight() {
        return right;
    }

    public void setRight(CEntry<T> right) {
        this.right = right;
    }

    public void setLeft(CEntry left) {
        this.left = left;
    }
}
