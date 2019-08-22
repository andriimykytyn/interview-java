package interview.entity;

public enum  RoomType {
    STANDART("STANDART"), LUXE("LUXE"), SEMILUXE("SEMILUXE");

    private String type;

    RoomType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
