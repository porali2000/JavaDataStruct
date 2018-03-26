package datastructures;


public class CArray<T> {
    private final int intialSize = 1;
    private CEntry<T> root;
    private int size;

    public CArray() {
        this.size = 0;
    }


    public void add(T t) {
        CEntry previous = null;
        if (root == null) {
            this.root = new CEntry<>(t, null, null);
            return;
        }
        previous = this.root;
        while (previous.getRight() != null) {
            previous = previous.getRight();
        }

        add(t, previous);
    }

    private void add(T t, CEntry<T> previous) {
        CEntry<T> newEntry = new CEntry<>(t, previous, previous.getRight());
        previous.setRight(newEntry);
        size++;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        CEntry current = this.root;
        while (current != null) {
            stringBuffer.append(current.getValue());
            stringBuffer.append(", ");
            current = current.getRight();
        }
        return stringBuffer.toString();
    }

    public boolean find(T t) {
        CEntry current = this.root;
        while (current != null) {
            if (current.getValue().equals(t)) {
                return true;
            }
            current = current.getRight();
        }

        return false;
    }

    private CEntry<T> findAt(int index) {
        CEntry current = this.root;
        int count  = 0;
        while (current != null && count < index ) {
            current =  current.getRight();
            count++;
        }

        return current;
    }

    public void insert(int index, T value) {
        CEntry<T> cEntry = findAt(index - 1);
        if ( cEntry != null) {
            insert(value, cEntry);
        }

    }

    private void insert(T t, CEntry<T> previous) {
        CEntry<T> newEntry = new CEntry<>(t, previous.getLeft() , previous);
        previous.getLeft().setRight(newEntry);
        previous.setLeft(newEntry);
        size++;
    }

    public boolean delete(T t) {
        CEntry current = this.root;
        while (current != null) {
            if (current.getValue().equals(t)) {
                if (null != current.getLeft())
                    current.getLeft().setRight(current.getRight());
                if (null != current.getRight()) {
                    current.getRight().setLeft(current.getLeft());
                    if (current.equals(this.root))
                        this.root = current.getRight();
                }

                current = null;
                return true;
            }
            current = current.getRight();
        }

        return false;
    }
}
