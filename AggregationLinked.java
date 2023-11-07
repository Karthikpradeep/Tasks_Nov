import java.util.LinkedList;
class Author{
    private String name;

    public Author(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
}
class Book{
    private String title;
    private Author author;

    public Book(String title,Author author){
        this.title=title;
        this.author=author;
    }
    public String getTitle(){
        return title;
    }
    public Author geAuthor(){
        return author;
    }
}
public class AggregationLinked {
    public static void main(String[] args)
    {
        LinkedList<Book> books =new LinkedList<>();
        Author author1 = new Author("J K Rowling");
        Author author2 = new Author("Ursula K");

        Book book1 = new Book("Harry Potter and the Chamber of Secrets", author1);
        Book book2 = new Book("Harry Potter and the Philosopher's Stone", author1);
        Book book3 = new Book("A Wizard of Earthsea", author2);
        books.add(book1);
        books.add(book2);
        books.add(book3);

        for(Book book :books)
        {
            System.out.println("\nBook title - "+book.getTitle());
            System.out.println("Author name - "+book.geAuthor().getName());
            System.out.println();
        }
    }
}
