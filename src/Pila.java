public class Pila<T> {
    private Node<T> tope;
    private int tamanio;

    public Pila() {
        this.tope = null;
        this.tamanio = 0;
    }

    public void apilar(T dato) {
        Node<T> nuevoNodo = new Node<>(dato);
        nuevoNodo.setNext(tope);
        tope = nuevoNodo;
        tamanio++;
    }

    public T desapilar() {
        if (estaVacia()) throw new RuntimeException("La pila está vacía");
        T dato = tope.getData();
        tope = tope.getNext();
        tamanio--;
        return dato;
    }

    public T verTope() {
        if (estaVacia()) throw new RuntimeException("La pila está vacía");
        return tope.getData();
    }

    public boolean estaVacia() {
        return tope == null;
    }
    public int tamanio() {
        return tamanio;
    }

    @Override
    public String toString() {
        return "Pila{tamanio=" + tamanio + ", tope=" + (estaVacia() ? "null" : verTope()) + "}";
    }
}