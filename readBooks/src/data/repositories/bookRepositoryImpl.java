package data.repositories;

import data.models.Book;

import java.util.ArrayList;

public class bookRepositoryImpl implements bookRepository {

    ArrayList<Book> bookslist = new ArrayList<>();
    private int count;
    private Book Book;

    @Override
    public int count() {
        return bookslist.size();
    }

    @Override
    public Book save(String newBook) {
        count++;
        bookslist.add(Book);
        return Book;


    }
}
