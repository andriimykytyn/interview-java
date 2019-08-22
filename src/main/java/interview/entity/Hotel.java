package interview.entity;

import java.util.Objects;

public class Hotel {

    private Long id;
    private String country;
    private String city;
    private boolean isEuropeanCountry;
    private boolean visaFeeRequired;
    private int stars;
    private double insuranceCostPerDay;

    public Hotel() {
    }

    public Hotel(Long id, String country, String city,
                 boolean isEuropeanCountry, boolean visaFeeRequired, int stars, double insuranceCostPerDay) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.isEuropeanCountry = isEuropeanCountry;
        this.visaFeeRequired = visaFeeRequired;
        this.stars = stars;
        this.insuranceCostPerDay = insuranceCostPerDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isEuropeanCountry() {
        return isEuropeanCountry;
    }

    public void setEuropeanCountry(boolean europeanCountry) {
        isEuropeanCountry = europeanCountry;
    }

    public boolean isVisaFeeRequired() {
        return visaFeeRequired;
    }

    public void setVisaFeeRequired(boolean visaFeeRequired) {
        this.visaFeeRequired = visaFeeRequired;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public double getInsuranceCostPerDay() {
        return insuranceCostPerDay;
    }

    public void setInsuranceCostPerDay(double insuranceCostPerDay) {
        this.insuranceCostPerDay = insuranceCostPerDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hotel)) return false;
        Hotel hotel = (Hotel) o;
        return isEuropeanCountry == hotel.isEuropeanCountry &&
                visaFeeRequired == hotel.visaFeeRequired &&
                stars == hotel.stars &&
                insuranceCostPerDay == hotel.insuranceCostPerDay &&
                Objects.equals(id, hotel.id) &&
                Objects.equals(country, hotel.country) &&
                Objects.equals(city, hotel.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, city, isEuropeanCountry, visaFeeRequired, stars, insuranceCostPerDay);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", isEuropeanCountry=" + isEuropeanCountry +
                ", visaFeeRequired=" + visaFeeRequired +
                ", stars=" + stars +
                ", insuranceCostPerDay=" + insuranceCostPerDay +
                '}';
    }
}
