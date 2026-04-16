public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN DE BIBLIOTECA ===");
        System.out.println("Aplicación Java de consola iniciada.\n");

        // Crear una biblioteca
        Library library = new Library("Biblioteca Central");

        // Crear algunos libros
        Book book1 = new Book("El Quijote", "978-84-376-0494-7", "Miguel de Cervantes", 1605);
        Book book2 = new Book("Cien años de soledad", "978-84-376-0495-4", "Gabriel García Márquez", 1967);
        Book book3 = new Book("1984", "978-84-376-0496-1", "George Orwell", 1949);
        Book book4 = new Book("El amor en los tiempos del cólera", "978-84-376-0497-8", "Gabriel García Márquez", 1985);

        // Agregar libros a la biblioteca
        System.out.println("📚 AGREGANDO LIBROS A LA BIBLIOTECA:");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        System.out.println("✅ Libros agregados exitosamente");

        // Mostrar información de la biblioteca
        System.out.println("\n📊 INFORMACIÓN DE LA BIBLIOTECA:");
        System.out.println(library);
        System.out.println("\n" + library.getStatistics());

        // Buscar libros por título
        System.out.println("\n🔍 BÚSQUEDA POR TÍTULO ('amor'):");
        LinkedList<Book> resultadosBusqueda = library.findBooksByTitle("amor");
        for (int i = 0; i < resultadosBusqueda.size(); i++) {
            System.out.println("  - " + resultadosBusqueda.get(i));
        }

        // Buscar libros por autor
        System.out.println("\n🔍 BÚSQUEDA POR AUTOR ('García Márquez'):");
        LinkedList<Book> librosPorAutor = library.findBooksByAuthor("García Márquez");
        for (int i = 0; i < librosPorAutor.size(); i++) {
            System.out.println("  - " + librosPorAutor.get(i));
        }

        // Prestar libros la Pila
        System.out.println("\n📖 SIMULANDO PRÉSTAMOS:");
        System.out.println(library.prestarLibro("978-84-376-0494-7")
                ? "✅ Se prestó: El Quijote" : "❌ No disponible");
        System.out.println(library.prestarLibro("978-84-376-0495-4")
                ? "✅ Se prestó: Cien años de soledad" : "❌ No disponible");

        // Devolver el último préstamo
        System.out.println("\n↩️ DEVOLVIENDO ÚLTIMO PRÉSTAMO:");
        Book devuelto = library.devolverUltimoPrestamo();
        if (devuelto != null) {
            System.out.println("✅ Devuelto: " + devuelto.getTitle());
        }


        // Mostrar libros disponibles y prestados
        System.out.println("\n📚 LIBROS DISPONIBLES:");
        LinkedList<Book> disponibles = library.getAvailableBooks();
        for (int i = 0; i < disponibles.size(); i++) {
            System.out.println("  - " + disponibles.get(i));
        }

        System.out.println("\n📤 LIBROS PRESTADOS:");
        LinkedList<Book> prestados = library.getLoanedBooks();
        for (int i = 0; i < prestados.size(); i++) {
            System.out.println("  - " + prestados.get(i));
        }

        // Mostrar estadísticas finales
        System.out.println("\n📊 ESTADÍSTICAS FINALES:");
        System.out.println(library.getStatistics());

        // Procesar argumentos si se proporcionan
        if (args.length > 0) {
            System.out.println("\n💻 ARGUMENTOS RECIBIDOS:");
            for (int i = 0; i < args.length; i++) {
                System.out.println("  " + (i + 1) + ": " + args[i]);
            }
        }

        System.out.println("\n🎉 Demostración completada.");
    }
}