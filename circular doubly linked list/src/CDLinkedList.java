/* Liam Waaga */

public class CDLinkedList<T> {
    private Node<T> tail;
    private Node<T> head;
    private int size;

    public CDLinkedList() {
        tail = null;
        head = null;
    }

    public void addFirst(T obj) {
        Node<T> node = new Node<T>(obj, tail, head);
        if (head != null) {
            head.prev(node);
        } else {
            /* tail must be null in this case, because there are no elements in the list */
            tail = node;
        }
        head = node;
        size++;
    }
    
    public void addLast(T obj) {
        Node<T> node = new Node<T>(obj, tail, head);
        if (tail != null) {
            tail.next(node);
            head.prev(node);
        } else {
            /* in this case, head must be null if tail is null, so we set head to node as well */
            head = node;
        }
        tail = node;
        size++;
    }

    public T removeFirst() {
        T obj;
        if (head != null) {
            obj = head.obj();
            this.head = head.next();
            if (head == null) {
                tail = null;
            }
            size--;
            return obj;
        } else {
            /* if head is null then obviously we are out of bounds */
            throw new IndexOutOfBoundsException();
        }
    }
    
    public T removeLast() {
        T obj = null;
        if (tail != null) {
            obj = tail.obj();
            this.tail = tail.prev();
            if (tail == null) {
                head = null;
            }
            size--;
            return obj;
        } else {
            /* if tail is null then obviously we are out of bounds */
            throw new IndexOutOfBoundsException();
        }

    }

    public void insertAt(int index, T obj) {
        Node<T> curr = tail;
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        
        if (index == 0) {
            /* don't duplicate code */
            addFirst(obj);
        } else if (index == size) {
            /* don't duplicate code */
            addLast(obj);
        } else {
            /* select the right node */
            while (index > 0) {
                curr = curr.next();
                index--;
            }
            Node<T> x = new Node<T>(obj, curr, curr.next());
            /* add it in */
            curr.next(x);
            x.next().prev(x);
            size++;
        }
    }

    public T get(int index) {
        Node<T> curr = head;
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (index > 0) {
            curr = curr.next();
            index--;
        }
        return curr.obj();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public String toString() {
        Node<T> curr = head;
        String out = "[";
        if (isEmpty()) {
            return "[]";
        }
        do {
            out += curr.obj().toString();
            out += ", ";
            curr = curr.next();
        } while (curr != tail);
        out += curr.obj() + "]";
        return out;
    }

}