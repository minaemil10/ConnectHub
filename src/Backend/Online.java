package Backend;

public class Online {
    private Boolean status;

    public Online(Boolean status, String user) {
        this.status = status;
        this.user = user;
    }

    private String user;

    public Boolean getStatus() {
        return status;
    }

    public String getUser() {
        return user;
    }
}
