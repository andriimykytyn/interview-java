package interview.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Objects;

public class Check {

    private Long id;
    private double totalPrice;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime created;
    private Long customerId;

    public Check() {
    }

    public Check(Long id, double totalPrice, LocalDateTime created, Long customerId) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.created = created;
        this.customerId = customerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Check)) return false;
        Check check = (Check) o;
        return Double.compare(check.totalPrice, totalPrice) == 0 &&
                Objects.equals(id, check.id) &&
                Objects.equals(created, check.created) &&
                Objects.equals(customerId, check.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalPrice, created, customerId);
    }

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", created=" + created +
                ", customerId=" + customerId +
                '}';
    }
}
