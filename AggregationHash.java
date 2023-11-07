import java.util.HashMap;

class Author {
    private String name;

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Book {
    private String title;
    private Author author;

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }
}

public class AggregationHash {
    public static void main(String[] args) {
        HashMap<String, Author> authors = new HashMap<>();
        HashMap<String, Book> books = new HashMap<>();

        Author author1 = new Author("J K Rowling");
        Author author2 = new Author("Ursula K");

        Book book1 = new Book("Harry Potter and the Chamber of Secrets", author1);
        Book book2 = new Book("Harry Potter and the Philosopher's Stone", author1);
        Book book3 = new Book("A Wizard of Earthsea", author2);

       
        authors.put(author1.getName(), author1);
        authors.put(author2.getName(), author2);

        books.put(book1.getTitle(), book1);
        books.put(book2.getTitle(), book2);
        books.put(book3.getTitle(), book3);

       
        for (Book book : books.values()) {
            System.out.println("\nBook Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor().getName());
            System.out.println();
        }
    }
}
