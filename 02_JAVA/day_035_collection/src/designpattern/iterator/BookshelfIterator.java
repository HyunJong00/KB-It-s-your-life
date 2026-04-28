package day_035_collection.src.designpattern.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookshelfIterator implements Iterator<Book> {
    private BookShelf bookShelf;
    private int index;

    public BookshelfIterator(BookShelf bookShelf){
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < bookShelf.getLength();
    }

    @Override
    public Book next() {
        if(!hasNext()){
            //런타임 예외
            throw new NoSuchElementException();
        }
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}