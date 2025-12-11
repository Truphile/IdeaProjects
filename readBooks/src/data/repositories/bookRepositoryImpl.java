package data.repositories;

import data.models.Book;

import java.util.ArrayList;

public class bookRepositoryImpl implements bookRepository {

   private ArrayList<Book> bookslist = new ArrayList<>();
    private int count;
    private Book book = new Book();

    @Override
    public long count() {
        return bookslist.size();
    }

    @Override
    public Book save(Book newBook) {
        if (newBook == null) {
            return null;
        }
        if (newBook.getId() == 0) {
            count++;
            newBook.setId(count);
            bookslist.add(newBook);
            return newBook;
        }

        return update(newBook);
    }

    private Book update(Book newBook) {
      bookslist.removeIf(b -> b.getId() == newBook.getId());
        bookslist.add(newBook);
        return newBook;
    }


    @Override
    public Book findById(int Id) {
        for (Book book : bookslist) {
            if (book.getId() == Id) {
                return book;
            }
        }
        return null;

    }

    @Override
    public void deleteById(int id) {
        bookslist.remove( bookslist.get(id-1));

    }


}


        


