package Backend;

public class Online {
    private Boolean status;
    private String user;
    public Online(Boolean status, String user) {
        this.status = status;
        this.user = user;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getUser() {
        return user;
    }
}
