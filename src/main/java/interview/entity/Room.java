package interview.entity;

import java.util.Objects;

public class Room {

    private Long id;
    private RoomType roomType;
    private int amountOfBeds;
    private double costPerDay;
    private Long hotelId;

    public Room() {
    }

    public Room(Long id, RoomType roomType, int amountOfBeds,
                double costPerDay, Long hotelId) {
        this.id = id;
        this.roomType = roomType;
        this.amountOfBeds = amountOfBeds;
        this.costPerDay = costPerDay;
        this.hotelId = hotelId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = RoomType.valueOf(roomType);
    }

    public int getAmountOfBeds() {
        return amountOfBeds;
    }

    public void setAmountOfBeds(int amountOfBeds) {
        this.amountOfBeds = amountOfBeds;
    }

    public double getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(double costPerDay) {
        this.costPerDay = costPerDay;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return amountOfBeds == room.amountOfBeds &&
                costPerDay == room.costPerDay &&
                Objects.equals(id, room.id) &&
                roomType == room.roomType &&
                Objects.equals(hotelId, room.hotelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomType, amountOfBeds, costPerDay, hotelId);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomType=" + roomType +
                ", amountOfBeds=" + amountOfBeds +
                ", costPerDay=" + costPerDay +
                ", hotelId=" + hotelId +
                '}';
    }
}
