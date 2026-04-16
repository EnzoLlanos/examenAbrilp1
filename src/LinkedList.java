
public class LinkedList<T> {
    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }


    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> actual = head;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(newNode);
        }
        size++;
    }


    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }
        Node<T> actual = head;
        for (int i = 0; i < index; i++) {
            actual = actual.getNext();
        }
        return actual.getData();
    }


    public boolean remove(T data) {
        if (head == null) return false;

        if (head.getData().equals(data)) {
            head = head.getNext();
            size--;
            return true;
        }

        Node<T> actual = head;
        while (actual.getNext() != null) {
            if (actual.getNext().getData().equals(data)) {
                actual.setNext(actual.getNext().getNext());
                size--;
                return true;
            }
            actual = actual.getNext();
        }
        return false;
    }


    public boolean contains(T data) {
        Node<T> actual = head;
        while (actual != null) {
            if (actual.getData().equals(data)) return true;
            actual = actual.getNext();
        }
        return false;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public void clear() {
        head = null;
        size = 0;
    }


    public int size() {
        return size;
    }
}