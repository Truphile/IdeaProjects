package dtos.requests;

public class AddBookRequest {
    private String author;
    private int edition;
    private String description;
    private int quantity;
    private String bookName;
    private String genre;
    private int isbn;

    public void setBookName(String bookName) {
        this.bookName = bookName;

    }

    public void setDescription(String bookDescription) {
        this.description = bookDescription;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public int getEdition() {
        return edition;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getBookName() {
        return bookName;
    }

    public String getGenre() {
        return genre;
    }

    public int getIsbn() {
        return isbn;
    }
}
