package Backend.Friend_Management;

public class PostString {
    private String author;
    private String text;
    private String photo;
    private String date;
    public PostString(String author, String text, String photo,String date) {
        this.author = author;
        this.text = text;
        this.photo = photo;
        this.date=date;
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

    public String getDate() {
        return date;
    }
}
