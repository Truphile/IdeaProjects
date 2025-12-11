package dtos.responses;

public class AddBookResponse {
    private int id;
    private String message;
    private String title;

    public AddBookResponse(int id, String message, String title) {
        this.id = id;
        this.message = message;
        this.title = title;
    }
}
