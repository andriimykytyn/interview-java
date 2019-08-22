package interview.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import interview.entity.RoomType;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class OrderDto {

    private int days;
    @NotBlank
    private String country;
    @NotBlank
    private String city;
    private boolean hasTransfer;
    private boolean hasBreakfast;
    private boolean hasLunch;
    private boolean hasDinner;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime departmentDate;
    private int beds;
    private RoomType roomType;
    private int hotelStars;

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public String getRoomType() {
        return roomType.name();
    }

    public void setRoomType(String roomType) {
        this.roomType = RoomType.valueOf(roomType);
    }

    public int getHotelStars() {
        return hotelStars;
    }

    public void setHotelStars(int hotelStars) {
        this.hotelStars = hotelStars;
    }
}
