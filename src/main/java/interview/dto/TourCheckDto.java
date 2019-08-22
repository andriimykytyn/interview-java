package interview.dto;

import java.util.Objects;

public class TourCheckDto {

    private double transferPrice;
    private double breakfastPrice;
    private double lunchPrice;
    private double dinnerPrice;
    private int days;
    private double totalTourPrice;

    public TourCheckDto() {
    }

    public TourCheckDto(double transferPrice, double breakfastPrice,
                        double lunchPrice, double dinnerPrice, int days, double totalTourPrice) {
        this.transferPrice = transferPrice;
        this.breakfastPrice = breakfastPrice;
        this.lunchPrice = lunchPrice;
        this.dinnerPrice = dinnerPrice;
        this.days = days;
        this.totalTourPrice = totalTourPrice;
    }

    public double getTransferPrice() {
        return transferPrice;
    }

    public void setTransferPrice(double transferPrice) {
        this.transferPrice = transferPrice;
    }

    public double getBreakfastPrice() {
        return breakfastPrice;
    }

    public void setBreakfastPrice(double breakfastPrice) {
        this.breakfastPrice = breakfastPrice;
    }

    public double getLunchPrice() {
        return lunchPrice;
    }

    public void setLunchPrice(double lunchPrice) {
        this.lunchPrice = lunchPrice;
    }

    public double getDinnerPrice() {
        return dinnerPrice;
    }

    public void setDinnerPrice(double dinnerPrice) {
        this.dinnerPrice = dinnerPrice;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getTotalTourPrice() {
        return totalTourPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TourCheckDto)) return false;
        TourCheckDto that = (TourCheckDto) o;
        return Double.compare(that.transferPrice, transferPrice) == 0 &&
                Double.compare(that.breakfastPrice, breakfastPrice) == 0 &&
                Double.compare(that.lunchPrice, lunchPrice) == 0 &&
                Double.compare(that.dinnerPrice, dinnerPrice) == 0 &&
                days == that.days &&
                Double.compare(that.totalTourPrice, totalTourPrice) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(transferPrice, breakfastPrice, lunchPrice, dinnerPrice, days, totalTourPrice);
    }

    public void setTotalTourPrice(double totalTourPrice) {
        this.totalTourPrice = totalTourPrice;
    }

    @Override
    public String toString() {
        return "TourCheckDto{" +
                "transferPrice=" + transferPrice +
                ", breakfastPrice=" + breakfastPrice +
                ", lunchPrice=" + lunchPrice +
                ", dinnerPrice=" + dinnerPrice +
                ", days=" + days +
                ", totalTourPrice=" + totalTourPrice +
                '}';
    }
}
