public class Node<T> {
    
    private Node<T> left;
    private Node<T> right;
    
    private T obj;
    
    public Node(T obj, Node<T> left, Node<T> right) {
        this.obj = obj;
        this.left = left;
        this.right = right;
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
