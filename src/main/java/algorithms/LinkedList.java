package algorithms;

public class LinkedList<E> {
    E data;
    LinkedList<E> next;

    public LinkedList(E data, LinkedList<E> next) {
        this.data = data;
        this.next = next;
    }
}
