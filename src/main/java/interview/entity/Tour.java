package interview.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Tour {

    private Long id;
    private int nights;
    private boolean isBreakfastIncluded;
    private boolean isDinnerIncluded;
    private boolean isSupperIncluded;
    private LocalDate departmentDate;
    private LocalDate created;
    private Long destinationId;
    private Long hotelId;

    public Tour() {
    }

    public Tour(Long id, int nights, boolean isBreakfastIncluded,
                boolean isDinnerIncluded, boolean isSupperIncluded,
                LocalDate departmentDate, LocalDate created,
                Long destinationId, Long hotelId) {
        this.id = id;
        this.nights = nights;
        this.isBreakfastIncluded = isBreakfastIncluded;
        this.isDinnerIncluded = isDinnerIncluded;
        this.isSupperIncluded = isSupperIncluded;
        this.departmentDate = departmentDate;
        this.created = created;
        this.destinationId = destinationId;
        this.hotelId = hotelId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
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

    public LocalDate getDepartmentDate() {
        return departmentDate;
    }

    public void setDepartmentDate(LocalDate departmentDate) {
        this.departmentDate = departmentDate;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
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
        if (!(o instanceof Tour)) return false;
        Tour tour = (Tour) o;
        return nights == tour.nights &&
                isBreakfastIncluded == tour.isBreakfastIncluded &&
                isDinnerIncluded == tour.isDinnerIncluded &&
                isSupperIncluded == tour.isSupperIncluded &&
                Objects.equals(id, tour.id) &&
                Objects.equals(departmentDate, tour.departmentDate) &&
                Objects.equals(created, tour.created) &&
                Objects.equals(destinationId, tour.destinationId) &&
                Objects.equals(hotelId, tour.hotelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nights, isBreakfastIncluded, isDinnerIncluded, isSupperIncluded, departmentDate, created, destinationId, hotelId);
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", nights=" + nights +
                ", isBreakfastIncluded=" + isBreakfastIncluded +
                ", isDinnerIncluded=" + isDinnerIncluded +
                ", isSupperIncluded=" + isSupperIncluded +
                ", departmentDate=" + departmentDate +
                ", created=" + created +
                ", destinationId=" + destinationId +
                ", hotelId=" + hotelId +
                '}';
    }
}
