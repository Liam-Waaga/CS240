public class AVLNode<E> {
    E element;
    AVLNode<E> left;
    AVLNode<E> right;
    int height;

    AVLNode(E element) {
        this.element = element;
        this.height = 0; // leaf node has height 0
    }
}
