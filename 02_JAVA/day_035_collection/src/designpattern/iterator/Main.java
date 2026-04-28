package day_035_collection.src.designpattern.iterator;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Around the world in 80 Days"));
        bookShelf.appendBook(new Book("The Lord of the Rings"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));

        for (Book book : bookShelf) {
            System.out.println(book.getName());
        }
        System.out.println();
    }
}
