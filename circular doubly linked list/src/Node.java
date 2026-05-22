public class Node<T> {
    private T obj;
    private Node<T> prev;
    private Node<T> next;

    public Node(T obj, Node<T> prev, Node<T> next) {
        this.obj = obj;
        this.prev = prev;
        this.next = next;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
}
