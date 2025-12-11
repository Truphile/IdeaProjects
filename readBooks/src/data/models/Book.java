package data.models;

public class Book {

    private String name;

    private int isbn;

    private String author;

    private int quantity;

    private int edition;

    private int id;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }


}
