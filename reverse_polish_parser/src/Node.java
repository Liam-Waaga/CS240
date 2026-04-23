public class Node<T> {

    private Node<T> left;
    private Node<T> right;

    private T obj;

    /* this exists to know where in the string we ended at */
    private int end_point;

    public Node(T obj, Node<T> left, Node<T> right) {
        this.obj = obj;
        this.left = left;
        this.right = right;
    }

    public int getEnd_point() {
        return end_point;
    }

    public void setEnd_point(int end_point) {
        this.end_point = end_point;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
