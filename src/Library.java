
public class Library {
    private String name;
    private LinkedList<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new LinkedList<>();
    }

    // Getters
    public String getName() {
        return name;
    }
    public LinkedList<Book> getBooks() {
        return books;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }


    public boolean addBook(Book book) {
        if (book != null) {
            books.add(book);
            return true;
        }
        return false;
    }


    public boolean removeBook(Book book) {
        return books.remove(book);
    }


    public Book findBookByIsbn(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }


    public LinkedList<Book> findBooksByTitle(String title) {
        LinkedList<Book> foundBooks = new LinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getTitle().contains(title)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }


    public LinkedList<Book> findBooksByAuthor(String authorName) {
        LinkedList<Book> foundBooks = new LinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getAuthor().contains(authorName)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }


    public LinkedList<Book> getAvailableBooks() {
        LinkedList<Book> availableBooks = new LinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }


    public LinkedList<Book> getLoanedBooks() {
        LinkedList<Book> loanedBooks = new LinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (!book.isAvailable()) {
                loanedBooks.add(book);
            }
        }
        return loanedBooks;
    }


    public String getStatistics() {
        int totalBooks = books.size();
        int availableBooks = getAvailableBooks().size();
        int loanedBooks = getLoanedBooks().size();

        return String.format(
                "Estadísticas de la Biblioteca:\n" +
                        "- Total de Libros: %d\n" +
                        "- Libros Disponibles: %d\n" +
                        "- Libros Prestados: %d\n",
                totalBooks, availableBooks, loanedBooks
        );
    }

    private Pila<Book> historialPrestamos = new Pila<>();

    public boolean prestarLibro(String isbn) {
        Book libro = findBookByIsbn(isbn);
        if (libro != null && libro.lend()) {
            historialPrestamos.apilar(libro);
            return true;
        }
        return false;
    }

    public Book devolverUltimoPrestamo() {
        if (!historialPrestamos.estaVacia()) {
            Book libro = historialPrestamos.desapilar();
            libro.returnBook();
            return libro;
        }
        return null;
    }



    @Override
    public String toString() {
        return "Library{name='" + name + "', totalBooks=" + books.size() + "}";
    }
}