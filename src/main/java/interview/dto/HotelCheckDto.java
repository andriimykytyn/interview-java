package interview.dto;

import java.util.Objects;

public class HotelCheckDto {

    private double visaFeePrice;
    private double insurancePrice;
    private double worldWideInsuranceMultiplier;
    private double totalInsurancePrice;
    private int stars;
    private double hotelPriceTotal;

    public HotelCheckDto() {
    }

    public HotelCheckDto(double visaFeePrice, double insurancePrice,
                         double worldWideInsuranceMultiplier, double totalInsurancePrice,
                         int stars, double hotelPriceTotal) {
        this.visaFeePrice = visaFeePrice;
        this.insurancePrice = insurancePrice;
        this.worldWideInsuranceMultiplier = worldWideInsuranceMultiplier;
        this.totalInsurancePrice = totalInsurancePrice;
        this.stars = stars;
        this.hotelPriceTotal = hotelPriceTotal;
    }

    public double getVisaFeePrice() {
        return visaFeePrice;
    }

    public void setVisaFeePrice(double visaFeePrice) {
        this.visaFeePrice = visaFeePrice;
    }

    public double getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(double insurancePrice) {
        this.insurancePrice = insurancePrice;
    }

    public double getWorldWideInsuranceMultiplier() {
        return worldWideInsuranceMultiplier;
    }

    public void setWorldWideInsuranceMultiplier(double worldWideInsuranceMultiplier) {
        this.worldWideInsuranceMultiplier = worldWideInsuranceMultiplier;
    }

    public double getTotalInsurancePrice() {
        return totalInsurancePrice;
    }

    public void setTotalInsurancePrice(double totalInsurancePrice) {
        this.totalInsurancePrice = totalInsurancePrice;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public double getHotelPriceTotal() {
        return hotelPriceTotal;
    }

    public void setHotelPriceTotal(double hotelPriceTotal) {
        this.hotelPriceTotal = hotelPriceTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HotelCheckDto)) return false;
        HotelCheckDto that = (HotelCheckDto) o;
        return Double.compare(that.visaFeePrice, visaFeePrice) == 0 &&
                Double.compare(that.insurancePrice, insurancePrice) == 0 &&
                Double.compare(that.worldWideInsuranceMultiplier, worldWideInsuranceMultiplier) == 0 &&
                Double.compare(that.totalInsurancePrice, totalInsurancePrice) == 0 &&
                stars == that.stars &&
                Double.compare(that.hotelPriceTotal, hotelPriceTotal) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(visaFeePrice, insurancePrice, worldWideInsuranceMultiplier, totalInsurancePrice, stars, hotelPriceTotal);
    }

    @Override
    public String toString() {
        return "HotelCheckDto{" +
                "visaFeePrice=" + visaFeePrice +
                ", insurancePrice=" + insurancePrice +
                ", worldWideInsuranceMultiplier=" + worldWideInsuranceMultiplier +
                ", totalInsurancePrice=" + totalInsurancePrice +
                ", stars=" + stars +
                ", hotelPriceTotal=" + hotelPriceTotal +
                '}';
    }
}
