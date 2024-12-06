package Backend.Friend_Management;

public class PostString {
    private String author;
    private String text;
    private String photo;

    public PostString(String author, String text, String photo) {
        this.author = author;
        this.text = text;
        this.photo = photo;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public String getPhoto() {
        return photo;
    }
}
