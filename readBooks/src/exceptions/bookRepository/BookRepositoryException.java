package exceptions.bookRepository;

public class BookRepositoryException extends RuntimeException {
    public BookRepositoryException(String message) {
        super(message);
    }
}
