public class Node<T> {
    private T obj;
    private Node<T> prev;
    private Node<T> next;

    public Node(T obj, Node<T> prev, Node<T> next) {
        this.obj = obj;
        this.prev = prev;
        this.next = next;
    }

    public T obj() {
        return obj;
    }

    public void obj(T obj) {
        this.obj = obj;
    }

    public Node<T> next() {
        return next;
    }

    public void next(Node<T> next) {
        this.next = next;
    }

    public Node<T> prev() {
        return prev;
    }

    public void prev(Node<T> prev) {
        this.prev = prev;
    }
}

