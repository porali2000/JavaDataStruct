public class SingleLinkedListNode<E> {

    SingleLinkedListNode next;
    E data;

    public SingleLinkedListNode(){
        this.next = null;
        this.data = null;
    }

    public SingleLinkedListNode (SingleLinkedListNode previousNode, E data) {
        this.data = data;
        this.next = previousNode.next;
        previousNode.next = this;
    }
}
