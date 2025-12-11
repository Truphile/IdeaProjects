package dtos.requests;

public class AddBookRequest {
    private String author;
    private String edition;
    private String description;
    private int quantity;
    private String bookName;
    private String genre;
    private String isbn;

    public void setBookName(String bookName) {
        this.bookName = bookName;

    }

    public void setDescription(String bookDescription) {
        this.description = bookDescription;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
