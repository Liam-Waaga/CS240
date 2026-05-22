public class CDLinkedList<T> {
    private Node<T> tail;
    private Node<T> head;

    public CDLinkedList() {
        tail = null;
        head = null;
    }

    public void addFirst(T obj) {
        Node<T> node = new Node<T>(obj, tail, head);
        if (head != null) {
            head.setPrev(node);
        }
        head = node;
    }
    public void addLast(T obj) {
        Node<T> node = new Node<T>(obj, tail, head);
        if (tail != null) {
            tail.setPrev(node);
        }
        head = node;
    }
}