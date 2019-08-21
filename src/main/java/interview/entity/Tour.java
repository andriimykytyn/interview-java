package interview.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Tour {

    private Long id;
    //STANDART, LUXE, SEMILUXE
    private HotelRoom hotelRoom;
    private int nights;
    private int roomMembers;
    private int distance;
    private boolean isBreakfastIncluded;
    private boolean isDinnerIncluded;
    private boolean isSupperIncluded;
    private int hotelStars;
    private LocalDate departmentDate;
    private Long destinationId;

    public Tour() {
    }

    public Tour(Long id, String hotelRoom, int nights,
                int roomMembers, int distance, boolean isBreakfastIncluded,
                boolean isDinnerIncluded, boolean isSupperIncluded, int hotelStars,
                LocalDate departmentDate, Long destinationId) {
        this.id = id;
        this.hotelRoom = HotelRoom.valueOf(hotelRoom);
        this.nights = nights;
        this.roomMembers = roomMembers;
        this.distance = distance;
        this.isBreakfastIncluded = isBreakfastIncluded;
        this.isDinnerIncluded = isDinnerIncluded;
        this.isSupperIncluded = isSupperIncluded;
        this.hotelStars = hotelStars;
        this.departmentDate = departmentDate;
        this.destinationId = destinationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelRoom() {
        return hotelRoom.name();
    }

    public void setHotelRoom(String hotelRoom) {
        this.hotelRoom = HotelRoom.valueOf(hotelRoom);
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public int getRoomMembers() {
        return roomMembers;
    }

    public void setRoomMembers(int roomMembers) {
        this.roomMembers = roomMembers;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isBreakfastIncluded() {
        return isBreakfastIncluded;
    }

    public void setBreakfastIncluded(boolean breakfastIncluded) {
        isBreakfastIncluded = breakfastIncluded;
    }

    public boolean isDinnerIncluded() {
        return isDinnerIncluded;
    }

    public void setDinnerIncluded(boolean dinnerIncluded) {
        isDinnerIncluded = dinnerIncluded;
    }

    public boolean isSupperIncluded() {
        return isSupperIncluded;
    }

    public void setSupperIncluded(boolean supperIncluded) {
        isSupperIncluded = supperIncluded;
    }

    public int getHotelStars() {
        return hotelStars;
    }

    public void setHotelStars(int hotelStars) {
        this.hotelStars = hotelStars;
    }

    public LocalDate getDepartmentDate() {
        return departmentDate;
    }

    public void setDepartmentDate(LocalDate departmentDate) {
        this.departmentDate = departmentDate;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tour)) return false;
        Tour tour = (Tour) o;
        return nights == tour.nights &&
                roomMembers == tour.roomMembers &&
                distance == tour.distance &&
                isBreakfastIncluded == tour.isBreakfastIncluded &&
                isDinnerIncluded == tour.isDinnerIncluded &&
                isSupperIncluded == tour.isSupperIncluded &&
                hotelStars == tour.hotelStars &&
                Objects.equals(id, tour.id) &&
                hotelRoom == tour.hotelRoom &&
                Objects.equals(departmentDate, tour.departmentDate) &&
                Objects.equals(destinationId, tour.destinationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hotelRoom, nights, roomMembers, distance, isBreakfastIncluded, isDinnerIncluded, isSupperIncluded, hotelStars, departmentDate, destinationId);
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", hotelRoom=" + hotelRoom +
                ", nights=" + nights +
                ", roomMembers=" + roomMembers +
                ", distance=" + distance +
                ", isBreakfastIncluded=" + isBreakfastIncluded +
                ", isDinnerIncluded=" + isDinnerIncluded +
                ", isSupperIncluded=" + isSupperIncluded +
                ", hotelStars=" + hotelStars +
                ", departmentDate=" + departmentDate +
                ", destinationId=" + destinationId +
                '}';
    }
}
