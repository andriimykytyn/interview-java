package interview.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Objects;

public class Tour {

    private Long id;
    private int days;
    private boolean hasTransfer;
    private boolean hasBreakfast;
    private boolean hasLunch;
    private boolean hasDinner;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime departmentDate;
    private Long hotelId;

    public Tour() {
    }

    public Tour(Long id, int days, boolean hasTransfer,
                boolean hasBreakfast, boolean hasLunch, boolean hasDinner,
                LocalDateTime departmentDate, Long hotelId) {
        this.id = id;
        this.days = days;
        this.hasTransfer = hasTransfer;
        this.hasBreakfast = hasBreakfast;
        this.hasLunch = hasLunch;
        this.hasDinner = hasDinner;
        this.departmentDate = departmentDate;
        this.hotelId = hotelId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public boolean isHasTransfer() {
        return hasTransfer;
    }

    public void setHasTransfer(boolean hasTransfer) {
        this.hasTransfer = hasTransfer;
    }

    public boolean isHasBreakfast() {
        return hasBreakfast;
    }

    public void setHasBreakfast(boolean hasBreakfast) {
        this.hasBreakfast = hasBreakfast;
    }

    public boolean isHasLunch() {
        return hasLunch;
    }

    public void setHasLunch(boolean hasLunch) {
        this.hasLunch = hasLunch;
    }

    public boolean isHasDinner() {
        return hasDinner;
    }

    public void setHasDinner(boolean hasDinner) {
        this.hasDinner = hasDinner;
    }

    public LocalDateTime getDepartmentDate() {
        return departmentDate;
    }

    public void setDepartmentDate(LocalDateTime departmentDate) {
        this.departmentDate = departmentDate;
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
        return days == tour.days &&
                hasTransfer == tour.hasTransfer &&
                hasBreakfast == tour.hasBreakfast &&
                hasLunch == tour.hasLunch &&
                hasDinner == tour.hasDinner &&
                Objects.equals(id, tour.id) &&
                Objects.equals(departmentDate, tour.departmentDate) &&
                Objects.equals(hotelId, tour.hotelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, days, hasTransfer, hasBreakfast, hasLunch, hasDinner, departmentDate, hotelId);
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", days=" + days +
                ", hasTransfer=" + hasTransfer +
                ", hasBreakfast=" + hasBreakfast +
                ", hasLunch=" + hasLunch +
                ", hasDinner=" + hasDinner +
                ", departmentDate=" + departmentDate +
                ", hotelId=" + hotelId +
                '}';
    }
}
