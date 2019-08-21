package interview.entity;

import java.util.Objects;

public class Destination {

    private Long id;
    private String country;
    private String city;
    //insurance price for a specific country will be different
    private int insurance;
    private boolean isWorldwideInsuranceRequired;
    private boolean isVisaFeeRequired;

    public Destination() {
    }

    public Destination(Long id, String country, String city,
                       int insurance, boolean isWorldwideInsuranceRequired,
                       boolean isVisaFeeRequired) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.insurance = insurance;
        this.isWorldwideInsuranceRequired = isWorldwideInsuranceRequired;
        this.isVisaFeeRequired = isVisaFeeRequired;
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

    public int getInsurance() {
        return insurance;
    }

    public void setInsurance(int insurance) {
        this.insurance = insurance;
    }

    public boolean isWorldwideInsuranceRequired() {
        return isWorldwideInsuranceRequired;
    }

    public void setWorldwideInsuranceRequired(boolean worldwideInsuranceRequired) {
        isWorldwideInsuranceRequired = worldwideInsuranceRequired;
    }

    public boolean isVisaFeeRequired() {
        return isVisaFeeRequired;
    }

    public void setVisaFeeRequired(boolean visaFeeRequired) {
        isVisaFeeRequired = visaFeeRequired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Destination)) return false;
        Destination that = (Destination) o;
        return insurance == that.insurance &&
                isWorldwideInsuranceRequired == that.isWorldwideInsuranceRequired &&
                isVisaFeeRequired == that.isVisaFeeRequired &&
                Objects.equals(id, that.id) &&
                Objects.equals(country, that.country) &&
                Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, city, insurance, isWorldwideInsuranceRequired, isVisaFeeRequired);
    }

    @Override
    public String toString() {
        return "Destination{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", insurance=" + insurance +
                ", isWorldwideInsuranceRequired=" + isWorldwideInsuranceRequired +
                ", isVisaFeeRequired=" + isVisaFeeRequired +
                '}';
    }
}
