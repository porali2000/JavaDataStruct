package algorithms;

import java.util.List;

public class ReverseLinkList<E> {

    public  LinkedList<E>  reverseList(LinkedList<E> original) {
        if(original == null || original.next == null) {
            return  original;
        }

        LinkedList<E> next = original.next;
        LinkedList<E> reversed = reverseList(next);
        original.next = null;
        next.next = original;
        return reversed;
    }
}
