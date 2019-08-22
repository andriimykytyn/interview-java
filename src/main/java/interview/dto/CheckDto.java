package interview.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Objects;

public class CheckDto {

    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime departmentDate;
    private double roomPrice;
    private HotelCheckDto hotelPrice;
    private TourCheckDto tourPrice;
    private double priceWithoutDiscount;
    private double certificateDiscount;
    private double totalPrice;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime created;
    private Long customerId;

    public CheckDto() {
    }

    public CheckDto(Long id, LocalDateTime departmentDate, double roomPrice,
                    HotelCheckDto hotelPrice, TourCheckDto tourPrice, double certificateDiscount,
                    double totalPrice,double priceWithoutDiscount, LocalDateTime created, Long customerId) {
        this.id = id;
        this.departmentDate = departmentDate;
        this.roomPrice = roomPrice;
        this.hotelPrice = hotelPrice;
        this.tourPrice = tourPrice;
        this.certificateDiscount = certificateDiscount;
        this.totalPrice = totalPrice;
        this.priceWithoutDiscount = priceWithoutDiscount;
        this.created = created;
        this.customerId = customerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDepartmentDate() {
        return departmentDate;
    }

    public void setDepartmentDate(LocalDateTime departmentDate) {
        this.departmentDate = departmentDate;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public HotelCheckDto getHotelPrice() {
        return hotelPrice;
    }

    public void setHotelPrice(HotelCheckDto hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    public TourCheckDto getTourPrice() {
        return tourPrice;
    }

    public void setTourPrice(TourCheckDto tourPrice) {
        this.tourPrice = tourPrice;
    }

    public double getCertificateDiscount() {
        return certificateDiscount;
    }

    public void setCertificateDiscount(double certificateDiscount) {
        this.certificateDiscount = certificateDiscount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public double getpriceWithoutDiscount() {
        return priceWithoutDiscount;
    }

    public void setpriceWithoutDiscount(double priceWithoutDiscount) {
        this.priceWithoutDiscount = priceWithoutDiscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CheckDto)) return false;
        CheckDto checkDto = (CheckDto) o;
        return Double.compare(checkDto.roomPrice, roomPrice) == 0 &&
                Double.compare(checkDto.certificateDiscount, certificateDiscount) == 0 &&
                Double.compare(checkDto.totalPrice, totalPrice) == 0 &&
                Double.compare(checkDto.priceWithoutDiscount, priceWithoutDiscount) == 0 &&
                Objects.equals(id, checkDto.id) &&
                Objects.equals(departmentDate, checkDto.departmentDate) &&
                Objects.equals(hotelPrice, checkDto.hotelPrice) &&
                Objects.equals(tourPrice, checkDto.tourPrice) &&
                Objects.equals(created, checkDto.created) &&
                Objects.equals(customerId, checkDto.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentDate, roomPrice, hotelPrice, tourPrice, certificateDiscount, totalPrice, priceWithoutDiscount, created, customerId);
    }

    @Override
    public String toString() {
        return "CheckDto{" +
                "id=" + id +
                ", departmentDate=" + departmentDate +
                ", roomPrice=" + roomPrice +
                ", hotelPrice=" + hotelPrice +
                ", tourPrice=" + tourPrice +
                ", certificateDiscount=" + certificateDiscount +
                ", totalPrice=" + totalPrice +
                ", priceWithoutDiscount=" + priceWithoutDiscount +
                ", created=" + created +
                ", customerId=" + customerId +
                '}';
    }
}
